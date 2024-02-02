package com.github.mikoli.pmeutilities.utils.enums;

public enum Permissions {

    BYPASS_ITEM_LIMIT("itemlimit.bypass"),
    MININGMONITOR_TRACK("miningmonitor.track"),
    MININGMONITOR_MONITOR("miningmonitor.monitor"),
    BYPASS_INVENTORY_CLEAR("bypassinvclear"),
    GET_ITEM_CMD("getitem");

    private final String permission;

    Permissions(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return "pmeutils." + permission;
    }
}
