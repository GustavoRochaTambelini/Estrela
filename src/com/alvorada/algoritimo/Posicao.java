package com.alvorada.algoritimo;

public class Posicao {
	int linha;
	int coluna;
	String posicao;
	int obstaculo;
	String abitada;

	public Posicao() {
		this.linha = 0;
		this.coluna = 0;
		this.posicao = linha + "X" + coluna;
		this.abitada = "";
		this.obstaculo = 0;
	}

	public static Posicao frente(Posicao p) {
		p.coluna += 1;
		return p;
	}

	public static Posicao diagonalFrente(Posicao p) {
		p.coluna += 1;
		p.linha += 1;
		return p;
	}

	public static Posicao cima(Posicao p) {
		p.linha += 1;
		return p;
	}

	public static Posicao diagonalCima(Posicao p) {

		p.coluna -= 1;
		p.linha += 1;
		return p;

	}
	public static Posicao Traz(Posicao p) {

		p.coluna -= 1;
		
		return p;

	}
	
	public static Posicao diagonalTraz(Posicao p) {

		p.coluna -= 1;
		p.linha -= 1;
		return p;

	}
	public static Posicao baixo(Posicao p) {

		
		p.linha -= 1;
		return p;

	}
	public static Posicao diagonalBaixo(Posicao p) {

		p.linha -= 1;
		p.coluna += 1;
		return p;

	}
}
