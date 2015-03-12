package tp.pr4.mv.observers;

public interface StackObserver<T> {
	public void onPush(T value);
	public void onPop(T value);
	//public void onStackReset();
}
