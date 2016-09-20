package test;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Principal {

	public static void main(String[] args) {
		// Crea el scheduler
		ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
		
		// Programa la ejecución cada 2 segundos del hilo (servicio). La ejecuión empieza a los 5 segundos
		executor.scheduleAtFixedRate(new Servicio(), 5, 2, TimeUnit.SECONDS);
	}

}
