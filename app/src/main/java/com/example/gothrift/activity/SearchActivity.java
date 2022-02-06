package com.example.gothrift.activity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import com.example.gothrift.R;


public class SearchActivity extends AppCompatActivity {

    ListView listView;
    String[] name = {"Dress","Blouse","Jeans","Tunik","Kulot"};

    ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        listView = findViewById(R.id.listView);

        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1,name);
        listView.setAdapter(arrayAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu1,menu);

        MenuItem menuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setQueryHint("Type here to search");

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {


                arrayAdapter.getFilter().filter(newText);
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }
}