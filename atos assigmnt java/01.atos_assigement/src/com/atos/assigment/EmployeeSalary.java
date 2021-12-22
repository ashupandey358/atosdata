package com.atos.assigment;

import java.util.Scanner;

public class EmployeeSalary {
	
	private int id;
	private String name;
	private double basicSalary;
	
	

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public double getBasicSalary() {
		return basicSalary;
	}



	public void setBasicSalary(double basicSalary) {
		this.basicSalary = basicSalary;
	}



	public static void main(String[] args) {
		EmployeeSalary emp = new EmployeeSalary();
		System.out.println("1. Entre the id here");
		Scanner sc = new Scanner(System.in);
		int id = sc.nextInt();
		
		
		emp.setId(id);
		
		System.out.println("2. Entre the name here");
		String name = sc.next();
		
		emp.setName(name);
		
		System.out.println("3. Entre the basic salary ");
		double basicSalary = sc.nextDouble();
		emp.setBasicSalary(basicSalary);
		double basicSalary1 = emp.getBasicSalary();
		double hra = (basicSalary1*7)/100;
		double da = (basicSalary1*12)/100;
		double it = (basicSalary1*3)/100;
		double pf = (basicSalary1*5)/100;
		double netSalary = basicSalary1 + hra + da -it - pf;
		System.out.println();
		System.out.println("Employee id is :"+ emp.getId());
		System.out.println("The name of the employee is :"+emp.getName());
		System.out.println("Net Salary of the employee is :"+netSalary);
		
		

	}

}
