package br.com.casa.notas;

import java.util.List;

import br.com.Conexao.Tratamento;
import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class AppTela6 extends Activity {
	public ListView lista;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tela6);

		ArrayAdapter<String> adapter;
		List<String> teste = new Tratamento().tabelaDados();

		if (teste.size() > 5) {

			String[] contatos = { teste.get(13).toString(),
					teste.get(20).toString(), teste.get(27).toString(),
					teste.get(34).toString(), teste.get(41).toString(),
					teste.get(48).toString() };

			adapter = new ArrayAdapter<String>(this,
					android.R.layout.simple_list_item_1, contatos);

		} else {

			String[] contatos = { "Não existem dados" };
			adapter = new ArrayAdapter<String>(this,
					android.R.layout.simple_list_item_1, contatos);
		}

		lista = (ListView) findViewById(R.id.lista6);
		lista.setAdapter(adapter);

		lista.setOnItemClickListener(new OnItemClickListener() {

			public void onItemClick(AdapterView arg0, View arg1, View arg2,
					long arg3) {
				if (lista.getSelectedItem() != null) {
					AlertDialog.Builder dialogo = new AlertDialog.Builder(
							AppTela6.this);
					dialogo.setTitle("");
					dialogo.setMessage(lista.getSelectedItem().toString());
					dialogo.setNeutralButton("OK", null);
					dialogo.show();
				}

			}

			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {

			}

		});

	}
}
