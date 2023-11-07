package com.example.contentprovidertest;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<FunkoPopData> data;
    Button insertButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        insertButton = findViewById(R.id.insertButton);
        data = new ArrayList<>();
        ListView listView = findViewById(R.id.listView);
        registerForContextMenu(listView);
        MyTableAdapter adapter = new MyTableAdapter(this, data);
        listView.setAdapter(adapter);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.data_entry, null);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Handle the item click here
                // 'position' is the position of the clicked item in the list
                // 'id' can be used if your adapter has stable IDs
                // 'view' is the clicked view, you can access its children if needed
                // 'parent' is the parent AdapterView (in this case, the ListView)
            }
        });
        insertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });


        builder.setView(dialogView)
                .setTitle("Data Entry")
                .setPositiveButton("Save", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Handle the data entry and save the input values
                        EditText IdEdit = dialogView.findViewById(R.id.ID);
                        int idInput = Integer.parseInt(IdEdit.getText().toString());

                        EditText nameEdit = dialogView.findViewById(R.id.name);
                        String popName = nameEdit.getText().toString();

                        EditText numberEdit = dialogView.findViewById(R.id.number);
                        int popNumber = Integer.parseInt(numberEdit.getText().toString());

                        EditText typeEdit = dialogView.findViewById(R.id.type);
                        String popType = typeEdit.getText().toString();

                        EditText fandomEdit = dialogView.findViewById(R.id.fandom);
                        String popFandom = fandomEdit.getText().toString();

                        CheckBox onEdit = dialogView.findViewById(R.id.on);
                        boolean popOn = onEdit.isChecked();

                        EditText ultimateEdit = dialogView.findViewById(R.id.ultimate);
                        String popUltimate = ultimateEdit.getText().toString();

                        EditText priceEdit = dialogView.findViewById(R.id.price);
                        double popPrice = Double.parseDouble(priceEdit.getText().toString());

                        FunkoPopData newFunko = new FunkoPopData(idInput, popName, popNumber, popType, popFandom, popOn, popUltimate, popPrice);
                        data.add(newFunko);
                        adapter.notifyDataSetChanged();
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel(); // Dismiss the dialog without saving
                    }
                });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);
    }
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int position = info.position;

        if (item.getItemId() == R.id.action_edit) {
            return true;
        } else if (item.getItemId() == R.id.action_delete) {
            if(data.get(position) != null) {
                data.remove(position);
            }
            return true;
        } else {
            return super.onContextItemSelected(item);
        }
    }
}

