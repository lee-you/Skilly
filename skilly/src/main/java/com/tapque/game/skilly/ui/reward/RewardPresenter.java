package com.tapque.game.skilly.ui.reward;

import com.tapque.game.skilly.app.base.ApiCallBack;
import com.tapque.game.skilly.app.base.BasePresenter;
import com.tapque.game.skilly.data.BaseResult;
import com.tapque.game.skilly.data.MainBean;

public class RewardPresenter extends BasePresenter<RewardContract.View> implements RewardContract.Presenter {

    private RewardContract.Model model;

    public RewardPresenter() {
        model = new RewardModel();
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
