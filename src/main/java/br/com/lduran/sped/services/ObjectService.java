package br.com.lduran.sped.services;

import java.util.List;

import br.com.lduran.sped.bean.ObjectBI;
import br.com.lduran.sped.bean.Organizacao;

public interface ObjectService
{
	public ObjectBI save(ObjectBI obj);
	public void saveAll(List<? extends ObjectBI> lstObjetosBI);
	public ObjectBI getObject(List<String> file);
	public ObjectBI getObject(String linha, String tabChar);
	public List<? extends ObjectBI> getObjectList(List<String> fileContent);
	public List<? extends ObjectBI> getObjectList(List<String> fileContent, Organizacao org, String criteria);
	public String getObjectHeader();
	public String getObjectContent(ObjectBI obj);
}
