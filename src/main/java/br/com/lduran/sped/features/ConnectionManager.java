package br.com.lduran.sped.features;

import java.sql.*;

import br.com.lduran.sped.exception.GlobalcodeException;

public class ConnectionManager
{
	/*
	 * The values of the constants below must be in accordance with the database used.
	 */
	private static final String NOME_BANCO = "YOUR_DATA_BASE";
	private static final String STR_CON = "jdbc:mysql://localhost/" + NOME_BANCO + "?serverTimezone=UTC";
	private static final String USER = "YOUR_USER";
	private static final String PASSWORD = "YOUR_PASSWORD";

	public static Connection getConnection() throws GlobalcodeException
	{
		Connection conn = null;
		try
		{
			conn = DriverManager.getConnection(STR_CON, USER, PASSWORD);
			System.out.println("[ConnectionManager]: Obtendo conexao");
		}
		catch (SQLException e)
		{
			throw new GlobalcodeException("Error getting connection", e);
		}
		return conn;
	}

	public static void closeAll(Connection conn)
	{
		try
		{
			if (conn != null)
			{
				conn.close();
			}
		}
		catch (Exception e)
		{
			System.out.println("---> Unable to close bank connection");
			System.out.println("---> Error breakdown: ");
			e.printStackTrace();
		}
	}

	public static void closeAll(Connection conn, Statement stmt)
	{
		try
		{
			if (stmt != null)
			{
				stmt.close();
			}
			closeAll(conn);
		}
		catch (Exception e)
		{
			System.out.println("---> Unable to close bank connection");
			System.out.println("---> Error breakdown: ");
			e.printStackTrace();
		}
	}

	public static void closeAll(Connection conn, Statement stmt, ResultSet rs)
	{
		try
		{
			if (rs != null)
			{
				rs.close();
			}
		}
		catch (SQLException e)
		{
			System.out.println("---> Unable to close bank connection");
			System.out.println("---> Error breakdown: ");
			e.printStackTrace();
		}

		ConnectionManager.closeAll(conn, stmt);
	}
}