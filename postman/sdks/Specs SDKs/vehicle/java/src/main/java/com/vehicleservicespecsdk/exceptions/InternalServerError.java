package com.vehicleservicespecsdk.exceptions;

import java.util.List;
import java.util.Map;

/**
 * Error thrown for HTTP 500 responses.
 *
 * Part of the status-named exception hierarchy; extends {@link ApiError} and
 * carries the raw error body via {@code body()} (untyped for this status).
 */
public class InternalServerError extends ApiError {

  public InternalServerError(String message, Object body, Map<String, List<String>> headers) {
    super(message, 500, body, headers);
  }
}
