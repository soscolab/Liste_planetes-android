package com.example.liste_planetess;
import com.example.liste_planetess.PlaneteAdapter;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private ArrayList<String> planetes;
    ListView listview;
    PlaneteAdapter adapter;
    private Button verif;
    Data data = new Data();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Data data = new Data();

        listview = (ListView) findViewById(R.id.listView);
        adapter = new PlaneteAdapter(this, data);
        listview.setAdapter(adapter);
        verif = (Button)findViewById(R.id.verif);
        verif.setOnClickListener(VerifListener);

    }


    private View.OnClickListener VerifListener = new View.OnClickListener() {


        public void onClick(View v) {

            int score = 0;
            String[] PlanetesTaille = data.getPTaillePlanete();

            for(int i = 0; i<PlanetesTaille.length; i++) {


                v = listview.getChildAt(i);
                Spinner sp = v.findViewById(R.id.spinner);
                TextView textView = v.findViewById(R.id.textView);

                if(sp.getSelectedItem().toString().equals(PlanetesTaille[i])){
                    score++;
                    Toast.makeText(MainActivity.this, "Score: "+score, Toast.LENGTH_SHORT).show();
                }
            }


        }

        ;


    };

}
