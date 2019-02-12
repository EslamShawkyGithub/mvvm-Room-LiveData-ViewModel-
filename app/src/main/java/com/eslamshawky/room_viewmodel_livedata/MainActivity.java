package com.eslamshawky.room_viewmodel_livedata;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.eslamshawky.room_viewmodel_livedata.Entites.Item;
import com.eslamshawky.room_viewmodel_livedata.ViewModel.MainActivityViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private RecyclerView recyclerView;
    private FloatingActionButton fab;
    private List<Item> list;
    private MainActivityViewModel mViewModel;

    // TAG for Logging
    private final String TAG = this.getClass().getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e(TAG, "_ActivityInit");

        // init views and adapter
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        fab = (FloatingActionButton) findViewById(R.id.add_btn);
        fab.setOnClickListener(this);
        list = new ArrayList<>();

    }
    @Override
    public void onClick(View v) {
        // go to add activity
        Intent intent = new Intent(this, AddActivity.class);
        startActivity(intent);
    }
}
