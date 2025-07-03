/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.ntthanh.drink_store.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.ntthanh.drink_store.exception.NoSuchTableDrinkException;
import com.ntthanh.drink_store.model.TableDrink;
import com.ntthanh.drink_store.service.base.TableDrinkLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.ntthanh.drink_store.model.TableDrink",
	service = AopService.class
)
public class TableDrinkLocalServiceImpl extends TableDrinkLocalServiceBaseImpl   implements AopService {
	
	public TableDrink addTableDrink(int tableNumber, int seats, String status) {
	    long tableDrinkId = counterLocalService.increment();
	    TableDrink tableDrink = tableDrinkPersistence.create(tableDrinkId);
	    
	    tableDrink.setTableNumber(tableNumber);
	    tableDrink.setSeats(seats);
	    tableDrink.setStatus(status);
	    
	    return tableDrinkPersistence.update(tableDrink);
	}

	public TableDrink updateTableDrink(long id, int tableNumber, int seats, String status) throws PortalException {
	    TableDrink tableDrink = tableDrinkPersistence.findByPrimaryKey(id);
	    
	    tableDrink.setTableNumber(tableNumber);
	    tableDrink.setSeats(seats);
	    tableDrink.setStatus(status);

	    return tableDrinkPersistence.update(tableDrink);
	}
	

	 @Override
	    public TableDrink fetchTableDrink(long tableDrinkId) {
	        try {
	            
	            TableDrink tableDrink = tableDrinkPersistence.findByPrimaryKey(tableDrinkId);
	            
	            return tableDrink;
	        } catch (com.liferay.portal.kernel.exception.NoSuchModelException e) {
	            System.out.println("Không tìm thấy TableDrink với ID: " + tableDrinkId);
	            return null; 
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        }
	    }

	@Override
	public TableDrink fetchTableDrinkId(long tableNumberId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TableDrink findByTableDrinkId(long tableNumberId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TableDrink fetchTableDrinkByTableDrinkId(long tableDrinkId) {
		// TODO Auto-generated method stub
		return null;
	}
}