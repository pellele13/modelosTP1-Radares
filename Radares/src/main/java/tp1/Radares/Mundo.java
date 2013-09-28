package tp1.Radares;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Mundo {

	List<Pais> paises;
	
	public Mundo(){
		paises = new ArrayList<Pais>();
	}
	
	public void cargarPaises(String pais, String pLimitrofe){
		Pais paise = new Pais(pais);
		Pais paisLimitrofe = new Pais(pLimitrofe);
		int pos = 0;
		if ((pos = this.buscarPais(paise)) != -1){
			this.paises.get(pos).agregarLimitrofe(paisLimitrofe);
		}else{
			paise.agregarLimitrofe(paisLimitrofe);
			agregarPais(paise);
		}
		pos = 0;
		if ((pos = this.buscarPais(paisLimitrofe)) != -1){
			this.paises.get(pos).agregarLimitrofe(paise);
		}else{
			paisLimitrofe.agregarLimitrofe(paise);
			agregarPais(paisLimitrofe);
		}
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
	
	public void getPaisesConRadar(){
		for(Pais pais:paises){
			if (pais.isRadar()){
				System.out.println(pais.getCodigo());
			}
		}
		//Recorrer paises y copiar los que tienen radar...
	}

	public boolean mundoCubierto(){
		for(Pais unPais:paises){
			if (!unPais.tieneCobertura()){
				return false;
			}
		}
		return true;
	}

	public void getPaisesConSusLimitrofes(){
		Collections.sort(paises);
		for(Pais pais:paises){
			System.out.print("Pais: " + pais.getCodigo() + " | ");
			System.out.print("Cobertura: " + pais.tieneCobertura());
			System.out.println(" Radar: " + pais.tieneRadar());
			System.out.print("Limitrofes: ");
			for(Pais paisLimitrofe:pais.getLimitrofes()){
				System.out.print(paisLimitrofe.getCodigo() + " ");				
			}
			System.out.println();
			System.out.println();
		}
		System.out.println("------------------------------------------------");
	}
	
	public void colocarRadares(){
		while(!mundoCubierto()){
			//ordenamos descendentemente por cantidad de limitrofes sin cobertura
			Collections.sort(paises);
			Pais unPais = paises.get(0);
			unPais.instalarRadar();
		}
	}
}
