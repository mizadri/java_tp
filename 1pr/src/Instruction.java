package tp.pr1.mv;

public class Instruction {
	
public static final String LINE_SEPARATOR = System.getProperty("line.separator"); 
private InstructionType instruccion;
private Integer argumento;

	
public Instruction(InstructionType a){
	this.instruccion = a;	
}

public Instruction(InstructionType a, Integer b){
	this.instruccion = a;
	this.argumento = b;
	
}

public InstructionType getType(){
	return this.instruccion;	
}

public Integer getParam(){
	return this.argumento;
}

public String toString(){
	String a = "";
	a = instruccion + " " + Integer.toString(argumento);
	return a;
}

}
