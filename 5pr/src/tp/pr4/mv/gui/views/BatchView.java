package tp.pr4.mv.gui.views;



import tp.pr4.mv.Memory;
import tp.pr4.mv.OperandStack;
import tp.pr4.mv.instructions.Instruction;
import tp.pr4.mv.observers.CPUObserver;
import tp.pr4.mv.observers.Observable;

public class BatchView implements CPUObserver {

	 public BatchView(Observable<CPUObserver> cpu) {
	 cpu.addObserver(this);
	
	}
	@Override
	public void onStartInstrExecution(Instruction ins) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onEndInstrExecution(int pc, Memory<Integer> mem, OperandStack<Integer> stack) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStartRun() {

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
		// TODO Auto-generated method stub

	}

}
