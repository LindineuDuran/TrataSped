package br.com.lduran.sped.dao;

import java.sql.*;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.lduran.sped.bean.Organizacao;
import br.com.lduran.sped.exception.GlobalcodeException;
import br.com.lduran.sped.features.ConnectionManager;

public class OrganizacaoDAOImpl implements IOrganizacaoDAO
{
	private final static String SALVAR_ORGANIZACAO = "INSERT INTO `dbsped`.`organizacoes` (`cnpj`, `razaoSocial`, `cep`, `codigoIBGE`, `uf`, `estado`, `regiao_metropolitana`, `mesorregiao`, `microrregiao`, `latitude`, `longitude`, `area`, `populacao`, `regiao`, `cidade`, `cidade_estado`, `endereco`, `bairro`, `pais`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private final static String CREATE_TABLE = "CREATE TABLE  IF NOT EXISTS  `organizacoes` ( `organizacao_id` bigint(20) NOT NULL AUTO_INCREMENT, `cnpj` varchar(255) DEFAULT NULL, `razaoSocial` varchar(255) DEFAULT NULL, `cep` varchar(255) DEFAULT NULL, `codigoIBGE` varchar(255) DEFAULT NULL, `uf` varchar(255) DEFAULT NULL, `estado` varchar(255) DEFAULT NULL, `regiao_metropolitana` varchar(255) DEFAULT NULL, `mesorregiao` varchar(255) DEFAULT NULL, `microrregiao` varchar(255) DEFAULT NULL, `latitude` double DEFAULT NULL, `longitude` double DEFAULT NULL, `area` double DEFAULT NULL, `populacao` bigint(20) DEFAULT NULL, `regiao` varchar(255) DEFAULT NULL, `cidade` varchar(255) DEFAULT NULL, `cidade_estado` varchar(255) DEFAULT NULL, `endereco` varchar(255) DEFAULT NULL, `bairro` varchar(255) DEFAULT NULL, `pais` varchar(255) DEFAULT NULL, PRIMARY KEY (`organizacao_id`)) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci";
	private final static String GET_ALL_ORGANIZACAO = "SELECT * FROM organizacoes";

	public void createTable() throws GlobalcodeException
	{
		Connection conn = null;
		Statement stmt = null;
		try
		{
			conn = ConnectionManager.getConnection();
			stmt = conn.createStatement();
			stmt.executeUpdate(CREATE_TABLE);
		}
		catch (SQLException e)
		{
			throw new GlobalcodeException("Erro ao criar a tabela de clientes : " + CREATE_TABLE, e);
		}
		finally
		{
			ConnectionManager.closeAll(conn, stmt);
		}
	}

	@Override
	public void save(Organizacao organizacao) throws GlobalcodeException
	{
		Connection conn = null;
		PreparedStatement stmt = null;
		try
		{
			conn = ConnectionManager.getConnection();
			stmt = conn.prepareStatement(SALVAR_ORGANIZACAO);
			stmt.setString(1, organizacao.getCnpj());
			stmt.setString(2, organizacao.getRazaoSocial());
			stmt.setString(3, organizacao.getCep());
			stmt.setString(4, organizacao.getCodigoIBGE());
			stmt.setString(5, organizacao.getUf());
			stmt.setString(6, organizacao.getEstado());
			stmt.setString(7, organizacao.getRegiaoMetropolitana());
			stmt.setString(8, organizacao.getMesorregiao());
			stmt.setString(9, organizacao.getMicrorregiao());
			stmt.setDouble(10, organizacao.getLatitude());
			stmt.setDouble(11, organizacao.getLongitude());
			stmt.setDouble(12, organizacao.getArea());
			stmt.setDouble(13, organizacao.getPopulacao());
			stmt.setString(14, organizacao.getRegiao());
			stmt.setString(15, organizacao.getCidade());
			stmt.setString(16, organizacao.getCidadeEstado());
			stmt.setString(17, organizacao.getEndereco());
			stmt.setString(18, organizacao.getBairro());
			stmt.setString(19, organizacao.getPais());

			// execute the preparedstatement
			stmt.execute();

			System.out.println("SQL = " + SALVAR_ORGANIZACAO);
		}
		catch (SQLException e)
		{
			JOptionPane.showMessageDialog(null, e.getClass().getName() + "\r\n" + e.getMessage());
		}
		finally
		{
			ConnectionManager.closeAll(conn, stmt);
		}
	}

	@Override
	public void saveAll(List<Organizacao> organizacoes) throws GlobalcodeException
	{
		for (Organizacao org : organizacoes)
		{
			save(org);
		}

	}

	@Override
	public void excluir(String cpf) throws GlobalcodeException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public List getAllOrganizacaos() throws GlobalcodeException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Organizacao getOrganizacaoByCPF(String cpf) throws GlobalcodeException
	{
		// TODO Auto-generated method stub
		return null;
	}

}
