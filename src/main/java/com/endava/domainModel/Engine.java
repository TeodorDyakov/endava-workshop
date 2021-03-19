package com.endava.domainModel;

import java.util.Map;

public enum Engine {
    ELECTRIC, INTERNAL_COMBUSTION, JET;

    public static final Map<String, Engine> engineMap = Map.of(
        "electric", ELECTRIC,
        "ICE", INTERNAL_COMBUSTION,
        "jet", JET);
}
