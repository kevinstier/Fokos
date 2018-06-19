package nl.kevinhaitsma.fokos;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public class DownloadImageTask
        extends AsyncTask<String, Void, Bitmap> {

    private Listener listener;

    public DownloadImageTask(final Listener listener) {
        this.listener = listener;
    }

    @Override
    protected Bitmap doInBackground(String... urls) {
        final String url = urls[0];
        Bitmap bitmap = null;

        try {
            final InputStream inputStream = new URL(url).openStream();
            bitmap = BitmapFactory.decodeStream(inputStream);
        } catch (final IOException ioException) {
            listener.onImageDownloadError();
        }
        return bitmap;
    }

    @Override
    protected void onPostExecute(Bitmap result) {
        if (null != result) {
            listener.onImageDownloaded(result);
        } else {
            listener.onImageDownloadError();
        }
    }



    public interface Listener {
        void onImageDownloaded(final Bitmap bitmap);
        void onImageDownloadError();
    }
}
