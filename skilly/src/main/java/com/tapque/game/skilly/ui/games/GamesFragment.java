package com.tapque.game.skilly.ui.games;

import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.tapque.game.skilly.R;
import com.tapque.game.skilly.app.base.BaseMvpFragment;
import com.tapque.game.skilly.ui.adapter.GamesAdapter;
import com.tapque.game.skilly.ui.adapter.HomeAdapter;

import java.util.ArrayList;
import java.util.List;

public class GamesFragment extends BaseMvpFragment<GamesPresenter> implements GamesContract.View ,SwipeRefreshLayout.OnRefreshListener{

    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView recyclerView;
    private GamesAdapter gamesAdapter;

    public static GamesFragment newInstance() {
        return new GamesFragment();
    }

    @Override
    protected int layoutId() {
        return R.layout.fragment_games;
    }

    @Override
    protected void initView(View contentView) {
        swipeRefreshLayout = contentView.findViewById(R.id.refresh_view);
        swipeRefreshLayout.setOnRefreshListener(this);
        recyclerView = contentView.findViewById(R.id.recycler_view);

        if (mActivity != null) {
            gamesAdapter = new GamesAdapter();
            recyclerView.setLayoutManager(new LinearLayoutManager(mActivity));
            recyclerView.setAdapter(gamesAdapter);
        }
    }

    @Override
    protected void lazyLoadData() {
        if (gamesAdapter != null) {
            List<String> dada = new ArrayList<>();
            dada.add("");
            dada.add("");
            gamesAdapter.setNewInstance(dada);
        }
    }

    @Override
    protected GamesPresenter createPresenter() {
        return new GamesPresenter();
    }

    @Override
    public void onRefresh() {

    }
}