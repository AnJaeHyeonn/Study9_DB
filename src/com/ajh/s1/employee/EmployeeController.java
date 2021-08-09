package com.ajh.s1.employee;

import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeController {

	private EmployeeDAO employeeDAO;
	private EmployeeView employeeView;
	ArrayList<EmployeeDTO> ar;
	Scanner sc;

	public EmployeeController() {
		employeeDAO = new EmployeeDAO();
		employeeView = new EmployeeView();
		ar = new ArrayList<EmployeeDTO>();
		sc = new Scanner(System.in);
	}

	public void start() {

		boolean flag = true;

		while (flag) {

			System.out.println("1. 전체 사원 출력");
			System.out.println("2. 사원 번호를 통한 정보 출력");
			System.out.println("3. LAST_NAME을 통한 정보 출력");
			System.out.println("4. FIRST_NAME을 통한 정보 출력");
			System.out.println("5. 전체 평균 급여의 정보 출력");
			System.out.println("6. 부서 별 평균 급여의 정보 출력");
			System.out.println("7. 종 료");

			int i = sc.nextInt();

			if (i == 1) {
				// 1번
				ar = employeeDAO.getList();
				employeeView.view(ar);
				continue;
			} else if (i == 2) {
				// 2번
				EmployeeDTO emDTO = employeeDAO.getOne(101);
				employeeView.view(emDTO);
				continue;
			} else if (i == 3 || i == 4) {
				// 3번, 4번
				ar = employeeDAO.getSearch(i);
				employeeView.view(ar);
				continue;
			} else if (i == 5) {
				double j = employeeDAO.avg();
				employeeView.view(j);
				continue;
			} else if (i == 6) {
				employeeDAO.avg2();
				continue;
			} else {
				break;
			}

		}
	}

}
