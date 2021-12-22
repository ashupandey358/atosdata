package com.atos.assigment;

import java.util.Scanner;

public class ArmaticOperation {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Entre the two Number");
		int a = sc.nextInt();
		int b = sc.nextInt();
		System.out.println("The sum of this number is " + (a+b));
		System.out.println("The substraction of this number is " + (a-b));
		System.out.println("The multiplaction of this number is " + (a*b));
		System.out.println("The divisible of this number is " + (a/b));

	}

}
