package com.endava.domainModel;

import java.util.Map;

public enum ShipType {
    CARGO, FISHING;
    public static final Map<String, ShipType> typeMap = Map.of(
        "cargo", CARGO,
        "fishing", FISHING
    );
}
