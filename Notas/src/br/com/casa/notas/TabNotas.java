package br.com.casa.notas;

import java.util.List;
import br.com.Conexao.TratamentoNotas;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class TabNotas extends Activity {
	public ListView lista;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tab_notas);

		Intent i = getIntent();

		int tab = i.getIntExtra("tab", 0);

		// TextView text = (TextView) findViewById(R.id.txtText);

		ArrayAdapter<String> adapter = null;

		String[] contatos = pegaLista(tab);
		adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, contatos);

		lista = (ListView) findViewById(R.id.listaNota1);
		lista.setAdapter(adapter);
		
	}

	public String[] pegaLista(int cod) {
		List<String[]> listas = TratamentoNotas.getInstance()
				.getConjuntoArrays();
		
		
		return listas.get(cod);
	}
}
