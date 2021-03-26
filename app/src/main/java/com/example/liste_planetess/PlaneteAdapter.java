package com.example.liste_planetess;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;


class PlaneteAdapter extends BaseAdapter {

    private final MainActivity activity;
    private Data data;
    private ArrayList<String> planetes;
    private String[] taillePlanetes;
    private Button verif;
    int nombre;

    public PlaneteAdapter(MainActivity mainActivity, Data data) {
        this.activity = mainActivity;
        this.data = data;
        this.planetes = data.getPlanetes();
        this.taillePlanetes = data.getPTaillePlanete();


    }

    @Override
    public int getCount() {
        return planetes.size();
    }

    @Override
    public Object getItem(int arg0) {
        return planetes.get(arg0);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = convertView;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            itemView = inflater.inflate(R.layout.listitem, null);
        }
        TextView nomPlanete = (TextView) itemView.findViewById(R.id.textView);
        final CheckBox checkBox = (CheckBox) itemView.findViewById(R.id.checkbox);
        final Spinner spinner = (Spinner) itemView.findViewById(R.id.spinner);
        nomPlanete.setText(planetes.get(position));

        // String[] taillePlanetes = {"4900", "12000", "12800", "6800", "144000", "120000", "52000", "50000", "2300"};

        final ArrayAdapter<String> spinadapter = new ArrayAdapter<String>(activity, android.R.layout.simple_spinner_item, taillePlanetes);
        spinadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinadapter);

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                CheckBox checkBox = (CheckBox)  compoundButton.findViewById(R.id.checkbox);
                if (checkBox.isChecked()) {
                    spinner.setEnabled(false);
                    spinadapter.notifyDataSetChanged();
                    nombre++;
                } else {
                    spinner.setEnabled(true);
                    spinadapter.notifyDataSetChanged();
                    nombre--;
                }
                if(nombre==data.getPlanetes().size())
                {
                    verif = activity.findViewById(R.id.verif);
                    verif.setEnabled(true);


                }

                else
                {
                    verif = activity.findViewById(R.id.verif);
                    verif.setEnabled(false);

                }
            }
        });




        return itemView;

    }
}