package com.endava.domainModel;

import java.util.Map;

public enum CarType {
    SUV, SEDAN, COUPE, HATCHBACK;

    public final static Map<String, CarType> typeMap = Map.of(
        "SUV", CarType.SUV,
        "sedan", CarType.SEDAN,
        "hatchback", CarType.HATCHBACK,
        "coupe", CarType.COUPE);
}
