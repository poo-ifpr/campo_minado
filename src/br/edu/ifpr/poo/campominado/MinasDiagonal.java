package br.edu.ifpr.poo.campominado;

public class MinasDiagonal implements EstrategiaMinas {

	@Override
	public void geraMinas(Mapa mapa) {
		Casa[][] casas = new Casa[mapa.getLinhas()][mapa.getColunas()];
		for(int i = 0; i < casas.length; i++){
			for(int j = 0; j < casas.length; j++){
				if(i == j){
					casas[i][j] = new CasaEscondida(mapa, i, j,
												CampoMinado.MINADO);
				}
				else{
					casas[i][j] = new CasaEscondida(mapa, i, j,
												CampoMinado.SEM_MINA);
				}
			}
		}
		mapa.setCasas(casas);
	}

}
