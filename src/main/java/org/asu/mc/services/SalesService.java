package org.asu.mc.services;

import java.util.List;

import org.asu.mc.dao.SalesDao;
import org.asu.mc.model.Sales;
import org.springframework.beans.factory.annotation.Autowired;

public class SalesService {

	@Autowired
	SalesDao salesDao;
	
	public boolean addSales(Sales sales) throws Exception {
		return salesDao.addSales(sales);
	}

	public Sales getSalesById(long id) throws Exception {
		return salesDao.getSalesById(id);
	}

	public List<Sales> getSalesList() throws Exception {
		return salesDao.getSalesList();
	}

	public boolean deleteSales(long id) throws Exception {
		return salesDao.deleteSales(id);
	}

}
