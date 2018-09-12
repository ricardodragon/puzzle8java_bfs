package com.busca.largura.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Node {
	private int [][] valor; 
	
	private Node pai;
	
	private int posX;
	
	private int posY;
	
	private List<Node> filhos = new ArrayList<>();
	
	public Node(int[][] valor, int posX, int posY, Node pai) {
		this.valor = new int [3][3]; 
		this.valor[0] = Arrays.copyOf(valor[0], 3);
		this.valor[1] = Arrays.copyOf(valor[1], 3);
		this.valor[2] = Arrays.copyOf(valor[2], 3);
		this.posX = posX;
		this.posY = posY;
		this.pai = pai;		
	}
	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int[][] getValor() {
		return valor;
	}
	
	public void mostraMatriz() {
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++)
				System.out.print(this.valor[i][j] + "\t");
			System.out.print("\n");
		}
		
		System.out.println("\n");
		if(this.pai != null)
			this.pai.mostraMatriz();
	}
	
	public void setValor(int[][] valor) {
		this.valor = valor;
	}
	public void move(Move move) {
		int temp;
		if(move == Move.BAIXO) {
			temp = this.valor [this.posX-1][this.posY];
			this.valor [this.posX-1][this.posY] = 0;
			this.valor [this.posX][this.posY] = temp;
			this.posX--;
		}else if(move == Move.CIMA) {
			temp = this.valor [this.posX+1][this.posY];
			this.valor [this.posX+1][this.posY] = 0;
			this.valor [this.posX][this.posY] = temp;
			this.posX++;
		}else if(move == Move.DIREITA) {
			temp = this.valor [this.posX][this.posY+1];
			this.valor [this.posX][this.posY+1] = 0;
			this.valor [this.posX][this.posY] = temp;
			this.posY++;
		}else if(move == Move.ESQUERDA) {
			temp = this.valor [this.posX][this.posY-1];
			this.valor [this.posX][this.posY-1] = 0;
			this.valor [this.posX][this.posY] = temp;
			this.posY--;
		}
	}
	public List<Node> getFilhos() {
		return filhos;
	}
	public void setFilhos(List<Node> filhos) {
		this.filhos = filhos;
	}
}
