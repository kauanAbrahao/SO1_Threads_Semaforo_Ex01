package view;

import java.util.concurrent.Semaphore;

import controller.ThreadCorredor;

public class Principal {
	public static void main(String[] args) {
		int permissao = 1;
		Semaphore semaforo = new Semaphore(permissao);
		for (int pessoa = 1; pessoa <= 4; pessoa++) {
			Thread corredor = new ThreadCorredor(semaforo, pessoa);
			corredor.start();
		}
	}
}
