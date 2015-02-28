package com.picon.phecalome;


import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.ActionBar.Tab;
import com.actionbarsherlock.app.SherlockListFragment;
import com.picon.bdd.Caca;

public class HistoriqueFragment extends SherlockListFragment  implements ActionBar.TabListener{

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
		// BDD
		ArrayList<Caca> cacas = ((StatsActivity) getActivity()).getCacas();

		List<String> mesCacas = new ArrayList<String>();
		for (Caca c : cacas) {
			mesCacas.add(c.toString());
		}

		/** Creating array adapter to set data in listview */
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity().getBaseContext(), android.R.layout.simple_list_item_1, mesCacas);

		/** Setting the array adapter to the listview */
		setListAdapter(adapter);


		//		
		//		TextView tv = (TextView)findViewById(R.id.nb_cacas);
		//		tv.setText("Nombre de cacas : " + cacas.size());
		//		ListView liste = (ListView) findViewById(R.id.liste_cacas);
		//		 
		//		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mesCacas);
		//	    liste.setAdapter(adapter);

		return super.onCreateView(inflater, container, savedInstanceState);

	}

	@Override
	public void onStart() {
		super.onStart();

		/** Setting the multiselect choice mode for the listview */
		//getListView().setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		ft.add(android.R.id.content, this,"historique");

		ft.attach(this);
	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		ft.detach(this);
	}

	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
	}
}