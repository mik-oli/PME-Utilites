package com.github.mikoli.pmeutilities.utils;

public enum Permissions {

    BYPASS_ITEM_LIMIT("itemlimit.bypass"),
    MININGMONITORTRACK("miningmonitor.track"),
    MININGMONITORMONITOR("miningmonitor.monitor");

    private final String permission;

    Permissions(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return "pmeutils." + permission;
    }
}
