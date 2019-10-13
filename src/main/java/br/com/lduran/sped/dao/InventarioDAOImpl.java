package br.com.lduran.sped.dao;

import java.sql.*;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.lduran.sped.bean.Inventario;
import br.com.lduran.sped.exception.GlobalcodeException;
import br.com.lduran.sped.features.ConnectionManager;

public class InventarioDAOImpl implements IInventarioDAO
{
	private final static String SALVAR_INVENTARIO = "INSERT INTO `dbsped`.`inventario` (`dataInventario`, `IdItem`, `unidade`, `quantidade`, `valorUnitario`, `valorTotal`, `propriedade`, `participante`, `textoComplementar`, `contaContabil`, `valorTotIR`, `organizacao`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private final static String CREATE_TABLE = "CREATE TABLE  IF NOT EXISTS  `inventario` ( `inventario_id` bigint(20) NOT NULL AUTO_INCREMENT, `dataInventario` varchar(255) DEFAULT NULL, `IdItem` varchar(255) DEFAULT NULL, `unidade` varchar(255) DEFAULT NULL, `quantidade` double DEFAULT NULL, `valorUnitario` decimal(19,2) DEFAULT NULL, `valorTotal` decimal(19,2) DEFAULT NULL, `propriedade` varchar(255) DEFAULT NULL, `participante` varchar(255) DEFAULT NULL, `textoComplementar` varchar(255) DEFAULT NULL, `contaContabil` varchar(255) DEFAULT NULL, `valorTotIR` decimal(19,2) DEFAULT NULL, `organizacao` varchar(255) DEFAULT NULL, PRIMARY KEY (`inventario_id`)) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci";
	private final static String GET_ALL_INVENTARIO = "SELECT * FROM organizacoes";

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
	public void save(Inventario inventario) throws GlobalcodeException
	{
		Connection conn = null;
		PreparedStatement stmt = null;

		try
		{
			conn = ConnectionManager.getConnection();
			stmt = conn.prepareStatement(SALVAR_INVENTARIO);
			stmt.setString(1, inventario.getDataInventario());
			stmt.setString(2, inventario.getIdItem());
			stmt.setString(3, inventario.getUnidade());
			stmt.setDouble(4, inventario.getQuantidade());
			stmt.setBigDecimal(5, inventario.getValorUnitario());
			stmt.setBigDecimal(6, inventario.getValorTotal());
			stmt.setString(7, inventario.getPropriedade());
			stmt.setString(8, inventario.getParticipante());
			stmt.setString(9, inventario.getTextoComplementar());
			stmt.setString(10, inventario.getContaContabil());
			stmt.setBigDecimal(11, inventario.getValorTotIR());
			stmt.setString(12, inventario.getOrganizacao());

			// execute the preparedstatement
			stmt.execute();

			System.out.println("SQL = " + SALVAR_INVENTARIO);
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
	public void saveAll(List<Inventario> inventarios) throws GlobalcodeException
	{
		for (Inventario inv : inventarios)
		{
			save(inv);
		}

	}

	@Override
	public void excluir(String cpf) throws GlobalcodeException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public List getAllInventarios() throws GlobalcodeException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Inventario getInventarioByCPF(String cpf) throws GlobalcodeException
	{
		// TODO Auto-generated method stub
		return null;
	}

}
