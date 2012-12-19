package br.com.casa.notas;

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

		// Tab #1
		i = new Intent().setClass(this, TabNotas.class);
		i.putExtra("tab", "0");
		spec = tabHost.newTabSpec("0").setIndicator("Tab 1").setContent(i);
		tabHost.addTab(spec);

		// Tab #2
		i = new Intent().setClass(this, TabNotas.class);
		i.putExtra("tab", "1");
		spec = tabHost.newTabSpec("1").setIndicator("Tab 2").setContent(i);
		tabHost.addTab(spec);
		// Tab #2
		i = new Intent().setClass(this, TabNotas.class);
		i.putExtra("tab", "2");
		spec = tabHost.newTabSpec("2").setIndicator("Tab 3").setContent(i);
		tabHost.addTab(spec);
		// Tab #2
		i = new Intent().setClass(this, TabNotas.class);
		i.putExtra("tab", "3");
		spec = tabHost.newTabSpec("3").setIndicator("Tab 4").setContent(i);
		tabHost.addTab(spec);

		// Tab #2
		i = new Intent().setClass(this, TabNotas.class);
		i.putExtra("tab", "4");
		spec = tabHost.newTabSpec("4").setIndicator("Tab 5").setContent(i);
		tabHost.addTab(spec);
		// Tab #2
		i = new Intent().setClass(this, TabNotas.class);
		i.putExtra("tab", "5");
		spec = tabHost.newTabSpec("5").setIndicator("Tab 6").setContent(i);
		tabHost.addTab(spec);
		// Tab #2
		i = new Intent().setClass(this, TabNotas.class);
		i.putExtra("tab", "6");
		spec = tabHost.newTabSpec("6").setIndicator("Tab 7").setContent(i);
		tabHost.addTab(spec);
		// Tab #2
		i = new Intent().setClass(this, TabNotas.class);
		i.putExtra("tab", "7");
		spec = tabHost.newTabSpec("7").setIndicator("Tab 8").setContent(i);
		tabHost.addTab(spec);

		// Set a tab a ser carrega ao iniciar a tabhost
		tabHost.setCurrentTab(0);
	}
}
