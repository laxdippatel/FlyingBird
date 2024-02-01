package com.example.flybird;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        Intent mIntent = getIntent();
        int intValue = mIntent.getIntExtra("EXTRA_MESSAGE", 0);
        /* AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("Game Over");
        builder.setMessage("Score:" + intValue);
        builder.show();*/
        TextView tv = findViewById(R.id.myImageViewText);
        tv.setText(Integer.toString(intValue));

        ImageButton imageButton=(ImageButton) findViewById(R.id.retbtn);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SecondActivity.this,MainActivity.class);
                startActivity(intent);

            }
        });

    }

    public void onBackPressed(){

        finish();
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);

    }
}
