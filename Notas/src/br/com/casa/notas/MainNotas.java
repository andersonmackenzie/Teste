package br.com.casa.notas;

import br.com.Conexao.TratamentoNotas;
import android.app.ActivityGroup;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TabHost;

public class MainNotas extends ActivityGroup {
	static TabHost tabHost;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_notas);

		Resources res = getResources();
		tabHost = (TabHost) findViewById(R.id.tabHost);
		tabHost.setup(this.getLocalActivityManager());

		TabHost.TabSpec spec;

		Intent i;

		// Valor da Quantidade

		int quantidade = TratamentoNotas.getInstance().getQuantNotas();

		for (int j = 0; j < quantidade; j++) {
			// Criacao de Tabs

			i = new Intent().setClass(this, TabNotas.class);
			i.putExtra("tab", j);
			spec = tabHost.newTabSpec(String.valueOf(j))
					.setIndicator("Materia").setContent(i);
			tabHost.addTab(spec);

		}

		tabHost.setCurrentTab(0);
	}
}
