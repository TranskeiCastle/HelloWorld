package test.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AccountWithSyncUsingLock {
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
		// Create a lock
		private static Lock lock = new ReentrantLock();
		private int balance = 0;

		public int getBalance() {
			return balance;
		}

		// public synchronized void deposit(int amount) {
		public void deposit(int amount) {
			lock.lock();
			// try-catch用于增加存款计算结果错误机率
			try {
				int newBalance = balance + amount;
				Thread.sleep(5);
				balance = newBalance;
			} catch (InterruptedException ex) {
				System.out.println(ex.getCause());
			} finally {
				// Release the lock
				lock.unlock();
			}

		}
	}
}
