package br.com.casa.notas;

import java.util.List;

import br.com.Conexao.Tratamento;
import br.com.Conexao.TratamentoNotas;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * super.{@link Activity}
 * */
public class TabNotas extends Activity {
	public ListView lista;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tab_notas);

		Intent i = getIntent();

		String tabContent = i.getStringExtra("tab");

		TextView text = (TextView) findViewById(R.id.txtText);

		if (tabContent.equalsIgnoreCase("0"))
			text.setText("BLOGANDO TAB 0");
		else if (tabContent.equalsIgnoreCase("1"))
			text.setText("BLOGANDO A PRIMEIRA TAB\nTAB 1");

		List<String> teste = new TratamentoNotas().tabelaDados();
		ArrayAdapter<String> adapter = null;

		// if (teste.size() > 5) {
		// String[] contatos = { teste.get(8).toString(),
		// teste.get(15).toString(), teste.get(22).toString(),
		// teste.get(29).toString(), teste.get(36).toString(),
		// teste.get(43).toString() };
		//
		// adapter = new ArrayAdapter<String>(this,
		// android.R.layout.simple_list_item_1, contatos);
		// } else {
		String[] contatos = { teste.get(5) };
		adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, contatos);
		// }

		teste = null;
		lista = (ListView) findViewById(R.id.listaNota1);
		lista.setAdapter(adapter);

	}

}
