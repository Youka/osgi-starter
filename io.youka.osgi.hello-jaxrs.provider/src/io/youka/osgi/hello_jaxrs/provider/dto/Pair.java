package io.youka.osgi.hello_jaxrs.provider.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

@Value
public class Pair<A, B> {
    @JsonProperty("key")
    A first;
    @JsonProperty("value")
    B second;
}
