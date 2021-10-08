package com.tapque.game.skilly.app.newwork;

import com.tapque.game.skilly.data.MainBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * time:2017/4/7
 * description:
 * author: LiYou
 */

public interface ApiService {

    /**
     * 获取首页数据
     */
    @GET("/app/index")
    Observable<MainBean> getMainData();

}
