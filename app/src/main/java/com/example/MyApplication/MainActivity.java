package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private FirebaseDatabase mfirFirebaseDatabase;
    private DatabaseReference mdaDatabaseReference;
    EditText txtName;
    EditText txtDescription;
    EditText txtPlace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FirebaseUtil.openFbReference("Traveldeals");
        mfirFirebaseDatabase = FirebaseUtil.mFirebaseDatabase;
        mdaDatabaseReference = FirebaseUtil.mDatabaseReference;
        txtName = (EditText)findViewById(R.id.editText2);
        txtDescription = (EditText)findViewById(R.id.editText3);
        txtPlace = (EditText)findViewById(R.id.editText4);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.save_menu:
                saveDeal();
                Toast.makeText(this, "Deal Saved", Toast.LENGTH_SHORT).show();
                clean();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    private void clean() {

        txtName.setText("");
        txtDescription.setText("");
        txtPlace.setText("");
        txtName.requestFocus();
    }

    private void saveDeal() {
        String txtitle = txtName.getText().toString();
        String txtdescription = txtDescription.getText().toString();
        String txtplace = txtPlace.getText().toString();
        TravelDeal travelDeal = new TravelDeal(txtitle,txtdescription,txtplace);
        mdaDatabaseReference.push().setValue(travelDeal);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.save_file,menu);
        return true;

    }
}
