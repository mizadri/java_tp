package tp.pr4.mv.inout;

import java.io.IOException;

public interface OutStrategy {

	public void open() throws IOException;
	public void write(int x);
	public void close();
	
}
