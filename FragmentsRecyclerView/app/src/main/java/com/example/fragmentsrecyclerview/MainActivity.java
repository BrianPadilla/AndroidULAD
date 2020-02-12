package com.example.fragmentsrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements PersonAdapter.ItemClicked {

    TextView lblName,lblPhone;
    EditText txtName,txtPhone;
    Button btnAdd;
    ListFrag listFrag;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lblName = findViewById(R.id.lblName);
        lblPhone = findViewById(R.id.lblPhone);
        txtName = findViewById(R.id.txtName);
        txtPhone = findViewById(R.id.txtTel);
        btnAdd = findViewById(R.id.btnAdd);

        fragmentManager = this.getSupportFragmentManager();
        listFrag = (ListFrag) fragmentManager.findFragmentById(R.id.listFrag);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(txtName.getText().toString().isEmpty() || txtPhone.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "Please Fill The Data", Toast.LENGTH_SHORT).show();
                }
               else
                {
                   ApplicationClass.people.add(new Person(txtName.getText().toString().trim(),txtPhone.getText().toString().trim()));
                    Toast.makeText(MainActivity.this, "Person Successfully added", Toast.LENGTH_SHORT).show();
                    txtPhone.setText(null);
                    txtName.setText(null);
                    listFrag.NotifyDataChanged();
                }

            }
        });

        onItemClicked(0);
    }

    @Override
    public void onItemClicked(int index) {
        lblName.setText(ApplicationClass.people.get(index).getName());
        lblPhone.setText(ApplicationClass.people.get(index).getTelNr());
    }
}
