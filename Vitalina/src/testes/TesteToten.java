package testes;
import recurso.*;
import java.sql.*;
import java.util.ArrayList;

import DAO.*;

import entidade.Linha;
import entidade.Localidade;
import entidade.Toten;

public class TesteToten {

	/**
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		
		Toten toten = new Toten(2);
		DAOToten daoToten = new DAOToten();
		//SALVAR
		daoToten.salvar(toten);
		
		//BUSCAR TODOS
		ArrayList<Toten> totens = daoToten.buscar();

		for (Toten x : totens) {
			System.out.print(x.getIdToten()+"\t");
			System.out.println(x.getIdLocalidade()+"\t");
		}
		
		System.out.println("Ok!");
		
		//BUSCAR ESPECÍFICO
		Toten toten1 = daoToten.buscar(2);
		
		System.out.print(toten1.getIdToten()+"\t");
		System.out.println(toten1.getIdLocalidade());
		
		
		//DELETAR ESPECÍFICO
		daoToten.deletar(3);
		
		//ATUALIZAR ESPECÍFICO
		//O banco reclama de violação caso tente trocar um toten para outra localidade
		//daoToten.update(new Toten(1,5));
	}

}
