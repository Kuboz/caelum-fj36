package br.com.caelum.estoque.ws;

import java.io.Serializable;

import javax.xml.ws.WebFault;

@WebFault(name="AutorizacaoFault")
public class AutorizacaoException extends RuntimeException implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AutorizacaoException(String message) {
		super(message);
	}
	
}
