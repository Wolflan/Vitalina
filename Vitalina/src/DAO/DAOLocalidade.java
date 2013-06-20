package DAO;

import entidade.Localidade;
import java.sql.*;
import java.util.ArrayList;

import recurso.FabricaDeConexao;

public class DAOLocalidade implements IDAO<Localidade> {
	
	PreparedStatement ps;
	Connection con;
	ResultSet result;
	
	@Override
	public void salvar(Localidade objeto) {
		// TODO Auto-generated method stub
		try {
			con = FabricaDeConexao.getConnection();
			String executar = "INSERT INTO localidade (nomeLocalidade,tipo) VALUES (?,?)";
			ps = con.prepareStatement(executar);
			ps.setString(1, objeto.getNome());
			ps.setString(2, String.valueOf(objeto.getTipo()));
			ps.execute();
			
			ps.close();
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public ArrayList<Localidade> buscar() {
		// TODO Auto-generated method stub
		try {
			con = FabricaDeConexao.getConnection();
			String query = "SELECT * FROM localidade";
			ps = con.prepareStatement(query);
			result = ps.executeQuery();
			
			ArrayList<Localidade> retorno = new ArrayList<Localidade>();
			while (result.next()) {
				retorno.add( new Localidade( result.getInt(1), result.getString(2), result.getString(3).charAt(0) ) );
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
	public Localidade buscar(int codigo) {
		// TODO Auto-generated method stub
		try {
			con = FabricaDeConexao.getConnection();
			String query = "SELECT * FROM localidade WHERE idLocalidade = ?";
			ps = con.prepareStatement(query);
			ps.setInt(1,codigo);
			result = ps.executeQuery();
			
			result.next();
			
				Localidade localidade = new Localidade(result.getInt(1),result.getString(2),result.getString(3).charAt(0));
				
				ps.close();
				con.close();
				result.close();
				
				return localidade;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void update(Localidade objeto) {
		// TODO Auto-generated method stub
		try {
			con = FabricaDeConexao.getConnection();
			String query = "UPDATE localidade SET nomeLocalidade = ?, tipo = ? WHERE idLocalidade = ?";
			ps = con.prepareStatement(query);
			ps.setString(1,objeto.getNome());
			ps.setString(2,String.valueOf(objeto.getTipo()));
			ps.setInt(3, objeto.getidLocalidade());
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
			String query = "DELETE FROM localidade WHERE idLocalidade = ?";
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
			String query = "SELECT count(*) FROM localidade";
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

	@Override
	public ArrayList<Localidade> buscar(String pesquisa) {
		// TODO Auto-generated method stub
		return null;
	}
}
