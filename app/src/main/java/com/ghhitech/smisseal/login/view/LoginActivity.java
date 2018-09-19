package com.ghhitech.smisseal.login.view;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.ghhitech.smisseal.R;
import com.ghhitech.smisseal.login.model.UserModel;
import com.ghhitech.smisseal.login.presenter.ILoginPresenter;
import com.ghhitech.smisseal.login.presenter.LoginPresenterCompl;
import com.ghhitech.smisseal.picture.view.PictureActivity;
import com.ghhitech.smisseal.utils.DialogFactoryUtils;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * @author yijigu
 */
public class LoginActivity extends FragmentActivity implements ILoginView, View.OnClickListener {

    ILoginPresenter loginPresenter;
    private Button login;
    private Button clear;
    private EditText userName;
    private EditText password;
    private DialogFactoryUtils dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login = this.findViewById(R.id.btn_login);
        clear = this.findViewById(R.id.btn_clear);
        userName = this.findViewById(R.id.userName);
        password = this.findViewById(R.id.password);

        loginPresenter = new LoginPresenterCompl(this);

        dialog = DialogFactoryUtils.builder(this);

        login.setOnClickListener(this);
        clear.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                dialog.progress("正在登录...").show();
                loginPresenter.login(userName.getText().toString(), password.getText().toString())
                        .subscribeOn(Schedulers.io())
                        .unsubscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe((Consumer<UserModel>) userModel -> {
                                    if (userModel.isSuccess()) {
                                        dialog.success("登录成功！").show();
                                        Intent intent = new Intent(LoginActivity.this, PictureActivity.class);
                                        startActivity(intent);
                                    }else{
                                        dialog.error("账号或密码错误！").show();


                                    }
                                },(Consumer<Throwable>) e ->{
                                        dialog.error("登录失败！").show();
                                });
                break;
            case R.id.btn_clear:
                loginPresenter.clear();
                break;
            default:

        }

    }

    @Override
    public void clearText() {
        userName.setText("");
        password.setText("");
    }

    @Override
    protected void onPause() {
        super.onPause();
        dialog.close();
    }
}
