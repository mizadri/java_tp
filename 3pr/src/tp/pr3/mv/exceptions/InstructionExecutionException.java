package tp.pr3.mv.exceptions;

/**
 * Clase encargada de representar una excepcion de ejecucion de instruccion.
 * Dispone de diferentes constructoras para su depuracion e identificacion.
 * @author Adrian Garcia y Omar Gaytan
 *
 */
public class InstructionExecutionException extends Throwable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public InstructionExecutionException(){
		super();
	}
	
	public InstructionExecutionException(String arg0){
		super(arg0);
	}
	
	public InstructionExecutionException(Throwable arg0){
		super(arg0);
	}
	
	public InstructionExecutionException(String arg0, Throwable arg1){
		super(arg0,arg1);
	}
}
