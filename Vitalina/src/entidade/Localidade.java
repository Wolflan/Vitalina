package entidade;

import DAO.DAOLocalidade;

public class Localidade {

	private int idLocalidade;
	private String nome;
	private char tipo;
	
	public Localidade (String nome, char tipo ) {
		DAOLocalidade daoLocalidade = new DAOLocalidade();
		this.idLocalidade = (daoLocalidade.getLast() + 1);
		this.nome = nome;
		this.tipo = tipo;
	
	}
	
	public Localidade (int idLocalidade, String nome, char tipo ) {
	
		this.idLocalidade = idLocalidade;
		this.nome = nome;
		this.tipo = tipo;
	
	}
	
	public int getidLocalidade() {
	
		return idLocalidade;
	
	}
	
	public String getNome() {
	
		return nome;
	
	}
	
	public char getTipo() {
	
		return tipo;
		
	}


}