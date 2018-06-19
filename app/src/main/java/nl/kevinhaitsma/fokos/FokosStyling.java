package nl.kevinhaitsma.fokos;

public final class FokosStyling {
    private static final FokosStyling ourInstance = new FokosStyling();

    public static FokosStyling getInstance() {
        return ourInstance;
    }

    public static FokosStyling getCleanInstance() {
        FokosStyling fokosStyling = getInstance();
        fokosStyling.reset();
        return fokosStyling;
    }

    private FokosStyling() {
    }

    private void reset() {

    }
}
