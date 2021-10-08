package com.tapque.game.skilly.app.base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;

public abstract class BaseFragment extends Fragment {

    public AppCompatActivity mActivity;
    //是否第一次加载
    private boolean isFirstLoad = true;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(layoutId(), container, false);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mActivity = (AppCompatActivity) context;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        isFirstLoad = true;
        initPresenter();
        initView(view);
        initData();
    }

    protected abstract int layoutId();

    protected abstract void initView(View view);

    protected abstract void lazyLoadData();

    protected void initPresenter(){}

    /**
     * Fragment执行onViewCreated后触发
     */
    protected void initData() {
    }

    @Override
    public void onResume() {
        super.onResume();
        onVisible();
    }

    private void onVisible() {
        if (getLifecycle().getCurrentState() == Lifecycle.State.STARTED && isFirstLoad) {
            lazyLoadData();
            isFirstLoad = false;
        }
    }
}
