package com.erz.formlayout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.erz.library.formlayout.FormField;
import com.erz.library.formlayout.FormLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FormLayout formLayout = (FormLayout) findViewById(R.id.form);
        formLayout.addField(new FormField("Test 1"));
        formLayout.addField(new FormField("Test 2"));
        formLayout.addField(new FormField("Test 2"));
        formLayout.addField(new FormField("Test 2"));
        formLayout.addField(new FormField("Test 2"));
        formLayout.addField(new FormField("Test 2"));
        formLayout.addField(new FormField("Test 2"));
        formLayout.addField(new FormField("Test 2"));
        formLayout.addField(new FormField("Test 2"));
        formLayout.addField(new FormField("Test 2"));
        formLayout.addField(new FormField("Test 2"));
        formLayout.addField(new FormField("Test 2"));
        formLayout.addField(new FormField("Test 2"));
        formLayout.addField(new FormField("Test 2"));
        formLayout.addField(new FormField("Test 2"));
        formLayout.addField(new FormField("Test 2"));
        formLayout.addField(new FormField("Test 2"));
        formLayout.addField(new FormField("Test 2"));
        formLayout.addField(new FormField("Test 2"));
        formLayout.addField(new FormField("Test 3"));
        formLayout.addField(new FormField("Test 4"));
        formLayout.addField(new FormField("Test 5"));
        formLayout.addField(new FormField("Test 5"));
        formLayout.addField(new FormField("Test 5"));
        formLayout.addField(new FormField("Test 5"));
        formLayout.addField(new FormField("Test 5"));
        formLayout.addField(new FormField("Test 5"));
        formLayout.addField(new FormField("Test 5"));
    }
}
