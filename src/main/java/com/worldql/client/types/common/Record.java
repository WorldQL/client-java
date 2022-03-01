package com.worldql.client.types.common;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public record Record(UUID uuid, @JsonProperty("world_name") String world_name, Vector3 position, byte[] data) {}
