package tp.pr4.mv.inout;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class InStrategyFile implements InStrategy {
	
	String fname;
	FileReader f;
	
	public InStrategyFile(String fname){
		this.fname = fname;	
	}
	
	public void open(){
		try {
			f = new FileReader(fname);
		} catch (FileNotFoundException e) {
			System.err.println("Uso incorrecto: Error al acceder al fichero IN ("+ fname +")");
			System.exit(2);
		}
	}

	public int read() {
		int r = -1;
		try{
			if (f.ready()) r = f.read();
		}
		catch (IOException e){
			e.printStackTrace();
		}
		return r;
	}

	public void close() {
		try {
			f.close();
		} catch (IOException e) {
			System.out.println("Error: " + fname + "cant close");
		}
		
	}

}
