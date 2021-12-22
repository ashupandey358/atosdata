package com.atos.assigment;

import java.util.Scanner;

public class AreaOfRectangle {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Entre the Length of the side");
		int length = sc.nextInt();
		System.out.println("Entre the breath of the side");
		int breath = sc.nextInt();
		int area = length * breath;
		System.out.println("The Area of rectangle is "+area);

	}

}
