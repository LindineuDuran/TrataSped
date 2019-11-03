package br.com.lduran.sped.bean;

import lombok.*;

@Getter
@Setter
@ToString
public class Participante extends ObjectBI implements Empresa
{
	private String cnpj;
	private String razaoSocial = "";
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
	private String segmento = "";
}