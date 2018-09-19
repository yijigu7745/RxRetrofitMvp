package com.ghhitech.smisseal.base;

import android.content.Context;
import android.view.View;

public abstract class BaseHolder<Data> {
    protected Context context;
    protected View mRootView;
    protected int mPosition;
    protected Data mData;
    protected int type = 999;

    public BaseHolder() {
        mRootView = initView();
        mRootView.setTag(this);
    }

    public BaseHolder(Context context) {
        this.context = context;
        mRootView = initView();
        mRootView.setTag(this);
    }

    public View getRootView() {
        return mRootView;
    }

    public void setData(Data data) {
        mData = data;
        refreshView();
    }

    public Data getData() {
        return mData;
    }

    public void setPosition(int position) {
        mPosition = position;
    }

    public int getPosition() {
        return mPosition;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    /**
     * 子类必须覆盖用于实现UI初始化
     */
    protected abstract View initView();

    /**
     * 子类必须覆盖用于实现UI刷新
     */
    public abstract void refreshView();

    /**
     * 用于回收
     */
    public void recycle() {

    }
}
