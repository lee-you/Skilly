package com.tapque.game.skilly.ui.reward;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.tapque.game.skilly.R;
import com.tapque.game.skilly.app.base.BaseFragment;

public class RewardFragment extends BaseFragment {


    public static RewardFragment newInstance() {
        return new RewardFragment();
    }

    @Override
    protected int layoutId() {
        return R.layout.fragment_notifications;
    }

    @Override
    protected void initView(View view) {

    }

    @Override
    protected void lazyLoadData() {
    }
}