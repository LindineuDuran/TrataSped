package br.com.lduran.sped.dao;

import java.util.List;

import br.com.lduran.sped.bean.Inventario;
import br.com.lduran.sped.exception.GlobalcodeException;

public interface IInventarioDAO
{
	/**
	 * @param Inventario inventario a ser inserido na fonte de dados em questao
	 * @throws GlobalcodeException
	 */
	public abstract void save(Inventario inventario) throws GlobalcodeException;

	public abstract void saveAll(List<Inventario> inventarios) throws GlobalcodeException;

	/**
	 * @param CPF do Inventario a ser excluido da fonte de dados em questao
	 * @throws GlobalcodeException
	 */
	public abstract void excluir(String cpf) throws GlobalcodeException;

	/**
	 * @return java.util.List contendo todos os Inventarios contidos na fonte da dados em questao
	 * @throws GlobalcodeException
	 */
	public abstract List getAllInventarios() throws GlobalcodeException;

	/**
	 * @param String CPF do Inventario a ser pesquisado no "banco de dados"
	 * @return Inventario
	 * @throws GlobalcodeException
	 */
	public abstract Inventario getInventarioByCPF(String cpf) throws GlobalcodeException;
}
