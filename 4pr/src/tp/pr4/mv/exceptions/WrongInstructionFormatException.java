package tp.pr4.mv.exceptions;

/**
 * Clase encargada de representar una excepcion de formato en la instruccion.
 * Dispone de diferentes constructoras para su depuracion e identificacion.
 * @author Adrian Garcia y Omar Gaytan
 *
 */
public class WrongInstructionFormatException extends Throwable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public WrongInstructionFormatException(){
		super();
	}
	
	public WrongInstructionFormatException(String arg0){
		super(arg0);
	}
	
	public WrongInstructionFormatException(Throwable arg0){
		super(arg0);
	}
	
	public WrongInstructionFormatException(String arg0, Throwable arg1){
		super(arg0,arg1);
	}
}
