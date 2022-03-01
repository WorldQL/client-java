package com.worldql.client.types.server_bound;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.worldql.client.serialization.BinaryUUID;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

@JsonSerialize
public record ServerMessage(
    @NotNull
    @JsonProperty("sender")
    @JsonSerialize(using = BinaryUUID.UUIDSerializer.class) UUID sender,

    @NotNull
    @JsonProperty("token")
    String token,

    @NotNull
    @JsonProperty("payload")
    Payload payload
) {}
