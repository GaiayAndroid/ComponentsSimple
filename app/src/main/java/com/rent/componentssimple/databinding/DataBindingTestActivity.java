package com.rent.componentssimple.databinding;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.rent.componentssimple.R;

/**
 * <p> Created by RenTao on 2018/2/7.
 */
public class DataBindingTestActivity extends AppCompatActivity {
    UserViewModel viewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final DataBindingActivityTestBinding binding = DataBindingUtil.setContentView(this, R.layout.data_binding_activity_test);
        viewModel = new UserViewModel();
        binding.setViewmodel(viewModel);

        viewModel.requestData();

//        viewModel.logo.set("http://ss.zm518.cn/aedcc0e204ad43b4a9b1fb195cbd9971/image/20170119/18/0142.00002.jpeg");
    }

}
