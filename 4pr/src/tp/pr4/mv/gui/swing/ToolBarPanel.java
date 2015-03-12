package tp.pr4.mv.gui.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
	public class ToolBarPanel extends JPanel{
		private GUIControler guiCtrl;
		private JButton runButton;
		private JButton exitButton;
		private JButton stepButton;
		
		public ToolBarPanel(GUIControler guiCtrl){
			this.guiCtrl = guiCtrl;
			initGUI();
		}

		private void initGUI(){
			this.setBorder(new TitledBorder ("Actions"));
			
			stepButton = new JButton();
			stepButton.setIcon(createImageIcon("step.png"));
			stepButton.setToolTipText("Step");
			this.add(stepButton);
			stepButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					guiCtrl.step();
				}
			});
			runButton = new JButton();
			runButton.setIcon(createImageIcon("run.png"));
			runButton.setToolTipText("Run");
			this.add(runButton);
			runButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					guiCtrl.run();
				}
			});
			exitButton = new JButton();
			exitButton.setIcon(createImageIcon("exit.png"));
			exitButton.setToolTipText("Exit");
			this.add(exitButton);
			exitButton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					guiCtrl.quit();
				}
			});
		}
		public void disableGUI(){
			this.stepButton.setEnabled(false);
			this.runButton.setEnabled(false);
		}

		private static ImageIcon createImageIcon(String path){
			java.net.URL imgURL = MainWindow.class.getResource(path);
			if(imgURL != null) return new ImageIcon(imgURL);
			else return null;
		}

}