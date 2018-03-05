package com.rent.componentssimple.databinding;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.rent.componentssimple.R;

import java.util.Arrays;

/**
 * <p> Created by RenTao on 2018/1/29.
 */
public class DataBindingBasicActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        UserEntity user = new UserEntity();
        user.setName("aaaa");
        user.setHobby(new String[] { "basketball" });
        final com.rent.componentssimple.databinding.DataBindingActivityBasicBinding binding = DataBindingUtil.setContentView(this, R.layout.data_binding_activity_basic);
        binding.setUser(user);
        binding.setClickListener(this);
        binding.setClickEvent(new ClickEvent());

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                UserEntity user = binding.getUser();
                user.setAge(10);
                user.setMarried(true);
                user.setHobby(new String[] { "basketball", "football" });
                binding.setUser(user);
            }
        }, 3000);
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(this, "clicked", Toast.LENGTH_SHORT).show();
    }

    public class ClickEvent {
        public void onHobbyClicked(String[] hobby) {
            Toast.makeText(DataBindingBasicActivity.this, Arrays.toString(hobby), Toast.LENGTH_SHORT).show();
        }
    }
}
