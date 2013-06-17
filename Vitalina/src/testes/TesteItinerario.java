package testes;
import recurso.*;
import java.sql.*;
import java.util.ArrayList;

import DAO.*;

import entidade.Itinerario;
import entidade.Linha;
import entidade.Localidade;

public class TesteItinerario {

	/**
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		
		Itinerario itinerario = new Itinerario(5,2,1);
		DAOItinerario daoItinerario = new DAOItinerario();
		//SALVAR
		daoItinerario.salvar(itinerario);
		
		//BUSCAR TODOS
		ArrayList<Itinerario> itinerarios = daoItinerario.buscar();

		for (Itinerario x : itinerarios) {
			System.out.print(x.getIdLinha()+"\t");
			System.out.print(x.getIdLocalidade()+"\t");
			System.out.println(x.getOrdem()+"\t");
		}
		
		System.out.println("Ok!");
		
		//BUSCAR ESPECÍFICO
		//Linha local = daoLinha.buscar(2);
		
		//System.out.println(local.getIdLinha());
		//System.out.println(local.getNome());
		//System.out.println(local.getIdEmpresa());
		
		//DELETAR ESPECÍFICO
		//daoLinha.deletar(4);
		
		//ATUALIZAR ESPECÍFICO
		//daoLinha.update(new Linha("Praias",2));
	}

}
