package br.com.Conexao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Tratamento {
	public List<String> tabelaDados() {

		PegaDados dados = PegaDados.getInstance();

		StringBuilder html = dados.getConteudo();

		Document doc = Jsoup.parse(html.toString());

		Element table = doc.select("table[id=mytable]").first();

		if (table == null)
			return new ArrayList<String>();

		Iterator<Element> ite = table.select("td").iterator();
	
		List<String> lista = new ArrayList<String>();

		while (ite.hasNext()) {
			lista.add(ite.next().text());
		}
		return lista;
	}

}
