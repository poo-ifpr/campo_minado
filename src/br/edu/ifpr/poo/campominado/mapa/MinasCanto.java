package br.edu.ifpr.poo.campominado.mapa;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifpr.poo.campominado.mapa.casa.Casa;
import br.edu.ifpr.poo.campominado.mapa.casa.CasaEscondida;
import br.edu.ifpr.poo.campominado.mapa.casa.TipoCasa;

public class MinasCanto implements EstrategiaMinas {

	@Override
	public void geraMinas(Mapa mapa) {
		List<Casa> minado = new ArrayList<Casa>();
		Casa[][] casas = mapa.getCasas();
		for(int i = 0; i < casas.length; i++){
			for(int j = 0; j < casas.length; j++){
				if(ehCanto(i,j, casas.length)){
					casas[i][j] = new CasaEscondida(mapa, i, j,
												TipoCasa.MINADO);
					minado.add(casas[i][j]);
				}
				else{
					casas[i][j] = new CasaEscondida(mapa, i, j,
												TipoCasa.SEM_MINA);
				}
			}
		}
		mapa.setCasas(casas);
		mapa.setMinado(minado);
	}
	
	private boolean ehCanto(int linha, int coluna, int tamanho){
		return ehPrimeiraLinha(linha) ||
				ehUltimaLinha(linha, tamanho) ||
				ehPrimeiraColuna(coluna) ||
				ehUltimaColuna(coluna, tamanho);
	}

	private boolean ehUltimaColuna(int coluna, int tamanho) {
		return coluna == tamanho - 1;
	}

	private boolean ehPrimeiraColuna(int coluna) {
		return coluna == 0;
	}

	private boolean ehUltimaLinha(int linha, int tamanho) {
		return linha == tamanho - 1;
	}

	private boolean ehPrimeiraLinha(int linha) {
		return linha == 0;
	}
	
	
	
	
	

}
