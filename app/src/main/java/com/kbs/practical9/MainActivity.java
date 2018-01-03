package com.kbs.practical9;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    TextView tvtitle;
    CheckBox chkbold,chkitalic;
    Spinner spfont;
    ArrayAdapter adapter;
    //ArrayAdapter aadp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvtitle=(TextView)findViewById(R.id.tvfont);
        chkbold=(CheckBox)findViewById(R.id.chkbold);
        chkitalic=(CheckBox)findViewById(R.id.chkitalic);

        spfont = (Spinner)findViewById(R.id.spnfont);
        adapter = ArrayAdapter.createFromResource(this,R.array.font_name,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spfont.setAdapter(adapter);
        spfont.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Typeface font= Typeface.create(adapter.getItem(i).toString(),0);
                tvtitle.setTypeface(font);
                //aadp.getItem(i);
                Toast.makeText(MainActivity.this, "applied", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        chkbold.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if(tvtitle.getTypeface().getStyle()==Typeface.BOLD)
                {
                    tvtitle.setTypeface(tvtitle.getTypeface(),Typeface.NORMAL);
                    Toast.makeText(MainActivity.this, tvtitle.getTypeface().getStyle()+"-r", Toast.LENGTH_SHORT).show();
                }
                else if(tvtitle.getTypeface().getStyle()==Typeface.ITALIC)
                {
                    tvtitle.setTypeface(tvtitle.getTypeface(),Typeface.BOLD_ITALIC);
                    Toast.makeText(MainActivity.this, tvtitle.getTypeface().getStyle()+"-a", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    tvtitle.setTypeface(tvtitle.getTypeface(),Typeface.BOLD);
                    Toast.makeText(MainActivity.this, tvtitle.getTypeface().getStyle()+"-f", Toast.LENGTH_SHORT).show();
                }

            }
        });

        chkitalic.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(tvtitle.getTypeface().getStyle()==Typeface.ITALIC)
                {
                    tvtitle.setTypeface(tvtitle.getTypeface(),Typeface.NORMAL);
                }
                else if(tvtitle.getTypeface().getStyle()==Typeface.BOLD)
                {
                    tvtitle.setTypeface(tvtitle.getTypeface(),Typeface.BOLD_ITALIC);
                }
                else
                {
                    tvtitle.setTypeface(tvtitle.getTypeface(),Typeface.ITALIC);
                }

            }
        });
    }
}
