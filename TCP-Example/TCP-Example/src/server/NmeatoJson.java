package server;

import java.util.StringTokenizer;


public class NmeatoJson {

	private static String entrada;
	 	  
	   public static void SepararToken( String s)
	   {

		   //entrada= "$GPGGA,181908.00,3404.7041778,N,07044.3966270,W,4,13,1.00,495.144,M,29.200,M,0.10,0000*40";
		   entrada=s;
		   StringTokenizer st = new StringTokenizer(entrada, "," ) ;
		   String[] tok = new String[st.countTokens()];
		   int cont=0;

		   while(st.hasMoreTokens())
		   {

		   tok[cont] = st.nextToken();
		   cont++;
		   }
		   System.out.println("latitud: "+ tok[2] );

		   System.out.println("longitud: "+ tok[4] );

	
	
	
	   }
}

