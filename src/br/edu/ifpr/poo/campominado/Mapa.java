package br.edu.ifpr.poo.campominado;

public class Mapa {
	
	private int linhas, colunas;
	Casa[][] casas;

	
	public int getColunas() {
		return colunas;
	}

	public void setColunas(int colunas) {
		this.colunas = colunas;
	}

	public Mapa(int linhas, int colunas){
		this.setLinhas(linhas);
		this.setColunas(colunas);
		inicializa();
	}

	public int getLinhas() {
		return linhas;
	}

	public void setLinhas(int linhas) {
		this.linhas = linhas;
	}
	
	private void inicializa(){
		casas = new Casa[linhas][colunas];
		for(int i = 0; i < casas.length; i++){
			for(int j = 0; j < casas.length; j++){
				if(i == j){
					casas[i][j] = new CasaEscondida(this, i, j,
												CampoMinado.MINADO);
				}
				else{
					casas[i][j] = new CasaEscondida(this, i, j,
												CampoMinado.SEM_MINA);
				}
			}
		}
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
