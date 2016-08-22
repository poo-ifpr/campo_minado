package br.edu.ifpr.poo.campominado.mapa.casa;

import br.edu.ifpr.poo.campominado.EstadoJogo;
import br.edu.ifpr.poo.campominado.mapa.Mapa;

public abstract class Casa {

	private boolean minado;
	private int x, y;
	Mapa mapa;
	
	
	public Casa(Mapa mapa, int x, int y,
			TipoCasa tipoCasa) {
		this.setMapa(mapa);
		this.setX(x);
		this.setY(y);
		this.setMinado(tipoCasa == TipoCasa.MINADO);
	}
	
	public Mapa getMapa() {
		return mapa;
	}



	public void setMapa(Mapa mapa) {
		this.mapa = mapa;
	}



	public int getY() {
		return y;
	}



	public void setY(int y) {
		this.y = y;
	}



	public abstract String toString();

	public abstract boolean isEscondida();
	
	public boolean isMinado() {
		return minado;
	}



	public void setMinado(boolean minado) {
		this.minado = minado;
	}



	public int getX() {
		return x;
	}



	public void setX(int x) {
		this.x = x;
	}

	public abstract EstadoJogo jogar();
}
