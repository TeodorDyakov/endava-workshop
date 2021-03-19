package com.endava.domainModel;

import java.util.Map;

public enum PlaneType {
    JET, PROPELLER;
    public static final Map<String, PlaneType> typeMap = Map.of("jet", JET, "propeller", PROPELLER);
}
