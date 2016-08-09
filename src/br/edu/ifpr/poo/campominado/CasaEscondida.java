package br.edu.ifpr.poo.campominado;

public class CasaEscondida extends Casa {

	public CasaEscondida(Mapa mapa, int x, int y,
						boolean minado) {
		this.setMapa(mapa);
		this.setX(x);
		this.setY(y);
		this.setMinado(minado);
	}
	
	@Override
	public String toString() {
		return "O ";
	}

}
