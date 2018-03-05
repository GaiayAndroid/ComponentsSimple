package com.rent.componentssimple.databinding;

import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

import com.rent.componentssimple.BR;

/**
 * <p> Created by RenTao on 2018/2/7.
 */
public class UserViewModel {
    public ObservableField<UserEntity> user = new ObservableField<>();
    private UserView userView;

    public void requestData() {
//        loadCache();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                UserEntity userEntity = user.get();
                if (userEntity == null) {
                    userEntity = new UserEntity();
                    user.set(userEntity);
                }
                userEntity.id = "id11";
                userEntity.name = "name11";
                userEntity.intro = "intro11";
                userEntity.logo = "http://ss.zm518.cn/ae32c42e64434648af5cccb25ee1e906/image/20170825/18/3959.00017.jpeg";
                user.notifyChange();

                if (userView != null) {
                    userView.showIntro(userEntity.intro);
                }
            }
        }, 1500);
    }

    private void loadCache() {
        UserEntity entity = new UserEntity();
        entity.id = "id";
        entity.name = "name";
        entity.intro = "intro";
        user.set(entity);
    }

    public void setUserView(UserView userView) {
        this.userView = userView;
    }

    public interface UserView {
        void showIntro(String intro);
    }

    public static class UserEntity {
        public String id;
        public String name;
        public String intro;
        public String logo;
    }

    public boolean isShow() {
        return user.get() != null && user.get().intro != null;
    }

    public void onClicked() {
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaa");
    }
}
