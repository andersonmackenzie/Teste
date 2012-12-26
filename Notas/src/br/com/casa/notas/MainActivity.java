package br.com.casa.notas;

import android.os.Bundle;
import android.app.TabActivity;
import android.content.Intent;
import android.widget.TabHost;

public class MainActivity extends TabActivity {
	static TabHost tabHost;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		TabHost tbHost = getTabHost();
		TabHost.TabSpec spec;
		Intent intent;
		intent = new Intent().setClass(this, AppTela1.class);
		spec = tbHost.newTabSpec("tab1").setIndicator("Segunda")
				.setContent(intent);
		tbHost.addTab(spec);

		intent = new Intent().setClass(this, AppTela2.class);
		spec = tbHost.newTabSpec("tab2").setIndicator("Terça")
				.setContent(intent);
		tbHost.addTab(spec);

		intent = new Intent().setClass(this, AppTela3.class);

		spec = tbHost.newTabSpec("tab3").setIndicator("Quarta")
				.setContent(intent);
		tbHost.addTab(spec);

		intent = new Intent().setClass(this, AppTela4.class);
		spec = tbHost.newTabSpec("tab4").setIndicator("Quinta")
				.setContent(intent);
		tbHost.addTab(spec);

		intent = new Intent().setClass(this, AppTela5.class);
		spec = tbHost.newTabSpec("tab5").setIndicator("Sexta")
				.setContent(intent);
		tbHost.addTab(spec);

		intent = new Intent().setClass(this, AppTela6.class);
		spec = tbHost.newTabSpec("tab6").setIndicator("Sabado")
				.setContent(intent);
		tbHost.addTab(spec);
		tbHost.setCurrentTab(0);
	}

}
