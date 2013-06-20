package testes;
import recurso.*;
import java.sql.*;
import java.util.ArrayList;

import DAO.DAOEmpresa;
import DAO.DAOLocalidade;

import entidade.Empresa;
import entidade.Linha;
import entidade.Localidade;

public class TesteEmpresa {

	/**
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		
		Empresa empresa = new Empresa("WolfCorporation");
		empresa.addLinha(new Linha("Praias",empresa.getIdEmpresa()));
		empresa.addLinha(new Linha("Centro",empresa.getIdEmpresa()));
		empresa.addLinha(new Linha("Praças",empresa.getIdEmpresa()));
		empresa.addLinha(new Linha("Comércio",empresa.getIdEmpresa()));
		empresa.addLinha(new Linha("Baixada",empresa.getIdEmpresa()));
		
		DAOEmpresa daoEmpresa = new DAOEmpresa();
		//SALVAR
		daoEmpresa.salvar(empresa);
		
		//BUSCAR TODOS
		ArrayList<Empresa> empresas = daoEmpresa.buscar();

		for (Empresa x : empresas) {
			System.out.print(x.getIdEmpresa()+"\t");
			System.out.println(x.getNome()+"\t");
			
		}
		
		System.out.println("Ok!");
		
		//BUSCAR ESPECÍFICO
		Empresa empresa2 = daoEmpresa.buscar(1);
		
		System.out.println(empresa2.getIdEmpresa());
		System.out.println(empresa2.getNome());
	
		
		//DELETAR ESPECÍFICO
		//daoEmpresa.deletar(8);
		
		//ATUALIZAR ESPECÍFICO
		daoEmpresa.update(new Empresa(10,"FODA"));
	}

}
