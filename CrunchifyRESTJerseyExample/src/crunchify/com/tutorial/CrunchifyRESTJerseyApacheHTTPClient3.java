package crunchify.com.tutorial;
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JOptionPane;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;


import java.lang.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
 
/**
 * @author Crunchify.com
 * 
 */
 
public class CrunchifyRESTJerseyApacheHTTPClient3 implements Runnable {
	
	
	public static void main(String[] args) {
		
		// Crea el scheduler
				ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
				
				// Programa la ejecución cada 2 segundos del hilo (servicio). La ejecuión empieza a los 5 segundos
				executor.scheduleAtFixedRate(new CrunchifyRESTJerseyApacheHTTPClient3(), 5, 2, TimeUnit.SECONDS);
		       
        
	}

	@Override
	public void run() {
		System.out.println("hola");	
		
		
		try {
            
			URL url = new URL(
					"http://127.0.0.1:8080/CruchifyRESTJerseyExample-1/crunchify/ctofservice/");
					//"http://169.254.121.191:8080/CruchifyRESTJerseyExample-1/crunchify/ctofservice/");
			
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/xml");
			

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}
			

			BufferedReader br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));

			String output;
			System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {

				System.out.println(output);
				//JOptionPane.showMessageDialog(null, output);
		    			}
			
			conn.disconnect();

		} catch (MalformedURLException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
			
		}
	}
}