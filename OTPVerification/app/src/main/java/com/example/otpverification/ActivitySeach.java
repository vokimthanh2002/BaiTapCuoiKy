package com.example.otpverification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.widget.SearchView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class ActivitySeach extends AppCompatActivity {

    RecyclerView rc ;
    MainAdapter mainAdapter;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seach);

        rc =(RecyclerView) findViewById(R.id.rv);
        searchView = (SearchView) findViewById(R.id.seachView);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                txtSeach(s);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                txtSeach(s);
                return false;
            }
        });

        rc.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<MovieModel> options =
                new FirebaseRecyclerOptions.Builder<MovieModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("movies"), MovieModel.class)
                        .build();

        mainAdapter = new MainAdapter(options);
        rc.setAdapter(mainAdapter);
    }
    private void txtSeach(String str){
        FirebaseRecyclerOptions<MovieModel> options =
                new FirebaseRecyclerOptions.Builder<MovieModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("movies").orderByChild("namemovie").startAt(str).endAt(str+"~"), MovieModel.class)
                        .build();

        mainAdapter= new MainAdapter(options);
        mainAdapter.startListening();
        rc.setAdapter(mainAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mainAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mainAdapter.stopListening();
    }
}