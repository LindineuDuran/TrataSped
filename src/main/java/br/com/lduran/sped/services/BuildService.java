package br.com.lduran.sped.services;

public class BuildService
{
	public ObjectService getObjectService(String objectType)
	{
		switch (objectType)
		{
		case "Organizacoes":
			OrgService orgService = new OrgServiceImpl();
			return (ObjectService) orgService;

		case "Participantes":
			ParticipanteService participanteService = new ParticipanteServiceImpl();
			return (ObjectService) participanteService;

		case "Produtos":
			ProdutoService produtoService = new ProdutoServiceImpl();
			return (ObjectService) produtoService;

		default:
			return null;
		}
	}
}
