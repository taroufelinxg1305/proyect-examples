package server;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Operaciones 
{
	
	String filename="";
	
	
	public static void guardar(String linea)
	{
		 try
		 {
		    File file = new File( "coordenadas.txt" );

		    // si no existe el archivo
		    if ( ! file.exists( ) )
		    {
		        file.createNewFile( );
		    }

		    FileWriter fw = new FileWriter( file.getAbsoluteFile( ),true );
		    BufferedWriter bw = new BufferedWriter( fw );
		    bw.write( linea );
		    bw.newLine();
		    bw.close( );
		    //System.out.println("Done writing to " + fileName); //For testing 
		 }
		 catch( IOException e )
		 {
		 System.out.println("Error: " + e);
		 e.printStackTrace( );
		 }
		} 
	
	public static double[] promedioCoor(double[][] temp)
	{
		double[] promVec = new double[2];
		double pLat,pLon,sLat=0,sLon=0;
		int nfilas= temp.length;
		for(int i=0;i<nfilas;i++)
		{
			sLat+=temp[i][0];
			sLon+=temp[i][1];
		}
		pLat=sLat/nfilas;
		pLon=sLon/nfilas;
		promVec[0]=pLat;
		promVec[1]=pLon;
		return promVec;
	}
	
	
}
