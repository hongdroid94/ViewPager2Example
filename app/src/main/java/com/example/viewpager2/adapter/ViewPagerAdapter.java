package com.example.viewpager2.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.viewpager2.ui.fragment.FragBoard;
import com.example.viewpager2.ui.fragment.FragHome;
import com.example.viewpager2.ui.fragment.FragVisitorHistory;

public class ViewPagerAdapter extends FragmentStateAdapter {
    private FragHome mFragHome;
    private FragBoard mFragBoard;
    private FragVisitorHistory mFragVisitorHistory;

    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
        mFragHome = new FragHome();
        mFragBoard = new FragBoard();
        mFragVisitorHistory = new FragVisitorHistory();
    }

    @NonNull
    @Override
    public Fragment createFragment(int _position) {
        switch (_position) {
            case 0:
                return mFragHome;
            case 1:
                return mFragBoard;
            case 2:
                return mFragVisitorHistory;
        }
        return mFragHome;
    }

    @Override
    public int getItemCount() { // 구현 해둔 탭의 갯수만큼 적어줌.
        return 3;
    }

    public String getItemPosTitle(final int _position) {
        switch (_position) {
            case 0:
                return "홈";
            case 1:
                return "게시판";
            case 2:
                return "방명록";

            default: return "";
        }
    }
}
