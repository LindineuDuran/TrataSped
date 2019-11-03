package br.com.lduran.sped.bean;

import lombok.*;

@Getter
@Setter
@ToString
public class Produto extends ObjectBI
{
	private String IdProduto = "";
	private String descricao = "";
	private String tipoDeProduto = "";
	private String familiaProd = "";
	private String grupoProd = "";
}