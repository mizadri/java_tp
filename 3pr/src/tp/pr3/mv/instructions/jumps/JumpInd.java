package tp.pr3.mv.instructions.jumps;

import tp.pr3.mv.CPU;
import tp.pr3.mv.exceptions.InstructionExecutionException;
import tp.pr3.mv.exceptions.LethalJumpsException;
import tp.pr3.mv.instructions.Instruction;


public class JumpInd implements Instruction {

	@Override
	public void execute(CPU cpu) throws InstructionExecutionException {
		boolean exec = false;
		Integer top = cpu.pop();
		
		if(top != null)
		exec = cpu.modifyProgramCounter(top);
		
		
		if(!exec) throw new LethalJumpsException("Error ejecutando instruccion JumpInd(nº de salto incorrecto/pila vacia)");
		//return exec;
	}

	@Override
	public String toString() {
		return "JUMPIND";
	}

	@Override
	public Instruction parse(String[] s){
		Instruction ins = null;
		if (s.length == 1 && s[0].equalsIgnoreCase("JUMPIND"))
			ins = new JumpInd();
		return ins;
	}

}
