package br.edu.ifpr.poo.campominado;

import java.util.Scanner;

import br.edu.ifpr.poo.campominado.mapa.Mapa;

public class CampoMinado {

	private Mapa mapa;
	private Jogada jogada;
	private EstadoJogo situacao;
	
	public CampoMinado(){
		this(10);
	}
	
	public CampoMinado(int tamanho){
		mapa = new Mapa(tamanho);
		situacao = EstadoJogo.JOGANDO;
	}
	
	public void jogar(){
		Jogada jogada = null;
		do{
			desenhaCampoMinado();
			jogada = criarJogada();
			situacao = mapa.jogar(jogada);	
		}while(situacao == EstadoJogo.JOGANDO);
		if(situacao == EstadoJogo.DERROTA){
			System.out.println("Você perdeu");
		}
		else{
			System.out.println("Você venceu");
		}
		revelarMapa();
	}
	
	private Jogada criarJogada(){
		Scanner scanner = null;
		int x = 0, y = 0;
		System.out.println("Digite a linha, depois a coluna (0 a 9)");
		scanner = new Scanner(System.in);
		x = scanner.nextInt();
		y = scanner.nextInt();
		jogada = new Jogada(x, y);
		System.out.println("x=" + jogada.getX() + " y=" + jogada.getY());
		return jogada;
	}
	
	

	
	private void desenhaCampoMinado(){
		mapa.desenha();
	}
	
	private void revelarMapa(){
		mapa.reveleSe();
		desenhaCampoMinado();
	}
}
