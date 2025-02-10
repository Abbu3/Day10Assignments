package com.java.basic;

public class Main {

	public static void main(String[] args) {
		CheckingBalance checkingBalance = new CheckingBalance(0);
		System.out.println(checkingBalance.getBalance());
		
		
		Thread t1 = new Thread(new BankAccount(checkingBalance, true, 500), "Thread-1");
		Thread t2 = new Thread(new BankAccount(checkingBalance, true, 500), "Thread-2");
		Thread t3 = new Thread(new BankAccount(checkingBalance, true, 500), "Thread-3");
		Thread t4 = new Thread(new BankAccount(checkingBalance, true, 500), "Thread-4");
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}

}

class CheckingBalance {
	
	double balance;
	public CheckingBalance(double balance) {
		this.balance = balance;
		
	}
	
	public synchronized void deposit(double amount) {
		if(amount > 0) {	
			balance += amount;
			System.out.println(Thread.currentThread().getName() + " " + "deposit :" +amount+ " " + "Balance" +balance);
		}	
		}
	public synchronized void withdraw(double amount) {
		if(amount > 0 && this.balance >= amount) {
			this.balance -= amount;
			System.out.println(Thread.currentThread().getName() + " " + "withdraw :" +amount+ " " + "Balance" +balance);
		} else {
			System.out.println(Thread.currentThread().getName() + "attempt to withdraw :" +amount+ " " + "but balance is insufficient");
		}
	}	
	
	public double getBalance() {
		return balance;
	}
}

class BankAccount implements Runnable{
	CheckingBalance checkingBalance;
	boolean deposit;
	double amount;
	
	
	public BankAccount(CheckingBalance checkingBalance, boolean deposit, double amount) {
		this.checkingBalance = checkingBalance;
		this.deposit = deposit;
		this.amount = amount;
	}


	@Override
	public void run() {
		if(deposit) {
			checkingBalance.deposit(amount);
		} else {
			checkingBalance.withdraw(amount);
		}
		
	}
	
}