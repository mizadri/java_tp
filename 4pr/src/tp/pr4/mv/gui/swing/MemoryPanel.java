package tp.pr4.mv.gui.swing;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.AbstractTableModel;





import tp.pr4.mv.Memory;
import tp.pr4.mv.Memory.MemCell;


public class MemoryPanel extends JPanel {
/**
	 * 
	 */
private static final long serialVersionUID = 1L;

private GUIControler guiCtrl;
private MemTableModel model;
private JTextField tPos, tValue;
private JLabel lPos, lVal;
private JButton bSet;
private JTable table; 


	public MemoryPanel(GUIControler guiCtrl){
	this.guiCtrl = guiCtrl;
	initGUI();
	}

	private void initGUI(){
	this.setBorder(new TitledBorder("Memory"));
	this.setLayout(new BorderLayout());
	
	model = new MemTableModel();
	table = new JTable(model);

	JPanel bot = new JPanel();
	JPanel buttons = new JPanel();
	JPanel topbuttons = new JPanel();
	JPanel botbuttons = new JPanel();
	
	buttons.setLayout(new GridLayout(2,1));
	bot.setLayout(new BorderLayout());
	
	this.lPos = new JLabel ("Position: ");
	this.lVal = new JLabel ("Value: ");
	this.bSet = new JButton("Set");
	
	this.tPos = new JTextField(5);
	this.tValue = new JTextField(5);
	
	bSet.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			guiCtrl.write(tPos.getText(), tValue.getText());
			tPos.setText("");
			tValue.setText("");
		}
	});
	
	//Agregacion de componentes a paneles pequenos
	
	
	bot.add(new JScrollPane(table), BorderLayout.CENTER);
	topbuttons.add(lPos);
	topbuttons.add(tPos);
	topbuttons.add(lVal);
	topbuttons.add(tValue);
	botbuttons.add(bSet);
	buttons.add(topbuttons);
	buttons.add(botbuttons);
	
	
	
	//Agregacion de componentes al panel global(this)
	
	this.add(bot, BorderLayout.CENTER);
	this.add(buttons, BorderLayout.SOUTH);
	this.setPreferredSize(new Dimension(300, 125));
	}

	void updateView(){
	model.refresh();
	}

		class MemTableModel extends AbstractTableModel{
	
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		String [] columnNames = {"Address", "Value"};
		int[][] rowData = new int[100][2];
		
		
		public MemTableModel(){
		}
		public void setValueAt(int value, int row, int col) { 
			rowData[row][col] = value;
			fireTableCellUpdated(row, col);
			}
		public String getColumnName(int col) {
			return columnNames[col].toString(); 
			}
		
		public boolean isCellEditable(int row, int col) { return true;  }
		@SuppressWarnings("rawtypes")
		public void refresh(){
			Memory<Integer> memory = guiCtrl.getMemory();
			ArrayList<Object> mCells = memory.getArray(); 
			
			for(int i = 0; i<memory.getNumElems(); i++){
					rowData[i][0] = ((MemCell) mCells.get(i)).getPos();
					rowData[i][1] = (int) ((Memory.MemCell)mCells.get(i)).getValue();
					
					
				}
			model.fireTableDataChanged();
			table.repaint();
		
			}
		
		
		public int getColumnCount() {
			return 2;
		}
	
		public int getRowCount() {
			return guiCtrl.getMemoryRows();
		}
	
		public Object getValueAt(int a, int b) {
		return rowData[a][b];
		}
	 	}
}
