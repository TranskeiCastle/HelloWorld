package test.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AccountWithoutSync {
	private static Account account = new Account();

	public static void main(String[] args) {
		ExecutorService executor = Executors.newCachedThreadPool();

		for (int i = 0; i < 100; i++) {
			executor.execute(new AddAPennyTask());
		}
		executor.shutdown();

		while (!executor.isTerminated()) {

		}
		System.out.println("What's the balance? " + account.getBalance());
	}

	// A thread for adding a penny to the account
	private static class AddAPennyTask implements Runnable {
		public void run() {
			account.deposit(1);
		}
	}

	// An inner class for account
	private static class Account {
		private int balance = 0;

		public int getBalance() {
			return balance;
		}
//		public synchronized void deposit(int amount) {
		public void deposit(int amount) {
			// int newBalance = balance + amount;
			// try-catch用于增加结果错误机率
			 try {
			 Thread.sleep(5);
			 } catch (InterruptedException ex) {
			 System.out.println(ex.getCause());
			 }
			// balance = newBalance;
			balance += amount;
		}
	}
}
