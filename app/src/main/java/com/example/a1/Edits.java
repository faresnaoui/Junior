package com.example.a1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.PrecomputedText;
import android.util.Log;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.EditText;

import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.firestore.local.LruGarbageCollector;
import com.naoui.rh.R;


import android.content.Intent;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Edits extends AppCompatActivity {
    EditText phone,Email;
    ImageButton mofi,sup;
    String mail,tel,id,base,activity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edits);
        mofi = findViewById(R.id.editb);
        sup = findViewById(R.id.dellb);
        phone = findViewById(R.id.mod_phone);
        Email = findViewById(R.id.mod_mail);

        tel=getIntent().getStringExtra("Phone");
        mail=getIntent().getStringExtra("Email");
        id=getIntent().getStringExtra("id");
        base=getIntent().getStringExtra("base");
        activity=getIntent().getStringExtra("act");

        Email.setText(mail);
        phone.setText(tel);




        mofi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myintent ;
                DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child(base);
                reference.child(id).child("mail").setValue(Email.getText().toString());
                reference.child(id).child("telephone").setValue(phone.getText().toString());
                if (activity=="soft")
                { myintent =new Intent(Edits.this, soft.class); }
                else
                    myintent = new Intent(Edits.this, hard.class);
                startActivity(myintent);



            }
        });


        sup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
                reference.child(base).child(id).removeValue();
                if (activity=="soft"){
                 Intent myintent =new Intent(Edits.this, soft.class);
                startActivity(myintent);}
                else{
                    Intent myintent = new Intent(Edits.this, hard.class);
                startActivity(myintent);}

            }
        });


    }


}
