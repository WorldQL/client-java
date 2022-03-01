package com.worldql.client.types.common;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

@JsonFormat(shape = JsonFormat.Shape.ARRAY)
@JsonPropertyOrder({ "x", "y", "z" })
public record Vector3(double x, double y, double z) {
    // region: Wither Functions
    @Contract(" -> new")
    public @NotNull Vector3 copy() {
        return new Vector3(x(), y(), z());
    }

    @Contract("_ -> new")
    public @NotNull Vector3 withX(double x) {
        return new Vector3(x, y(), z());
    }

    @Contract("_ -> new")
    public @NotNull Vector3 withY(double y) {
        return new Vector3(x(), y, z());
    }

    @Contract("_ -> new")
    public @NotNull Vector3 withZ(double z) {
        return new Vector3(x(), y(), z);
    }
    // endregion
}
