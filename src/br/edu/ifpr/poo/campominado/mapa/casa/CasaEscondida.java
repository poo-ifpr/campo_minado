package br.edu.ifpr.poo.campominado.mapa.casa;

import br.edu.ifpr.poo.campominado.EstadoJogo;
import br.edu.ifpr.poo.campominado.mapa.Mapa;

public class CasaEscondida extends Casa {


	
	public CasaEscondida(Mapa mapa, int x, int y, TipoCasa tipoCasa) {
		super(mapa, x, y, tipoCasa);
		
	}

	@Override
	public String toString() {
		return "O ";
	}

	@Override
	public boolean isEscondida() {
		return true;
	}


	public void reveleSe() {
		mapa.revelarCasa(this);

	}

	@Override
	public EstadoJogo jogar() {
		return mapa.revelarCasa(this);
	}

}
