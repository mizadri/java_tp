package tp.pr3.mv.exceptions;

/**
 * Clase encargada de representar una excepcion de ejecucion de comando.
 * Dispone de diferentes constructoras para su depuracion e identificacion.
 * @author Adrian Garcia y Omar Gaytan
 *
 */
public class CommandExecutionException extends Throwable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public CommandExecutionException(){
		super();
	}
	
	public CommandExecutionException(String arg0){
		super(arg0);
	}
	
	public CommandExecutionException(Throwable arg0){
		super(arg0);
	}
	
	public CommandExecutionException(String arg0, Throwable arg1){
		super(arg0,arg1);
	}
}
