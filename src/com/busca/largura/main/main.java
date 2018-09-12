package com.busca.largura.main;

import com.busca.largura.model.Node;
import com.busca.largura.util.BuscaEmProfundidade;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][] v = {
				{0,1,2},
				{3,4,5},
				{6,7,8}
			};
		int [][] v2 = {
				{3,1,4},
				{2,0,8},
				{5,6,7}
			};		
	
		

		new BuscaEmProfundidade(v).buscar(new Node(v2, 1, 1, null));
	}

}
