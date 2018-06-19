package nl.kevinhaitsma.fokos;

public class FokosGestures {
    public boolean loadImageDefault = true;
    public boolean allowVerticalSwipe = true;
    public boolean allowZoom = true;

    private static final FokosGestures ourInstance = new FokosGestures();

    public static FokosGestures getInstance() {
        return ourInstance;
    }

    public static FokosGestures getCleanInstance() {
        FokosGestures fokosGestures = getInstance();
        fokosGestures.reset();
        return fokosGestures;
    }

    private FokosGestures() {
    }

    private void reset() {
        loadImageDefault = true;
        allowVerticalSwipe = true;
        allowZoom = true;
    }
}
