package br.com.pokemon;

import java.util.Random;
import java.util.Scanner;

public class Principal {

	static int ataqueUsuario() {
		Scanner leitor = new Scanner(System.in);
		System.out.println("Escolha seu ataque");
		System.out.println("(1) - Soco");
		System.out.println("(2) - Especial");
		return leitor.nextInt();
	}

	static int AtaqueComputador() {
		Random gerador = new Random();
		return gerador.nextInt(3) + 1; // retorna numero entre 1 e 3
	}

	
	static void imprimeHP(int hpUsuario, int hpComputador, int contEspecial) {
		
		System.out.println("=====================");
		System.out.println("- HP Usuario " + hpUsuario);
		System.out.println("- HP Computador " + hpComputador);
		System.out.println(" Contagem Especiais " + contEspecial);
		System.out.println("=====================");

		
		
	}
	
	static void batalha() {
		int hpUsuario = 150;
		int hpComputador = 11;
		int contEspecial = 5;
		int escolhaAtaque;
		while (hpUsuario > 0 && hpComputador > 0) {
			imprimeHP(hpUsuario, hpComputador, contEspecial);
			escolhaAtaque = ataqueUsuario();
			switch(escolhaAtaque) {
			case 1:
				System.out.println("Usuario usou um soco");
				hpComputador -= 7;
				break;
			case 2:
				System.out.println("Usuario usou um ataque especial");
				hpComputador -= 20;
				contEspecial--;
				break;
				default:
					System.out.println("Opção invalida.");
					break;
			}
			if (hpComputador > 0) {
				escolhaAtaque = AtaqueComputador();
				switch(escolhaAtaque) {
				case 1:
					System.out.println("Computador usou um soco");
					hpUsuario -= 2;
					break;
				case 2:
					System.out.println("Computador usou um chute");
					hpUsuario -= 3;
					break;
				case 3: 
					System.out.println("Computador usou um ataque especial");
					hpUsuario -=4;
					break;
				}
				
			}
			else {
				System.out.println("INIMIGO DERROTADO!");
			}
		}
			
	}

	public static void main(String[] args) {
		Scanner leitor = new Scanner(System.in);
		int continua = 1;
		while (continua == 1) {
			batalha();
			System.out.println("Fim do jogo. Deseja Continuar? (1) Sim (2) Não");

			continua = leitor.nextInt();

		}

	}

}
