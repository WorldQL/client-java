package com.worldql.client.types.server_bound;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonSerialize
public record HeartbeatRequest(
    @Nullable
    @JsonProperty("no_once")
    String noonce
) implements ServerMessagePayload {
    @Override
    public @NotNull Request getRequest() {
        return Request.HEARTBEAT;
    }
}
