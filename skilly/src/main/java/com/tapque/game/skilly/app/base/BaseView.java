package com.tapque.game.skilly.app.base;


public interface BaseView {

    /**
     * 显示加载中
     */
    default void showLoading(){};

    /**
     * 隐藏加载
     */
    default void hideLoading(){};

}
