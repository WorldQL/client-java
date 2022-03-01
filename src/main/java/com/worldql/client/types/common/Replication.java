package com.worldql.client.types.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public enum Replication {
    @JsonProperty("except_self")
    EXCEPT_SELF,

    @JsonProperty("including_self")
    INCLUDING_SELF,

    @JsonProperty("only_self")
    ONLY_SELF,
}
