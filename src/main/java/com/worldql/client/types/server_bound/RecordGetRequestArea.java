package com.worldql.client.types.server_bound;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.worldql.client.types.common.Vector3;
import org.jetbrains.annotations.NotNull;

@JsonSerialize
public record RecordGetRequestArea(
    @NotNull
    @JsonProperty("world_name")
    String world,

    @NotNull
    @JsonProperty("pos_1")
    Vector3 pos1,

    @NotNull
    @JsonProperty("pos_2")
    Vector3 pos2
) implements RecordGetRequest, ServerMessagePayload {

    @Override
    public @NotNull Lookup getLookup() {
        return Lookup.BY_AREA;
    }

    @Override
    public @NotNull Request getRequest() {
        return Request.RECORD_GET;
    }
}
