package DAO;

import entidade.Empresa;
import entidade.Linha;
import entidade.Localidade;
import java.sql.*;
import java.util.ArrayList;

import recurso.FabricaDeConexao;

public class DAOEmpresa implements IDAO<Empresa> {
	
	PreparedStatement ps;
	Connection con;
	ResultSet result;
	
	@Override
	public void salvar(Empresa objeto) {
		// TODO Auto-generated method stub
		try {
			con = FabricaDeConexao.getConnection();
			String executar = "INSERT INTO empresa (nomeEmpresa) VALUES (?)";
			ps = con.prepareStatement(executar);
			ps.setString(1, objeto.getNome());
			ps.execute();
			
			ArrayList<Linha> linhas = objeto.getLinhas();
			DAOLinha daoLinha = new DAOLinha();
			
			for (Linha x : linhas) {
				daoLinha.salvar(x);
			}
			
			ps.close();
			con.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public ArrayList<Empresa> buscar() {
		// TODO Auto-generated method stub
		try {
			con = FabricaDeConexao.getConnection();
			String query = "SELECT * FROM empresa";
			ps = con.prepareStatement(query);
			result = ps.executeQuery();
			
			ArrayList<Empresa> retorno = new ArrayList<Empresa>();
			DAOLinha daoLinha = new DAOLinha();
			ArrayList<Linha> linhas = daoLinha.buscar();
			
			while (result.next()) {
				Empresa empresa = new Empresa( result.getInt(1), result.getString(2) );
				
				for(Linha x : linhas) {
					if (empresa.getIdEmpresa() == x.getIdEmpresa()) {
						empresa.addLinha(x);
					}
				}
				
				retorno.add(empresa);
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
	public Empresa buscar(int codigo) {
		// TODO Auto-generated method stub
		try {
			con = FabricaDeConexao.getConnection();
			String query = "SELECT * FROM empresa WHERE idEmpresa = ?";
			ps = con.prepareStatement(query);
			ps.setInt(1,codigo);
			result = ps.executeQuery();
			
			result.next();
			
				Empresa empresa = new Empresa(result.getInt(1),result.getString(2));
				
				DAOLinha daoLinha = new DAOLinha();
				ArrayList<Linha> linhas = daoLinha.buscar();
				
				for(Linha x : linhas) {
					if (empresa.getIdEmpresa() == x.getIdEmpresa()) {
						empresa.addLinha(x);
					}
				}
				
				ps.close();
				con.close();
				result.close();
				
				return empresa;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void update(Empresa objeto) {
		// TODO Auto-generated method stub
		try {
			con = FabricaDeConexao.getConnection();
			String query = "UPDATE empresa SET nomeEmpresa = ? WHERE idEmpresa = ?";
			ps = con.prepareStatement(query);
			ps.setString(1,objeto.getNome());
			ps.setInt(2, objeto.getIdEmpresa());
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
			String query = "DELETE FROM empresa WHERE idEmpresa = ?";
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
			String query = "SELECT max(idEmpresa) FROM empresa";
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
