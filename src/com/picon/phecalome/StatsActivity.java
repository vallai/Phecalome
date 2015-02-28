package com.picon.phecalome;

import android.app.Activity;
import android.os.Bundle;

import com.picon.bdd.CacaDAO;

public class StatsActivity extends Activity {
	
	private CacaDAO dao;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_stats);

		// BDD
		this.dao = new CacaDAO(this);
		dao.lire();
		 //TextView tv = (TextView)findViewById(R.id.nb_cacas);
		 //tv.setText("Nombre de cacas : " + nb_cacas);
	}
}
