package tp.pr3.mv.instructions;

import tp.pr3.mv.exceptions.WrongInstructionFormatException;
import tp.pr3.mv.instructions.arithmetics.*;
import tp.pr3.mv.instructions.booleanCond.*;
import tp.pr3.mv.instructions.jumps.*;
import tp.pr3.mv.instructions.numericCond.*;
import tp.pr3.mv.instructions.restSeq.*;



/**
 * Clase encargada de traducir la entrada de consola a instrucciones.
 * @author Adrian Garcia y Omar Gaytan
 *
 */
public class InstructionParser {

	/**
	 * Array de instrucciones
	 */
	private static Instruction arrayIns[] = {
		new Add(), new Div(), new Mul(), new Sub(),
		new And(), new Not(), new Or(),
		new Bf(), new Bt(), new Jump(),
		new Equals(), new GreaterThan(), new LessOrEqual(), new LessThan(),
		new Dup(), new Flip(), new Halt(),new Load(), new Neg(), new Out(), new Pop(), new Push(), new Store(),	new In(),
		new Rjump(), new Rbf(), new Rbt(),
		new JumpInd(), new LoadInd(), new StoreInd()
	};
	
	/**
	 * Analiza la entrada del usuario y genera la instruccion correspondiente.
	 * @param line
	 * @return instruccion
	 * @throws WrongInstructionFormatException 
	 */
	public Instruction parseProgramInstruction(String line) throws WrongInstructionFormatException {
		Instruction ins = null;
		String[] st = line.split(" ");

		int i = 0;
		boolean stop = false;
		while (i < InstructionParser.arrayIns.length && !stop) {
			ins = InstructionParser.arrayIns[i].parse(st);
			if (ins != null)
				stop = true;
			else
				i++;
		}
		if(ins == null) throw new WrongInstructionFormatException("Error en el formato de la instrucción");
		return ins;

	}
	
}
