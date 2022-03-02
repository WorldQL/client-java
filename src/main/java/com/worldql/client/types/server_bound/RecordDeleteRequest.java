package com.worldql.client.types.server_bound;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.worldql.client.types.common.PartialRecord;
import org.jetbrains.annotations.NotNull;

@JsonSerialize
public record RecordDeleteRequest(
    @NotNull
    @JsonProperty("records")
    PartialRecord[] records
) implements ServerMessagePayload {
    @Override
    public @NotNull Request getRequest() {
        return Request.RECORD_DELETE;
    }
}
