package tp.pr4.mv.controllers;

import tp.pr4.mv.CPU;

public class BatchController extends Controller {

	public BatchController(CPU cpu) {
		super(cpu);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void start() {
		super.run();
	}

}
