package com.example.a1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.naoui.rh.R;

import java.util.ArrayList;
import java.util.HashMap;

public class soft extends AppCompatActivity {

    ImageButton add;
    EditText nom, prnom, mail, num;
    ListView listView;
    public TextView phone,email;

    private FirebaseDatabase mDatabase;


    ArrayList arrayList;
    int i=0;

    public interface MyCallback {
        void onCallback(formateur value);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft);
Bundle extras = getIntent().getExtras();
        add = findViewById(R.id.Adds);
        nom = findViewById(R.id.Namels);
        prnom = findViewById(R.id.Nicknamels);
        mail = findViewById(R.id.Emails);
        num = findViewById(R.id.Phones);





        final ArrayList<formateur> list=new ArrayList<formateur>();
        final soft.MyCustomAdapter myadpter= new soft.MyCustomAdapter(list);
        ListView ls=(ListView)findViewById(R.id.listViews);
        ls.setAdapter(myadpter);




        DatabaseReference reference= FirebaseDatabase.getInstance().getReference().child("les formateurs soft");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list.clear();
                for (DataSnapshot datasnapshot:snapshot.getChildren()){
                    formateur value = datasnapshot.getValue(formateur.class);
                    value.setId(datasnapshot.getKey());
                    list.add(value);

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        ls.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String ids;
                TextView textView=view.findViewById(R.id.txt_email);
                TextView textView1=view.findViewById(R.id.txt_phone);


                Intent I=new Intent(soft.this,Edits.class);

                for (int j=0;j<list.size();j++){
                    if (list.get(j).getTelephone()==textView1.getText().toString()){
                        ids=list.get(j).getId();
                        Log.i("cc", "Le dernier nom est " + ids);
                        I.putExtra("id", ids);
                        break;
                    }

                }

                I.putExtra("Email",textView.getText().toString());
                I.putExtra("Phone",textView1.getText().toString());
                I.putExtra("base","les formateurs soft");
                I.putExtra("act","soft");
                startActivity(I);


            }
        });
        add.setOnClickListener(view -> {

            String n = nom.getText().toString();
            String p = prnom.getText().toString();
            String e = mail.getText().toString();
            String ph = num.getText().toString();

            if (n.equals("") || p.equals("") || e.equals("") || ph.equals("")) {
                Toast.makeText(getApplicationContext(), "Fields are Empty", Toast.LENGTH_SHORT).show();
            }
            else {

                formateur f = new formateur(e, n, p, ph);
                add(f);
            }

                }

        );





    }

    public void add(formateur f){
        HashMap<String , Object> map =new HashMap<>();
        map.put("nom",f.getNom());
        map.put("prenom",f.getPrenom());
        map.put("mail",f.getMail());
        map.put("telephone",f.getTelephone());
        String str="formateur"+ i;
        i++;
        FirebaseDatabase mDatabase = FirebaseDatabase.getInstance ();
        mDatabase.getReference("les formateurs soft").push().setValue(map);
        Toast.makeText(getApplicationContext(),"Registrated Successefully",Toast.LENGTH_SHORT).show();

    }

    class MyCustomAdapter extends BaseAdapter
    {
        ArrayList<formateur> Items=new ArrayList<formateur>();
        MyCustomAdapter(ArrayList<formateur> Items ) {
            this.Items=Items;

        }


        @Override
        public int getCount() {
            return Items.size();
        }

        @Override
        public String getItem(int position) {
            return Items.get(position).getMail();

        }

        @Override
        public long getItemId(int position) {
            return  position;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            LayoutInflater linflater =getLayoutInflater();
            View view1=linflater.inflate(R.layout.row_view, null);

            TextView txtph =(TextView) view1.findViewById(R.id.txt_phone);
            TextView txtem =(TextView) view1.findViewById(R.id.txt_email);
            TextView txtpre =(TextView) view1.findViewById(R.id.txt_prenom);
            TextView txtno =(TextView) view1.findViewById(R.id.txt_nom);
            txtph.setText(Items.get(i).telephone);
            txtem.setText(Items.get(i).mail);
            txtpre.setText(Items.get(i).prenom);
            txtno.setText(Items.get(i).nom);


            return view1;

        }



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // R.menu.mymenu is a reference to an xml file named mymenu.xml which should be inside your res/menu directory.
        // If you don't have res/menu, just create a directory named "menu" inside res
        getMenuInflater().inflate(R.menu.actionbar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    // handle button activities
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.myhard) {
            Intent intent=new Intent(soft.this,hard.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}