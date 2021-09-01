package com.t1908e.listviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView listviewContact;
    private List<Contact> listContacts = new ArrayList<Contact>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        listviewContact = findViewById(R.id.listviewContact);
        ContactAdapter contactAdapter = new ContactAdapter(listContacts, this);
        listviewContact.setAdapter(contactAdapter);
    }

    private void initData() {
        listContacts.add(new Contact("Huy 2", "03333237860", R.drawable.ic_avatar1));
        listContacts.add(new Contact("Huy 1", "03333237860", R.drawable.ic_avatar2));
        listContacts.add(new Contact("Huy 3", "03333237860", R.drawable.ic_avatar3));
        listContacts.add(new Contact("Huy 4", "03333237860", R.drawable.ic_avatar4));
        listContacts.add(new Contact("Huy 5", "03333237860", R.drawable.ic_avatar2));
        listContacts.add(new Contact("Huy 6", "03333237860", R.drawable.ic_avatar1));
    }
}