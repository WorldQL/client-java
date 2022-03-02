package com.worldql.client.types.server_bound;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.worldql.client.types.common.Replication;
import org.jetbrains.annotations.NotNull;
import org.msgpack.core.annotations.Nullable;

@JsonSerialize
public record GlobalMessageRequest(
    @NotNull
    @JsonProperty("world_name")
    String world,

    @NotNull
    @JsonProperty("replication")
    Replication replication,

    @Nullable
    @JsonProperty("data")
    byte[] data
) implements ServerMessagePayload {
    @Override
    public @NotNull Request getRequest() {
        return Request.GLOBAL_MESSAGE;
    }
}
