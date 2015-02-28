package com.picon.phecalome;


import java.util.ArrayList;
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

    			/** Creating array adapter to set data in listview */
    			ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity().getBaseContext(), android.R.layout.simple_list_item_1, resume);

    			/** Setting the array adapter to the listview */
    			setListAdapter(adapter);
        return super.onCreateView(inflater, container, savedInstanceState);
 
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
    }
}