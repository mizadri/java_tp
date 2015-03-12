package tp.pr4.mv.exceptions;

/**
 * Clase encargada de representar una excepcion de la maquina virtual.
 * Dispone de diferentes constructoras para su depuracion e identificacion.
 * @author Adrian Garcia y Omar Gaytan
 *
 */
public class MVException extends Throwable {
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	
	public MVException(){
		super();
	}
	
	public MVException(String arg0){
		super(arg0);
	}
	
	public MVException(Throwable arg0){
		super(arg0);
	}
	
	public MVException(String arg0, Throwable arg1){
		super(arg0,arg1);
	}
}
