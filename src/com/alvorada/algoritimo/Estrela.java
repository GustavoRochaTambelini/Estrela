package com.alvorada.algoritimo;

import java.io.BufferedReader;
import java.io.File;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Estrela extends Posicao {
	public static String s;
	public static String[] array;
	public static ArrayList<Posicao> posicao = new ArrayList<Posicao>();
	public static ArrayList<Posicao> arrayAUX = new ArrayList<Posicao>();
	public static int dimencao;
	public static BufferedReader br;
	public static int po = 0;
	public static int origem;
	public static int destino;
	public static int aux;
	static int index = 0;

	public static void main(String[] args) throws IOException {
		Manipulacao();
		for (int i = 0; i < posicao.size(); i++) {
			arrayAUX.add(i, new Posicao());
			arrayAUX.get(i).linha = posicao.get(i).linha;
			arrayAUX.get(i).coluna = posicao.get(i).coluna;
			arrayAUX.get(i).obstaculo = posicao.get(i).obstaculo;
			if (array.length == 4) {
				arrayAUX.get(i).abitada = posicao.get(i).abitada;
			}

		}

		Imprimir(arrayAUX);
		Imprimir(posicao);
		System.out.println("\n" + origem + "\n" + destino);
		Distancia(arrayAUX, origem);
	}

	public static void Entrada() throws IOException {
		File f = new File("Entrada.txt");
		f.createNewFile();
		FileReader fr = new FileReader(f);
		br = new BufferedReader(fr);

	}

	public static void Manipulacao() throws IOException {
		Entrada();

		while ((s = br.readLine()) != null) {

			armazenar();

		}
		procuraOrigem(posicao, 0);
		procuraDestino(posicao, 0);

	}

	public static void armazenar() {
		if (array == null) {
			array = s.split(";");
			dimencao = Integer.parseInt(array[0]);
		} else {
			array = s.split(";");

			posicao.add(po, new Posicao());
			posicao.get(po).linha = Integer.parseInt(array[0]);
			posicao.get(po).coluna = Integer.parseInt(array[1]);
			posicao.get(po).obstaculo = Integer.parseInt(array[2]);
			if (array.length == 4) {
				posicao.get(po).abitada = array[3];
			}
			po++;
		}
	}

	public static void Imprimir(ArrayList<Posicao> p) {
		System.out.print("[");
		for (int i = 0; i < p.size(); i++) {
			System.out.print(
					p.get(i).linha + " - " + p.get(i).coluna + " - " + p.get(i).obstaculo + " - " + p.get(i).abitada);

			if (i < p.size() - 1) {
				System.out.print(",");
			}
		}
		System.out.println("]");
	}

	public static void procuraOrigem(ArrayList<Posicao> p, int i) {
		try {
			if (p.get(i).abitada.equals("o")) {
				origem = i;

			} else {

				procuraOrigem(p, i += 1);
			}
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Origem não encontrada !!!\nPorfavor insira a origem('o') na Entrada.txt");
		}

	}

	public static void procuraDestino(ArrayList<Posicao> p, int i) {
		try {
			if (p.get(i).abitada.equals("d")) {
				destino = i;

			} else {

				procuraDestino(p, i += 1);
			}
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Destino não encontrada !!!\nPorfavor insira a destino('d') na Entrada.txt");
		}

	}

	public static void Distancia(ArrayList<Posicao> p, int i) {
		if (p.get(i).linha != p.get(destino).linha) {
			if (p.get(i).coluna != p.get(destino).coluna) {
				if (i < p.size()) {
					if (p.get(destino).coluna > p.get(i).coluna) {
						if (p.get(destino).linha > p.get(i).linha) {
							diagonalFrente(p.get(i));
						} else {
							diagonalBaixo(p.get(i));
						}
					} else {
						if (p.get(destino).linha > p.get(i).linha) {
							diagonalCima(p.get(i));
						} else {
							diagonalTraz(p.get(i));
						}
					}

					Comparacao(p, i);
					if (p.get(aux).linha == (p.get(destino)).linha && p.get(aux).coluna == (p.get(destino)).coluna) {
						System.out.println("é igual");

					} else {
						System.out.println("Nao é igual");
						Distancia(p, aux);
					}
				}
			} else {
				// vai para cima
				if (i < p.size()) {
					cima(p.get(i));
					Comparacao(p, i);
					if (p.get(aux).linha == (p.get(destino)).linha && p.get(aux).coluna == (p.get(destino)).coluna) {
						System.out.println("é igual");

					} else {
						System.out.println("Nao é igual");
						Distancia(p, aux);
					}
				} // fim if
			}

		} else { // vai para frente
			if (i < p.size()) {
				frente(p.get(i));
				Comparacao(p, i);
				if (p.get(aux).linha == (p.get(destino)).linha && p.get(aux).coluna == (p.get(destino)).coluna) {
					System.out.println("é igual");

				} else {
					System.out.println("Nao é igual");
					Distancia(p, aux);
				}
			} // fim if

		}
	}

	public static void Comparacao(ArrayList<Posicao> p, int i) {
		if (index < p.size()) {
			if (p.get(i).linha == posicao.get(index).linha && p.get(i).coluna == posicao.get(index).coluna) {
				aux = index;

			} else {
				index += 1;
				Comparacao(p, i);

			}
		}
	}
}