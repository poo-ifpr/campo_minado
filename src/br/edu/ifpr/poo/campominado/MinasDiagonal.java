package br.edu.ifpr.poo.campominado;

import java.util.ArrayList;
import java.util.List;

public class MinasDiagonal implements EstrategiaMinas {

	@Override
	public void geraMinas(Mapa mapa) {
		List<Casa> minado = new ArrayList<Casa>();
		Casa[][] casas = mapa.getCasas();
		for(int i = 0; i < casas.length; i++){
			for(int j = 0; j < casas.length; j++){
				if(i == j){
					casas[i][j] = new CasaEscondida(mapa, i, j,
												CampoMinado.MINADO);
					minado.add(casas[i][j]);
				}
				else{
					casas[i][j] = new CasaEscondida(mapa, i, j,
												CampoMinado.SEM_MINA);
				}
			}
		}
		mapa.setCasas(casas);
		mapa.setMinado(minado);
	}

}
