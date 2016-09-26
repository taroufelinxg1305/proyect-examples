package server;

import java.util.StringTokenizer;

public class NmeatoJson {

	private static String entrada;
	private static double[][] lastCoor = new double[10][2];
	static int tamLastcoor = 0;

	public static void SepararToken(String s) {

		// entrada=
		// "$GPGGA,181908.00,3404.7041778,N,07044.3966270,W,4,13,1.00,495.144,M,29.200,M,0.10,0000*40";
		entrada = s;
		StringTokenizer st = new StringTokenizer(entrada, ",");
		String[] tok = new String[st.countTokens()];
		int cont = 0;

		while (st.hasMoreTokens()) {

			tok[cont] = st.nextToken();
			cont++;
		}
		System.out.println("latitud: " + tok[2]);

		System.out.println("longitud: " + tok[4]);
		String linea = "" + tok[2] + "," + tok[4];
		Operaciones.guardar(linea);
		almacenTemp(tok[2], tok[4]);
		

	}
	
	private static void almacenTemp( String s1, String s2 )
	{
		if (tamLastcoor < 10) {
			try {
				lastCoor[tamLastcoor][0] = Double.parseDouble(s1);
				lastCoor[tamLastcoor][1] = Double.parseDouble(s2);
				tamLastcoor++;
			} catch (NumberFormatException n) {
				System.out.println("fallo la conversion de coordenada");
			}

		} else {
			for (int i = 0; i < tamLastcoor-1; i++) {
				lastCoor[i][0] = lastCoor[i + 1][0];
				lastCoor[i][1] = lastCoor[i + 1][1];
			}
			lastCoor[tamLastcoor-1][0] = Double.parseDouble(s1);
			lastCoor[tamLastcoor-1][1] = Double.parseDouble(s2);
		}
		
	}

	public static double[][] getLastCoor() {
		return lastCoor;
	}

	
}
