package tp1.Radares;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class LeerArchivo {
	private FileInputStream entrada;
	private BufferedReader buffer;
	private String strLine;
	Mundo mundo = new Mundo();
	
	public LeerArchivo(){
		entrada = null;
		buffer = null;
		strLine = null;
	}
	
	public void abrirArchivo(String nombre){
		try{
			entrada = new FileInputStream(nombre);
			buffer = new BufferedReader(new InputStreamReader(entrada));
		}catch (Exception e){
            System.err.println("Ocurrio un error: " + e.getMessage());
		}
	}
	
	public void leerArchivo(){
		String[] datos = null;
		try{			
			while ( (strLine = buffer.readLine()) != null){
				datos = strLine.split(" ");
				if (datos[0].equals("e")){
					procesar(datos[1], datos[2]);
				} 
			}
		}catch (Exception e){
			System.err.println("Ocurrio un error: " + e.getMessage());
		}
	}
	
	private void procesar(String paise, String limitrofe) {
		Pais pais = new Pais(paise);
		Pais paisLimitrofe = new Pais(limitrofe);
		int pos = 0;
		if ((pos = mundo.buscarPais(pais)) != -1){
			mundo.paises.get(pos).getLimitrofes().add(paisLimitrofe);
		}else{
			pais.agregarLimitrofe(paisLimitrofe);
			mundo.agregarPais(pais);
		}
	}

	public void cerrarArchivo(){
		try{
			entrada.close();
		}catch (Exception e){
			System.err.println("Ocurrio un error: " + e.getMessage());
		}
	}

	public Mundo getMundo() {
		return mundo;
	}

}