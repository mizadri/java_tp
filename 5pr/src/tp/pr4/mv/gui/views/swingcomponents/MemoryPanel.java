package tp.pr4.mv.gui.views.swingcomponents;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.TreeMap;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.AbstractTableModel;

import tp.pr4.mv.Memory;
import tp.pr4.mv.OperandStack;

import tp.pr4.mv.controllers.Controller;
import tp.pr4.mv.instructions.Instruction;
import tp.pr4.mv.observers.CPUObserver;
import tp.pr4.mv.observers.MemoryObserver;
import tp.pr4.mv.observers.Observable;



public class MemoryPanel extends JPanel implements  MemoryObserver<Integer>, CPUObserver {
/**
	 * 
	 */
private static final long serialVersionUID = 1L;

private Observable<MemoryObserver<Integer>> memory;
private Observable<CPUObserver> cpu;

private Controller ctrl;
private MemTableModel model;
private JTextField tPos, tValue;
private JLabel lPos, lVal;
private JButton bSet;
private JTable table; 


	public MemoryPanel(Controller ctrl,
			Observable<MemoryObserver<Integer>> memory,
			Observable<CPUObserver> cpu) {
		this.ctrl = ctrl;
		this.memory = memory;
		this.cpu = cpu;
		initGUI();
		
	}

	private void initGUI(){
	
	cpu.addObserver(this);
	memory.addObserver(this);
	
		
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
			String pos = "";
			String val = "";
			try{
			pos = tPos.getText();
			val = tValue.getText();
			ctrl.write(Integer.parseInt(pos), Integer.parseInt(val));
			}catch(NumberFormatException e){
				JOptionPane.showMessageDialog(null, e.getMessage(), "Tipo de datos incorrecto", JOptionPane.ERROR_MESSAGE);
			}
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

		class MemTableModel extends AbstractTableModel{
	
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		String [] columnNames = {"Address", "Value"};
		TreeMap<Integer,Integer> tree ;
		
		
		public MemTableModel(){
			tree = new TreeMap<Integer,Integer>();
		}
	
		public String getColumnName(int col) {
			return columnNames[col].toString(); 
			}
		
		public boolean isCellEditable(int row, int col) { 
			return false;
		}
		
		public void setValue(int index, int value){
			tree.put(index, value);
			model.fireTableDataChanged();
		}
//		@SuppressWarnings("rawtypes")
//		public void refresh(){
//			if(mem!=null){
//				
//			
//			ArrayList<Object> mCells = mem.getArray(); 
//			
//			for(int i = 0; i<mem.getNumElems(); i++){
//					rowData[i][0] = ((MemCell) mCells.get(i)).getPos(); 
//					rowData[i][1] = (int) ((Memory.MemCell)mCells.get(i)).getValue();
//					
//					
//				}
//			model.fireTableDataChanged();
//			table.repaint();
//			}
//			}
		
		
		public int getColumnCount() {
			return 2;
		}
	
		public int getRowCount() {
			return tree.size();
		}
		
	
		public Object getValueAt(int a, int b) {
				int aux = 0 ;
				if(b==0) aux = (int) tree.keySet().toArray()[a];
				if(b==1) aux = (int) tree.values().toArray()[a];
			return aux;
		}
		public void addPair(int a, int b){
		tree.put(a, b);
		model.fireTableDataChanged();
		}
		}

		@Override
		public void onStartInstrExecution(Instruction ins) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onEndInstrExecution(int pc, Memory<Integer> mem, OperandStack<Integer> stack) {
		
		}

		@Override
		public void onStartRun() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onEndRun() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onError(String msg, String title) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onHalt() {
			this.bSet.setEnabled(false);
		}

		@Override
		public void onWrite(int index, Integer value) {
			model.addPair(index, value);
			
		}

	
}
