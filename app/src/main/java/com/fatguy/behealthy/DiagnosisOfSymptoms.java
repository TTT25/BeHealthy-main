package com.fatguy.behealthy;

import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class DiagnosisOfSymptoms {

    private static final String TAG = "ReadAndWriteSnippets";
    ArrayList<Symptom> list=new ArrayList<Symptom>();

    public ArrayList<Symptom> getList() {
        return list;
    }
    public ArrayList<Symptom> add(DatabaseReference mPostReference) {
        ValueEventListener postListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // Get Post object and use the values to update the UI
                Symptom post = dataSnapshot.getValue(Symptom.class);
                list.add(post);


            }
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
                Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
            }
        };
        return list;
    }

    public void add(DataSnapshot dataSnapshot,ArrayList<Symptom> list){

        list.clear();

        for(DataSnapshot ds :dataSnapshot.getChildren()){
            Symptom d= new Symptom();
            d.setID(ds.getValue(Symptom.class).getID());
            d.setID_Specialist(ds.getValue(Symptom.class).getID_Specialist());
            d.setTierd(ds.getValue(Symptom.class).getTierd());
            d.setHurt(ds.getValue(Symptom.class).getHurt());
            d.setBody(ds.getValue(Symptom.class).getBody());
            d.setBreath(ds.getValue(Symptom.class).getBreath());
            d.setLostweight(ds.getValue(Symptom.class).getLostweight());
            d.setSkin(ds.getValue(Symptom.class).getSkin());
            d.setPeargnancy(ds.getValue(Symptom.class).getPeargnancy());
            list.add(d);
        }

    }

    public  String Seach(ArrayList<Symptom> S,
            String Tierd,
            String Hurt,
            String body,
            String breath,
            String lostweight,
            String Skin,
            String peargnancy)
    {
        String chuoi="" ;
        for (int i= 0 ; i<S.size();i++)
        {
            if (S.get(i).getTierd()==Tierd && S.get(i).getHurt()==Hurt && S.get(i).getBody()==body && S.get(i).getBreath()==breath &&
                    S.get(i).getLostweight()==lostweight && S.get(i).getSkin()==Skin && S.get(i).getPeargnancy()==peargnancy)
            {
                chuoi = chuoi + " " + S.get(i).getID();
            }
        }
        return  chuoi;
    }







 }
