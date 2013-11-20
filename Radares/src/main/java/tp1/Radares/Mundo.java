package tp1.Radares;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Mundo {

	String nombre;
	List<Pais> paises;
	int cantLimites;
	long iniProc;
	long finProc;
	
	public Mundo(String nombre){
		this.nombre = nombre;
		paises = new ArrayList<Pais>();
		cantLimites = 0;
	}
	
	public List<Pais> getListaPaises(){
		return paises;
	}
	
	public void cargarPaises(String sPais, String sLimitrofe){
		//Busco si existe los paises en el grafo; sino, los cargo
		Pais paisCentral = buscarPais(sPais);
		Pais paisLimitrofe = buscarPais(sLimitrofe);
		if (paisCentral == null){
			paisCentral = new Pais(sPais);
			agregarPais(paisCentral);
		}
		if (paisLimitrofe == null){
			paisLimitrofe = new Pais(sLimitrofe);
			agregarPais(paisLimitrofe);
		}

		//Agrego el pais limitrofe para cada uno, y cuento una vez la relación
		cantLimites += paisCentral.agregarLimitrofe(paisLimitrofe);
		paisLimitrofe.agregarLimitrofe(paisCentral);
	}
	
	public void agregarPais(Pais pais){
		paises.add(pais);
	}
	
	public Pais buscarPais (String cod){
		for(int i = 0; i < paises.size(); i++){
			if (paises.get(i).getCodigo().equals(cod)){
				return paises.get(i);
			}
		}
		return null;
	}
	
	public void colocarRadares(){
		iniProc = System.nanoTime();
		while(!mundoCubierto()){
			//ordenamos descendentemente por cantidad de limitrofes sin cobertura
			Collections.sort(paises);
			Pais unPais = paises.get(0);
			//Si el primer pais de la lista tiene algun limitrofe sin cubrir, entonces instalo el radar
			if(unPais.getLimSinCobertura() > 0){
				unPais.instalarRadar();
			}
			//Sino, quiere decir que quedó algún país aislado sin cobertura. Lo busco e instalo
			else{
				cubrirRestantes();
			}
		}
		finProc = System.nanoTime();
	}

	public boolean mundoCubierto(){
		for(Pais unPais:paises){
			if (!unPais.tieneCobertura()){
				return false;
			}
		}
		return true;
	}

	public void cubrirRestantes(){
		for(Pais unPais:paises){
			if (!unPais.tieneCobertura()){
				unPais.instalarRadar();
			}
		}
	}

	public void imprimirDatosPrevios(){
		System.out.println("------------------------------------------------");
		System.out.println(" Modelo: " + nombre);
		System.out.println("Cantidad de países: " + paises.size());
		System.out.println("Cantidad de límites: " + cantLimites);
	}
	
	public void imprimirResultados(){
		System.out.println("------------------------------------------------");
		System.out.println("Solución:");
		int sol = 0;
		for(Pais pais:paises){
			if (pais.isRadar()){
				System.out.print(pais.getCodigo() + " - ");
				sol++;
			}
		}
		System.out.println();
		System.out.println("Total países con radar: " + sol);
		double duracion = (finProc - iniProc) / 1e6;
		System.out.println("Duración ms: " + duracion);
		System.out.println("------------------------------------------------");
	}
	
}
