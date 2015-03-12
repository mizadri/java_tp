package tp.pr4.mv.exceptions;

/**
 * Clase encargada de representar una excepcion de formato en el comando.
 * Dispone de diferentes constructoras para su depuracion e identificacion.
 * @author Adrian Garcia y Omar Gaytan
 *
 */
public class WrongCommandFormatException extends Throwable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public WrongCommandFormatException(){
		super();
	}
	
	public WrongCommandFormatException(String arg0){
		super(arg0);
	}
	
	public WrongCommandFormatException(Throwable arg0){
		super(arg0);
	}
	
	public WrongCommandFormatException(String arg0, Throwable arg1){
		super(arg0,arg1);
	}
}
