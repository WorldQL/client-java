package com.worldql.client.types.server_bound;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public enum Request {
    @JsonProperty("handshake")
    HANDSHAKE,

    @JsonProperty("heartbeat")
    HEARTBEAT,

    @JsonProperty("global_message")
    GLOBAL_MESSAGE,

    @JsonProperty("local_message")
    LOCAL_MESSAGE,

    @JsonProperty("world_subscribe")
    WORLD_SUBSCRIBE,

    @JsonProperty("world_unsubscribe")
    WORLD_UNSUBSCRIBE,

    @JsonProperty("area_subscribe")
    AREA_SUBSCRIBE,

    @JsonProperty("area_unsubscribe")
    AREA_UNSUBSCRIBE,

    @JsonProperty("record_get")
    RECORD_GET,

    @JsonProperty("record_set")
    RECORD_SET,

    @JsonProperty("record_delete")
    RECORD_DELETE,

    @JsonProperty("record_clear")
    RECORD_CLEAR,
}
