package com.chainsys.minproject.entry;


import com.chainsys.minproject.commonutil.Validator;
import com.chainsys.minproject.ui.AppointmentUi;
import com.chainsys.minproject.ui.DoctorUi;

import com.chainsys.minproject.ui.EmployeeUi;
public class Startup {
			public static void main(String args[]) {
				loadMenu();
			}

			private static void loadMenu() {
				System.out.println("Enter Menu : 1 is EmployeeMenu, 2 is Doctor Menu, 3 is Appointment Menu ");
				java.util.Scanner sc = new java.util.Scanner(System.in);
		      try {
				int call = sc.nextInt();
				switch (call) {
				case 1:
					loadEmployeeMenu();
					break;
				case 2:
					loadDoctorMenu();
					break;
				case 3:
					loadAppointmentMenu();
					break;
				}
		      }finally {
		    	  sc.close();
		      }
			}

			private static void loadEmployeeMenu() {
				System.out.println("Enter Employee Method : 1=addNewEmployee, 2=getEmployeeById ,3=getAllEmployeesDetails ,4=updateEmployee, 5=deleteEmployee, 6=updateEmployeeSalary, 7=updateEmployeeFirstName");
				java.util.Scanner sc = new java.util.Scanner(System.in);
				try {
				int call = sc.nextInt();
				
				switch (call) {
				case 1:
					EmployeeUi.addNewEmployee();
					break;

				case 2:
					EmployeeUi.getEmployeeById() ;
					break;
				case 3:
					EmployeeUi.getAllEmployeesDetails();
					break;
				case 4:
					EmployeeUi.updateEmployee();
				case 5:
					EmployeeUi.deleteEmployee();
					break;
				
				case 6:
					EmployeeUi.updateEmployeeSalary();
					break;
				case 7:
					EmployeeUi.updateEmployeeFirstName() ;
				
				}
				}
				finally {
					sc.close();
				}
			}

			private static void loadDoctorMenu() {
				System.out.println(
						"Enter Doctor Method :"+ " 1=addNewDoctor ,"+ "2=deleteDoctordetails; ,"+ "3=updateDocDetails ,"+ "4=updateDoctorNam,"+ " 5=updateStandardFees,"+ " 6=ViewAllEmployeeDetails, "+ "7=viewEmployeeDetails ");
				java.util.Scanner sc = new java.util.Scanner(System.in);
				try {
				int call = sc.nextInt();
				switch (call) {
				case 1:
					DoctorUi.addNewDoctor();
					break;
				case 2:
					DoctorUi.deleteDoctordetails();
					break;
				case 3:
					DoctorUi.updateDocDetails();
					break;
				case 4:
					DoctorUi.updateDoctorName();
					break;
				case 5:
					DoctorUi.updateStandardFees();
					break;
				case 6:
					DoctorUi.ViewAllEmployeeDetails();
					break;
				case 7:
					DoctorUi.viewEmployeeDetails();
					break;
				}
				}finally {
					sc.close();
				}
			}

			private static void loadAppointmentMenu() {
				System.out.println("Enter Method : 1=addNewAppointment ,2=deleteAppointmentDetails ,3=updateAppDetails ,4=updateCollectedfees ,5=updatePatientName ,6=ViewAllAppointmentDetails ,7=viewAppointmentDetails ");
				java.util.Scanner sc = new java.util.Scanner(System.in);
				try {
				int call = sc.nextInt();
				switch (call) {
				case 1:
					AppointmentUi.addNewAppointments();
					break;
				case 2:
					AppointmentUi.deleteAppointmentDetails();
					break;
				case 3:
					AppointmentUi.updateAppDetails();
					break;
				case 4:
					AppointmentUi.updateCollectedfees();
					break;
				case 5:
					AppointmentUi.updatePatientName();
					break;
				case 6:
					AppointmentUi.ViewAllAppointmentDetails();
					break;
				case 7:
					AppointmentUi.viewAppointmentDetails();
					break;
				
				
				}
				
				}finally {
					sc.close();
				}
			}


}
