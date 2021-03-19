package com.endava.domainModel;

import java.util.Map;

public enum RailedVehicleType {
    TRAM, TRAIN, METRO;
    public static final Map<String, RailedVehicleType> typeMap
        = Map.of(
        "tram", TRAM,
        "train", TRAIN,
        "metro", METRO);
}
