package br.com.casa.notas;

import java.util.List;

import br.com.Conexao.Tratamento;
import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class AppTela5 extends Activity {
	public ListView lista5;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tela5);

		List<String> teste = new Tratamento().tabelaDados();
		String[] contatos = { teste.get(12).toString(),
				teste.get(19).toString(), teste.get(26).toString(),
				teste.get(33).toString(), teste.get(40).toString(),
				teste.get(47).toString() };

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, contatos);
		lista5 = (ListView) findViewById(R.id.lista5);
		lista5.setAdapter(adapter);

		lista5.setOnItemClickListener(new OnItemClickListener() {

			public void onItemClick(AdapterView arg0, View arg1, View arg2,
					long arg3) {
				if (lista5.getSelectedItem() != null) {
					AlertDialog.Builder dialogo = new AlertDialog.Builder(
							AppTela5.this);
					dialogo.setTitle("");
					dialogo.setMessage(lista5.getSelectedItem().toString());
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
