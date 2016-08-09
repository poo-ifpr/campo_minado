package br.edu.ifpr.poo.campominado;

public class Mapa {
	
	private int linhas, colunas;
	Casa[][] casas;

	
	public Mapa(int linhas, int colunas){
		this(linhas, colunas, new MinasDiagonal());
	}
	
	public Mapa(int linhas, int colunas, EstrategiaMinas estrategia){
		this.setLinhas(linhas);
		this.setColunas(colunas);
		estrategia.geraMinas(this);
	}

	public Casa[][] getCasas() {
		return casas;
	}

	public void setCasas(Casa[][] casas) {
		this.casas = casas;
	}

	public int getColunas() {
		return colunas;
	}

	public void setColunas(int colunas) {
		this.colunas = colunas;
	}

	public int getLinhas() {
		return linhas;
	}

	public void setLinhas(int linhas) {
		this.linhas = linhas;
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
