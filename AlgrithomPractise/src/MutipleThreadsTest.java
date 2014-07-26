class MyThread implements Runnable {

	String name;
	int start;
	int end;

	public MyThread(String str, int a, int b) {
		// TODO Auto-generated constructor stub
		this.start = a;
		this.end = b;
		this.name = str;
	}

	public void run() {
		for (int i = start; i < end; i++) {
			System.out.println(name + " is running " + i);
		}
	}

	public static void main(String[] args) {
		Thread[] threads = new Thread[2];
		threads[0] = new Thread(new MyThread("1", 0, 10));
		threads[1] = new Thread(new MyThread("2", 10, 20));
		for (int i = 0; i < 2; i++) {
			threads[i].start();
		}
		for (int i = 0; i < 2; i++) {
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		System.out.println("all finished!");
	}
}