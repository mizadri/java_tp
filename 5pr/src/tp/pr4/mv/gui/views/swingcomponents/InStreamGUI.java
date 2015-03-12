package tp.pr4.mv.gui.views.swingcomponents;


import javax.swing.JTextArea;

import tp.pr4.mv.inout.InStrategy;

public class InStreamGUI implements InStrategy {
	JTextArea inputTextArea;
	InStrategy old;
	StringBuilder content;
	int pos;
	int leer;
	public InStreamGUI(InStrategy old, JTextArea inputTextArea) {
		this.old = old;
		this.inputTextArea = inputTextArea;
		pos = 0;
		content = new StringBuilder();
		leer = old.read();
		// 1. leer toda la entrada del old, y construir el StringBuilder content
		while (leer != -1){
			content.append((char)leer);
			leer = old.read();
		}
		// 2. mostrar el contenido de content en el inputTextArea
		inputTextArea.setText(content.toString());

	}
	public void open() { /* suponemos que old ya est� abierto */} 
	public void close() { old.close(); } // cerrar old tambi�n

	@Override
		public int read() {
			int c = 0;
			// 1. si pos == content.length() entonce ya no hay m�s caracteres
			if (pos == content.length()) {  
				c = -1;
//				JOptionPane.showMessageDialog(null, "No hay mas caracteres disponibles para leer", "Fin", JOptionPane.INFORMATION_MESSAGE);
			}
			else
			{
				c = content.charAt(pos);  // 2. consultar el car�cter c el la posici�n pos del content
				if((c != 10) && (c != 13)){  // 3. si c no es salto de linea (c!=10 y c!=13) lo cambiamos con * en content!
					content.replace(pos, pos + 1, "*");
				}
				this.inputTextArea.setText(content.toString()); // 4. actualizar el inputTextArea;
				pos++; // 5. actualizar pos
			}
			return c; // 6. devolver c;

	}
}