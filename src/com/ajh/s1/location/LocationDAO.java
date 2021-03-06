package com.ajh.s1.location;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.ajh.s1.utill.DBConnect;

public class LocationDAO {

	private DBConnect dbConnect;
	Scanner sc;
	ArrayList<LocationDTO> ar;

	public LocationDAO() {
		dbConnect = new DBConnect();
		sc = new Scanner(System.in);
		ar = new ArrayList<LocationDTO>();
	}

	public LocationDTO getLocation(int employee_id) {

		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;

		LocationDTO locationDTO = null;

		try {
			con = dbConnect.getConnect();

			String sql = "SELECT * FROM LOCATIONS WHERE LOCATION_ID = (SELECT LOCATION_ID FROM DEPARTMENTS WHERE DEPARTMENT_ID = (SELECT DEPARTMENT_ID FROM EMPLOYEES WHERE EMPLOYEE_ID = ?))";

			st = con.prepareStatement(sql);

			st.setInt(1, employee_id);

			rs = st.executeQuery();

			if (rs.next()) {
				locationDTO = new LocationDTO();

				locationDTO.setLocation_id(rs.getInt("location_id"));
				locationDTO.setStreet_address(rs.getString("street_address"));
				locationDTO.setPostal_code(rs.getString("postal_code"));
				locationDTO.setCity(rs.getString("city"));
				locationDTO.setState_province(rs.getString("state_province"));
				locationDTO.setCountry_id(rs.getString("country_id"));
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return locationDTO;

	}

	// getCount
	// Location의 주소 갯수를 리턴하고 출력

	public int getCount() {

		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;

		int i = 0;

		try {

			con = dbConnect.getConnect();

			String sql = "SELECT COUNT(LOCATION_ID) FROM LOCATIONS";

			st = con.prepareStatement(sql);

			rs = st.executeQuery();

			rs.next();
			i = rs.getInt(1);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
				con.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return i;

	}

	// getSearch
	// street_address 의 일부를 받아서 검색
	public ArrayList<LocationDTO> getSearch() {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;

		try {

			con = dbConnect.getConnect();

			System.out.println("검색 할 글자를 입력하세요.");
			String input = sc.next().toLowerCase();
			String sql = "SELECT * FROM LOCATIONS WHERE lower(STREET_ADDRESS) LIKE ?";

			st = con.prepareStatement(sql);

			st.setString(1, "%" + input + "%");

			System.out.println(st);

			rs = st.executeQuery();

			System.out.println(rs);

			while (rs.next()) {
				LocationDTO locationDTO = new LocationDTO();

				locationDTO.setLocation_id(rs.getInt("location_id"));
				locationDTO.setStreet_address(rs.getString("street_address"));
				locationDTO.setPostal_code(rs.getString("postal_code"));
				locationDTO.setCity(rs.getString("city"));
				locationDTO.setState_province(rs.getString("state_province"));
				locationDTO.setCountry_id(rs.getString("country_id"));

				ar.add(locationDTO);

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
				con.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return ar;

	}

	public LocationDTO getOne(int location_id) {

		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;

		LocationDTO locationDTO = null;

		try {
			con = dbConnect.getConnect();

			String sql = "SELECT * FROM LOCATIONS WHERE LOCATION_ID = ?";

			st = con.prepareStatement(sql);

			st.setInt(1, location_id);

			rs = st.executeQuery();

			if (rs.next()) {
				locationDTO = new LocationDTO();
				locationDTO.setLocation_id(rs.getInt("location_id"));
				locationDTO.setStreet_address(rs.getString("street_address"));
				locationDTO.setPostal_code(rs.getString("postal_code"));
				locationDTO.setCity(rs.getString("city"));
				locationDTO.setState_province(rs.getString("state_province"));
				locationDTO.setCountry_id(rs.getString("country_id"));
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return locationDTO;

	}

	public ArrayList<LocationDTO> getList() {
		System.out.println("LOCATION Select Start");
		// LOCATIONS Table을 조회해서 출력

		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;

		try {

			con = dbConnect.getConnect();
			System.out.println("접속 성공");

			String sql = "SELECT * FROM LOCATIONS";

			st = con.prepareStatement(sql);

			rs = st.executeQuery();

			while (rs.next()) {
				LocationDTO locationDTO = new LocationDTO();

				locationDTO.setLocation_id(rs.getInt("location_id"));
				locationDTO.setStreet_address(rs.getString("street_address"));
				locationDTO.setPostal_code(rs.getString("postal_code"));
				locationDTO.setCity(rs.getString("city"));
				locationDTO.setState_province(rs.getString("state_province"));
				locationDTO.setCountry_id(rs.getString("country_id"));

				ar.add(locationDTO);

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
				con.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return ar;

	}

}
