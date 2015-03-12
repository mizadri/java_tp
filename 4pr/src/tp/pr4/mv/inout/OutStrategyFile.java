package tp.pr4.mv.inout;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class OutStrategyFile implements OutStrategy {

	private String fname;
    private PrintWriter pw;
    private FileWriter file;
    
	public OutStrategyFile(String fname){
	 this.fname = fname;
	}
	
	public void open() throws IOException {
		
		try {
			file = new FileWriter(fname);
			pw = new PrintWriter(file);
		} catch (FileNotFoundException e) {
			System.err.println("Uso incorrecto: Error al acceder al fichero ("+ fname +")");
			System.exit(2);
		}
		
	}

	
	public void write(int x) {
		pw.print((char)x);
	}

	
	public void close() {
		try{
			file.close();} 
		catch(IOException e) {
			e.printStackTrace();
		}
		
	}

}
