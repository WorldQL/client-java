package com.worldql.client.types.server_bound;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.jetbrains.annotations.NotNull;

@JsonSerialize
public record ServerMessagePayload(
    @NotNull
    @JsonProperty("request")
    PayloadType request,

    @NotNull
    @JsonUnwrapped
    Payload payload
) {
    public enum PayloadType {
        @JsonProperty("handshake")
        HANDSHAKE,
    }

    public static @NotNull ServerMessagePayload fromRequest(final @NotNull Payload payload) {
        PayloadType request = payload.getType();
        return new ServerMessagePayload(request, payload);
    }
}
