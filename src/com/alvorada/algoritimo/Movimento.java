package com.alvorada.algoritimo;

public class Movimento extends Posicao {
public int frente() {
		
		return coluna += 1;
	}

	public void diaFrente() {
		linha += 1;

	}

	public void cima() {
		linha += 1;
		coluna += 1;
	}

	public void diaCima() {
		linha += 1;
		coluna -= 1;
	}

	public void traz() {
		coluna -= 1;
	}

	public void diaTraz() {
		linha -= 1;
		coluna -= 1;
	}

	public void baixo() {
		linha -= 1;
	}

	public void diaBaixo() {
		linha -= 1;
		coluna += 1;
	}

}
