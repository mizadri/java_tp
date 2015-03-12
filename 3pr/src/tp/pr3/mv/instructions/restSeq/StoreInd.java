package tp.pr3.mv.instructions.restSeq;

import tp.pr3.mv.CPU;
import tp.pr3.mv.instructions.Instruction;
 

public class StoreInd extends RestSeq
{


	public String toString() {
		return "STOREIND ";
	}

	public Instruction parse(String[] s){
		Instruction ins = null;
		if (s.length == 1 && s[0].equalsIgnoreCase("STOREIND"))
			ins = new StoreInd();
		return ins;
	}

	protected boolean executeAux(CPU cpu) {
		boolean exec = false;
		
		if(cpu.getSizeStack()>=2){
		int top = cpu.pop();
		int top2 = cpu.pop();
		exec = cpu.write(top2, top); // write(pos , value) 
		}

		return exec;
	}

}
