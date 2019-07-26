package com.cognizant.truyum.dao;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

public class CartDaoCollectionImpl implements CartDao {

	private static HashMap<Long, Cart> userCarts;
	
	public CartDaoCollectionImpl() {
		super();
		if(userCarts == null) {
			userCarts=new HashMap<>();
		}
	}

	@Override
	public void addCartItem(long userId, long menuItemId) throws ParseException {
		MenuItemDao menuItemDao=new MenuItemDaoCollectionImpl();
		MenuItem menuItem=menuItemDao.getMenuItem(menuItemId);
		if(userCarts.containsKey(userId)) {
			userCarts.get(userId).getMenuItemList().add(menuItem);
		}
		else {
			Cart cart=new Cart();
			List<MenuItem> list=new ArrayList<MenuItem>();
			list.add(menuItem);
			cart.setMenuItemList(list);
			userCarts.put(userId, cart);
		}
	}

	@Override
	public void removeCartId(long userId, long menuItemId) {
		List<MenuItem> list=userCarts.get(userId).getMenuItemList();
		for(MenuItem menuItem : list) {
			if(menuItem.getId() == menuItemId) {
				list.remove(menuItem);
				break;
			}
		}
	}

	@Override
	public Cart getAllCartItem(long userId) throws CartEmptyException {
		Cart cart=userCarts.get(userId);
		if(cart == null | cart.getMenuItemList().isEmpty()) {
			throw new CartEmptyException();
		}
		List<MenuItem> list=cart.getMenuItemList();
		double total=0;
		for(MenuItem menuItem : list) {
			total+=menuItem.getPrice();
		}
		cart.setTotal(total);
		return cart;
	}

}
