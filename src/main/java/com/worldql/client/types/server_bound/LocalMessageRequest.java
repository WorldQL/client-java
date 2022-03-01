package com.worldql.client.types.server_bound;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.worldql.client.types.common.Replication;
import com.worldql.client.types.common.Vector3;
import org.jetbrains.annotations.NotNull;
import org.msgpack.core.annotations.Nullable;

public record LocalMessageRequest(
    @NotNull
    @JsonProperty("world_name")
    String world,

    @NotNull
    @JsonProperty("position")
    Vector3 position,

    @NotNull
    @JsonProperty("replication")
    Replication replication,

    @Nullable
    @JsonProperty("data")
    byte[] data
) implements ServerMessagePayload {
    @Override
    public @NotNull Request getRequest() {
        return Request.LOCAL_MESSAGE;
    }
}
