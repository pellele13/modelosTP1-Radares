package tp1.Exportador;

import java.util.ArrayList;

public class ColeccionLimitrofes {
	private ArrayList<GrupoLimitrofes> coleccion;

	public ColeccionLimitrofes() {
		coleccion = new ArrayList<GrupoLimitrofes>();
	}

	public int getCantidadSubconjuntos() {
		return coleccion.size();
	}

	public void agregarSubconjunto(GrupoLimitrofes subconjunto) {
		coleccion.add(subconjunto);
	}

	public void exportarRestricciones(Exportador salida) {
		for (GrupoLimitrofes grupo : coleccion) {
			salida.escribirString("\t" + grupo.generarRestriccion() + "\n");
		}
	}

	public void imprimir() {
		for (GrupoLimitrofes grupo : coleccion) {
			grupo.imprimir();
			System.out.println();
		}
	}

	public void exportarVariables(Exportador salida) {
		for(GrupoLimitrofes pais : coleccion){
			salida.escribirString("dvar int Y" + pais.getPaisVertice().toString() + " in bivalente;\n");			
		}
	}

	public void exportarFuncional(Exportador salida) {
		for(int i=0; coleccion.size() > i; i++){
			if(coleccion.size()-1 > i)
				salida.escribirString("Y" + coleccion.get(i).getPaisVertice().toString() + " + ");
			else
				salida.escribirString("Y" + coleccion.get(i).getPaisVertice().toString() + ";\n");
		}
	}
}