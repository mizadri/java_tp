package tp.pr1.mv;

public class InstructionParser {

	
	public Instruction parse(String s) {
		String[] st = s.split(" ");
			int tam = st.length;
			
			if(tam == 1){
				if(st[0].equalsIgnoreCase("POP")) return new Instruction(InstructionType.POP);
				else if (st[0].equalsIgnoreCase("DUP")) return new Instruction(InstructionType.DUP);
				else if (st[0].equalsIgnoreCase("FLIP")) return new Instruction(InstructionType.FLIP);
				else if (st[0].equalsIgnoreCase("ADD")) return new Instruction(InstructionType.ADD);
				else if (st[0].equalsIgnoreCase("SUB")) return new Instruction(InstructionType.SUB);
				else if (st[0].equalsIgnoreCase("MUL")) return new Instruction(InstructionType.MUL);
				else if (st[0].equalsIgnoreCase("DIV")) return new Instruction(InstructionType.DIV);
				else if (st[0].equalsIgnoreCase("OUT")) return new Instruction(InstructionType.OUT);
				else if (st[0].equalsIgnoreCase("HALT")) return new Instruction(InstructionType.HALT);
				else return null;
			}
			else if (tam == 2) {
				int argumento = Integer.parseInt(st[1]);
				
				if(st[0].equalsIgnoreCase("PUSH")) return new Instruction (InstructionType.PUSH, argumento);
				else if(st[0].equalsIgnoreCase("STORE")) return new Instruction (InstructionType.STORE, argumento);
				else if(st[0].equalsIgnoreCase("LOAD")) return new Instruction (InstructionType.LOAD, argumento);
				else return null;
			}
			
			else return null;
			
	}
	
}
