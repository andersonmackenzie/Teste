package com.example.testeapp;

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

public class AppTela1 extends Activity {
	public ListView listaI;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tela1);

		List<String> teste = new Tratamento().tabelaDados();

		// List<String> teste = new TesteJsoap().listaDados();
		String[] contatos = { teste.get(8).toString(),
				teste.get(15).toString(), teste.get(22).toString(),
				teste.get(29).toString(), teste.get(36).toString(),
				teste.get(43).toString() };
		teste = null;
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, contatos);
		listaI = (ListView) findViewById(R.id.lista1);
		listaI.setAdapter(adapter);

		listaI.setOnItemClickListener(new OnItemClickListener() {

			public void onItemClick(AdapterView arg0, View arg1, View arg2,
					long arg3) {
				if (listaI.getSelectedItem() != null) {
					AlertDialog.Builder dialogo = new AlertDialog.Builder(
							AppTela1.this);
					dialogo.setTitle("");
					dialogo.setMessage(listaI.getSelectedItem().toString());
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
