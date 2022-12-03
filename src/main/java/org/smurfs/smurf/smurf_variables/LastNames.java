package org.smurfs.smurf.smurf_variables;

import java.util.List;
import java.util.Random;

public enum LastNames {
    COHEN("Cohen"),
    LEVI("Levi"),
    KATZ("Katz"),
    BEN_HAIM("Ben Haim"),
    BEN_SHANAN("Ben Shanan");


    LastNames(String firstName) {}

    private static final List<LastNames> VALUES =
            List.of(values());
    private static final Random RANDOM = new Random();

    public static LastNames randomFirstName() {
        return VALUES.get(RANDOM.nextInt(VALUES.size()));
    }
}
