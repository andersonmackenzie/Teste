package br.com.Conexao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import br.com.Auxiliares.User;

public class TratamentoNotas {

	private static TratamentoNotas singleton;

	private static PegaDados dados;
	private List<String[]> conjuntoArrays;

	private int quantidade;

	private TratamentoNotas() {
		inicializa();
	}

	private void inicializa() {
		dados = PegaDados.getInstance();
		dados.recebeNotas();
		prencheArray2();
	}

	public List<String> tabelaDados() {

		PegaDados dados = PegaDados.getInstance();

		StringBuilder html = dados.getConteudoNotas();

		Document doc = Jsoup.parse(html.toString());

		Element table = doc.select("table[id=mytable]").first();

		Iterator<Element> ite = table.select("td").iterator();

		List<String> lista = new ArrayList<String>();

		while (ite.hasNext()) {

			lista.add(ite.next().text());

		}

		return lista;

	}

	public void prencheArray2() {

		List<StringBuffer> a = dados.getDadosNotas();

		Iterator<StringBuffer> iterator = a.iterator();
		conjuntoArrays = new ArrayList<String[]>();

		String[] list;

		while (iterator.hasNext()) {
			int valor = 0;

			list = new String[14];
			while (valor <= 13) {

				list[valor++] = iterator.next().toString();

			}

			conjuntoArrays.add(list);
		}
		this.quantidade = conjuntoArrays.size();

		// System.out.println("Valor do A " + l.size());

	}

	public List<String[]> getConjuntoArrays() {
		if (conjuntoArrays == null) {
			prencheArray2();
		}
		return conjuntoArrays;
	}

	public void setConjuntoArrays(List<String[]> conjuntoArrays) {
		this.conjuntoArrays = conjuntoArrays;

	}

	public static TratamentoNotas getInstance() {
		if (singleton == null)
			singleton = new TratamentoNotas();

		return singleton;
	}

	public int getQuantNotas() {
		return quantidade;
	}

}
