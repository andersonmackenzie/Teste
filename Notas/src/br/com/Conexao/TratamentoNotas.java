package br.com.Conexao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import br.com.Auxiliares.User;

public class TratamentoNotas {

	private static PegaDados dados;

	public TratamentoNotas() {
		inicializa();
	}

	private void inicializa() {
		dados = PegaDados.getInstance();
		dados.recebeNotas();
	}

	public List<String> tabelaDados() {

		PegaDados dados = PegaDados.getInstance();

		StringBuilder html = dados.getConteudoNotas();

		Document doc = Jsoup.parse(html.toString());

		// Element pNome = doc.select("b[class=tituloNomeTia]").first();
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

	public static List<String[]> prencheArray2() {

		List<StringBuffer> a = dados.getDadosNotas();
		Iterator<StringBuffer> iterator = a.iterator();
		List<String[]> l = new ArrayList<String[]>();

		String[] list;

		while (iterator.hasNext()) {
			int valor = 0;

			list = new String[14];
			while (valor <= 13) {

				list[valor++] = iterator.next().toString();

			}
			l.add(list);
		}
		System.out.println("Valor do A " + l.size());
		return l;

	}

}
