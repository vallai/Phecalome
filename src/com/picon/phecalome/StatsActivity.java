package com.picon.phecalome;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.picon.bdd.Caca;
import com.picon.bdd.CacaDAO;

public class StatsActivity extends Activity {

	private CacaDAO dao;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_stats);

		// BDD
		this.dao = new CacaDAO(this);
		ArrayList<Caca> cacas = dao.lireCacas();

		String listeCacas = "";
		for (Caca c : cacas) {
			listeCacas += c + "\n";
		}
		
		TextView tv = (TextView)findViewById(R.id.nb_cacas);
		tv.setText("Nombre de cacas : " + cacas.size() + "\n\n" + listeCacas );
	}
}
