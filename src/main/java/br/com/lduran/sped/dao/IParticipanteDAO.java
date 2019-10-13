package br.com.lduran.sped.dao;

import java.util.List;

import br.com.lduran.sped.bean.Participante;
import br.com.lduran.sped.exception.GlobalcodeException;

public interface IParticipanteDAO
{
	/**
	 * @param Participante participante a ser inserido na fonte de dados em questao
	 * @throws GlobalcodeException
	 */
	public abstract void save(Participante participante) throws GlobalcodeException;

	public abstract void saveAll(List<Participante> participantes) throws GlobalcodeException;

	/**
	 * @param CPF do Participante a ser excluido da fonte de dados em questao
	 * @throws GlobalcodeException
	 */
	public abstract void excluir(String cpf) throws GlobalcodeException;

	/**
	 * @return java.util.List contendo todos os Participantes contidos na fonte da dados em questao
	 * @throws GlobalcodeException
	 */
	public abstract List getAllParticipantes() throws GlobalcodeException;

	/**
	 * @param String CPF do Participante a ser pesquisado no "banco de dados"
	 * @return Participante
	 * @throws GlobalcodeException
	 */
	public abstract Participante getParticipanteByCPF(String cpf) throws GlobalcodeException;
}
