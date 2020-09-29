package com.focaink.simbirsofttest;

import android.content.Context;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

public class Note {
    String id;
    String dateStart;
    String dateFinish;
    String name;
    String description;

    Note(String id, String dateStart, String dateFinish, String name, String description) {
        this.id = id;
        this.dateStart = dateStart;
        this.dateFinish = dateFinish;
        this.name = name;
        this.description = description;
    }


}