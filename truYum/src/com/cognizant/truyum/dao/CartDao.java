package com.cognizant.truyum.dao;

import java.text.ParseException;

import com.cognizant.truyum.model.Cart;

public interface CartDao {

	public void addCartItem(long userId,long menuItemId) throws ParseException;
	public Cart getAllCartItem(long userId) throws CartEmptyException;
	public void removeCartId(long userId,long menuItemId);
	
}
