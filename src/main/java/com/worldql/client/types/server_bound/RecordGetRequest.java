package com.worldql.client.types.server_bound;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.jetbrains.annotations.NotNull;

public interface RecordGetRequest {
    @JsonSerialize
    enum Lookup {
        @JsonProperty("by_area")
        BY_AREA,

        @JsonProperty("by_uuid")
        BY_UUID,
    }

    @NotNull
    @JsonProperty("lookup")
    Lookup getLookup();
}
