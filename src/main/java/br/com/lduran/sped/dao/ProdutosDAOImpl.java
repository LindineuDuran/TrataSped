
package br.com.lduran.sped.dao;

import java.sql.*;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.lduran.sped.bean.Produto;
import br.com.lduran.sped.exception.GlobalcodeException;
import br.com.lduran.sped.features.ConnectionManager;

/**
 * @author lsduran
 *
 */
public class ProdutosDAOImpl implements IProdutosDAO
{
	private final static String SALVAR_PRODUTO = "INSERT INTO `dbsped`.`produtos` (`IdProduto`, `Produto`, `TipoDeProduto`, `FamiliaDeProdutos`, `GrupoDeProdutos`) VALUES (?, ?, ?, ?, ?)";
	private final static String CREATE_TABLE = "CREATE TABLE  IF NOT EXISTS  `produtos` (`produto_id` bigint(20) NOT NULL AUTO_INCREMENT,`IdProduto` varchar(255) DEFAULT NULL, `Produto` varchar(255) DEFAULT NULL, `TipoDeProduto` varchar(255) DEFAULT NULL, `FamiliaDeProdutos` varchar(255) DEFAULT NULL, `GrupoDeProdutos` varchar(255) DEFAULT NULL, PRIMARY KEY (`produto_id`)) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci";
	private final static String GET_ALL_PRODUTOS = "SELECT * FROM produtos";

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
	public void save(Produto produto) throws GlobalcodeException
	{
		Connection conn = null;
		PreparedStatement stmt = null;

		try
		{
			conn = ConnectionManager.getConnection();
			stmt = conn.prepareStatement(SALVAR_PRODUTO);
			stmt.setString(1, produto.getIdProduto());
			stmt.setString(2, produto.getDescricao());
			stmt.setString(3, produto.getTipoDeProduto());
			stmt.setString(4, produto.getFamiliaProd());
			stmt.setString(5, produto.getGrupoProd());

			// execute the preparedstatement
			stmt.execute();

			System.out.println("SQL = " + SALVAR_PRODUTO);
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
	public void saveAll(List<Produto> produtos) throws GlobalcodeException
	{
		for (Produto p : produtos)
		{
			save(p);
		}
	}

	@Override
	public void excluir(String cpf) throws GlobalcodeException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public List getAllProdutos() throws GlobalcodeException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Produto getProdutoByCPF(String cpf) throws GlobalcodeException
	{
		// TODO Auto-generated method stub
		return null;
	}
}
