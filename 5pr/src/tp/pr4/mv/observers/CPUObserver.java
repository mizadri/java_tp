package tp.pr4.mv.observers;

import tp.pr4.mv.Memory;
import tp.pr4.mv.OperandStack;
import tp.pr4.mv.instructions.Instruction;

public interface CPUObserver {
	public void onStartInstrExecution(Instruction ins);
	public void onEndInstrExecution(int pc, Memory<Integer> mem, OperandStack<Integer> stack);
	public void onStartRun();
	public void onEndRun();
	public void onError(String msg, String title);
	public void onHalt();
	//public void onReset(ProgramMV program);
	
}
