package DAO;

import entidade.Linha;
import entidade.Localidade;
import entidade.Toten;

import java.sql.*;
import java.util.ArrayList;

import recurso.FabricaDeConexao;

public class DAOToten implements IDAO<Toten> {
	
	PreparedStatement ps;
	Connection con;
	ResultSet result;
	
	@Override
	public void salvar(Toten objeto) {
		// TODO Auto-generated method stub
		try {
			con = FabricaDeConexao.getConnection();
			String executar = "INSERT INTO toten (fkIdLocalidade) VALUES (?)";
			ps = con.prepareStatement(executar);
			ps.setInt(1, objeto.getIdLocalidade());
			ps.execute();
			
			ps.close();
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public ArrayList<Toten> buscar() {
		// TODO Auto-generated method stub
		try {
			con = FabricaDeConexao.getConnection();
			String query = "SELECT * FROM toten";
			ps = con.prepareStatement(query);
			result = ps.executeQuery();
			
			ArrayList<Toten> retorno = new ArrayList<Toten>();
			
			while (result.next()) {
				retorno.add( new Toten( result.getInt(1), result.getInt(2)) );
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
	public Toten buscar(int codigo) {
		// TODO Auto-generated method stub
		try {
			con = FabricaDeConexao.getConnection();
			String query = "SELECT * FROM toten WHERE idToten = ?";
			ps = con.prepareStatement(query);
			ps.setInt(1,codigo);
			result = ps.executeQuery();
			
			result.next();
			
				Toten toten = new Toten( result.getInt(1),result.getInt(2));
				
				ps.close();
				con.close();
				result.close();
				
				return toten;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void update(Toten objeto) {
		// TODO Auto-generated method stub
		try {
			con = FabricaDeConexao.getConnection();
			String query = "UPDATE toten SET fkIdLocalidade = ? WHERE idToten= ?";
			ps = con.prepareStatement(query);
			ps.setInt(1,objeto.getIdLocalidade());
			ps.setInt(2, objeto.getIdToten());
			ps.execute();
			
			con.close();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void deletar(int codigo) {
		// TODO Auto-generated method stub
		try {
			con = FabricaDeConexao.getConnection();
			String query = "DELETE FROM toten WHERE idToten = ?";
			ps = con.prepareStatement(query);
			ps.setInt(1,codigo);
			ps.execute();
			
			con.close();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	public int getLast() {
		// TODO Auto-generated method stub
		try {
			con = FabricaDeConexao.getConnection();
			String query = "SELECT count(*) FROM toten";
			ps = con.prepareStatement(query);
			result = ps.executeQuery();
			
			result.next();
			
			int retorno = result.getInt(1);
			
			con.close();
			ps.close();
			
			return retorno;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}
