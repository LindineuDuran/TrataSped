package br.com.lduran.sped.services;

public class BuildService
{
	public ObjectService getObjectService(String objectType)
	{
		switch (objectType)
		{
		case "Organizacoes":
			return new OrgServiceImpl();

		default:
			return null;
		}
	}
}
