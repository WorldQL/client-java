package com.worldql.client.types.server_bound;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.jetbrains.annotations.NotNull;

@JsonSerialize
public record RecordSetRequest(
    @NotNull
    @JsonProperty("records")
    Record[] records
) implements ServerMessagePayload {
    @Override
    public @NotNull Request getRequest() {
        return Request.RECORD_SET;
    }
}
