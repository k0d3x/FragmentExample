package codes.ameer.com.fragmentexample;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void changeFragment(View view) {

        Fragment fragment;
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if(view.getId() == R.id.fragment1){
            view.setBackground(ContextCompat.getDrawable(this, R.drawable.fragment_one_clicked));
            View previousView = findViewById(R.id.fragment2);
            previousView.setBackground(ContextCompat.getDrawable(this, R.drawable.transparent_border));
            fragment = new FragmentOne();
            fragmentTransaction.replace(R.id.fragment_container,fragment);
        }
        if(view.getId() == R.id.fragment2){
            view.setBackground(ContextCompat.getDrawable(this, R.drawable.fragment_two_clicked));
            View previousView = findViewById(R.id.fragment1);
            previousView.setBackground(ContextCompat.getDrawable(this, R.drawable.transparent_border));
            fragment = new FragmentTwo();
            fragmentTransaction.replace(R.id.fragment_container,fragment);
        }
        fragmentTransaction.commit();
    }
}
