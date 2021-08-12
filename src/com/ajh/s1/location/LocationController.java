package com.ajh.s1.location;

import java.util.ArrayList;

public class LocationController {

	private LocationDAO locationDAO;
	private LocationView locationView;
	ArrayList<LocationDTO> ar;

	public LocationController() {
		locationDAO = new LocationDAO();
		locationView = new LocationView();
		ar = new ArrayList<LocationDTO>();
	}

	public void start() {

		// DB에서 Location Table의 모든 정보 조회
//		ar = locationDAO.getList();
//		locationView.view(ar);

//		LocationDTO locationDTO = locationDAO.getOne(1000);
//		locationView.view(locationDTO);

//		ar = locationDAO.getSearch();
//		locationView.view(ar);

//		int i = locationDAO.getCount();
//		locationView.view(i);
		
		LocationDTO locationDTO = locationDAO.getLocation(100);
		locationView.view(locationDTO);

	}

}
