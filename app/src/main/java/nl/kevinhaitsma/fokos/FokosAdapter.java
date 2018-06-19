package nl.kevinhaitsma.fokos;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class FokosAdapter extends FragmentPagerAdapter {

    public FokosAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @Override
    public Fragment getItem(int position) {
        return new FokosFragment().newInstance(position);
    }

    @Override
    public int getCount() {
        return FokosConfiguration.getInstance().mediaTypes.size();
    }
}
