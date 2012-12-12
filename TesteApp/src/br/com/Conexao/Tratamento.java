package br.com.Conexao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Tratamento {
	public List<String> tabelaDados() {

		StringBuilder html = new PegaDados().recebe();

		Document doc = Jsoup.parse(html.toString());

		Element pNome = doc.select("b[class=tituloNomeTia]").first();
		// String nomeFac =
		// doc.select("b[class=tituloFaculdade]").first().text();
		//
		// String nome = pNome.text();

		Element table = doc.select("table[id=mytable]").first();

		Iterator<Element> ite = table.select("td").iterator();

		List<String> lista = new ArrayList<String>();

		while (ite.hasNext()) {

			lista.add(ite.next().text());

		}
		
		return lista;

	}

}
