package br.com.lduran.sped.bean;

public class Produto extends ObjectBI
{
	private String IdProduto = "";
	private String descricao = "";
	private String tipoDeProduto = "";
	private String familiaProd = "";
	private String grupoProd = "";

	public String getTipoDeProduto()
	{
		return this.tipoDeProduto;
	}

	public void setTipoDeProduto(String tipoDeProduto)
	{
		this.tipoDeProduto = tipoDeProduto;
	}

	public String getFamiliaProd()
	{
		return this.familiaProd;
	}

	public void setFamiliaProd(String familiaProd)
	{
		this.familiaProd = familiaProd;
	}

	public String getGrupoProd()
	{
		return this.grupoProd;
	}

	public void setGrupoProd(String grupoProd)
	{
		this.grupoProd = grupoProd;
	}

	public String getIdProduto()
	{
		return this.IdProduto;
	}

	public void setIdProduto(String idProduto)
	{
		this.IdProduto = idProduto;
	}

	public String getDescricao()
	{
		return this.descricao;
	}

	public void setDescricao(String descricao)
	{
		this.descricao = descricao;
	}

	@Override
	public String toString()
	{
		return "Produto [IdProduto=" + this.IdProduto + ", descricao=" + this.descricao + ", tipoDeProduto=" + this.tipoDeProduto + ", familiaProd=" + this.familiaProd + ", grupoProd=" + this.grupoProd + "]";
	}
}