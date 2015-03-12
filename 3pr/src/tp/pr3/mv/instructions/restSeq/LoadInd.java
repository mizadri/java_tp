package tp.pr3.mv.instructions.restSeq;

import tp.pr3.mv.CPU;
import tp.pr3.mv.instructions.Instruction;


public class LoadInd extends RestSeq{

	@Override
	public String toString() {
		return "LOADIND ";
	}

	@Override
	public Instruction parse(String[] s){
		Instruction ins = null;
		if (s.length == 1 && s[0].equalsIgnoreCase("LOADIND"))
			ins = new LoadInd();
		return ins;
	}

	@Override
	protected boolean executeAux(CPU cpu) {
		boolean exec = false;
		Integer top = cpu.pop();
	
		if(top != null && cpu.canLoad(top))
		exec = cpu.push(cpu.load(top));  
		
		return exec;
	}

}
