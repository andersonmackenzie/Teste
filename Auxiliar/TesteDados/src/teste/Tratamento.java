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
		StringBuffer saida = new StringBuffer();
		while (ite.hasNext()) {
			
			saida.append(ite.next().text());
			if (i > 13) {
				listaNotas.add(saida);
//			saida.delete(0, saida.length());
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

		for (String a : lista2) {
			System.out.println(a);
		}

	}

}
