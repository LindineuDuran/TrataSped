package br.com.lduran.sped.bean;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
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
}