package br.com.lduran.sped.dao;

import java.sql.*;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.lduran.sped.bean.Participante;
import br.com.lduran.sped.exception.GlobalcodeException;
import br.com.lduran.sped.features.ConnectionManager;

public class ParticipanteDAOImpl implements IParticipanteDAO
{

	private final static String SALVAR_PARTICIPANTE = "INSERT INTO `dbsped`.`participantes` (`cnpj`, `razaoSocial`, `cep`, `codigoIBGE`, `uf`, `estado`, `regiaoMetropolitana`, `mesorregiao`, `microrregiao`, `latitude`, `longitude`, `area`, `populacao`, `regiao`, `cidade`, `cidadeEstado`, `endereco`, `bairro`, `pais`, `segmento`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private final static String CREATE_TABLE = "CREATE TABLE  IF NOT EXISTS  `participantes` ( `participante_id` bigint(20) NOT NULL AUTO_INCREMENT, `cnpj` varchar(255) DEFAULT NULL, `razaoSocial` varchar(255) DEFAULT NULL, `cep` varchar(255) DEFAULT NULL, `codigoIBGE` varchar(255) DEFAULT NULL, `uf` varchar(255) DEFAULT NULL, `estado` varchar(255) DEFAULT NULL, `regiaoMetropolitana` varchar(255) DEFAULT NULL, `mesorregiao` varchar(255) DEFAULT NULL, `microrregiao` varchar(255) DEFAULT NULL, `latitude` double DEFAULT NULL, `longitude` double DEFAULT NULL, `area` double DEFAULT NULL, `populacao` bigint(20) DEFAULT NULL, `regiao` varchar(255) DEFAULT NULL, `cidade` varchar(255) DEFAULT NULL, `cidadeEstado` varchar(255) DEFAULT NULL, `endereco` varchar(255) DEFAULT NULL, `bairro` varchar(255) DEFAULT NULL, `pais` varchar(255) DEFAULT NULL, `segmento` varchar(255) DEFAULT NULL, PRIMARY KEY (`participante_id`)) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci";
	private final static String GET_ALL_PARTICIPANTE = "SELECT * FROM participantes";

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
	public void save(Participante participante) throws GlobalcodeException
	{
		Connection conn = null;
		PreparedStatement stmt = null;

//		`cnpj`, `razaoSocial`, `cep`, `codigoIBGE`, `uf`, `estado`, `regiaoMetropolitana`, `mesorregiao`,
//        `microrregiao`, `latitude`, `longitude`, `area`, `populacao`, `regiao`, `cidade`, `cidadeEstado`, `endereco`,
//        `bairro`, `pais`, `segmento`

		try
		{
			conn = ConnectionManager.getConnection();
			stmt = conn.prepareStatement(SALVAR_PARTICIPANTE);
			stmt.setString(1, participante.getCnpj());
			stmt.setString(2, participante.getRazaoSocial());
			stmt.setString(3, participante.getCep());
			stmt.setString(4, participante.getCodigoIBGE());
			stmt.setString(5, participante.getUf());
			stmt.setString(6, participante.getEstado());
			stmt.setString(7, participante.getRegiaoMetropolitana());
			stmt.setString(8, participante.getMesorregiao());
			stmt.setString(9, participante.getMicrorregiao());
			stmt.setDouble(10, participante.getLatitude());
			stmt.setDouble(11, participante.getLongitude());
			stmt.setDouble(12, participante.getArea());
			stmt.setDouble(13, participante.getPopulacao());
			stmt.setString(14, participante.getRegiao());
			stmt.setString(15, participante.getCidade());
			stmt.setString(16, participante.getCidadeEstado());
			stmt.setString(17, participante.getEndereco());
			stmt.setString(18, participante.getBairro());
			stmt.setString(19, participante.getPais());
			stmt.setString(20, participante.getSegmento());

			// execute the preparedstatement
			stmt.execute();

			System.out.println("SQL = " + SALVAR_PARTICIPANTE);
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
	public void saveAll(List<Participante> participantes) throws GlobalcodeException
	{
		for (Participante part : participantes)
		{
			save(part);
		}

	}

	@Override
	public void excluir(String cpf) throws GlobalcodeException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public List getAllParticipantes() throws GlobalcodeException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Participante getParticipanteByCPF(String cpf) throws GlobalcodeException
	{
		// TODO Auto-generated method stub
		return null;
	}

}
