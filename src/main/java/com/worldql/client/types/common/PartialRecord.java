package com.worldql.client.types.common;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public record PartialRecord(UUID uuid, @JsonProperty("world_name") String world) {}
