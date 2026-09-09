package com.vehicleservicespecsdk.models;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.HashMap;
import java.util.Map;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.With;
import lombok.extern.jackson.Jacksonized;
import org.openapitools.jackson.nullable.JsonNullable;

@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class CreateVehiclesParameters {

  @JsonProperty("x-mock-response-code")
  private JsonNullable<Long> xMockResponseCode;

  @JsonProperty("requestBody")
  private JsonNullable<CreateVehiclesRequest> requestBody;

  // FSM-59: capture unknown JSON fields so they round-trip on re-serialize.
  // @Builder.Default keeps the empty-map default in the Lombok-generated builder; without it the
  // builder would leave the map null and the any-setter would NPE on the first unknown field.
  // Deserialization is wired via the builder's @JsonAnySetter (see the Builder below), NOT here:
  // Lombok @Jacksonized deserializes through the builder and does not copy a field-level
  // @JsonAnySetter across, so unknown fields would be silently dropped if it lived on this field.
  @Builder.Default
  private Map<String, Object> additionalProperties = new HashMap<>();

  // @JsonAnyGetter must sit on the getter (not the field) so Jackson inlines the unknown entries on
  // serialize. On the field it double-registers with the Lombok getter and leaks a literal
  // "additionalProperties" property into every request body and object parameter.
  // Declaring the getter here also stops Lombok @Data from generating its own.
  @JsonAnyGetter
  public Map<String, Object> getAdditionalProperties() {
    return additionalProperties;
  }

  @JsonIgnore
  public Long getXMockResponseCode() {
    return xMockResponseCode.orElse(null);
  }

  @JsonIgnore
  public CreateVehiclesRequest getRequestBody() {
    return requestBody.orElse(null);
  }

  // Overwrite lombok builder methods
  public static class CreateVehiclesParametersBuilder {

    private JsonNullable<Long> xMockResponseCode = JsonNullable.undefined();

    @JsonProperty("x-mock-response-code")
    public CreateVehiclesParametersBuilder xMockResponseCode(Long value) {
      if (value == null) {
        throw new IllegalStateException("xMockResponseCode cannot be null");
      }
      this.xMockResponseCode = JsonNullable.of(value);
      return this;
    }

    private JsonNullable<CreateVehiclesRequest> requestBody = JsonNullable.undefined();

    @JsonProperty("requestBody")
    public CreateVehiclesParametersBuilder requestBody(CreateVehiclesRequest value) {
      if (value == null) {
        throw new IllegalStateException("requestBody cannot be null");
      }
      this.requestBody = JsonNullable.of(value);
      return this;
    }

    @JsonAnySetter
    public CreateVehiclesParametersBuilder additionalProperties(String key, Object value) {
      if (this.additionalProperties$value == null) {
        this.additionalProperties$value = new HashMap<>();
      }
      this.additionalProperties$value.put(key, value);
      this.additionalProperties$set = true;
      return this;
    }
  }
}
