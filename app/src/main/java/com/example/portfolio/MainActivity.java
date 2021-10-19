package com.example.portfolio;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RatingBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RatingBar ratingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){

            case R.id.item1:
                String mail = "mailto:njirainifrancis802@gmail.com";
                Intent contact = new Intent().setAction(Intent.ACTION_SENDTO);
                contact.setData(Uri.parse(mail));
                if (contact.resolveActivity(getPackageManager())!=null){
                    startActivity(contact);
                    finish();
                }else
                {
                    Toast.makeText(getApplicationContext(),"No suitable application\n"+"to Launch Activity",Toast.LENGTH_LONG).show();
                }
                break;

            case R.id.item2:
                ratingBar = findViewById(R.id.rating);
                ratingBar.setVisibility(View.VISIBLE);
                ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
                    @Override
                    public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                        Toast.makeText(getApplicationContext(),rating+"",Toast.LENGTH_LONG).show();
                    }
                });
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}