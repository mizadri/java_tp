package tp.pr4.mv.observers;

public interface MemoryObserver<T> {
	public void onWrite(int index, T value);
	//public void onMemReset(); 
}
