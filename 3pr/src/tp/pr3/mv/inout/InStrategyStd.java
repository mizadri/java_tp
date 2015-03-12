package tp.pr3.mv.inout;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class InStrategyStd implements InStrategy {
	BufferedReader lectura;
public InStrategyStd(){
		
	}
	
	public void open() {
		lectura = new BufferedReader (new InputStreamReader (System.in));
	}

	
	public int read() {
		
		int a = -1;
		try {
			a = lectura.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return a;
	}
	

	
	public void close() {
		try {
			lectura.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}
