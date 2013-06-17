package entidade;

import DAO.DAOLinha;

public class Linha {

	private int idLinha;
	private String nome;
	private int idEmpresa;
	
	public Linha (int idLinha, String nome, int idEmpresa) {
	
		this.idLinha = idLinha;
		this.nome = nome;
		this.idEmpresa = idEmpresa;

	}
	
	public Linha (String nome, int idEmpresa) {
		DAOLinha daoLinha = new DAOLinha();
		this.idLinha = (daoLinha.getLast() +1 );
		this.nome = nome;
		this.idEmpresa = idEmpresa;

	}

	public int getIdLinha() {
	
		return idLinha;
		
	}
	
	public String getNome() {
	
		return nome;
	}

	public int getIdEmpresa() {
		return idEmpresa;
	}


}