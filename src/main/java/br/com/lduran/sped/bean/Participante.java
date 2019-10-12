package br.com.lduran.sped.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Participantes")
public class Participante extends ObjectBI implements Empresa
{

	@Id
	@Column(length = 100, name = "IdParticipante")
	private String cnpj;

	@Column(name = "Participante")
	private String razaoSocial = "";

	@Column(name = "CEP")
	private String cep = "";

	@Column(name = "IdCidade")
	private String codigoIBGE = "";

	@Column(name = "UF")
	private String uf = "";

	@Column(name = "Estado")
	private String estado = "";

	@Column(name = "RegiaoMetropolitana")
	private String regiaoMetropolitana = "";

	@Column(name = "Mesorregiao")
	private String mesorregiao = "";

	@Column(name = "Microrregiao")
	private String microrregiao = "";

	@Column(name = "Latitude")
	private Double latitude = 0.0;

	@Column(name = "Longitude")
	private Double longitude = 0.0;

	@Column(name = "Area")
	private Double area = 0.0;

	@Column(name = "Populacao")
	private Long populacao = (long) 0;

	@Column(name = "Regiao")
	private String regiao = "";

	@Column(name = "Cidade")
	private String cidade = "";

	@Column(name = "CidadeEstado")
	private String cidadeEstado = "";

	@Column(name = "Endereco")
	private String endereco = "";

	@Column(name = "Bairro")
	private String bairro = "";

	@Column(name = "Pais")
	private String pais = "";

	@Column(name = "Segmento")
	private String segmento = "";

	@Override
	public String getCnpj()
	{
		return this.cnpj;
	}

	@Override
	public void setCnpj(String cnpj)
	{
		this.cnpj = cnpj;
	}

	@Override
	public String getRazaoSocial()
	{
		return this.razaoSocial;
	}

	@Override
	public void setRazaoSocial(String razaoSocial)
	{
		this.razaoSocial = razaoSocial;
	}

	@Override
	public String getCep()
	{
		return this.cep;
	}

	@Override
	public void setCep(String cep)
	{
		this.cep = cep;
	}

	@Override
	public String getCodigoIBGE()
	{
		return this.codigoIBGE;
	}

	@Override
	public void setCodigoIBGE(String codigoIBGE)
	{
		this.codigoIBGE = codigoIBGE;
	}

	@Override
	public String getUf()
	{
		return this.uf;
	}

	@Override
	public void setUf(String uf)
	{
		this.uf = uf;
	}

	@Override
	public String getEstado()
	{
		return this.estado;
	}

	@Override
	public void setEstado(String estado)
	{
		this.estado = estado;
	}

	@Override
	public String getRegiaoMetropolitana()
	{
		return this.regiaoMetropolitana;
	}

	@Override
	public void setRegiaoMetropolitana(String regiaoMetropolitana)
	{
		this.regiaoMetropolitana = regiaoMetropolitana;
	}

	@Override
	public String getMesorregiao()
	{
		return this.mesorregiao;
	}

	@Override
	public void setMesorregiao(String mesorregiao)
	{
		this.mesorregiao = mesorregiao;
	}

	@Override
	public String getMicrorregiao()
	{
		return this.microrregiao;
	}

	@Override
	public void setMicrorregiao(String microrregiao)
	{
		this.microrregiao = microrregiao;
	}

	@Override
	public Double getLatitude()
	{
		return this.latitude;
	}

	@Override
	public void setLatitude(Double latitude)
	{
		this.latitude = latitude;
	}

	@Override
	public Double getLongitude()
	{
		return this.longitude;
	}

	@Override
	public void setLongitude(Double longitude)
	{
		this.longitude = longitude;
	}

	@Override
	public Double getArea()
	{
		return this.area;
	}

	@Override
	public void setArea(Double area)
	{
		this.area = area;
	}

	@Override
	public String getRegiao()
	{
		return this.regiao;
	}

	@Override
	public void setRegiao(String regiao)
	{
		this.regiao = regiao;
	}

	@Override
	public String getCidade()
	{
		return this.cidade;
	}

	@Override
	public void setCidade(String cidade)
	{
		this.cidade = cidade;
	}

	@Override
	public String getCidadeEstado()
	{
		return this.cidadeEstado;
	}

	@Override
	public void setCidadeEstado(String cidadeEstado)
	{
		this.cidadeEstado = cidadeEstado;
	}

	@Override
	public String getEndereco()
	{
		return this.endereco;
	}

	@Override
	public void setEndereco(String endereco)
	{
		this.endereco = endereco;
	}

	@Override
	public String getBairro()
	{
		return this.bairro;
	}

	@Override
	public void setBairro(String bairro)
	{
		this.bairro = bairro;
	}

	@Override
	public String getPais()
	{
		return this.pais;
	}

	@Override
	public void setPais(String pais)
	{
		this.pais = pais;
	}

	public String getSegmento()
	{
		return this.segmento;
	}

	public void setSegmento(String segmento)
	{
		this.segmento = segmento;
	}

	@Override
	public String toString()
	{
		return "Participante [cnpj=" + this.cnpj + ", razaoSocial=" + this.razaoSocial + ", cep=" + this.cep + ", codigoIBGE="
				+ this.codigoIBGE + ", uf=" + this.uf + ", estado=" + this.estado + ", regiaoMetropolitana=" + this.regiaoMetropolitana
				+ ", mesorregiao=" + this.mesorregiao + ", microrregiao=" + this.microrregiao + ", latitude=" + this.latitude
				+ ", longitude=" + this.longitude + ", area=" + this.area + ", populacao=" + this.populacao + ", regiao=" + this.regiao
				+ ", cidade=" + this.cidade + ", cidadeEstado=" + this.cidadeEstado + ", endereco=" + this.endereco + ", bairro="
				+ this.bairro + ", pais=" + this.pais + ", segmento=" + this.segmento + "]";
	}
}