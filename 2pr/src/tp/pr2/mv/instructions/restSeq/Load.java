package tp.pr2.mv.instructions.restSeq;


import tp.pr2.mv.instructions.Instruction;
import tp.pr2.mv.CPU;

/**
 * Clase encargada de ejecutar, crear y representar la instruccion LOAD
 * @author Omar Gaytan y Adrian Garcia
 *
 */
public class Load extends RestSeq{

	private int operand;
	
	/**
	 * Constructora por defecto
	 */
	public Load(){
		
	}
	
	/**
	 * Constructora con un parametro
	 * @param ope - posicion de memoria a leer
	 */
	public Load(int ope){
		
		this.operand = ope;
	}
	
	/**
	 * Metodo que ejecuta la instruccion LOAD sobre la CPU
	 * @param cpu
	 * @return True si se realiza la instruccion correctamente y false en caso de que la posicion de memoria no sea correcta
	 */
	protected boolean executeAux(CPU cpu) {
		boolean exec = false;
		
		if(cpu.canLoad(this.operand)){
			cpu.push(cpu.load(this.operand));
			exec= true;
		}
		return exec;
	}

	/**
	 * Crea un objeto nuevo de la instruccion correspondiente si el texto analizado coincide con la cadena "LOAD + (int)"
	 * @param s - cadena de texto analizar
	 * @return Nuevo objeto de tipo Instruction
	 */
	public Instruction parse(String[] s) {
		Instruction ins = null;
		if (s.length == 2 && s[0].equalsIgnoreCase("LOAD")){
			
			ins = new Load(Integer.parseInt(s[1]));
		}
		return ins;
	}
	
	/**
	 * Devuelve una representacion textual de la instruccion
	 * @return "LOAD + (posicion en memoria)"
	 */
    public String toString(){
		
		return "LOAD " + this.operand;
		
	}

}
