package com.tapque.game.skilly.app.base;

import com.tapque.game.skilly.data.BaseResult;

public interface ApiCallBack<T> {

    void success(BaseResult<T> baseResult);

    void fail(String msg);

}
