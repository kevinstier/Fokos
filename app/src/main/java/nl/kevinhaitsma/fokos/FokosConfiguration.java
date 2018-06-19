package nl.kevinhaitsma.fokos;

import java.util.List;

public final class FokosConfiguration {
    public Fokos fokos;
    public List<FokosMediaType> mediaTypes;

    private static final FokosConfiguration ourInstance = new FokosConfiguration();

    public static FokosConfiguration getInstance() {
        return ourInstance;
    }

    public static FokosConfiguration getCleanInstance() {
        FokosConfiguration fokosConfiguration = getInstance();
        fokosConfiguration.reset();
        return fokosConfiguration;
    }

    private FokosConfiguration() {
    }

    private void reset() {
        fokos = null;
        mediaTypes = null;
    }
}
