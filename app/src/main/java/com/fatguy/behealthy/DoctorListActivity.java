package com.fatguy.behealthy;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

import com.github.mikephil.charting.renderer.DataRenderer;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.ArrayList;

public class DoctorListActivity extends Activity {

    FirebaseDatabase root;
    DataRenderer mData;
    DiagnosisOfSymptoms DOS = new DiagnosisOfSymptoms() ;


   ArrayList<Symptom> list=new ArrayList<Symptom>();
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        Query root=FirebaseDatabase.getInstance().getReference().child("Symptom");


        Button Analyze = findViewById(R.id.topnav_btnAnalyze);
        Analyze.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list = DOS.add(root.getRef());

            }
        });














    }
}
