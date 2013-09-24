package tp1.Radares;

public class App 
{
    public static void main( String[] args )
    {
    	MundoFactory factory = new MundoFactory();
    	factory.abrirArchivo("./EJEMPLOLECTURA.TXT");
    	factory.leerArchivo();
     	Mundo mundito = factory.getMundo();
     	
     	mundito.getPaisesConSusLimitrofes();
     	
//    	mundito.colocarRadares();
//    	
//     	mundito.getPaisesConSusLimitrofes();
     	
    	factory.cerrarArchivo();
    	
    	mundito.colocarRadares();
    	
    }
}
