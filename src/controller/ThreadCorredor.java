package controller;

import java.util.concurrent.Semaphore;

public class ThreadCorredor extends Thread {
	private Semaphore semaforo;
	private int pessoa;
	private int distancia = 200;
	private int metros;
	private static int num = 0;
	
	public ThreadCorredor(Semaphore semaforo, int pessoa) {
		this.semaforo = semaforo;
		this.pessoa = pessoa;
	}
	
		public void run() {
			andaCorredor();
//			=========== Início da Sessão Crítica =========
			try {
				semaforo.acquire();
				abrirPorta();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				semaforo.release();
			}
			
//			=========== Fim da Sessão Crítica =========
		}
		
		private void andaCorredor() {
			while (metros < distancia) {
				metros = metros + (int) (Math.random() * 2) + 4;
				System.out.println("A pessoa " + pessoa + " andou " + metros + " metros!");
			}
		}
		
		private void abrirPorta() {
			num++;
			int tempo = (int)(Math.random() + 1);
			try {
				sleep(tempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("A pessoa " + pessoa + " foi a " + num + "° a atravessar a porta!!!!");
		}
}


