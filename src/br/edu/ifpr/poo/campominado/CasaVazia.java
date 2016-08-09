package br.edu.ifpr.poo.campominado;

public class CasaVazia extends Casa {

	public CasaVazia() {
		this.setMinado(false);
	}
	
	@Override
	public String toString() {
		return "  ";
	}

}
