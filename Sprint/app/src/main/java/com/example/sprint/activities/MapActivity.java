package com.example.sprint.activities;

import android.os.Bundle;
import android.preference.PreferenceManager;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sprint.R;

import org.osmdroid.config.Configuration;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapController;
import org.osmdroid.views.MapView;

public class MapActivity extends AppCompatActivity {

    private MapView map_view;
    private MapController map_controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        map_view = (MapView) findViewById(R.id.map_view);

        Configuration.getInstance().load(this, PreferenceManager.getDefaultSharedPreferences(this));

        map_controller = (MapController) map_view.getController();

        GeoPoint Colombia = new GeoPoint(4.743766, -74.088907);

        map_controller.setCenter(Colombia);
        map_controller.setZoom(10);
        map_view.setMultiTouchControls(true);

    }
}