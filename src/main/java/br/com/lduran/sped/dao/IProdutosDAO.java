package br.com.lduran.sped.dao;

import java.util.List;

import br.com.lduran.sped.bean.Produto;
import br.com.lduran.sped.exception.GlobalcodeException;

public interface IProdutosDAO
{

	/**
	 * @param cliente Cliente a ser inserido na fonte de dados em questao
	 * @throws GlobalcodeException
	 */
	public abstract void save(Produto produto) throws GlobalcodeException;

	public abstract void saveAll(List<Produto> produtos) throws GlobalcodeException;

	/**
	 * @param CPF do Cliente a ser excluido da fonte de dados em questao
	 * @throws GlobalcodeException
	 */
	public abstract void excluir(String cpf) throws GlobalcodeException;

	/**
	 * @return java.util.List contendo todos os clientes contidos na fonte da dados em questao
	 * @throws GlobalcodeException
	 */
	public abstract List getAllProdutos() throws GlobalcodeException;

	/**
	 * @param String CPF do cliente a ser pesquisado no "banco de dados"
	 * @return Cliente
	 * @throws GlobalcodeException
	 */
	public abstract Produto getProdutoByCPF(String cpf) throws GlobalcodeException;
}