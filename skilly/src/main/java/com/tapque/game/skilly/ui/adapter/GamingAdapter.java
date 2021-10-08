package com.tapque.game.skilly.ui.adapter;

import androidx.annotation.NonNull;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.tapque.game.skilly.R;

public class GamingAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

    public GamingAdapter() {
        super(R.layout.item_games);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder baseViewHolder, String s) {

    }
}
