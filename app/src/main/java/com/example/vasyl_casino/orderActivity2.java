package com.example.vasyl_casino;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class orderActivity2 extends AppCompatActivity {

    String[] addresses = {"enteryourtext@gmail.com"};
    String subject = "Order from Gun Shop";
    String emailText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order2);

        getSupportActionBar().hide();

        Intent ReceivedOrderIntent = getIntent();

        String UserName = ReceivedOrderIntent.getStringExtra("userNameForIntent");
        String goodsName = ReceivedOrderIntent.getStringExtra("goodsName");
        int num = ReceivedOrderIntent.getIntExtra("quantity", 0);
        double orderPrice = ReceivedOrderIntent.getDoubleExtra("orderPrice", 0);
        TextView orderTextview = findViewById(R.id.orderTextview);
        orderTextview.setText(UserName + "\n" + goodsName + "\n" + num + "\n" + orderPrice);

        emailText = "Customer neme : " + UserName + "\n" + "Goods name : "
                + goodsName + "\n" + "Quantity : " + num + "\n" +
                "Price : " + orderPrice + "\n";
        TextView orderTextView = findViewById(R.id.orderTextview);
        orderTextview.setText(emailText);
    }
    public void send_order(View view) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("*/*");
        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, emailText);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
    }
