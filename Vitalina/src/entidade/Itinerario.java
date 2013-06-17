package entidade;

public class Itinerario {
	
	private int idItinerario;
	private int idLinha;
	private int idLocalidade;
	private int ordem;
	
	public Itinerario (int idItinerario, int idLinha, int idLocalidade, int ordem) {
		
		this.idItinerario = idItinerario;
		this.idLinha = idLinha;
		this.idLocalidade = idLocalidade;
		this.ordem = ordem;
	
	}

	public Itinerario (int idLinha, int idLocalidade, int ordem) {
		
		this.idLinha = idLinha;
		this.idLocalidade = idLocalidade;
		this.ordem = ordem;
	
	}
	public int getIdItinerario() {
		return idItinerario;
	}

	public int getIdLinha() {
		return idLinha;
	}

	public int getIdLocalidade() {
		return idLocalidade;
	}

	public int getOrdem() {
		return ordem;
	}
	
	


}