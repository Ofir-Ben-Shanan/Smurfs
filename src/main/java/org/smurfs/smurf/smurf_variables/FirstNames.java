package org.smurfs.smurf.smurf_variables;

import java.util.List;
import java.util.Random;

public enum FirstNames {
    OFIR("Ofir"),
    BAR("Bar"),
    DANI("Dani"),
    TAL("Tal"),
    GAL("Gal");

    FirstNames(String firstName) {
    }
    private static final List<FirstNames> VALUES =
            List.of(values());
    private static final Random RANDOM = new Random();

    public static FirstNames randomFirstName()  {
        return VALUES.get(RANDOM.nextInt(VALUES.size()));
    }
}
