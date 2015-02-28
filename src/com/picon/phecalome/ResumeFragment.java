package com.picon.phecalome;


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.ActionBar.Tab;
import com.actionbarsherlock.app.SherlockListFragment;
import com.picon.bdd.Caca;
 
public class ResumeFragment extends SherlockListFragment implements ActionBar.TabListener{
 

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        
    	// BDD
    			ArrayList<Caca> cacas = ((StatsActivity) getActivity()).getCacas();

    			List<String> resume = new ArrayList<String>();
    			resume.add("Nombre de cacas réalisés : " + cacas.size());
    			resume.add("Nombre de cacas par jour : " +  String.format("%.2f",this.getNbCacasJour(cacas)));
    			resume.add("Dureté moyenne : " + String.format("%.2f", this.getMoyennePuissance(cacas)));
    			
    			
    			/** Creating array adapter to set data in listview */
    			ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity().getBaseContext(), android.R.layout.simple_list_item_1, resume);

    			/** Setting the array adapter to the listview */
    			setListAdapter(adapter);
        return super.onCreateView(inflater, container, savedInstanceState);
 
    }
    
    public float getMoyennePuissance(ArrayList<Caca> cacas) {
    	// Verification de la liste
    	if (cacas.isEmpty()) {
    		return 0;
    	}
    	
    	int somme = 0;
    	for (Caca c:cacas) {
    		somme += c.getPuissance();
    	}
    	float res = somme/ (float)cacas.size();
    	return res;
    }
    
    public float getNbCacasJour(ArrayList<Caca> cacas) {
    	// Verification de la liste
    	if (cacas.isEmpty()) {
    		return 0;
    	}
    	// Calcul de la différence
    	Timestamp premierCaca = new Timestamp(cacas.get(0).getDate());
    	Timestamp now = new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());

    	float diff = (now.getTime() - premierCaca.getTime()) / (1000*60*60*24);
    	return cacas.size()/(float)(diff+1);
    }
 
    @Override
    public void onStart() {
        super.onStart();
    }
 
    @Override
    public void onTabSelected(Tab tab, FragmentTransaction ft) {
        ft.add(android.R.id.content, this,"resume");
        ft.attach(this);
    }
 
    @Override
    public void onTabUnselected(Tab tab, FragmentTransaction ft) {
         ft.detach(this);
    }
 
    @Override
    public void onTabReselected(Tab tab, FragmentTransaction ft) {
    	 ft.add(android.R.id.content, this,"resume");
         ft.attach(this);
    }
}