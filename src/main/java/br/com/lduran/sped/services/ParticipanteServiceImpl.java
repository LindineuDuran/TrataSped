package br.com.lduran.sped.services;

import java.util.LinkedList;
import java.util.List;

import br.com.lduran.sped.bean.*;

public class ParticipanteServiceImpl implements ParticipanteService, ObjectService
{
	@Override
	public List<? extends ObjectBI> getObjectList(List<String> fileContent)
	{
		List<Participante> objectListParticipantes = new LinkedList<>();

		for (String line : fileContent)
		{
			Participante participante = new Participante();

			String[] item = line.split("\\|");

			if ((item.length > 3) && (item[3] != null))
			{
				participante.setRazaoSocial(item[3]);
			}
			if ((item.length > 6) && (item[5] != null) && (item[6] != null))
			{
				participante.setCnpj(!item[5].equals("") ? item[5] : item[6]);
			}
			if ((item.length > 8) && (item[8] != null))
			{
				participante.setCodigoIBGE(item[8]);
			}
			if ((item.length > 11) && (item[10] != null) && (item[11] != null))
			{
				participante.setEndereco(item[10] + " " + item[11]);
			}
			if ((item.length > 13) && (item[13] != null))
			{
				participante.setBairro(item[13]);
			}

			objectListParticipantes.add(participante);
		}

		List<? extends ObjectBI> objectList = objectListParticipantes;
		return objectList;
	}

	@Override
	public List<? extends ObjectBI> getObjectList(List<String> fileContent, Organizacao org, String criteria)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getObjectHeader()
	{
		return "IdParticipante;IdCodigoIbge;Participante;Endereco;Bairro;Pais;Segmento;Cep";
	}

	@Override
	public String getObjectContent(ObjectBI obj)
	{
		Participante part = (Participante) obj;
		return part.getCnpj() + ";" + part.getCodigoIBGE() + ";" + part.getRazaoSocial() + ";" + part.getEndereco() + ";" + part.getBairro() + ";" + part.getPais() + ";" + part.getSegmento() + ";" + part.getCep();
	}

	@Override
	public ObjectBI getObject(String linha, String tabChar)
	{
		Participante participante = new Participante();

		String[] dados = linha.split(tabChar);

		if ((dados.length >= 1) && (dados[0] != null))
		{
			participante.setCnpj(dados[0]);
		}
		if ((dados.length >= 2) && (dados[1] != null))
		{
			participante.setCodigoIBGE(dados[1]);
		}
		if ((dados.length >= 3) && (dados[2] != null))
		{
			participante.setRazaoSocial(dados[2]);
		}
		if ((dados.length >= 4) && (dados[3] != null))
		{
			participante.setEndereco(dados[3]);
		}
		if ((dados.length >= 5) && (dados[4] != null))
		{
			participante.setBairro(dados[4]);
		}
		if ((dados.length >= 6) && (dados[5] != null))
		{
			participante.setPais(dados[5]);
		}
		if ((dados.length >= 7) && (dados[6] != null))
		{
			participante.setSegmento(dados[6]);
		}
		if ((dados.length >= 8) && (dados[7] != null))
		{
			participante.setCep(dados[7]);
		}

		return participante;
	}

	@Override
	public ObjectBI save(ObjectBI obj)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveAll(List<? extends ObjectBI> lstObjetosBI)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public ObjectBI getObject(List<String> file)
	{
		// TODO Auto-generated method stub
		return null;
	}
}