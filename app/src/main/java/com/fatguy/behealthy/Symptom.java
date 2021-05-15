package com.fatguy.behealthy;

public class Symptom {

    String ID;
    String ID_Specialist;
    String Name;
    String Tierd;
    String Hurt;
    String body;
    String breath;
    String lostweight;
    String Skin;
    String peargnancy;

    public Symptom() {
    }

    public Symptom(String name, String tierd, String hurt, String body, String breath, String lostweight, String skin, String peargnancy) {
        Name = name;
        Tierd = tierd;
        Hurt = hurt;
        this.body = body;
        this.breath = breath;
        this.lostweight = lostweight;
        Skin = skin;
        this.peargnancy = peargnancy;
    }

    public Symptom(String tierd, String hurt, String body, String breath, String lostweight, String skin, String peargnancy) {
        Tierd = tierd;
        Hurt = hurt;
        this.body = body;
        this.breath = breath;
        this.lostweight = lostweight;
        Skin = skin;
        this.peargnancy = peargnancy;
    }

    public Symptom(String ID, String ID_Specialist, String name, String tierd, String hurt, String body, String breath, String lostweight, String skin, String peargnancy) {
        this.ID = ID;
        this.ID_Specialist = ID_Specialist;
        Name = name;
        Tierd = tierd;
        Hurt = hurt;
        this.body = body;
        this.breath = breath;
        this.lostweight = lostweight;
        Skin = skin;
        this.peargnancy = peargnancy;
    }

    public String getID() {
        return ID;
    }

    public String getID_Specialist() {
        return ID_Specialist;
    }

    public String getName() {
        return Name;
    }

    public String getTierd() {
        return Tierd;
    }

    public String getHurt() {
        return Hurt;
    }

    public String getBody() {
        return body;
    }

    public String getBreath() {
        return breath;
    }

    public String getLostweight() {
        return lostweight;
    }

    public String getSkin() {
        return Skin;
    }

    public String getPeargnancy() {
        return peargnancy;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setID_Specialist(String ID_Specialist) {
        this.ID_Specialist = ID_Specialist;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setTierd(String tierd) {
        Tierd = tierd;
    }

    public void setHurt(String hurt) {
        Hurt = hurt;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setBreath(String breath) {
        this.breath = breath;
    }

    public void setLostweight(String lostweight) {
        this.lostweight = lostweight;
    }

    public void setSkin(String skin) {
        Skin = skin;
    }

    public void setPeargnancy(String peargnancy) {
        this.peargnancy = peargnancy;
    }
}
