package br.com.lduran.sped.bean;

public interface Empresa
{
	public String getCnpj();

	public void setCnpj(String cnpj);

	public String getRazaoSocial();

	public void setRazaoSocial(String razaoSocial);

	public String getCep();

	public void setCep(String cep);

	public String getCodigoIBGE();

	public void setCodigoIBGE(String codigoIBGE);

	public String getUf();

	public void setUf(String uf);

	public String getEstado();

	public void setEstado(String estado);

	public String getRegiaoMetropolitana();

	public void setRegiaoMetropolitana(String regiaoMetropolitana);

	public String getMesorregiao();

	public void setMesorregiao(String mesorregiao);

	public String getMicrorregiao();

	public void setMicrorregiao(String microrregiao);

	public Double getLatitude();

	public void setLatitude(Double latitude);

	public Double getLongitude();

	public void setLongitude(Double longitude);

	public Double getArea();

	public void setArea(Double area);

	public String getRegiao();

	public void setRegiao(String regiao);

	public String getCidade();

	public void setCidade(String cidade);

	public String getCidadeEstado();

	public void setCidadeEstado(String cidadeEstado);

	public String getEndereco();

	public void setEndereco(String endereco);

	public String getBairro();

	public void setBairro(String bairro);

	public String getPais();

	public void setPais(String pais);
}
