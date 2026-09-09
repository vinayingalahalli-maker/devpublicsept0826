package com.vehicleservicespecsdk.exceptions;

import com.vehicleservicespecsdk.models.CreateVehiclesConflictResponse;
import java.util.List;
import java.util.Map;

/**
 * Error thrown for HTTP 409 responses.
 *
 * Part of the status-named exception hierarchy; extends {@link ApiError} and
 * exposes a typed {@code body()} for this status.
 */
public class ConflictError extends ApiError {

  public ConflictError(
    String message,
    CreateVehiclesConflictResponse body,
    Map<String, List<String>> headers
  ) {
    super(message, 409, body, headers);
  }

  /**
   * @return The typed error body for this response.
   */
  @java.lang.Override
  public CreateVehiclesConflictResponse body() {
    return (CreateVehiclesConflictResponse) super.body();
  }
}
