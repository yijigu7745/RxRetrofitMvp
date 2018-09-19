package com.ghhitech.smisseal.situation.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

import com.ghhitech.smisseal.situation.presenter.ISituationPresenter;

public class SituationActivity extends FragmentActivity implements ISituationView {

    private ISituationPresenter situationPresenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(0);
    }
}
