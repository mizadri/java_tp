package tp.pr3.mv.exceptions;

/**
 * Clase encargada de representar una excepcion de ejecucion de instruccion.
 * Dispone de diferentes constructoras para su depuracion e identificacion.
 * @author Adrian Garcia y Omar Gaytan
 *
 */
public class LethalJumpsException extends InstructionExecutionException {
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	
	public LethalJumpsException(){
		super();
	}
	
	public LethalJumpsException(String arg0){
		super(arg0);
	}
	
	public LethalJumpsException(Throwable arg0){
		super(arg0);
	}
	
	public LethalJumpsException(String arg0, Throwable arg1){
		super(arg0,arg1);
	}
	
}
