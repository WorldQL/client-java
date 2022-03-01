package com.worldql.client.types.server_bound;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.jetbrains.annotations.Nullable;

@JsonSerialize
public record HandshakeRequest(
    @Nullable
    @JsonProperty("server_auth")
    String auth
) implements Payload {
    @Override
    public ServerMessagePayload.PayloadType getType() {
        return ServerMessagePayload.PayloadType.HANDSHAKE;
    }
}
