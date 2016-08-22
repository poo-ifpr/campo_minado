package br.edu.ifpr.poo.campominado.mapa.casa;

import br.edu.ifpr.poo.campominado.EstadoJogo;
import br.edu.ifpr.poo.campominado.mapa.Mapa;

public class CasaMinada extends Casa {

	public CasaMinada(Mapa mapa, int x, int y) {
		super(mapa, x, y, TipoCasa.MINADO);
	}

	@Override
	public String toString() {
		return "X";
	}

	@Override
	public boolean isEscondida() {
		return false;
	}

	@Override
	public EstadoJogo jogar() {
		return EstadoJogo.DERROTA;
	}

}
