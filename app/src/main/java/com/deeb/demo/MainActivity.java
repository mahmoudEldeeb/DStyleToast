package com.deeb.demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.widget.Toast;

import com.deeb.demo.databinding.ActivityMainBinding;
import com.deeb.dstyletoast.DStyleToast;

public class MainActivity extends AppCompatActivity implements ClickListener {
    ActivityMainBinding mainBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding=DataBindingUtil.setContentView(this,R.layout.activity_main);
        mainBinding.setClickListener(this);


    }

    @Override
    public void warrningToast() {
        DStyleToast.warningToast(this,"warning", Toast.LENGTH_SHORT);

    }

    @Override
    public void successToast() {

       //////////
        DStyleToast.sucessToast(this,"success", Toast.LENGTH_SHORT);

    }


    @Override
    public void errorToast() {
        DStyleToast.errorToast(this,"error", Toast.LENGTH_SHORT);
    }

    @Override
    public void infoToast() {
        DStyleToast.infoToast(this,"some information", Toast.LENGTH_SHORT);
    }

    @Override
    public void customToast() {
        DStyleToast.build(this)
                .setText("hello every body")
                .setBackgroundColor(R.color.colorPrimary)
                .setStrokeWidth(5)
                .setStrokeColor(R.color.colorAccent)
                .setCornerRadius(70)
                .setIconStart(R.drawable.ic_star_black_24dp)
                .setIconEnd(R.drawable.ic_star_black_24dp)
                .setLength(Toast.LENGTH_LONG)
                .show();
    }
}
