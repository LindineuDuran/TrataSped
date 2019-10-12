package br.com.lduran.sped.services;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.lduran.sped.bean.*;
import br.com.lduran.sped.features.ToolsFactory;

public class InventarioServiceImpl implements InventarioService, ObjectService
{
	@Override
	public List<? extends ObjectBI> getObjectList(List<String> fileContent)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<? extends ObjectBI> getObjectList(List<String> fileContent, Organizacao org, String criteria)
	{
		List<Inventario> objectListInventario = new LinkedList<>();

		int line = 0;
		int end = fileContent.size();
		String codigo = "";
		String[] item = null;

		int indicadorMovimento = 1;
		String dataInventario = "";

		while (line < end && !codigo.equals("H005"))
		{
			codigo = fileContent.get(line).substring(1, 5);

			switch (codigo)
			{
			case "H001":
				item = fileContent.get(line).split("\\|");
				if ((item.length >= 2) && (item[2] != null))
				{
					indicadorMovimento = Integer.parseInt(item[2]);
				}

				break;

			case "H005":
				item = fileContent.get(line).split("\\|");
				if ((item.length >= 2) && (item[2] != null))
				{
					dataInventario = item[2];
				}

				break;
			}

			line++;
		}

		if (indicadorMovimento == 0)
		{
			fileContent = fileContent.stream().filter(sped -> sped.substring(0, 6).equals("|H010|")).collect(Collectors.toList());

			for (String linha : fileContent)
			{
				Inventario inv = new Inventario();

				inv.setOrganizacao(org.getCnpj());
				inv.setDataInventario(dataInventario);

				item = linha.replace(",", ".").split("\\|");

				if ((item.length >= 2) && (item[2] != null))
				{
					inv.setIdItem(item[2]);
				}
				if ((item.length >= 3) && (item[3] != null))
				{
					inv.setUnidade(item[3]);
				}
				if ((item.length >= 4) && (item[4] != null) && (ToolsFactory.getInstance().isNumeric(item[4])))
				{
					inv.setQuantidade(Double.parseDouble(item[4]));
				}
				if ((item.length >= 5) && (item[5] != null) && (ToolsFactory.getInstance().isNumeric(item[5])))
				{
					inv.setValorUnitario(new BigDecimal(Double.parseDouble(item[5])).setScale(2, BigDecimal.ROUND_HALF_UP));
				}
				if ((item.length >= 6) && (item[6] != null) && (ToolsFactory.getInstance().isNumeric(item[6])))
				{
					inv.setValorTotal(new BigDecimal(Double.parseDouble(item[6])).setScale(2, BigDecimal.ROUND_HALF_UP));
				}
				if ((item.length >= 7) && (item[7] != null))
				{
					inv.setPropriedade(ToolsFactory.getInstance().obtemDescricaoIndicadorPropriedade("IP" + item[7]));
				}
				if ((item.length >= 8) && (item[8] != null))
				{
					inv.setParticipante(item[8]);
				}
				if ((item.length >= 9) && (item[9] != null))
				{
					inv.setTextoComplementar(item[9]);
				}
				if ((item.length >= 10) && (item[10] != null))
				{
					inv.setContaContabil(item[10]);
				}
				if ((item.length >= 11) && (item[11] != null) && (ToolsFactory.getInstance().isNumeric(item[11])))
				{
					inv.setValorTotIR(new BigDecimal(Double.parseDouble(item[11])).setScale(2, BigDecimal.ROUND_HALF_UP));
				}

				objectListInventario.add(inv);
			}
		}

		List<? extends ObjectBI> objectList = objectListInventario;
		return objectList;
	}

	@Override
	public String getObjectHeader()
	{
		return "DataDoInventario;IdItem;UnidadeDeMedida;Quantidade;ValorUnitario;ValorTotalDoItem;Propriedade;IdParticipante;TextoComplementar;ContaContabil;ValorTotalDoItemParaImpostoDeRenda;IdOrganizacao";
	}

	@Override
	public String getObjectContent(ObjectBI obj)
	{
		NumberFormat formatadorMoeda = NumberFormat.getNumberInstance();

		Inventario inv = (Inventario) obj;
		return inv.getDataInventario() + ";" + inv.getIdItem() + ";" + inv.getUnidade() + ";" + formatadorMoeda.format(inv.getQuantidade()) + ";" + formatadorMoeda.format(inv.getValorUnitario()) + ";"
				+ formatadorMoeda.format(inv.getValorTotal()) + ";" + inv.getPropriedade() + ";" + inv.getParticipante() + ";" + inv.getTextoComplementar() + ";" + inv.getContaContabil() + ";" + formatadorMoeda.format(inv.getValorTotIR())
				+ ";" + inv.getOrganizacao();
	}

	@Override
	public ObjectBI getObject(String linha, String tabChar)
	{
		// TODO Auto-generated method stub
		return null;
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