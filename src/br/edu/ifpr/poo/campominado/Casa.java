package br.edu.ifpr.poo.campominado;

public abstract class Casa {

	private boolean minado;
	private int x, y;
	Mapa mapa;
	
	
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
}
