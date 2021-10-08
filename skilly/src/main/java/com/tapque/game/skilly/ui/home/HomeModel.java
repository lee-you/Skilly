package com.tapque.game.skilly.ui.home;

import androidx.annotation.NonNull;

import com.tapque.game.skilly.app.base.ApiCallBack;
import com.tapque.game.skilly.app.newwork.Api;
import com.tapque.game.skilly.data.MainBean;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class HomeModel implements HomeContract.Model {

    @Override
    public void getMainData(ApiCallBack<MainBean> apiCallBack) {
        Api.getDefault().getMainData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MainBean>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull MainBean mainBean) {

                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

}
