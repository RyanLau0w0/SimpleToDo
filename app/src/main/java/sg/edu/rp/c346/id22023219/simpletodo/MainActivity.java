package sg.edu.rp.c346.id22023219.simpletodo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Spinner spnChange;
    EditText etChange;
    EditText etIndex;
    Button btnAdd;
    Button btnDelete;
    Button btnClear;
    ListView lvToDo;

    ArrayList<String> alToDo = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spnChange = findViewById(R.id.spinner);
        etChange= findViewById(R.id.editTextChange);
        etIndex = findViewById(R.id.editTextNumberIndex);
        btnAdd = findViewById(R.id.buttonAdd);
        btnDelete = findViewById(R.id.buttonDelete);
        btnClear = findViewById(R.id.buttonClear);
        lvToDo = findViewById(R.id.listViewToDo);

        ArrayAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, alToDo);
        lvToDo.setAdapter(adapter);

        spnChange.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {
                switch (i){
                    case 0:
                        btnAdd.setVisibility(View.VISIBLE);
                        btnDelete.setVisibility(View.GONE);
                        etIndex.setVisibility(View.VISIBLE);
                        break;
                    case 1:
                        btnAdd.setVisibility(View.GONE);
                        btnDelete.setVisibility(View.VISIBLE);
                        etIndex.setVisibility(View.GONE);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String change = etChange.getText().toString();
                Integer index = Integer.parseInt(etIndex.getText().toString());
                alToDo.add(index , change);
                adapter.notifyDataSetChanged();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String change = etChange.getText().toString();
                alToDo.remove(change);
                adapter.notifyDataSetChanged();
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alToDo.clear();
                adapter.notifyDataSetChanged();
            }
        });


    }
}