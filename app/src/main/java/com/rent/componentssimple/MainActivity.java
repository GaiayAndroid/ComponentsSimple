package com.rent.componentssimple;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.rent.componentssimple.databinding.DataBindingBasicActivity;
import com.rent.componentssimple.databinding.DataBindingListActivity;
import com.rent.componentssimple.databinding.DataBindingTestActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onDataBindingBasicClick(View v) {
        startActivity(DataBindingBasicActivity.class);
    }

    public void onDataBindingListClick(View v) {
        startActivity(DataBindingListActivity.class);
    }

    public void onDataBindingTestClick(View v) {
        startActivity(DataBindingTestActivity.class);
    }

    private void startActivity(Class clazz) {
        startActivity(new Intent(this, clazz));
    }
}
