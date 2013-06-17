package testes;
import recurso.*;
import java.sql.*;
import java.util.ArrayList;

import DAO.DAOLocalidade;

import entidade.Localidade;

public class TesteLocalidade {

	/**
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		
		Localidade localidade = new Localidade("Cidade Operária",'B');
		DAOLocalidade daoLocalidade = new DAOLocalidade();
		//SALVAR
		daoLocalidade.salvar(localidade);
		
		//BUSCAR TODOS
		ArrayList<Localidade> locais = daoLocalidade.buscar();

		for (Localidade x : locais) {
			System.out.print(x.getidLocalidade()+"\t");
			System.out.print(x.getNome()+"\t");
			System.out.println(x.getTipo()+"\t");
		}
		
		System.out.println("Ok!");
		
		//BUSCAR ESPECÍFICO
		Localidade local = daoLocalidade.buscar(2);
		
		System.out.println(local.getidLocalidade());
		System.out.println(local.getNome());
		System.out.println(local.getTipo());
		
		//DELETAR ESPECÍFICO
		daoLocalidade.deletar(10);
		
		//ATUALIZAR ESPECÍFICO
		daoLocalidade.update(new Localidade(1,"Camilo",'B'));
	}

}
