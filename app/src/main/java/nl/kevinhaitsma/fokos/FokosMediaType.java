package nl.kevinhaitsma.fokos;

import android.graphics.Bitmap;

public class FokosMediaType {
    private String mPhotoUrl;
    private Bitmap mPhotoBitMap;

    private String mVideoUrl;

    private String mPlaceholderUrl;
    private Bitmap mPlaceholderBitmap;

    private String mTitle;
    private String mSubtitle;

    public FokosMediaType photoUrl(String photoUrl) {
        this.mPhotoUrl = photoUrl;
        return this;
    }

    public FokosMediaType photoBitmap(Bitmap photoBitMap) {
        this.mPhotoBitMap = photoBitMap;
        return this;
    }

    public FokosMediaType videoUrl(String videoUrl) {
        this.mVideoUrl = videoUrl;
        return this;
    }

    public FokosMediaType placeholderUrl(String placeholderUrl) {
        this.mPlaceholderUrl = placeholderUrl;
        return this;
    }

    public FokosMediaType placeholderBitmap(Bitmap placeholderBitmap) {
        this.mPlaceholderBitmap = placeholderBitmap;
        return this;
    }

    public FokosMediaType title(String title) {
        this.mTitle = title;
        return this;
    }

    public FokosMediaType subtitle(String subtitle) {
        this.mSubtitle = subtitle;
        return this;
    }

    public String getPhotoUrl() {
        return mPhotoUrl;
    }

    public Bitmap getPhotoBitMap() {
        return mPhotoBitMap;
    }

    public String getVideoUrl() {
        return mVideoUrl;
    }

    public String getPlaceholderUrl() {
        return mPlaceholderUrl;
    }

    public Bitmap getPlaceholderBitmap() {
        return mPlaceholderBitmap;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getSubtitle() {
        return mSubtitle;
    }
}
