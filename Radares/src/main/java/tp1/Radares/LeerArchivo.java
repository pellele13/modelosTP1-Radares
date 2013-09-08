package tp1.Radares;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class LeerArchivo {
	private FileInputStream entrada;
	private BufferedReader buffer;
	
	public LeerArchivo(){
		
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
		String strLinea;
		try{			
			while ((strLinea = this.buffer.readLine()) != null){
				char flag = strLinea.charAt(0);
				if (flag == 'c'){
					System.out.println("Este es un comentario");
				}else if(flag == 'p'){
					System.out.println("Esto es # total de nodos y aristas");
				}else{
					System.out.println("Esto me interesa");
					System.out.println(strLinea);
				}
			}
		}catch (Exception e){
			System.err.println("Ocurrio un error: " + e.getMessage());
		}
	}
	
	public void cerrarArchivo(){
		try{
			entrada.close();
		}catch (Exception e){
			System.err.println("Ocurrio un error: " + e.getMessage());
		}
	}
}