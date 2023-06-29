package com.example.vasyl_casino;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    int num = 0;
    Spinner spinner;
    ArrayList spinnerArraylist;
    ArrayAdapter spinnerAdapter;
    String goodsName;
    double price;
    EditText UsernameEdittext;


HashMap firstHash;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UsernameEdittext = findViewById(R.id.editTextTextPersonName4);

        spinner = findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);
        spinnerArraylist = new ArrayList<>();

        getSupportActionBar().hide();

        spinnerArraylist.add("Glock 19");
        spinnerArraylist.add("Glock 17");
        spinnerArraylist.add("Glock 27");
        spinnerArraylist.add("Glock 35");
        spinnerArraylist.add("Glock 41");

        spinnerAdapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,spinnerArraylist);
spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
spinner.setAdapter(spinnerAdapter);

firstHash = new HashMap<>();
        firstHash.put("Glock 19",500.0);
        firstHash.put("Glock 17",599.0);
        firstHash.put("Glock 27",640.0);
        firstHash.put("Glock 35",700.0);
        firstHash.put("Glock 41",550.0);
    }

    public void sayNum(View view) {

        TextView textView = findViewById(R.id.textView4);
        num = num+1;
        textView.setText(""+num);
        TextView priceTextview = findViewById(R.id.textView7);
        priceTextview.setText(""+num*price);
    }
    public void sayNum2(View view) {


        TextView textView = findViewById(R.id.textView4);
        num = num-1;
        textView.setText(""+num);
        if(num <0){
num = 0;
            textView.setText("0");


        }

        TextView priceTextview = findViewById(R.id.textView7);
        priceTextview.setText(""+num*price);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
goodsName = spinner.getSelectedItem().toString();
price = (double) firstHash.get(goodsName);
TextView priceTextview = findViewById(R.id.textView7);
priceTextview.setText(""+num*price);



 ImageView goodsImage = findViewById(R.id.imageView2);

 switch (goodsName){
     case"Glock 19":
       goodsImage.setImageResource(R.drawable.glock19);
       break;
     case"Glock 17":
         goodsImage.setImageResource(R.drawable.glock17);
         break;
     case"Glock 27":
         goodsImage.setImageResource(R.drawable.glock27);
         break;
     case"Glock 35":
         goodsImage.setImageResource(R.drawable.glock35);
         break;
     case"Glock 41":
         goodsImage.setImageResource(R.drawable.glock41);
         break;
 }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void AddtoCard(View view) {

        order order = new order();
order.userName = UsernameEdittext.getText().toString();

order.goodName = goodsName;

order.num= num;

order.orderPrice = num*price;

        Intent orderIntent = new Intent(MainActivity.this,orderActivity2.class);

        orderIntent.putExtra("userNameForIntent", order.userName);
orderIntent.putExtra("goodsName",order.goodName);
        orderIntent.putExtra("quantity",order.num);
        orderIntent.putExtra("orderPrice",order.orderPrice);
startActivity(orderIntent);

    }
}