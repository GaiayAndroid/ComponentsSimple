package com.rent.componentssimple.databinding;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.rent.componentssimple.BR;
import com.rent.componentssimple.R;

import java.util.ArrayList;
import java.util.List;

/**
 * <p> Created by RenTao on 2018/1/29.
 */
public class DataBindingListActivity extends AppCompatActivity {
    private List<UserEntity> mData;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RecyclerView recyclerView = new RecyclerView(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mData = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            UserEntity user = new UserEntity();
            user.setName(i + "name");
            user.setHobby(new String[] { i + "", i + i + ""});
            mData.add(user);
        }
        final ListAdapter adapter = new ListAdapter(mData);
        recyclerView.setAdapter(adapter);
        setContentView(recyclerView);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mData.get(0).setName("changed");
                mData.remove(2);
                adapter.notifyDataSetChanged();
            }
        }, 3000);
    }

    private class ListAdapter extends BaseQuickAdapter<UserEntity, ListAdapter.ViewHolder> {

        ListAdapter(@Nullable List<UserEntity> data) {
            super(R.layout.data_binding_item, data);
        }

        @Override
        protected void convert(ViewHolder helper, UserEntity item) {
            ViewDataBinding binding = helper.getBinding();
            binding.setVariable(BR.user, item);
            binding.executePendingBindings();
        }

        @Override
        protected View getItemView(int layoutResId, ViewGroup parent) {
            ViewDataBinding binding = DataBindingUtil.inflate(mLayoutInflater, layoutResId, parent, false);
            if (binding == null) {
                return super.getItemView(layoutResId, parent);
            }
            View view = binding.getRoot();
            view.setTag(R.id.BaseQuickAdapter_databinding_support, binding);
            return view;
        }

        class ViewHolder extends BaseViewHolder {

            public ViewHolder(View view) {
                super(view);
            }

            ViewDataBinding getBinding() {
                return (ViewDataBinding) itemView.getTag(R.id.BaseQuickAdapter_databinding_support);
            }
        }
    }
}
