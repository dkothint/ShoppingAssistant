package org.asu.mc.services;

import java.util.List;

import org.asu.mc.dao.BeaconDao;
import org.asu.mc.model.Beacon;
import org.springframework.beans.factory.annotation.Autowired;

public class BeaconService {

	@Autowired
	BeaconDao beaconDao;
	
	public boolean addBeacon(Beacon beacon) throws Exception {
		return beaconDao.addBeacon(beacon);
	}

	public Beacon getBeaconById(long id) throws Exception {
		return beaconDao.getBeaconById(id);
	}

	public List<Beacon> getBeaconList() throws Exception {
		return beaconDao.getBeaconList();
	}

	public boolean deleteBeacon(long id) throws Exception {
		return beaconDao.deleteBeacon(id);
	}

}
