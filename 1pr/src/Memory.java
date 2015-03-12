package tp.pr1.mv;

public class Memory {
	
private Integer[] memory;
private boolean[] memUsed;
private int maxSize = 100;
private int numberOfElements = 0;

public Memory(){
	this.memory = new Integer[this.maxSize];
	this.memUsed = new boolean[this.maxSize];
}

public String toString(){
	String cad = "";

	if(this.numberOfElements == 0) 
		cad = cad + " <vacia>";
	
	else for(int i = 0; i < this.memory.length; i++ ){	
		if(this.memUsed[i])	//comprueba que la posicion haya sido escrita
			cad = cad + " [" + i + "]:" + this.memory[i];
	}
	return cad;	
}

public boolean store(int pos, int val){
	boolean aux;

    if(pos > memory.length){
		aux = false;
	}else {
		this.memory[pos] = val;
		this.memUsed[pos] = true;
		this.numberOfElements++;
		aux = true;
	}
	return aux;
}


public int load(int pos){
	return memory[pos];
}

public boolean canLoad(int pos){
	boolean aux = false;

if(pos>=0 && pos < memory.length && memUsed[pos]){
	aux = true;
}
	
	return aux;
}

public void reSize() {
	Integer[] aux = new Integer[maxSize];
	boolean[] auxB = new boolean[maxSize];
	
	for(int i=0;i<maxSize;i++){
		aux[i] = memory[i];
		auxB[i] = memUsed[i];
	}
	
	maxSize = maxSize * 2;
	memory = new Integer[maxSize];
	memUsed = new boolean[maxSize];
	
	for(int i=0; i < maxSize/2; i++){
		memory[i] = aux[i];
		memUsed[i] = auxB[i];
		}
	}
}
