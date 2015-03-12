package tp.pr4.mv.exceptions;

/**
 * Esta clase representa una excepcion que se lanza cuando intentas sacar elementos de una pila vacia.
 * @author Omar Gaytan y Adrian García
 *
 */
public class EmptyStackAcces extends Throwable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public EmptyStackAcces(){
		super();
	}
	
	public EmptyStackAcces(String arg0){
		super(arg0);
	}
	
	public EmptyStackAcces(Throwable arg0){
		super(arg0);
	}
	
	public EmptyStackAcces(String arg0, Throwable arg1){
		super(arg0,arg1);
	}
}
