package testes;
import recurso.*;
import java.sql.*;
import java.util.ArrayList;

import DAO.*;

import entidade.Linha;
import entidade.Localidade;

public class TesteLinha {

	/**
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		
		Linha linha = new Linha("Teste",1);
		System.out.println(linha.getIdLinha());
		DAOLinha daoLinha = new DAOLinha();
		//SALVAR
		daoLinha.salvar(linha);
		
		//BUSCAR TODOS
		ArrayList<Linha> locais = daoLinha.buscar();

		for (Linha x : locais) {
			System.out.print(x.getIdLinha()+"\t");
			System.out.print(x.getNome()+"\t");
			System.out.println(x.getIdEmpresa()+"\t");
		}
		
		System.out.println("Ok!");
		
		//BUSCAR ESPECÍFICO
		Linha local = daoLinha.buscar(2);
		
		System.out.println(local.getIdLinha());
		System.out.println(local.getNome());
		System.out.println(local.getIdEmpresa());
		
		//DELETAR ESPECÍFICO
		daoLinha.deletar(4);
		
		//ATUALIZAR ESPECÍFICO
		daoLinha.update(new Linha("Praias",2));
	}

}
