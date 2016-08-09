package br.edu.ifpr.poo.campominado;

import java.util.Scanner;

public class CampoMinado {

	public static boolean MINADO = true;
	public static boolean SEM_MINA = false;
	Mapa mapa;
	Jogada jogada;
	
	public CampoMinado(){
		mapa = new Mapa(10, 10);
	}
	
	public void jogar(){
		desenhaCampoMinado();
		jogada();
	}
	
	private void jogada(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Digite a linha, depois a coluna (0 a 9)");
		int x = scanner.nextInt();
		int y = scanner.nextInt();
		jogada = new Jogada(x, y);
		System.out.println("x=" + jogada.getX() + " y=" + jogada.getY());
		scanner.close();
	}
	
	

	
	private void desenhaCampoMinado(){
		mapa.desenha();
	}
}
