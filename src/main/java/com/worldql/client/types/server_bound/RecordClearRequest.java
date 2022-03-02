package com.worldql.client.types.server_bound;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.jetbrains.annotations.NotNull;

public interface RecordClearRequest {
    @JsonSerialize
    enum Clear {
        @JsonProperty("by_world")
        BY_WORLD,

        @JsonProperty("by_area")
        BY_AREA,
    }

    @NotNull
    @JsonProperty("clear")
    Clear getClear();
}
