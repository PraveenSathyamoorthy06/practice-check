package com.cognizant.truyum.dao;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoCollectionImpl implements MenuItemDao {

	private static List<MenuItem> menuItemList;
	
	public MenuItemDaoCollectionImpl() throws ParseException {
		super();
		if(menuItemList == null) {
			menuItemList=new ArrayList<MenuItem>();
		}
		MenuItem menuItem=new MenuItem(1001, "Sandwich", 99.00f, true, DateUtil.convertToDate("15/03/2017"), "Main Course", true);
		menuItemList.add(menuItem);
		menuItem=new MenuItem(1002, "Burger", 129.00f, true, DateUtil.convertToDate("23/12/2017"), "Main Course", false);
		menuItemList.add(menuItem);
		menuItem=new MenuItem(1003, "Pizza", 149.00f, true, DateUtil.convertToDate("21/08/2018"), "Main Course", false);
		menuItemList.add(menuItem);
		menuItem=new MenuItem(1004, "French Fries",57.00f, false, DateUtil.convertToDate("02/07/2017"), "Starters", true);
		menuItemList.add(menuItem);
		menuItem=new MenuItem(1005, "Chocolate Brownie", 32.00f, true, DateUtil.convertToDate("02/11/2022"), "Dessert", true);
		menuItemList.add(menuItem);
	}

	@Override
	public List<MenuItem> getMenuItemListAdmin() {
		return menuItemList;
	}

	@Override
	public List<MenuItem> getMenuItemListCustomer() {
		List<MenuItem> list=new ArrayList<>();
		for(MenuItem menuItem : menuItemList) {
			if((menuItem.getDateOfLaunch().before(new Date()) || menuItem.getDateOfLaunch() == (new Date())) && menuItem.isActive() ) {
				list.add(menuItem);
			}
		}
		return list;
	}

	@Override
	public void modifyMenuItem(MenuItem menuItem) {
		for(int i=0;i<menuItemList.size();i++) {
			if(menuItemList.get(i).getId() == menuItem.getId()) {
				menuItemList.set(i, menuItem);
			}
		}
		System.out.println(getMenuItem(menuItem.getId()));
	}

	@Override
	public MenuItem getMenuItem(long menuItemId) {
		for(int i=0;i<menuItemList.size();i++) {
			if(menuItemList.get(i).getId() == menuItemId) {
				return menuItemList.get(i);
			}
		}
		return null;
	}

}
