package br.com.casa.notas;

import br.com.Conexao.TratamentoNotas;
import android.app.ActivityGroup;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TabHost;

public class MainNotas extends ActivityGroup {
	static TabHost tabHost;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_notas);

		Resources res = getResources();
		tabHost = (TabHost) findViewById(R.id.tabHost);
		tabHost.setup(this.getLocalActivityManager());

		TabHost.TabSpec spec;

		Intent intent;

		// Quantidade de abas e materias

		int quantidade = TratamentoNotas.getInstance().getQuantNotas();

		for (int i = 0; i < quantidade; i++) {

			// Criacao de Tabs

			intent = new Intent().setClass(this, TabNotas.class);
			intent.putExtra("tab", i);
			spec = tabHost.newTabSpec(String.valueOf(i))
					.setIndicator("Materia").setContent(intent);
			tabHost.addTab(spec);
		}
		tabHost.setCurrentTab(0);
	}
}
