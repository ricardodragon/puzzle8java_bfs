package com.busca.largura.util;


import java.util.LinkedList;
import java.util.Queue;

import com.busca.largura.model.Move;
import com.busca.largura.model.Node;

public class BuscaEmProfundidade {
	
	private Queue<Node> filaNos;
	
	private int [][] valorBusca;
	public BuscaEmProfundidade(int [][] valorBusca) {
		this.filaNos = new LinkedList<Node>();
		this.valorBusca = valorBusca;
	}
	
	public boolean isResult(Node node) {		
		for(int i =0; i<valorBusca.length; i++)
			for(int j =0; j<valorBusca.length; j++)
				if(valorBusca[i][j] != node.getValor()[i][j])
					return false;		
		return true;
	}
	
	public void buscar(Node node) {	
		
		while(this.filaNos != null) {
			if(isResult(node)) {
				node.mostraMatriz();
				this.filaNos = null;
			}
			else {	
				if(node.getPosX()>0) {
					Node n = new Node(node.getValor(), node.getPosX(),node.getPosY(), node);
					n.move(Move.BAIXO);	
					node.getFilhos().add(n);				
					this.filaNos.add(n);																	
				}if(node.getPosY() > 0) {
					Node n = new Node(node.getValor(), node.getPosX(),node.getPosY(), node);
					n.move(Move.ESQUERDA);
					this.filaNos.add(n);				
					node.getFilhos().add(n);								
				}if(node.getPosX() < 2) {
					Node n = new Node(node.getValor(), node.getPosX(),node.getPosY(), node);
					n.move(Move.CIMA);
					this.filaNos.add(n);				
					node.getFilhos().add(n);								
				}if(node.getPosY() <2) {
					Node n = new Node(node.getValor(), node.getPosX(),node.getPosY(), node);
					n.move(Move.DIREITA);				
					this.filaNos.add(n);
					node.getFilhos().add(n);			
				}							
			 	node = this.filaNos.poll();					
			}			
		}
	}	
		
}
