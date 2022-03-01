package com.worldql.client.types.server_bound;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.NotNull;

public interface Payload {
    @JsonProperty("request")
    @NotNull
    Request getRequest();
}
