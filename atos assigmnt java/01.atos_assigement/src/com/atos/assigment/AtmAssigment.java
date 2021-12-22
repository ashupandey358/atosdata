package com.atos.assigment;

import java.util.Scanner;

public class AtmAssigment {
	private double balance = 0;
	private String string;
	

	public AtmAssigment(String string)
	{
		this.string = string;
	}


	public double getBalance() {
		return balance;
	}



	public void setBalance(double balance) {
		this.balance = balance;
	}

	public void options()
	{
		System.out.println("1. for the balance check");
		System.out.println("2. for the withdrawal");
		System.out.println("3. for the deposite");
		System.out.println("4. exit");
	}


	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		AtmAssigment atm = new AtmAssigment("!!Welcome to my bank!!");
		
		while(true)
		{
		System.out.println(atm.string);
		atm.options();
		int choose = sc.nextInt();
		
		switch (choose) {
		case 1:
			System.out.println("The current balance is " + atm.getBalance());
			System.out.println();
			break;
		case 2:
			System.out.println("Entre the withdrawal amount");
			double withdrawlAmount = sc.nextDouble();
			if(atm.getBalance()>=withdrawlAmount && withdrawlAmount>0)
			{
				double currentBalance = atm.getBalance() - withdrawlAmount;
				atm.setBalance(currentBalance);
				System.out.println("thanxs for you transction");
				System.out.println();
				
			}
			else if(atm.getBalance()<withdrawlAmount)
			{
				System.out.println("Transction is not complete due to insufficient balance");
				System.out.println();
			}
			else if(withdrawlAmount<0)
			{
				System.out.println("amount should always positive");
				System.out.println();
			}
			break;
		case 3:
			System.out.println("Entre the deposite amount");
			double depositeAmount = sc.nextDouble();
			if(depositeAmount>0)
			{
				double currentBalance = atm.getBalance() + depositeAmount;
				atm.setBalance(currentBalance);
				System.out.println("Thanks for transction");
				System.out.println();
			}
			else if(depositeAmount<0)
			{
				System.out.println("amount should always positive");
				System.out.println();
			}
			break;
		case 4:
			System.out.println("Thankyou for using our services Good Bye!!!");
            System.exit(0);			
			
		default:
			System.out.println("Please insert vaild option");
			System.out.println();
			
		}
		
	
		}

	}

}
