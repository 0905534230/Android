package com.example.contact;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvContacts;
    ArrayList<String> listContacts;
    ArrayAdapter<String> arrayAdapter;
    private MyDatabase db;
    ArrayList<Contact> listObjectContacts;
    private Button mBtnAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new MyDatabase(this);

        lvContacts = (ListView)findViewById(R.id.lv_contact);

        mBtnAdd = (Button)findViewById(R.id.btn_add_contact);

        listContacts = new ArrayList<String>();
        listObjectContacts = new ArrayList<Contact>();

        arrayAdapter = new ArrayAdapter<String>(this , android.R.layout.simple_list_item_1 , listContacts);
        lvContacts.setAdapter(arrayAdapter);
        getData();
        setOnClickOnItem();
        onClickAddBtn();
        arrayAdapter.notifyDataSetChanged();
    }

    public Contact findContact(String name){
        for (Contact contact:listObjectContacts){
            if(name == contact.getFullname())
                return contact;
        }
        return null;
    }

    public void setOnClickOnItem(){
        lvContacts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this , EditContactActivity.class);
                String item = lvContacts.getItemAtPosition(position).toString();
                Contact getContact = findContact(item);
                    Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();
                Bundle bundle = new Bundle();
                bundle.putSerializable("Contact" , getContact);
                intent.putExtra("My package" , bundle);
                startActivity(intent);
            }
        });
    }
    public  void onClickAddBtn(){
        mBtnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this , AddNewContact.class);
                startActivityForResult(intent , 1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1 && resultCode==RESULT_OK){
            Contact contact =(Contact)data.getExtras().getSerializable("Return");
            listObjectContacts.add(contact);
            listContacts.add(contact.getFullname());
//            Log.d("a", "onActivityResult: "+contact.getFullname());
            arrayAdapter.notifyDataSetChanged();
        }
    }
    public void getData(){
        listObjectContacts.clear();
        listObjectContacts = db.getAllContacts();
        for ( int i = 0 ; i < listObjectContacts.size() ; i++ ){
            listContacts.add(listObjectContacts.get(i).getFullname());
        }
        db.close();
        arrayAdapter.notifyDataSetChanged();
    }

}




