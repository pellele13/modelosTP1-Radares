package tp1.Radares;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Pais {
	int codigo;
	boolean cobertura;
	int limSinCobertura;
	List<Pais> limitrofes;
	
	public Pais(int codigo){
		this.codigo = codigo;
		cobertura = false;
		limSinCobertura = 0;
		limitrofes = new ArrayList<Pais>();
	}
	
	public void agregarLimitrofe(Pais lim){
		limitrofes.add(lim);
		limSinCobertura++;
	}
	
	public void aumentarCoberturaLimitrofe(){
		limSinCobertura--;
	}
	
	public void instalarAntena(){
		cobertura = true;
		Iterator<Pais> itLimitrofes;
		for(itLimitrofes = limitrofes.iterator(); itLimitrofes.hasNext(); ){
			Pais paisLim = itLimitrofes.next();
			paisLim.aumentarCoberturaLimitrofe();
			paisLim.abarcarLimitrofes();
		}
		limSinCobertura = 0;
	}
	
	public void abarcarLimitrofes(){
		Iterator<Pais> itLimitrofes;
		for(itLimitrofes = limitrofes.iterator(); itLimitrofes.hasNext(); ){
			Pais paisLim = itLimitrofes.next();
			paisLim.aumentarCoberturaLimitrofe();
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
}
