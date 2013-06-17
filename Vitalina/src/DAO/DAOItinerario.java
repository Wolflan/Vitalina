package DAO;

import entidade.Itinerario;
import entidade.Linha;
import entidade.Localidade;
import java.sql.*;
import java.util.ArrayList;

import recurso.FabricaDeConexao;

public class DAOItinerario implements IDAO<Itinerario> {
	
	PreparedStatement ps;
	Connection con;
	ResultSet result;
	
	@Override
	public void salvar(Itinerario objeto) {
		// TODO Auto-generated method stub
		try {
			con = FabricaDeConexao.getConnection();
			String executar = "INSERT INTO itinerario (fkIdLinha,fkIdLocalidade,ordem) VALUES (?,?,?)";
			ps = con.prepareStatement(executar);
			ps.setInt(1, objeto.getIdLinha());
			ps.setInt(2, objeto.getIdLocalidade());
			ps.setInt(3, objeto.getOrdem());
			ps.execute();
			
			ps.close();
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public ArrayList<Itinerario> buscar() {
		// TODO Auto-generated method stub
		try {
			con = FabricaDeConexao.getConnection();
			String query = "SELECT * FROM itinerario";
			ps = con.prepareStatement(query);
			result = ps.executeQuery();
			
			ArrayList<Itinerario> retorno = new ArrayList<Itinerario>();
			while (result.next()) {
				retorno.add( new Itinerario( result.getInt(1), result.getInt(2), result.getInt(3) ) );
			}
			
			ps.close();
			con.close();
			result.close();
			
			return retorno;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}
	
	@Override
	public Itinerario buscar(int codigo) {
		// TODO Auto-generated method stub
		
		
		return null;
	}

	@Override
	public void update(Itinerario objeto) {
		
	}
	
	@Override
	public void deletar(int codigo) {
		
		
	}
	
	@Override
	public int getLast() {
		
		return 0;
	}

}
