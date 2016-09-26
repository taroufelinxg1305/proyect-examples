package client;

import java.lang.*;
import java.io.*;
import java.net.*;
/*clase cliente para probar la comunicacion TCP   */
class Client {
	public static void main(String args[]) {
		try {
			Socket skt = new Socket("localhost", 1234);

			BufferedReader in = new BufferedReader(new InputStreamReader(skt.getInputStream()));
			System.out.print("Received string: '");

			while (!in.ready()) {
			}
			System.out.print(in.readLine()); // Read one line and output it

			System.out.print("'\n");
			in.close();
		} catch (Exception e) {
			System.out.print("Whoops! It didn't work!\n");
		}
	}
}