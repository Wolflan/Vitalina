package entidade;

import DAO.DAOToten;

public class Toten {

	public int idToten;
	public int idLocalidade;
	
	public Toten(int idToten, int idLocalidade) {
	
		this.idToten = idToten;
		this.idLocalidade = idLocalidade;
		
	}
	
	public Toten(int idLocalidade) {
		DAOToten toten = new DAOToten();
		this.idToten = (toten.getLast() + 1);
		this.idLocalidade = idLocalidade;
		
	}
	
	public int getIdToten() {
	
		return idToten;
	}

	public int getIdLocalidade() {
		return idLocalidade;
	}
}