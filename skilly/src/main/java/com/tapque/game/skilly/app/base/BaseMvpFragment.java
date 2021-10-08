package com.tapque.game.skilly.app.base;


public abstract class BaseMvpFragment<T extends BasePresenter> extends BaseFragment implements BaseView {

    protected T mPresenter;

    protected abstract T createPresenter();

    @SuppressWarnings("unchecked")
    protected void initPresenter() {
        mPresenter = createPresenter();
        //绑定生命周期
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }
}
