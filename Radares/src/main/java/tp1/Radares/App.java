package tp1.Radares;

public class App 
{
    public static void main( String[] args )
    {
    	LeerArchivo arch = new LeerArchivo();
    	arch.abrirArchivo("/home/pelele/git/modelosTP1-Radares/Radares/EJEMPLOLECTURA.TXT");
    	arch.leerArchivo();
     	Mundo mundito = arch.getMundo();
     	
     	mundito.getPaisesConSusLimitrofes();
     		    	
    	
    	arch.cerrarArchivo();
    	
    }
}
