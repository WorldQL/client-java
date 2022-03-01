package com.worldql.client.types.common;

import java.util.UUID;

public record Record(UUID uuid, String world_name, Vector3 position, byte[] data) {}
