package com.ghhitech.smisseal.picture.view;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.LazyHeaders;
import com.fasterxml.jackson.core.type.TypeReference;
import com.ghhitech.smisseal.R;
import com.ghhitech.smisseal.base.BaseHolder;
import com.ghhitech.smisseal.base.CommomAdapter;
import com.ghhitech.smisseal.base.Items;
import com.ghhitech.smisseal.constants.SealConstants;
import com.ghhitech.smisseal.datamanager.DataManager;
import com.ghhitech.smisseal.picture.model.PictureModel;
import com.ghhitech.smisseal.picture.presenter.IPicturePresenter;
import com.ghhitech.smisseal.picture.presenter.PicturePresenterCompl;
import com.ghhitech.smisseal.situation.model.SituationModel;
import com.ghhitech.smisseal.situation.presenter.ISituationPresenter;
import com.ghhitech.smisseal.situation.presenter.SituationPresenterCompl;
import com.ghhitech.smisseal.situation.view.ISituationView;
import com.ghhitech.smisseal.utils.DialogFactoryUtils;
import com.ghhitech.smisseal.utils.JSONTOBean;

import java.util.Date;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

public class PictureActivity extends FragmentActivity implements IPictrueView, ISituationView, View.OnClickListener {

    private DialogFactoryUtils dialogFactoryUtils;
    private IPicturePresenter picturePresenter;
    private ISituationPresenter situationPresenter;
    private PictureModel pictureModelList;
    //    private ListView listView;
    private ImageView imageView;
    private Button loadPicture;
    private Button prePicture;
    private Button nextPicture;
    private CommomAdapter<PictureModel> adapter;
    private int size = 0;
    private int position = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_picture);
//        listView = this.findViewById(R.id.listView);
        imageView = this.findViewById(R.id.image);
        loadPicture = this.findViewById(R.id.btn_load);
        prePicture = this.findViewById(R.id.pre_pic);
        nextPicture = this.findViewById(R.id.next_pic);
        dialogFactoryUtils = DialogFactoryUtils.builder(this);
        picturePresenter = new PicturePresenterCompl(this);
        situationPresenter = new SituationPresenterCompl(this);

        loadPicture.setOnClickListener(this);
        prePicture.setOnClickListener(this);
        nextPicture.setOnClickListener(this);

        initData();
    }

    private void initData() {
//        adapter = new CommomAdapter<PictureModel>(listView,pictureModelList) {
//            @Override
//            protected BaseHolder getHolder() {
//                return null;
//            }
//        };
    }

    @Override
    public void showMessage(String title, int msgType) {
        dialogFactoryUtils.close();
        switch (msgType) {
            case SealConstants.MESSAGE_TYPE_SUCCESS:
                dialogFactoryUtils.success(title).show();
                break;
            case SealConstants.MESSAGE_TYPE_ERROR:
                dialogFactoryUtils.error(title).show();
                break;
            case SealConstants.MESSAGE_TYPE_WORNING:
                dialogFactoryUtils.waring(title, false).show();
                break;
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_load:
                dialogFactoryUtils.progress("正在加载中...").show();
                picturePresenter.getPicture("636076636", "2018-02-05 17:37:24", "2018-02-05 17:48:38", 1, 4)
                        .subscribeOn(Schedulers.io())
                        .unsubscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<PictureModel>() {

                            @Override
                            public void onSubscribe(Disposable d) {
                            }

                            @Override
                            public void onNext(PictureModel pictureModel) {
                                dialogFactoryUtils.close();
                                if (pictureModel.getList().size() > 0) {
                                    loadPicture(pictureModel, 0);
                                    size = pictureModel.getList().size();
                                    pictureModelList = pictureModel;
                                    position = 0;
                                }
                            }

                            @Override
                            public void onError(Throwable e) {
                            }

                            @Override
                            public void onComplete() {
                                System.out.println("On Complete!");
                            }
                        });
//                situationPresenter.getSituationInfo()
//                        .subscribeOn(Schedulers.io())
//                        .unsubscribeOn(Schedulers.io())
//                        .observeOn(AndroidSchedulers.mainThread())
//                        .subscribe(new Observer<SituationModel>() {
//                            @Override
//                            public void onSubscribe(Disposable d) {
//
//                            }
//
//                            @Override
//                            public void onNext(SituationModel situationModel) {
//                                situationModel.isSuccess();
//                                System.out.println("BreakOffTaskNum:"+situationModel.getList().get(0).getBreakOffTaskNum());
//                            }
//
//                            @Override
//                            public void onError(Throwable e) {
//
//                            }
//
//                            @Override
//                            public void onComplete() {
//                                System.out.println("On Complete!");
//                            }
//                        });
                break;
            case R.id.pre_pic:
                if(position == 0){
                    dialogFactoryUtils.waring("已经是第一张。",true).show();
                }else{
                    position--;
                    loadPicture(pictureModelList,position);
                }
                break;
            case R.id.next_pic:
                if((position+1) >= size){
                    dialogFactoryUtils.waring("已经是最后一张。",true).show();
                }else{
                    position++;
                    loadPicture(pictureModelList,position);
                }
                break;
        }
    }

    public void loadPicture(PictureModel pictureModel, int position) {
        GlideUrl glideUrl = new GlideUrl(pictureModel.getList().get(position).getPhotourl(), new LazyHeaders.Builder().addHeader("Cookie", DataManager.getCookie()).build());
        Glide.with(PictureActivity.this)
                .load(glideUrl)
                .placeholder(R.drawable.empty)
                .error(R.drawable.pictures_no)
                .into(imageView);
    }
}
