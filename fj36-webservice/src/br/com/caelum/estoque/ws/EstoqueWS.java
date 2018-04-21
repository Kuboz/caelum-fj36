package br.com.caelum.estoque.ws;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService(targetNamespace="http://caelum.com.br/EstoqueWS/V1")
@Stateless
public class EstoqueWS {
	
	private Map<String, ItemEstoque> repositorio = new HashMap<>();
	
	private final String TOKEN = "TOKEN123";

	public EstoqueWS() {
		repositorio.put("SOA", new ItemEstoque("SOA", 5));
		repositorio.put("TDD", new ItemEstoque("TDD", 1));
		repositorio.put("RES", new ItemEstoque("RES", 2));
		repositorio.put("LOG", new ItemEstoque("LOG", 4));
		repositorio.put("WEB", new ItemEstoque("WEB", 1));
		repositorio.put("ARQ", new ItemEstoque("ARQ", 2));
	}

	@WebMethod(operationName="ItensPeloCodigo")
	@WebResult(name="ItemEstoque")
	public List<ItemEstoque> getQuantidade(@WebParam(name="codigo") List<String> codigos,
						@WebParam(name="tokenUsuario", header = true) String token) {
		List<ItemEstoque> itens = new ArrayList<>();
		
		if (!TOKEN.equals(token)) {
			throw new AutorizacaoException("Não autorizado");
		}
		
		if (codigos == null || codigos.isEmpty()) {
			return itens;
		}
		
		codigos.forEach(codigo -> {
			if (this.repositorio.containsKey(codigo)) {
				itens.add(this.repositorio.get(codigo));
			}
		});

		return itens;
	}
}
