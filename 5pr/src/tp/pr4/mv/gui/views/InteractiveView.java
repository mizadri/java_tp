package tp.pr4.mv.gui.views;

import tp.pr4.mv.Constants;
import tp.pr4.mv.Memory;
import tp.pr4.mv.OperandStack;
import tp.pr4.mv.instructions.Instruction;
import tp.pr4.mv.observers.CPUObserver;
import tp.pr4.mv.observers.Observable;

public class InteractiveView implements CPUObserver {

	public InteractiveView(Observable<CPUObserver> cpu) {
	cpu.addObserver(this);
	
	}
	@Override
	public void onStartInstrExecution(Instruction ins) {
		System.out.println("Comienza la ejecución de " + ins.toString());

	}

	@Override
	public void onEndInstrExecution(int pc, Memory<Integer> mem,OperandStack<Integer> stack) {
		System.out.println(Constants.MACHINE_STATE);
		System.out.println("Memoria:" + mem.toString() + Constants.LINE_SEPARATOR
				+ "Pila de operandos:" + stack.toString());
		System.out.print('>');
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
		System.err.println(title+msg);
	}

	@Override
	public void onHalt() {
		
	}

}
