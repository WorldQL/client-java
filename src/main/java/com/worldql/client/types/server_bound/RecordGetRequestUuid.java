package com.worldql.client.types.server_bound;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.worldql.client.types.common.PartialRecord;
import org.jetbrains.annotations.NotNull;

@JsonSerialize
public record RecordGetRequestUuid(
    @NotNull
    @JsonProperty("records")
    PartialRecord[] records
) implements RecordGetRequest, ServerMessagePayload {
    @Override
    public @NotNull Lookup getLookup() {
        return Lookup.BY_UUID;
    }

    @Override
    public @NotNull Request getRequest() {
        return Request.RECORD_GET;
    }
}
