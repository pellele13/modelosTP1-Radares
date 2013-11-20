package tp1.Radares;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.List;

import tp1.Exportador.ColeccionLimitrofes;
import tp1.Exportador.Exportador;
import tp1.Exportador.GrupoLimitrofes;

public class MundoFactory {
	private FileInputStream entrada;
	private BufferedReader buffer;
	private String strLine;
	Mundo mundo;
	private ColeccionLimitrofes S = new ColeccionLimitrofes();
	private Exportador salida = new Exportador();
	
	public MundoFactory(){
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
		mundo.cargarPaises(paise, limitrofe);
	}

	public void cerrarArchivo(){
		try{
			entrada.close();
		}catch (Exception e){
			System.err.println("Ocurrio un error: " + e.getMessage());
		}
	}

	public Mundo getMundo(String origen) {
		mundo = new Mundo(origen);
    	abrirArchivo(origen);
    	leerArchivo();
    	cerrarArchivo();
		return mundo;
	}

	public void generarS() {
		List<Pais> paises = mundo.getListaPaises();
		GrupoLimitrofes grupo;
		Integer paisVertice;
		List<Pais> limitrofes;

		for (Pais pais : paises){
			paisVertice = new Integer(pais.getCodigo());
			grupo = new GrupoLimitrofes(paisVertice);
			limitrofes = pais.getLimitrofes();
			for (Pais paisLim : limitrofes){
				grupo.agregarPais(new Integer(paisLim.getCodigo()));
			}
			S.agregarSubconjunto(grupo);
		}
	}

	public void exportarModelo(String rutaArchivoDestino) {
		try {
			salida.crearArchivo(rutaArchivoDestino);
		}
		catch (Exception e) {
			System.out.println("Error al crear archivo de salida");
			return;
		}
		
		salida.escribirString("range bivalente = 0..1;\n");

		salida.escribirString("// Variables Bivalentes\n");
		S.exportarVariables(salida);

		salida.escribirString("\n// Objetivo\n");
		salida.escribirString("minimize\n");
		S.exportarFuncional(salida);

		salida.escribirString("\n// Modelo\n");
		salida.escribirString("subject to {\n");
		S.exportarRestricciones(salida);
		salida.escribirString("}");

		salida.cerrarArchivo();
	}


}
