package br.edu.ifpr.poo.campominado.mapa.casa;

import br.edu.ifpr.poo.campominado.EstadoJogo;
import br.edu.ifpr.poo.campominado.mapa.Mapa;

public class CasaVazia extends Casa {
	
	private int numVizinhosMinados;
	
	public CasaVazia(Mapa mapa, int x, int y, int numVizinhosMinados) {
		super(mapa, x, y, TipoCasa.SEM_MINA);
		this.numVizinhosMinados = numVizinhosMinados;
	}

	@Override
	public String toString() {
		if(numVizinhosMinados == 0)
			return "  ";
		return numVizinhosMinados + " ";
	}

	@Override
	public boolean isEscondida() {
		return false;
	}

	@Override
	public EstadoJogo jogar() {
		return EstadoJogo.JOGANDO;		
	}

}
