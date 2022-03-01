package com.worldql.client.types.server_bound;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.jetbrains.annotations.NotNull;

@JsonSerialize
public record WorldUnsubscribeRequest(
    @NotNull
    @JsonProperty("world_name")
    String world
) implements Payload {
    @Override
    public @NotNull Request getRequest() {
        return Request.WORLD_UNSUBSCRIBE;
    }
}
