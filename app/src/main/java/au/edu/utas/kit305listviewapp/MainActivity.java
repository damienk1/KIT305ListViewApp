package au.edu.utas.kit305listviewapp;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    /*    ArrayList<String> items = new ArrayList<String>();
        items.add("Rick");
        items.add("Morty");
        items.add("Summer");
        items.add("Beth");
        items.add("Not Jerry");*/

        final String[] list_items = getResources().getStringArray(R.array.list_items); //create an array of strings from the strings xml item list-items
        ArrayList<String> items = new ArrayList<>(Arrays.asList(list_items)); //convert the array of strings into an ArrayList

        ArrayAdapter<String> myListAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, items);
        ListView myList = findViewById(R.id.myList);
        myList.setAdapter(myListAdapter);

        myList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                builder.setMessage(list_items[position]).setTitle("Item Tapped!");
                builder.setNegativeButton("cool", null);

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
    }
}
