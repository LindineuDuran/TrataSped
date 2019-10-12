package br.com.lduran.sped.services;

import java.util.LinkedList;
import java.util.List;

import br.com.lduran.sped.bean.*;

public class ProdutoServiceImpl implements ProdutoService, ObjectService
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
	public ObjectBI getObject(List<String> file)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ObjectBI getObject(String linha, String tabChar)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<? extends ObjectBI> getObjectList(List<String> fileContent)
	{
		List<Produto> objectListProdutos = new LinkedList<>();

		for (String line : fileContent)
		{
			String[] item = line.split("\\|");

			Produto novo = new Produto();

			if ((item.length > 2) && (item[2] != null))
			{
				novo.setIdProduto(item[2]);
			}
			if ((item.length > 3) && (item[3] != null))
			{
				novo.setDescricao(item[3]);
			}

			objectListProdutos.add(novo);
		}

		List<? extends ObjectBI> objectList = objectListProdutos;
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
		return "IdProduto;Produto;TipoDeProduto;GrupoDeProdutos;FamiliaDeProdutos";
	}

	@Override
	public String getObjectContent(ObjectBI obj)
	{
		Produto produto = (Produto) obj;
		return produto.getIdProduto() + ";" + produto.getDescricao() + ";" + produto.getTipoDeProduto() + ";" + produto.getGrupoProd() + ";" + produto.getFamiliaProd();
	}
}