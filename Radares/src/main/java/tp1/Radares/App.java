package tp1.Radares;

public class App 
{
    public static void main( String[] args )
    {
    	MundoFactory factory = new MundoFactory();
//     	Mundo mundito = factory.getMundo("./EJEMPLOLECTURA.TXT");
     	
     	Mundo mundito = factory.getMundo(args[0]);

     	mundito.getPaisesConSusLimitrofes();
     	
    	mundito.colocarRadares();
    	
     	mundito.getPaisesConSusLimitrofes();
     	
    }
}
