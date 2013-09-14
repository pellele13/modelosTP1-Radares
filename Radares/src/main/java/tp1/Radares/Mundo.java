package tp1.Radares;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Mundo {

	List<Pais> paises;
	
	public Mundo(){
		paises = new ArrayList<Pais>();
	}
	
	public void agregarPais(Pais pais){
		paises.add(pais);
	}
	
	public int buscarPais (Pais pais){
		int pos = -1;
		for(int i = 0; i < paises.size(); i++){
			if (paises.get(i).getCodigo().equals(pais.getCodigo())){
				pos = i;
			} 
		}
		return pos;
	}
	
	public ArrayList<Pais> getPaisesConRadar(){
		ArrayList<Pais> paisesConRadar = new ArrayList<Pais>();
		//Recorrer paises y copiar los que tienen radar...
		return paisesConRadar;
	}

	public void agregarPaisLimitrofe(Pais pais) {
		int pos = paises.indexOf(pais);
	}
	
	public void getPaisesConSusLimitrofes(){
		
		for(Pais pais:paises){
			System.out.print("Pais = " + pais.getCodigo() + " ");
			System.out.print("Sus limitrofes son = ");
			for(Pais paisLimitrofe:pais.getLimitrofes()){
				System.out.print(paisLimitrofe.getCodigo() + " ");				
			}
			System.out.println();
		}
	}
}
