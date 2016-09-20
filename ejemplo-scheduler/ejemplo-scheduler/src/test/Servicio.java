package test;

import java.util.Random;

public class Servicio implements Runnable {

	Random ran = new Random();
	
	@Override
	public void run() {
		int a = ran.nextInt(100);
		int b = ran.nextInt(100);
		System.out.println("Enviando datos " + a + "::" + b);
	}

}
