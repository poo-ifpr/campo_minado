package br.edu.ifpr.poo.campominado;

import java.util.ArrayList;
import java.util.List;

public class Mapa {
	
	private int tamanho;
	Casa[][] casas;
	List<Casa> minado;

	
	public Mapa(int tamanho){
		this(tamanho, new MinasDiagonal());
	}
	
	public Mapa(int tamanho, EstrategiaMinas estrategia){
		this.setTamanho(tamanho);
		this.setCasas(new Casa[getTamanho()][getTamanho()]);
		minado = new ArrayList<Casa>();
		estrategia.geraMinas(this);
	}

	public Casa[][] getCasas() {
		return casas;
	}

	public void setCasas(Casa[][] casas) {
		this.casas = casas;
	}

	public int getTamanho() {
		return tamanho;
	}

	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}

	public List<Casa> getMinado() {
		return minado;
	}

	public void setMinado(List<Casa> minado) {
		this.minado = minado;
	}

	public void desenha(){
		for(int i = 0; i < casas.length; i++){
			for(int j = 0; j < casas.length; j++){
				System.out.print(casas[i][j]);
			}
			System.out.println("");
		}
	}

}
