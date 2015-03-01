package com.picon.phecalome;

import com.picon.bdd.Caca;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MySimpleArrayAdapter extends ArrayAdapter<String> {
	private final Context context;
	private final String[] values;

	public MySimpleArrayAdapter(Context context, String[] values) {
		super(context, R.layout.ligne_layout, values);
		this.context = context;
		this.values = values;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View rowView = inflater.inflate(R.layout.ligne_layout, parent, false);


		String[] elements = values[position].split(" - ");
		System.out.println(values[position]);
		TextView titre = (TextView) rowView.findViewById(R.id.titre);
		TextView description = (TextView) rowView.findViewById(R.id.description);
		ImageView image = (ImageView) rowView.findViewById(R.id.image);
		titre.setText(elements[0]);
		switch (Integer.parseInt(elements[1])) {
		case 1 :
			description.setText(elements[1] + " : Crottes de lapin" );
			image.setImageResource(R.drawable.caca_1);
			break;
		case 2 :
			description.setText(elements[1] + " : Caca dur" );
			image.setImageResource(R.drawable.caca_2);
			break;
		case 3 :
			description.setText(elements[1] + " : Pas mal" );
			image.setImageResource(R.drawable.caca_3);
			break;
		case 4 :
			description.setText(elements[1] + " : Bien ouej'" );
			image.setImageResource(R.drawable.caca_4);
			break;
		case 5 :
			description.setText(elements[1] + " : Petit apéro" );
			image.setImageResource(R.drawable.caca_5);
			break;
		case 6 :
			description.setText(elements[1] + " : Bonne cuite" );
			image.setImageResource(R.drawable.caca_6);
			break;
		case 7 :
			description.setText(elements[1] + " : Oula, sacrée chouille !" );
			image.setImageResource(R.drawable.caca_7);
			break;

		}


		//    image.setImageDrawable(R.drawable.caca_1);


		String s = values[position];


		return rowView;
	}
} 
