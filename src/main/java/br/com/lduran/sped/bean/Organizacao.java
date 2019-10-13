package br.com.lduran.sped.bean;

public class Organizacao extends ObjectBI
{
	private String cnpj = "";
	private String razaoSocial;
	private String cep = "";
	private String codigoIBGE = "";
	private String uf = "";
	private String estado = "";
	private String regiaoMetropolitana = "";
	private String mesorregiao = "";
	private String microrregiao = "";
	private Double latitude = 0.0;
	private Double longitude = 0.0;
	private Double area = 0.0;
	private Long populacao = (long) 0;
	private String regiao = "";
	private String cidade = "";
	private String cidadeEstado = "";
	private String endereco = "";
	private String bairro = "";
	private String pais = "";

	/**
	 *
	 */
	public Organizacao()
	{
	}

	/**
	 * @param cnpj
	 * @param razaoSocial
	 * @param cep
	 * @param codigoIBGE
	 * @param endereco
	 * @param bairro
	 */
	public Organizacao(String cnpj, String razaoSocial, String cep, String codigoIBGE, String endereco, String bairro)
	{
		this.cnpj = cnpj;
		this.razaoSocial = razaoSocial;
		this.cep = cep;
		this.codigoIBGE = codigoIBGE;
		this.endereco = endereco;
		this.bairro = bairro;
	}

	/**
	 * @return the cnpj
	 */
	public String getCnpj()
	{
		return this.cnpj;
	}

	/**
	 * @param cnpj the cnpj to set
	 */
	public void setCnpj(String cnpj)
	{
		this.cnpj = cnpj;
	}

	/**
	 * @return the razaoSocial
	 */
	public String getRazaoSocial()
	{
		return this.razaoSocial;
	}

	/**
	 * @param razaoSocial the razaoSocial to set
	 */
	public void setRazaoSocial(String razaoSocial)
	{
		this.razaoSocial = razaoSocial;
	}

	/**
	 * @return the cep
	 */
	public String getCep()
	{
		return this.cep;
	}

	/**
	 * @param cep the cep to set
	 */
	public void setCep(String cep)
	{
		this.cep = cep;
	}

	/**
	 * @return the codigoIBGE
	 */
	public String getCodigoIBGE()
	{
		return this.codigoIBGE;
	}

	/**
	 * @param codigoIBGE the codigoIBGE to set
	 */
	public void setCodigoIBGE(String codigoIBGE)
	{
		this.codigoIBGE = codigoIBGE;
	}

	/**
	 * @return the uf
	 */
	public String getUf()
	{
		return this.uf;
	}

	/**
	 * @param uf the uf to set
	 */
	public void setUf(String uf)
	{
		this.uf = uf;
	}

	/**
	 * @return the estado
	 */
	public String getEstado()
	{
		return this.estado;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String estado)
	{
		this.estado = estado;
	}

	/**
	 * @return the regiaoMetropolitana
	 */
	public String getRegiaoMetropolitana()
	{
		return this.regiaoMetropolitana;
	}

	/**
	 * @param regiaoMetropolitana the regiaoMetropolitana to set
	 */
	public void setRegiaoMetropolitana(String regiaoMetropolitana)
	{
		this.regiaoMetropolitana = regiaoMetropolitana;
	}

	/**
	 * @return the mesorregiao
	 */
	public String getMesorregiao()
	{
		return this.mesorregiao;
	}

	/**
	 * @param mesorregiao the mesorregiao to set
	 */
	public void setMesorregiao(String mesorregiao)
	{
		this.mesorregiao = mesorregiao;
	}

	/**
	 * @return the microrregiao
	 */
	public String getMicrorregiao()
	{
		return this.microrregiao;
	}

	/**
	 * @param microrregiao the microrregiao to set
	 */
	public void setMicrorregiao(String microrregiao)
	{
		this.microrregiao = microrregiao;
	}

	/**
	 * @return the latitude
	 */
	public Double getLatitude()
	{
		return this.latitude;
	}

	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(Double latitude)
	{
		this.latitude = latitude;
	}

	/**
	 * @return the longitude
	 */
	public Double getLongitude()
	{
		return this.longitude;
	}

	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(Double longitude)
	{
		this.longitude = longitude;
	}

	/**
	 * @return the area
	 */
	public Double getArea()
	{
		return this.area;
	}

	/**
	 * @param area the area to set
	 */
	public void setArea(Double area)
	{
		this.area = area;
	}

	/**
	 * @return the populacao
	 */
	public Long getPopulacao()
	{
		return this.populacao;
	}

	/**
	 * @param populacao the populacao to set
	 */
	public void setPopulacao(Long populacao)
	{
		this.populacao = populacao;
	}

	/**
	 * @return the regiao
	 */
	public String getRegiao()
	{
		return this.regiao;
	}

	/**
	 * @param regiao the regiao to set
	 */
	public void setRegiao(String regiao)
	{
		this.regiao = regiao;
	}

	/**
	 * @return the cidade
	 */
	public String getCidade()
	{
		return this.cidade;
	}

	/**
	 * @param cidade the cidade to set
	 */
	public void setCidade(String cidade)
	{
		this.cidade = cidade;
	}

	/**
	 * @return the cidadeEstado
	 */
	public String getCidadeEstado()
	{
		return this.cidadeEstado;
	}

	/**
	 * @param cidadeEstado the cidadeEstado to set
	 */
	public void setCidadeEstado(String cidadeEstado)
	{
		this.cidadeEstado = cidadeEstado;
	}

	/**
	 * @return the endereco
	 */
	public String getEndereco()
	{
		return this.endereco;
	}

	/**
	 * @param endereco the endereco to set
	 */
	public void setEndereco(String endereco)
	{
		this.endereco = endereco;
	}

	/**
	 * @return the bairro
	 */
	public String getBairro()
	{
		return this.bairro;
	}

	/**
	 * @param bairro the bairro to set
	 */
	public void setBairro(String bairro)
	{
		this.bairro = bairro;
	}

	/**
	 * @return the pais
	 */
	public String getPais()
	{
		return this.pais;
	}

	/**
	 * @param pais the pais to set
	 */
	public void setPais(String pais)
	{
		this.pais = pais;
	}

	@Override
	public String toString()
	{
		return "Organizacao [cnpj=" + this.cnpj + ", razaoSocial=" + this.razaoSocial + ", cep=" + this.cep + ", codigoIBGE=" + this.codigoIBGE + ", uf=" + this.uf + ", estado=" + this.estado + ", regiaoMetropolitana="
				+ this.regiaoMetropolitana + ", mesorregiao=" + this.mesorregiao + ", microrregiao=" + this.microrregiao + ", latitude=" + this.latitude + ", longitude=" + this.longitude + ", area=" + this.area + ", populacao="
				+ this.populacao + ", regiao=" + this.regiao + ", cidade=" + this.cidade + ", cidadeEstado=" + this.cidadeEstado + ", endereco=" + this.endereco + ", bairro=" + this.bairro + ", pais=" + this.pais + "]";
	}
}