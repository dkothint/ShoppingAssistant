package org.asu.mc.services;

import java.util.List;

import org.asu.mc.dao.StoreDao;
import org.asu.mc.model.Store;
import org.springframework.beans.factory.annotation.Autowired;

public class StoreService {

	@Autowired
	StoreDao storeDao;
	
	public boolean addStore(Store store) throws Exception {
		return storeDao.addStore(store);
	}

	public Store getStoreById(long id) throws Exception {
		return storeDao.getStoreById(id);
	}

	public List<Store> getStoreList() throws Exception {
		return storeDao.getStoreList();
	}

	public boolean deleteStore(long id) throws Exception {
		return storeDao.deleteStore(id);
	}

}
