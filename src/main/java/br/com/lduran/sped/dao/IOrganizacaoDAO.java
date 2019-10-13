package br.com.lduran.sped.dao;

import java.util.List;

import br.com.lduran.sped.bean.Organizacao;
import br.com.lduran.sped.exception.GlobalcodeException;

public interface IOrganizacaoDAO
{
	/**
	 * @param Organizacao organizacao a ser inserido na fonte de dados em questao
	 * @throws GlobalcodeException
	 */
	public abstract void save(Organizacao organizacao) throws GlobalcodeException;

	public abstract void saveAll(List<Organizacao> organizacaos) throws GlobalcodeException;

	/**
	 * @param CPF do Organizacao a ser excluido da fonte de dados em questao
	 * @throws GlobalcodeException
	 */
	public abstract void excluir(String cpf) throws GlobalcodeException;

	/**
	 * @return java.util.List contendo todos os Organizacaos contidos na fonte da dados em questao
	 * @throws GlobalcodeException
	 */
	public abstract List getAllOrganizacaos() throws GlobalcodeException;

	/**
	 * @param String CPF do Organizacao a ser pesquisado no "banco de dados"
	 * @return Organizacao
	 * @throws GlobalcodeException
	 */
	public abstract Organizacao getOrganizacaoByCPF(String cpf) throws GlobalcodeException;
}
