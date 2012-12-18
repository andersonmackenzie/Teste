package teste;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import br.com.Auxiliares.User;

public class Tratamento {
	public static Tratamento instancia;
	private PegaDados dados;

	private Tratamento() {
		inicializa();
	}

	private void inicializa() {
		dados = PegaDados.getInstance();
		dados.recebe();
	}

	public List<String> tabelaDados() {

		StringBuilder html = dados.getConteudo();

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

	public List<String> getCabeçalho() {

		StringBuilder html = dados.getConteudo();

		Document doc = Jsoup.parse(html.toString());

		// Element pNome = doc.select("b[class=tituloNomeTia]").first();
		// String nomeFac =
		// doc.select("b[class=tituloFaculdade]").first().text();
		//
		// String nome = pNome.text();

		Element table = doc.select("table[id=mytable]").first();

		Iterator<Element> ite = table.select("td").iterator();

		List<String> cabecacho = new ArrayList<String>();
		int i = 0;
		cabecacho.add("codigo");
		while (ite.hasNext()) {
			i++;
			cabecacho.add(ite.next().text());

			if (i == 13)
				break;
		}

		return cabecacho;

	}

	public List<StringBuffer> getDadosNotas() {

		StringBuilder html = dados.getConteudo();

		Document doc = Jsoup.parse(html.toString());

		// Element pNome = doc.select("b[class=tituloNomeTia]").first();
		// String nomeFac =
		// doc.select("b[class=tituloFaculdade]").first().text();
		//
		// String nome = pNome.text();

		Element table = doc.select("table[id=mytable]").first();

		Iterator<Element> ite = table.select("td").iterator();

		List<StringBuffer> listaNotas = new ArrayList<StringBuffer>();
		int i = 0;
		StringBuffer saida;
		while (ite.hasNext()) {
			saida = new StringBuffer();

			saida.append(ite.next().text());
			if (i >= 13) {
				listaNotas.add(saida);

			}
			i++;
		}
		return listaNotas;

	}

	public static void main(String[] args) {
		Tratamento t = new Tratamento();

		PegaDados p = PegaDados.getInstance();

		List<String> lista = new ArrayList<String>();

		int i = 0;

		List<String> listas = t.getCabeçalho();

		for (String a : listas) {
			lista.add(" " + i + " -  - " + a);
			i++;
		}

		for (String a : lista) {
			System.out.println(a);
		}

		System.out.println("--------");

		List<String> lista2 = new ArrayList<String>();

		List<StringBuffer> tab = t.getDadosNotas();

		for (StringBuffer a : tab) {

			lista2.add(" " + i + " -  - " + a.toString());
			i++;
		}

		for (String a : prencheArray().get(4)) {
			if (!a.equals(""))
				System.out.println(a);
		}

		List<String[]> f = prencheArray2();
		String[] a = f.get(8);
		for (int j = 0; j < a.length; j++) {
			System.out.println(a[j]);
		}

		System.out.print(prencheArray2().size());
	}

	public static List<List<String>> prencheArray() {

		List<StringBuffer> a = new Tratamento().getDadosNotas();
		Iterator<StringBuffer> iterator = a.iterator();
		List<List<String>> l = new ArrayList<List<String>>();

		List<String> lista;

		while (iterator.hasNext()) {
			lista = new ArrayList<String>();
			int valor = 0;
			while (valor <= 13) {
				lista.add(iterator.next().toString());

				valor++;
			}
			l.add(lista);
		}

		return l;

	}

	public static List<String[]> prencheArray2() {

		List<StringBuffer> a = new Tratamento().getDadosNotas();
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
