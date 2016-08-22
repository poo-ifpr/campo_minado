package br.edu.ifpr.poo.campominado.mapa;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifpr.poo.campominado.EstadoJogo;
import br.edu.ifpr.poo.campominado.Jogada;
import br.edu.ifpr.poo.campominado.mapa.casa.Casa;
import br.edu.ifpr.poo.campominado.mapa.casa.CasaEscondida;
import br.edu.ifpr.poo.campominado.mapa.casa.CasaMinada;
import br.edu.ifpr.poo.campominado.mapa.casa.CasaVazia;
import br.edu.ifpr.poo.campominado.mapa.casa.TipoCasa;

public class Mapa {
	
	private int tamanho;
	private Casa[][] casas;
	private List<Casa> minado;
	private int numCasasReveladas;
	private final int totalParaVitoria;
	
	public Mapa(int tamanho){
		this(tamanho, new MinasDiagonal());
	}
	
	public Mapa(int tamanho, EstrategiaMinas estrategia){
		this.setTamanho(tamanho);
		this.setCasas(new Casa[getTamanho()][getTamanho()]);
		minado = new ArrayList<Casa>();
		estrategia.geraMinas(this);
		numCasasReveladas = 0;
		totalParaVitoria = (tamanho*tamanho) - minado.size();
	}


	
	private Casa getCasa(Jogada jogada){
		return casas[jogada.getX()][jogada.getY()];
	}
	
	private Casa getCasa(int x, int y){
		Jogada jogada = new Jogada(x, y);
		return getCasa(jogada);
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
		for(int linha = 0; linha < casas.length; linha++){
			if(linha == 0){
				for(int k = 0; k < casas.length; k++){
					System.out.print("--");
				}
			}
			System.out.println("");
			for(int coluna = 0; coluna < casas.length; coluna++){
				if(coluna == 0){
					System.out.print("|");
				}
				System.out.print(casas[linha][coluna] + "|");
			}
			System.out.println("");
			for(int k = 0; k < casas.length; k++){
				System.out.print("--");
			}
			System.out.print("");
		}
		System.out.println("");
	}

	public EstadoJogo jogar(Jogada jogada) {
		Casa casaEscolhida = getCasa(jogada);
		return casaEscolhida.jogar();	
	}

	public void reveleSe() {
		for(int i = 0; i < casas.length; i++){
			for(int j = 0; j < casas.length; j++){
				if(casas[i][j].isEscondida()){
					((CasaEscondida)casas[i][j]).reveleSe();
				}
			}
		}
	}

	
	private List<Casa> getVizinhos(int x, int y){
		List<Casa> vizinhos = new ArrayList<Casa>();
		for(int i = -1; i <= 1; i++){
			for(int j = - 1; j <= 1; j++){
				if((i == 0 && j == 0) || (x + i) < 0 || (x + i) >= tamanho ||

						(y + j) < 0 || (y + j) >= tamanho)
					continue;
				Casa vizinho = getCasa(x + i, y + j);
				vizinhos.add(vizinho);
			}
		}
		return vizinhos;
	}
	
	private List<CasaEscondida> getVizinhosMinados(int x, int y){	
		List<CasaEscondida> vizinhosMinados = new ArrayList<CasaEscondida>();
		List<Casa> vizinhos = getVizinhos(x, y);
		for(Casa vizinho : vizinhos){
			if(vizinho.isEscondida() && vizinho.isMinado()){
				vizinhosMinados.add((CasaEscondida) vizinho);
			}
		}
		return vizinhosMinados;
	}
	
	private List<CasaEscondida> getVizinhosEscondidosVazios(int x, int y){	
		List<CasaEscondida> vizinhosEscondidosVazios = new ArrayList<CasaEscondida>();
		List<Casa> vizinhos = getVizinhos(x, y);
		for(Casa vizinho : vizinhos){
			if(vizinho.isEscondida() && !vizinho.isMinado()){
				vizinhosEscondidosVazios.add((CasaEscondida) vizinho);
			}
		}
		return vizinhosEscondidosVazios;
	}
	
	
	
	public EstadoJogo revelarCasa(CasaEscondida casa) {
		int x = casa.getX();
		int y = casa.getY();
		if(casa.isMinado()){
			getCasas()[x][y] = new CasaMinada(this, x, y);
			return getCasas()[x][y].jogar();
		}
		List<CasaEscondida> vizinhosMinados = getVizinhosMinados(x, y);
		Casa novaCasa = new CasaVazia(this, x, y, vizinhosMinados.size());
		getCasas()[x][y] = novaCasa;
		numCasasReveladas++;
		if(numCasasReveladas >= totalParaVitoria){
			return EstadoJogo.VITORIA;
		}

		if(vizinhosMinados.size() == 0){
			for(CasaEscondida vizinhoEscondido : getVizinhosEscondidosVazios(x, y)){
				if(getVizinhosMinados(vizinhoEscondido.getX(),
						vizinhoEscondido.getY()).size() == 0){
					EstadoJogo situacao = vizinhoEscondido.jogar();
					if(situacao != EstadoJogo.JOGANDO){
						return situacao;
					}
				}
			}
		}


		return EstadoJogo.JOGANDO;
	}

}
