package com.tapque.game.skilly.ui.games;

import com.tapque.game.skilly.app.base.ApiCallBack;
import com.tapque.game.skilly.app.base.BasePresenter;
import com.tapque.game.skilly.data.BaseResult;
import com.tapque.game.skilly.data.MainBean;

public class GamesPresenter extends BasePresenter<GamesContract.View> implements GamesContract.Presenter {

    private GamesContract.Model model;

    public GamesPresenter() {
        model = new GamesModel();
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
