package com.worldql.client.types.server_bound;

import com.fasterxml.jackson.annotation.JsonIgnore;

public interface Payload {
    @JsonIgnore
    ServerMessagePayload.PayloadType getType();
}
