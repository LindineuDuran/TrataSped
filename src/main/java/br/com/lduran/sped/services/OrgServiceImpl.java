package br.com.lduran.sped.services;

import java.util.LinkedList;
import java.util.List;

import br.com.lduran.sped.bean.ObjectBI;
import br.com.lduran.sped.bean.Organizacao;

public class OrgServiceImpl /*extends ObjectAdapter*/ implements OrgService, ObjectService
{

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
	public Organizacao getObject(List<String> auxOrganizacao)
	{
		Organizacao org = new Organizacao();

		String[] item = auxOrganizacao.get(0).split("\\|");
		String[] itemComplementar = auxOrganizacao.get(1).split("\\|");

		if ((item.length > 6) && (item[6] != null)) {org.setRazaoSocial(item[6]);}
		if ((item.length > 7) && (item[7] != null)) {org.setCnpj(item[7]);}
		if ((item.length > 9) && (item[9] != null)) {org.setUf(item[9]);}
		if ((item.length > 11) && (item[11] != null)) {org.setCodigoIBGE(item[11]);}
		if ((itemComplementar.length > 3) && (itemComplementar[3] != null)) {org.setCep(itemComplementar[3]);}
		if ((itemComplementar.length > 5) && (itemComplementar[4] != null) && (itemComplementar[5] != null)) {org.setEndereco(itemComplementar[4] + " " + itemComplementar[5]);}
		if ((itemComplementar.length > 7) && (itemComplementar[7] != null)) {org.setBairro(itemComplementar[7]);}

		return org;
	}

	@Override
	public ObjectBI getObject(String linha, String tabChar)
	{
		Organizacao org = new Organizacao();

		String[] dados = linha.split(tabChar);

		if ((dados.length >= 1) && (dados[0] != null)) {org.setCnpj(dados[0]);}
		if ((dados.length >= 2) && (dados[1] != null)) {org.setCodigoIBGE(dados[1]);}
		if ((dados.length >= 3) && (dados[2] != null)) {org.setRazaoSocial(dados[2]);}
		if ((dados.length >= 4) && (dados[3] != null)) {org.setEndereco(dados[3]);}
		if ((dados.length >= 5) && (dados[4] != null)) {org.setBairro(dados[4]);}
		if ((dados.length >= 6) && (dados[5] != null)) {org.setCep(dados[5]);}

		return org;
	}

	@Override
	public List<? extends ObjectBI> getObjectList(List<String> fileContent)
	{

		List<Organizacao> organizacoes = new LinkedList<>();
		Organizacao org = new Organizacao();

		Integer end = fileContent.size();
		Integer line = 0;
		String[] item = null;

		while (line < end)
		{
			String codigo = fileContent.get(line).substring(1, 5);

			switch (codigo)
			{
			case "0000":
				item = fileContent.get(line).split("\\|");
				org = new Organizacao();

				if ((item.length > 6) && (item[6] != null)) {org.setRazaoSocial(item[6]);}
				if ((item.length > 7) && (item[7] != null)) {org.setCnpj(item[7]);}
				if ((item.length > 9) && (item[9] != null)) {org.setUf(item[9]);}
				if ((item.length > 11) && (item[11] != null)) {org.setCodigoIBGE(item[11]);}

				break;

			case "0005":
				item = fileContent.get(line).split("\\|");

				if ((item.length > 3) && (item[3] != null)) {org.setCep(item[3]);}
				if ((item.length > 5) && (item[4] != null) && (item[5] != null)) {org.setEndereco(item[4] + " " + item[5]);}
				if ((item.length > 7) && (item[7] != null)) {org.setBairro(item[7]);}

				organizacoes.add(org);

				break;
			}

			line++;
		}

		return organizacoes;
	}

	@Override
	public String getObjectHeader()
	{
		return "IdOrganizacao;IdCodigoIbge;Organizacao;Endereco;Bairro;Cep";
	}

	@Override
	public String getObjectContent(ObjectBI obj)
	{
		Organizacao org = (Organizacao) obj;
		return org.getCnpj() + ";" + org.getCodigoIBGE() + ";" + org.getRazaoSocial() + ";" + org.getEndereco() + ";" + org.getBairro() + ";" + org.getCep();
	}

	@Override
	public List<? extends ObjectBI> getObjectList(List<String> fileContent, Organizacao org, String criteria)
	{
		// TODO Auto-generated method stub
		return null;
	}
}
