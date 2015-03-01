package com.picon.phecalome;

import java.util.ArrayList;
import java.util.List;


import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.ActionBar.Tab;
import com.actionbarsherlock.app.SherlockFragmentActivity;


import com.picon.bdd.Caca;
import com.picon.bdd.CacaDAO;

public class StatsActivity extends SherlockFragmentActivity {

	private CacaDAO dao;
	private ArrayList<Caca> cacas;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_stats);

		// BDD
		this.dao = new CacaDAO(this);
		cacas = dao.lireCacas();
				
		//		TextView tv = (TextView)findViewById(R.id.nb_cacas);
		//		tv.setText("Nombre de cacas : " + cacas.size());
		//		ListView liste = (ListView) findViewById(R.id.liste_cacas);
				 
		//		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mesCacas);
		//	    liste.setAdapter(adapter);

		ActionBar actionBar = getSupportActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		actionBar.setDisplayShowHomeEnabled(false);
		actionBar.setDisplayShowTitleEnabled(false);

		Tab tab = actionBar.newTab()
				.setText("Resumé")
				.setTabListener(new ResumeFragment());

		actionBar.addTab(tab);

		tab = actionBar.newTab()
				.setText("Historique")
				.setTabListener(new HistoriqueFragment());

		actionBar.addTab(tab);

	}
	
	public CacaDAO getDao() {
		return this.dao;
	}
	
	public ArrayList<Caca> getCacas() {
		return this.cacas;
	}
}
