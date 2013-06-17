package entidade;

import java.util.ArrayList;

import DAO.DAOEmpresa;

public class Empresa {

	private int idEmpresa;
	private String nome;
	
	ArrayList<Linha> linhas = new ArrayList<Linha>();
	
	public Empresa(int idEmpresa, String nome) {
	
		this.idEmpresa = idEmpresa;
		this.nome = nome;
	
	}
	
	public Empresa (String nome) {

		DAOEmpresa daoEmpresa = new DAOEmpresa();
		this.idEmpresa = (daoEmpresa.getLast() + 1);
		this.nome = nome;
	
	}

	
	public void addLinha(Linha linha) {
	
			linhas.add(linha);
			
	}

	public ArrayList getLinhas() {
	
		return linhas;
		
	}
	
	public int getIdEmpresa() {
		
		return idEmpresa;
	}
	
	public String getNome() {
	
		return nome;
		
	}
	
}