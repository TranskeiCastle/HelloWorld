package test.thread;

public class TaskThreadDemo {
	public static void main(String[] args) {
		Runnable printA = new PrintChar('A', 100);
		Runnable printB = new PrintChar('B', 100);
		Runnable print100 = new PrintNum(100);

		Thread thread = new Thread(printA);
		Thread thread2 = new Thread(printB);
		Thread thread3 = new Thread(print100);

		thread.start();
		thread2.start();
		thread3.start();
	}
}

class PrintChar implements Runnable {
	private char charToPrint;
	private int times;

	public PrintChar(char charToPrint, int times) {
		super();
		this.charToPrint = charToPrint;
		this.times = times;
	}

	public void run() {
		for (int i = 1; i <= times; i++) {
			System.out.print(charToPrint);
		}
	}
	/*
	 * 如果要查看join()效果，使用这个run()方法 
	 */
	/*public void run() {
		Thread thread4 = new Thread(new PrintChar('c', 40));
		thread4.start();
		try {
			for (int i = 1; i <= lastNum; i++) {
				System.out.print(i + " ");
				// Thread.yield();
				if (i == 50)
					thread4.join();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}*/
	
}

class PrintNum implements Runnable {
	private int lastNum;

	public PrintNum(int lastNum) {
		super();
		this.lastNum = lastNum;
	}

	public void run() {
		for (int i = 1; i <= lastNum; i++) {
			System.out.print(i + " ");
			Thread.yield();
		}
	}
}