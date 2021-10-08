package com.tapque.game.skilly.ui.home;

import com.tapque.game.skilly.app.base.ApiCallBack;
import com.tapque.game.skilly.app.base.BasePresenter;
import com.tapque.game.skilly.data.BaseResult;
import com.tapque.game.skilly.data.MainBean;

public class HomePresenter extends BasePresenter<HomeContract.View> implements HomeContract.Presenter {

    private HomeContract.Model model;

    public HomePresenter() {
        model = new HomeModel();
    }

    @Override
    public void getMainData() {
        if (model != null) {
            model.getMainData(new ApiCallBack<MainBean>() {
                @Override
                public void success(BaseResult<MainBean> baseResult) {

                }

                @Override
                public void fail(String msg) {

                }
            });
        }
    }
}
