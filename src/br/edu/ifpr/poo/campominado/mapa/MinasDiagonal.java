package br.edu.ifpr.poo.campominado.mapa;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifpr.poo.campominado.CampoMinado;
import br.edu.ifpr.poo.campominado.mapa.casa.Casa;
import br.edu.ifpr.poo.campominado.mapa.casa.CasaEscondida;
import br.edu.ifpr.poo.campominado.mapa.casa.TipoCasa;

public class MinasDiagonal implements EstrategiaMinas {

	@Override
	public void geraMinas(Mapa mapa) {
		List<Casa> minado = new ArrayList<Casa>();
		Casa[][] casas = mapa.getCasas();
		for(int i = 0; i < casas.length; i++){
			for(int j = 0; j < casas.length; j++){
				if(i == j){
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

}
