package com.cognizant.truyum.dao;

import java.text.ParseException;

public class CartDaoCollectionImplTest {

	public static void main(String[] args) throws ParseException, CartEmptyException {
		testAddCartItem();
		testRemoveCartItem();
		testGetAllCartItems();
	}
	
	public static void testAddCartItem() throws ParseException, CartEmptyException {
		CartDao cartDao=new CartDaoCollectionImpl();
		cartDao.addCartItem(1, 1002);
		System.out.println(cartDao.getAllCartItem(1));
	}
	
	public static void testGetAllCartItems() {
		
	}
	
	public static void testRemoveCartItem() throws CartEmptyException {
		CartDao cartDao=new CartDaoCollectionImpl();
		cartDao.removeCartId(1, 1002);
		try {
			System.out.println(cartDao.getAllCartItem(1));
		}
		catch (CartEmptyException e) {
			System.out.println("Cart Is Empty !!!");
		}
	}

}
