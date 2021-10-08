package com.tapque.game.skilly.ui.home;

import android.os.Bundle;
import android.view.View;


import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.tapque.game.skilly.R;
import com.tapque.game.skilly.app.base.BaseMvpFragment;
import com.tapque.game.skilly.ui.adapter.HomeAdapter;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends BaseMvpFragment<HomePresenter> implements HomeContract.View, SwipeRefreshLayout.OnRefreshListener {

    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView recyclerView;
    private HomeAdapter homeAdapter;


    public static HomeFragment newInstance() {
        Bundle args = new Bundle();
        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int layoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView(View contentView) {
        swipeRefreshLayout = contentView.findViewById(R.id.refresh_view);
        swipeRefreshLayout.setOnRefreshListener(this);
        recyclerView = contentView.findViewById(R.id.recycler_view);

        if (mActivity != null) {
            homeAdapter = new HomeAdapter();
            recyclerView.setLayoutManager(new LinearLayoutManager(mActivity));
            recyclerView.setAdapter(homeAdapter);
        }
    }

    @Override
    protected void lazyLoadData() {
        if (homeAdapter != null) {
            List<String> dada = new ArrayList<>();
            dada.add("");
            dada.add("");
            homeAdapter.setNewInstance(dada);
        }
    }

    @Override
    protected HomePresenter createPresenter() {
        return new HomePresenter();
    }

    @Override
    public void onRefresh() {

    }
}