package br.com.lduran.sped.bean;

import java.math.BigDecimal;

import lombok.*;

@Getter
@Setter
@ToString
public class Inventario extends ObjectBI
{
	private Long inventario_id;
	private String dataInventario = "";
	private String IdItem = "";
	private String unidade = "";
	private double quantidade = 0.0;
	private BigDecimal valorUnitario = new BigDecimal(0);
	private BigDecimal valorTotal = new BigDecimal(0);
	private String propriedade = "";
	private String participante = "";
	private String textoComplementar = "";
	private String contaContabil = "";
	private BigDecimal valorTotIR = new BigDecimal(0);
	private String organizacao = "";
}