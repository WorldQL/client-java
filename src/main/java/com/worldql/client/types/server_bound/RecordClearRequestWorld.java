package com.worldql.client.types.server_bound;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.jetbrains.annotations.NotNull;

@JsonSerialize
public record RecordClearRequestWorld(
    @NotNull
    @JsonProperty("world_name")
    String world
) implements RecordClearRequest, ServerMessagePayload {
    @Override
    public @NotNull Clear getClear() {
        return Clear.BY_WORLD;
    }

    @Override
    public @NotNull Request getRequest() {
        return Request.RECORD_CLEAR;
    }
}
