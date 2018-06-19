package nl.kevinhaitsma.fokos;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class FokosActivity extends AppCompatActivity {

    private Fokos fokos;

    private ViewPager mViewPager;
    private LinearLayout mBottomView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fokos);

        fokos = FokosConfiguration.getInstance().fokos;

        mViewPager = findViewById(R.id.fokos_viewpager);

        initViewPager();
    }

    private void initViewPager() {
        mViewPager.setPageTransformer(true, FokosCustom.getInstance().pageTransformer);
        mViewPager.setAdapter(new FokosAdapter(getSupportFragmentManager()));
    }
}
