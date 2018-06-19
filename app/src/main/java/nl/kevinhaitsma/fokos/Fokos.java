package nl.kevinhaitsma.fokos;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.view.ViewGroup;

import java.util.List;

public final class Fokos {

    private final Activity mContext;

    private final FokosConfiguration mFokosConfiguration;
    private final FokosGestures mFokosGestures;
    private final FokosStyling mFokosStyling;
    private final FokosCustom mFokosCustom;

    private Fokos(Activity activity) {
        mContext = activity;
        mFokosConfiguration = FokosConfiguration.getCleanInstance();
        mFokosGestures = FokosGestures.getCleanInstance();
        mFokosStyling = FokosStyling.getCleanInstance();
        mFokosCustom = FokosCustom.getCleanInstance();
    }

    public static Fokos from(Activity activity) {
        return new Fokos(activity);
    }

    public Fokos mediaTypes(List<FokosMediaType> mediaTypes) {
        mFokosConfiguration.mediaTypes = mediaTypes;
        return this;
    }

    public Fokos bottomView(ViewGroup bottomView) {
        mFokosCustom.bottomView = bottomView;
        return this;
    }

    public Fokos loadImageDefault(boolean loadImageDefault) {
        mFokosGestures.loadImageDefault = loadImageDefault;
        return this;
    }

    public Fokos allowVerticalSwipe(boolean allowVerticalSwipe) {
        mFokosGestures.allowVerticalSwipe = allowVerticalSwipe;
        return this;
    }

    public Fokos allowZoom(boolean allowZoom) {
        mFokosGestures.allowZoom = allowZoom;
        return this;
    }

    public Fokos pageTransformer(ViewPager.PageTransformer pageTransformer) {
        mFokosCustom.pageTransformer = pageTransformer;
        return this;
    }

    public void start() {
        if (mContext != null && mFokosConfiguration.mediaTypes != null) {
            mFokosConfiguration.fokos = this;

            Intent intent = new Intent(mContext, FokosActivity.class);
            mContext.startActivity(intent);
        }
    }
}
