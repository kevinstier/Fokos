package nl.kevinhaitsma.fokos;

import android.support.v4.view.ViewPager;
import android.view.ViewGroup;

public final class FokosCustom {
    public ViewGroup bottomView;
    public ViewPager.PageTransformer pageTransformer = new DepthPageTransformer();

    private static final FokosCustom ourInstance = new FokosCustom();

    public static FokosCustom getInstance() {
        return ourInstance;
    }

    public static FokosCustom getCleanInstance() {
        FokosCustom fokosCustom = getInstance();
        fokosCustom.reset();
        return fokosCustom;
    }

    private FokosCustom() {
    }

    private void reset() {
        bottomView = null;
    }
}
