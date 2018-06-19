package nl.kevinhaitsma.fokos;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.chrisbanes.photoview.PhotoView;

public class FokosFragment extends Fragment {

    private int mPosition;

    public FokosFragment newInstance(int position) {
        FokosFragment fokosFragment = new FokosFragment();

        Bundle args = new Bundle();
        args.putInt("position", position);
        fokosFragment.setArguments(args);

        return fokosFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mPosition = getArguments().getInt("position");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fokos, container, false);

        PhotoView imageView = view.findViewById(R.id.fokos_image_view);
        imageView.setZoomable(FokosGestures.getInstance().allowZoom);

        if (FokosGestures.getInstance().allowVerticalSwipe) {
            imageView.setOnTouchListener(new SwipeHelper(getContext()) {
                @Override
                public void onVerticalSwipe() {
                    getActivity().finish();
                }
            });
        }

        if (FokosGestures.getInstance().loadImageDefault) {
            loadImageAsync(FokosConfiguration.getInstance().mediaTypes.get(mPosition).getPhotoUrl(), imageView);
        }

        return view;
    }

    private void loadImageAsync(String url, final PhotoView imageView) {
            new DownloadImageTask(new DownloadImageTask.Listener() {
                @Override
                public void onImageDownloaded(final Bitmap bitmap) {
                    imageView.setImageBitmap(bitmap);
                }
                @Override
                public void onImageDownloadError() {

                }
            }).execute(url);
    }
}
