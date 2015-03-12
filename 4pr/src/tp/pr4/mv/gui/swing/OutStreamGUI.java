package tp.pr4.mv.gui.swing;

import java.io.IOException;

import javax.swing.JTextArea;

import tp.pr4.mv.inout.OutStrategy;

public class OutStreamGUI implements OutStrategy {
	
	JTextArea outputTextArea;
	OutStrategy old;
	StringBuilder content;
	int pos;
	
	public OutStreamGUI(OutStrategy old, JTextArea outputTextArea) {

		this.old = old;

		 this.outputTextArea = outputTextArea;

		 content = new StringBuilder();
	 }
	
	@Override
	public void open() throws IOException {
		// no hacer nada, suponemos que old ya est� abierto

	}

	@Override
	public void write(int x) {
		
		content.append((char)x);
		old.write((char)x);
		outputTextArea.setText(content.toString());

	}

	@Override
	public void close() {
		old.close();
	}

}
