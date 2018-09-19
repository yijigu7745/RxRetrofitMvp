package com.ghhitech.smisseal.base;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;

import java.util.List;

public abstract class CommomAdapter<Data> extends BaseAdapter {

    private List<Data> mDatas;
    private AbsListView mListView;

    public CommomAdapter(AbsListView listView, List<Data> mDatas) {
        this.mDatas = mDatas;
        mListView = listView;
    }

    @Override
    public int getCount() {
        if (mDatas != null) {
            return mDatas.size();
        }
        return 0;
    }

    @Override
    public Data getItem(int position) {
        if (mDatas != null && position < mDatas.size()) {
            return mDatas.get(position);
        }
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    protected abstract BaseHolder getHolder();

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        BaseHolder<Data> holder;
        if (convertView != null && convertView.getTag() instanceof BaseHolder) {
            holder = (BaseHolder<Data>) convertView.getTag();
        } else {
            holder = getHolder();
        }
        holder.setPosition(position);
        holder.setData(mDatas.get(position));
        return holder.getRootView();
    }
}
