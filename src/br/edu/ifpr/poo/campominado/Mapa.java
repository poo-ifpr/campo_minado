package br.edu.ifpr.poo.campominado;

public class Mapa {
	
	private int linhas, colunas;
	Casa[][] campoMinado;

	
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
		campoMinado = new Casa[linhas][colunas];
		for(int i = 0; i < campoMinado.length; i++){
			for(int j = 0; j < campoMinado.length; j++){
				if(i == j){
					campoMinado[i][j] = new CasaEscondida(this, i, j,
												CampoMinado.MINADO);
				}
				else{
					campoMinado[i][j] = new CasaEscondida(this, i, j,
												CampoMinado.SEM_MINA);
				}
			}
		}
	}
	
	public void desenha(){
		for(int i = 0; i < campoMinado.length; i++){
			for(int j = 0; j < campoMinado.length; j++){
				System.out.print(campoMinado[i][j]);
			}
			System.out.println("");
		}
	}

}
