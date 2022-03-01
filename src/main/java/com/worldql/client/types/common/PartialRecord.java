package com.worldql.client.types.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.worldql.client.serialization.BinaryUUID;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

@JsonSerialize
public record PartialRecord(
    @NotNull
    @JsonProperty("uuid")
    @JsonSerialize(using = BinaryUUID.UUIDSerializer.class)
    @JsonDeserialize(using = BinaryUUID.UUIDDeserializer.class)
    UUID uuid,

    @NotNull
    @JsonProperty("world_name")
    String world
) {}
