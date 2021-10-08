package com.tapque.game.skilly.ui.games;

import com.tapque.game.skilly.app.base.ApiCallBack;
import com.tapque.game.skilly.app.base.BaseView;
import com.tapque.game.skilly.data.MainBean;

public interface GamesContract {

    interface Model {
        void getMainData(ApiCallBack<MainBean> apiCallBack);
    }

    interface View extends BaseView {

    }

    interface Presenter {
        void getMainData();
    }

}
