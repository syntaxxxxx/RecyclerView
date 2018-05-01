package fiqri.com.recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import fiqri.com.recyclerview.adapter.CardViewPresidentAdapter;
import fiqri.com.recyclerview.adapter.GridPresidentAdapter;
import fiqri.com.recyclerview.adapter.ListPresidentAdapter;
import fiqri.com.recyclerview.model.President;
import fiqri.com.recyclerview.model.PresidentData;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rv;
    private ArrayList<President> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv = findViewById(R.id.rv);
        rv.setHasFixedSize(true);

        list = new ArrayList<>();
        list.addAll(PresidentData.getListAll());

        setActionBarTitle("Mode List");

        showRecyclerList();

    }


    private void showSelectedPresident(President president) {
        Toast.makeText(this, "Kamu Memilih Dia " + president.getName(),
                Toast.LENGTH_SHORT).show();
    }


    private void setActionBarTitle(String title) {
        getSupportActionBar().setTitle(title);
    }


    private void showRecyclerCard() {

        rv.setLayoutManager(new LinearLayoutManager(this));
        CardViewPresidentAdapter adapter = new CardViewPresidentAdapter(this);
        adapter.setListPresident(list);
        rv.setAdapter(adapter);

    }


    private void showRecyclerList() {

        rv.setLayoutManager(new LinearLayoutManager(this));
        ListPresidentAdapter adapter = new ListPresidentAdapter(this);
        adapter.setListPresident(list);
        rv.setAdapter(adapter);

        ItemClickSupport.addTo(rv).setOnItemLongClickListener(
                new ItemClickSupport.OnItemLongClickListener() {

                    @Override
                    public boolean onItemLongClicked(RecyclerView recyclerView, int position, View v) {

                        showSelectedPresident(list.get(position));
                        return true;
                    }
                });
    }


    private void showRecyclerGrid() {

        rv.setLayoutManager(new GridLayoutManager(this, 2));
        GridPresidentAdapter adapter = new GridPresidentAdapter(this);
        adapter.setListPresident(list);
        rv.setAdapter(adapter);

        ItemClickSupport.addTo(rv).setOnItemClickListener(
                new ItemClickSupport.OnItemClickListener() {
                    @Override
                    public void onItemClicked(RecyclerView recyclerView, int position, View v) {

                        showSelectedPresident(list.get(position));
                    }
                }
        );
    }


    @Override
    public boolean onCreateOptionsMenu(Menu m) {
        getMenuInflater().inflate(R.menu.nav_category, m);
        return super.onCreateOptionsMenu(m);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        String title = null;

        switch (item.getItemId()) {

            case R.id.list:
                title = "Mode List";
                showRecyclerList();
                break;

            case R.id.grid:
                title = "Mode Grid";
                showRecyclerGrid();
                break;

            case R.id.cv:
                title = "Mode Card View";
                showRecyclerCard();
                break;

        }

        setActionBarTitle(title);
        return super.onOptionsItemSelected(item);

    }
}
