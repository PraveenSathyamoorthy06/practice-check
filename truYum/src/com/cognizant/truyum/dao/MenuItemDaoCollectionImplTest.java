package com.cognizant.truyum.dao;

import java.text.ParseException;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoCollectionImplTest {

	public static void main(String[] args) throws ParseException {
		testGetMenuItemListAdmin();
		testGetMenuItemListCustomer();
		testModifyMenuItem();
		testGetMenuItem();
	}

	public static void testGetMenuItemListAdmin() throws ParseException {
		MenuItemDao menuItemDao=new MenuItemDaoCollectionImpl();
		for(MenuItem menuItem : menuItemDao.getMenuItemListAdmin())
			System.out.println(menuItem);
		
	}
	
	public static void testGetMenuItemListCustomer() throws ParseException {
		MenuItemDao menuItemDao=new MenuItemDaoCollectionImpl();
		for(MenuItem menuItem : menuItemDao.getMenuItemListCustomer())
			System.out.println(menuItem);
	}
	
	public static void testModifyMenuItem() throws ParseException {
		MenuItemDao menuItemDao=new MenuItemDaoCollectionImpl();
		menuItemDao.modifyMenuItem(new MenuItem(1001, "Sandwich", 99.00f, true, DateUtil.convertToDate("15/03/2017"), "Main Course", true));
	}
	
	public static void testGetMenuItem() {
		
	}
	
}
