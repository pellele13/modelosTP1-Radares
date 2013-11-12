package tp1.Radares;

public class App 
{
	public static void main( String[] args )
    {
		//Genero datos para trabajar
    	MundoFactory factory = new MundoFactory();
     	Mundo mundito = factory.getMundo(args[0]);

     	//Proceso el modelo con la heurística
     	mundito.imprimir();
    	mundito.colocarRadares();
     	mundito.imprimir();
     	
     	//Exporto el modelo en formato OPL para CPLEX
     	factory.generarS();
     	factory.exportarModelo(args[1]);
     	
    }
    
    
}
