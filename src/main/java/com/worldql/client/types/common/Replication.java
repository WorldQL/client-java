package com.worldql.client.types.common;

public enum Replication {
    EXCEPT_SELF("except_self"),
    INCLUDING_SELF("including_self"),
    ONLY_SELF("only_self");

    private final String serialized;

    Replication(final String serialized) {
        this.serialized = serialized;
    }

    @Override
    public String toString() {
        return this.serialized;
    }
}
