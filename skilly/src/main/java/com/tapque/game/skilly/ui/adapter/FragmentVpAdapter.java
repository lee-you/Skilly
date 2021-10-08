package com.tapque.game.skilly.ui.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.tapque.game.skilly.ui.games.GamesFragment;
import com.tapque.game.skilly.ui.home.HomeFragment;
import com.tapque.game.skilly.ui.reward.RewardFragment;

import java.util.ArrayList;
import java.util.List;

public class FragmentVpAdapter extends FragmentStateAdapter {

    private List<Fragment> fragments = new ArrayList<>();

    public FragmentVpAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
        fragments.add(HomeFragment.newInstance());
        fragments.add(GamesFragment.newInstance());
        fragments.add(RewardFragment.newInstance());
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return (Fragment) fragments.get(position);
    }

    @Override
    public int getItemCount() {
        return fragments.size();
    }
}
