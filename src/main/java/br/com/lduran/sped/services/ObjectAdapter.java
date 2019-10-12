package br.com.lduran.sped.services;

import java.util.List;

import br.com.lduran.sped.bean.ObjectBI;
import br.com.lduran.sped.bean.Organizacao;

public class ObjectAdapter implements ObjectService
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
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getObjectContent(ObjectBI obj)
	{
		// TODO Auto-generated method stub
		return null;
	}
}
