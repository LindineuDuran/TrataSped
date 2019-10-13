package br.com.lduran.sped.exception;

/*
 * Globalcode - "The Developers Company"
 *
 * Academia do Java
 *
 */
public class GlobalcodeException extends Exception
{
	public GlobalcodeException(String mensagem, Exception e)
	{
		super(mensagem, e);
	}

	public GlobalcodeException(String mensagem)
	{
		super(mensagem);
	}
}