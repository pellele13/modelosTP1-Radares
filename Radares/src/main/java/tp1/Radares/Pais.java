package tp1.Radares;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Pais  implements Comparable<Pais>{
	String codigo;
	boolean cobertura;
	boolean radar;
	int limSinCobertura;
	List<Pais> limitrofes;
	
	public Pais(String codigo){
		this.codigo = codigo;
		cobertura = false;
		radar = false;
		limSinCobertura = 0;
		limitrofes = new ArrayList<Pais>();
	}
	
	public boolean isRadar() {
		return radar;
	}

	public void setRadar(boolean radar) {
		this.radar = radar;
	}

	public void agregarLimitrofe(Pais lim){
		limitrofes.add(lim);
		limSinCobertura++;
	}
	
	public boolean tieneRadar(){
		return radar;
	}
	
	public void cubrirPais(){
		cobertura = true;
	}
	
	public boolean tieneCobertura(){
		return cobertura;
	}
	
	public void instalarRadar(){
		radar = true;
		cubrirPais();
		Iterator<Pais> itLimitrofes;
		for(itLimitrofes = limitrofes.iterator(); itLimitrofes.hasNext(); ){
			Pais paisLim = itLimitrofes.next();
			paisLim.cubrirPais();
			paisLim.limSinCobertura--;
			paisLim.abarcarLimitrofes();
		}
		limSinCobertura = 0;
	}
	
	public void abarcarLimitrofes(){
		Iterator<Pais> itLimitrofes;
		for(itLimitrofes = limitrofes.iterator(); itLimitrofes.hasNext(); ){
			Pais paisLim = itLimitrofes.next();
			paisLim.limSinCobertura--;
		}
	}
	
	@Override
	public boolean equals(Object otro) {
		if (this == otro)
			return true;
		if ( !(otro instanceof Pais) )
			return false;
		Pais oPais = (Pais) otro;
		return (this.codigo == oPais.codigo);
	}
	
	public String getCodigo() {
		return codigo;
	}

	public List<Pais> getLimitrofes() {
		return limitrofes;
	}

	// El ordenamiento se realiza por el contador de cantidad de países limítrofes que no tienen cobertura.
	// Esto se hace para que en cada vuelta, se elija el pais con más limitrofes que no tengan cobertura primero.
	public int compareTo(Pais otroPais) {
		if(this.limSinCobertura < otroPais.limSinCobertura)
			return 1;
		if(this.limSinCobertura > otroPais.limSinCobertura)
			return -1;
		return 0;
	}

}
