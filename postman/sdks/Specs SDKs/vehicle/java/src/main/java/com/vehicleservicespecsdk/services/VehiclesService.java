package com.vehicleservicespecsdk.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.vehicleservicespecsdk.config.RequestConfig;
import com.vehicleservicespecsdk.config.VehicleServiceSpecSdkConfig;
import com.vehicleservicespecsdk.exceptions.ApiError;
import com.vehicleservicespecsdk.exceptions.BadRequestError;
import com.vehicleservicespecsdk.exceptions.ConflictError;
import com.vehicleservicespecsdk.exceptions.InternalServerError;
import com.vehicleservicespecsdk.exceptions.NotFoundError;
import com.vehicleservicespecsdk.http.Environment;
import com.vehicleservicespecsdk.http.HttpMethod;
import com.vehicleservicespecsdk.http.ModelConverter;
import com.vehicleservicespecsdk.http.VehicleServiceSpecSdkResponse;
import com.vehicleservicespecsdk.http.util.RequestBuilder;
import com.vehicleservicespecsdk.models.CreateVehiclesBadRequestResponse;
import com.vehicleservicespecsdk.models.CreateVehiclesConflictResponse;
import com.vehicleservicespecsdk.models.CreateVehiclesCreatedResponse;
import com.vehicleservicespecsdk.models.CreateVehiclesInternalServerErrorResponse;
import com.vehicleservicespecsdk.models.CreateVehiclesParameters;
import com.vehicleservicespecsdk.models.DeleteVehiclesByIdInternalServerErrorResponse;
import com.vehicleservicespecsdk.models.GetVehiclesByIdInternalServerErrorResponse;
import com.vehicleservicespecsdk.models.GetVehiclesByIdNotFoundResponse;
import com.vehicleservicespecsdk.models.GetVehiclesByIdOkResponse;
import com.vehicleservicespecsdk.models.GetVehiclesInternalServerErrorResponse;
import com.vehicleservicespecsdk.models.GetVehiclesOkResponse;
import com.vehicleservicespecsdk.models.UpdateVehiclesByIdBadRequestResponse;
import com.vehicleservicespecsdk.models.UpdateVehiclesByIdInternalServerErrorResponse;
import com.vehicleservicespecsdk.models.UpdateVehiclesByIdOkResponse;
import com.vehicleservicespecsdk.models.UpdateVehiclesByIdRequest;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import lombok.NonNull;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * VehiclesService Service
 */
public class VehiclesService extends BaseService {

  private RequestConfig getVehiclesConfig;
  private RequestConfig createVehiclesConfig;
  private RequestConfig getVehiclesByIdConfig;
  private RequestConfig updateVehiclesByIdConfig;
  private RequestConfig deleteVehiclesByIdConfig;

  /**
   * Constructs a new instance of VehiclesService.
   *
   * @param httpClient The HTTP client to use for requests
   * @param config The SDK configuration
   */
  public VehiclesService(@NonNull OkHttpClient httpClient, VehicleServiceSpecSdkConfig config) {
    super(httpClient, config);
  }

  /**
   * Sets method-level configuration for {@code getVehicles}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public VehiclesService setGetVehiclesConfig(RequestConfig config) {
    this.getVehiclesConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for {@code createVehicles}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public VehiclesService setCreateVehiclesConfig(RequestConfig config) {
    this.createVehiclesConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for {@code getVehiclesById}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public VehiclesService setGetVehiclesByIdConfig(RequestConfig config) {
    this.getVehiclesByIdConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for {@code updateVehiclesById}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public VehiclesService setUpdateVehiclesByIdConfig(RequestConfig config) {
    this.updateVehiclesByIdConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for {@code deleteVehiclesById}.
   * Method-level overrides take precedence over service-level configuration but are
   * overridden by request-level configurations.
   *
   * @param config The configuration overrides to apply at the method level
   * @return This service instance for method chaining
   */
  public VehiclesService setDeleteVehiclesByIdConfig(RequestConfig config) {
    this.deleteVehiclesByIdConfig = config;
    return this;
  }

  /**
   * Get all vehicles
   *
   * @return response of {@code List<GetVehiclesOkResponse>}
   */
  public List<GetVehiclesOkResponse> getVehicles() throws ApiError {
    return this.getVehicles(null);
  }

  /**
   * Get all vehicles
   *
   * @return response of {@code List<GetVehiclesOkResponse>}
   */
  public List<GetVehiclesOkResponse> getVehicles(RequestConfig requestConfig) throws ApiError {
    return withRawResponse().getVehicles(requestConfig).getData();
  }

  /**
   * Get all vehicles
   *
   * @return response of {@code CompletableFuture<List<GetVehiclesOkResponse>>}
   */
  public CompletableFuture<List<GetVehiclesOkResponse>> getVehiclesAsync() throws ApiError {
    return this.getVehiclesAsync(null);
  }

  /**
   * Get all vehicles
   *
   * @return response of {@code CompletableFuture<List<GetVehiclesOkResponse>>}
   */
  public CompletableFuture<List<GetVehiclesOkResponse>> getVehiclesAsync(
    RequestConfig requestConfig
  ) throws ApiError {
    return withRawResponse()
      .getVehiclesAsync(requestConfig)
      .thenApply(response -> response.getData());
  }

  private Request buildGetVehiclesRequest(RequestConfig resolvedConfig) {
    return new RequestBuilder(
      HttpMethod.GET,
      resolveBaseUrl(resolvedConfig, Environment.DEFAULT),
      "vehicles"
    ).build();
  }

  /**
   * Create a vehicle
   *
   * @return response of {@code CreateVehiclesCreatedResponse}
   */
  public CreateVehiclesCreatedResponse createVehicles() throws ApiError {
    return this.createVehicles(CreateVehiclesParameters.builder().build());
  }

  /**
   * Create a vehicle
   *
   * @param requestParameters {@link CreateVehiclesParameters} Request Parameters Object
   * @return response of {@code CreateVehiclesCreatedResponse}
   */
  public CreateVehiclesCreatedResponse createVehicles(
    @NonNull CreateVehiclesParameters requestParameters
  ) throws ApiError {
    return this.createVehicles(requestParameters, null);
  }

  /**
   * Create a vehicle
   *
   * @param requestParameters {@link CreateVehiclesParameters} Request Parameters Object
   * @return response of {@code CreateVehiclesCreatedResponse}
   */
  public CreateVehiclesCreatedResponse createVehicles(
    @NonNull CreateVehiclesParameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError {
    return withRawResponse().createVehicles(requestParameters, requestConfig).getData();
  }

  /**
   * Create a vehicle
   *
   * @return response of {@code CompletableFuture<CreateVehiclesCreatedResponse>}
   */
  public CompletableFuture<CreateVehiclesCreatedResponse> createVehiclesAsync() throws ApiError {
    return this.createVehiclesAsync(CreateVehiclesParameters.builder().build());
  }

  /**
   * Create a vehicle
   *
   * @param requestParameters {@link CreateVehiclesParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<CreateVehiclesCreatedResponse>}
   */
  public CompletableFuture<CreateVehiclesCreatedResponse> createVehiclesAsync(
    @NonNull CreateVehiclesParameters requestParameters
  ) throws ApiError {
    return this.createVehiclesAsync(requestParameters, null);
  }

  /**
   * Create a vehicle
   *
   * @param requestParameters {@link CreateVehiclesParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<CreateVehiclesCreatedResponse>}
   */
  public CompletableFuture<CreateVehiclesCreatedResponse> createVehiclesAsync(
    @NonNull CreateVehiclesParameters requestParameters,
    RequestConfig requestConfig
  ) throws ApiError {
    return withRawResponse()
      .createVehiclesAsync(requestParameters, requestConfig)
      .thenApply(response -> response.getData());
  }

  private Request buildCreateVehiclesRequest(
    @NonNull CreateVehiclesParameters requestParameters,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.POST,
      resolveBaseUrl(resolvedConfig, Environment.DEFAULT),
      "vehicles"
    )
      .setOptionalHeader("x-mock-response-code", requestParameters.getXMockResponseCode())
      .setJsonContent(requestParameters.getRequestBody())
      .build();
  }

  /**
   * Retrieve a vehicle
   *
   * @param id long
   * @return response of {@code GetVehiclesByIdOkResponse}
   */
  public GetVehiclesByIdOkResponse getVehiclesById(long id) throws ApiError {
    return this.getVehiclesById(id, null);
  }

  /**
   * Retrieve a vehicle
   *
   * @param id long
   * @return response of {@code GetVehiclesByIdOkResponse}
   */
  public GetVehiclesByIdOkResponse getVehiclesById(long id, RequestConfig requestConfig)
    throws ApiError {
    return withRawResponse().getVehiclesById(id, requestConfig).getData();
  }

  /**
   * Retrieve a vehicle
   *
   * @param id long
   * @return response of {@code CompletableFuture<GetVehiclesByIdOkResponse>}
   */
  public CompletableFuture<GetVehiclesByIdOkResponse> getVehiclesByIdAsync(long id)
    throws ApiError {
    return this.getVehiclesByIdAsync(id, null);
  }

  /**
   * Retrieve a vehicle
   *
   * @param id long
   * @return response of {@code CompletableFuture<GetVehiclesByIdOkResponse>}
   */
  public CompletableFuture<GetVehiclesByIdOkResponse> getVehiclesByIdAsync(
    long id,
    RequestConfig requestConfig
  ) throws ApiError {
    return withRawResponse()
      .getVehiclesByIdAsync(id, requestConfig)
      .thenApply(response -> response.getData());
  }

  private Request buildGetVehiclesByIdRequest(long id, RequestConfig resolvedConfig) {
    return new RequestBuilder(
      HttpMethod.GET,
      resolveBaseUrl(resolvedConfig, Environment.DEFAULT),
      "vehicles/{id}"
    )
      .setPathParameter("id", id)
      .build();
  }

  /**
   * Update a collection
   *
   * @param id long
   * @param updateVehiclesByIdRequest {@link UpdateVehiclesByIdRequest} Request Body
   * @return response of {@code UpdateVehiclesByIdOkResponse}
   */
  public UpdateVehiclesByIdOkResponse updateVehiclesById(
    long id,
    @NonNull UpdateVehiclesByIdRequest updateVehiclesByIdRequest
  ) throws ApiError {
    return this.updateVehiclesById(id, updateVehiclesByIdRequest, null);
  }

  /**
   * Update a collection
   *
   * @param id long
   * @param updateVehiclesByIdRequest {@link UpdateVehiclesByIdRequest} Request Body
   * @return response of {@code UpdateVehiclesByIdOkResponse}
   */
  public UpdateVehiclesByIdOkResponse updateVehiclesById(
    long id,
    @NonNull UpdateVehiclesByIdRequest updateVehiclesByIdRequest,
    RequestConfig requestConfig
  ) throws ApiError {
    return withRawResponse()
      .updateVehiclesById(id, updateVehiclesByIdRequest, requestConfig)
      .getData();
  }

  /**
   * Update a collection
   *
   * @param id long
   * @param updateVehiclesByIdRequest {@link UpdateVehiclesByIdRequest} Request Body
   * @return response of {@code CompletableFuture<UpdateVehiclesByIdOkResponse>}
   */
  public CompletableFuture<UpdateVehiclesByIdOkResponse> updateVehiclesByIdAsync(
    long id,
    @NonNull UpdateVehiclesByIdRequest updateVehiclesByIdRequest
  ) throws ApiError {
    return this.updateVehiclesByIdAsync(id, updateVehiclesByIdRequest, null);
  }

  /**
   * Update a collection
   *
   * @param id long
   * @param updateVehiclesByIdRequest {@link UpdateVehiclesByIdRequest} Request Body
   * @return response of {@code CompletableFuture<UpdateVehiclesByIdOkResponse>}
   */
  public CompletableFuture<UpdateVehiclesByIdOkResponse> updateVehiclesByIdAsync(
    long id,
    @NonNull UpdateVehiclesByIdRequest updateVehiclesByIdRequest,
    RequestConfig requestConfig
  ) throws ApiError {
    return withRawResponse()
      .updateVehiclesByIdAsync(id, updateVehiclesByIdRequest, requestConfig)
      .thenApply(response -> response.getData());
  }

  private Request buildUpdateVehiclesByIdRequest(
    long id,
    @NonNull UpdateVehiclesByIdRequest updateVehiclesByIdRequest,
    RequestConfig resolvedConfig
  ) {
    return new RequestBuilder(
      HttpMethod.PATCH,
      resolveBaseUrl(resolvedConfig, Environment.DEFAULT),
      "vehicles/{id}"
    )
      .setPathParameter("id", id)
      .setJsonContent(updateVehiclesByIdRequest)
      .build();
  }

  /**
   * Delete a vehicle
   *
   * @param id long
   * @return response of {@code void}
   */
  public void deleteVehiclesById(long id) throws ApiError {
    this.deleteVehiclesById(id, null);
  }

  /**
   * Delete a vehicle
   *
   * @param id long
   * @return response of {@code void}
   */
  public void deleteVehiclesById(long id, RequestConfig requestConfig) throws ApiError {
    withRawResponse().deleteVehiclesById(id, requestConfig);
  }

  /**
   * Delete a vehicle
   *
   * @param id long
   * @return response of {@code CompletableFuture<Void>}
   */
  public CompletableFuture<Void> deleteVehiclesByIdAsync(long id) throws ApiError {
    return this.deleteVehiclesByIdAsync(id, null);
  }

  /**
   * Delete a vehicle
   *
   * @param id long
   * @return response of {@code CompletableFuture<Void>}
   */
  public CompletableFuture<Void> deleteVehiclesByIdAsync(long id, RequestConfig requestConfig)
    throws ApiError {
    return withRawResponse()
      .deleteVehiclesByIdAsync(id, requestConfig)
      .thenApply(response -> response.getData());
  }

  private Request buildDeleteVehiclesByIdRequest(long id, RequestConfig resolvedConfig) {
    return new RequestBuilder(
      HttpMethod.DELETE,
      resolveBaseUrl(resolvedConfig, Environment.DEFAULT),
      "vehicles/{id}"
    )
      .setPathParameter("id", id)
      .build();
  }

  /**
   * Returns an accessor whose methods mirror this service but return the full HTTP response
   * (status code, headers, and raw body) wrapped alongside the parsed data.
   *
   * @return An accessor exposing raw-response variants of this service's methods
   */
  public WithRawResponse withRawResponse() {
    return new WithRawResponse();
  }

  /**
   * Per-call accessor exposing raw-response variants of {@link VehiclesService}'s methods.
   * Reuses the enclosing service's request builders and configuration.
   */
  public class WithRawResponse {

    /**
     * Get all vehicles
     *
     * @return response of {@code VehicleServiceSpecSdkResponse<List<GetVehiclesOkResponse>>}
     */
    public VehicleServiceSpecSdkResponse<List<GetVehiclesOkResponse>> getVehicles()
      throws ApiError {
      return this.getVehicles(null);
    }

    /**
     * Get all vehicles
     *
     * @return response of {@code VehicleServiceSpecSdkResponse<List<GetVehiclesOkResponse>>}
     */
    public VehicleServiceSpecSdkResponse<List<GetVehiclesOkResponse>> getVehicles(
      RequestConfig requestConfig
    ) throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(getVehiclesConfig, requestConfig);
      addErrorMapping(
        500,
        GetVehiclesInternalServerErrorResponse.class,
        (message, code, body, headers) -> new InternalServerError(message, body, headers)
      );
      Request request = buildGetVehiclesRequest(resolvedConfig);
      Response response = execute(request, resolvedConfig);
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return new VehicleServiceSpecSdkResponse<>(
        response,
        bodyBytes,
        ModelConverter.convert(bodyBytes, new TypeReference<List<GetVehiclesOkResponse>>() {})
      );
    }

    /**
     * Get all vehicles
     *
     * @return response of {@code CompletableFuture<VehicleServiceSpecSdkResponse<List<GetVehiclesOkResponse>>>}
     */
    public CompletableFuture<
      VehicleServiceSpecSdkResponse<List<GetVehiclesOkResponse>>
    > getVehiclesAsync() throws ApiError {
      return this.getVehiclesAsync(null);
    }

    /**
     * Get all vehicles
     *
     * @return response of {@code CompletableFuture<VehicleServiceSpecSdkResponse<List<GetVehiclesOkResponse>>>}
     */
    public CompletableFuture<
      VehicleServiceSpecSdkResponse<List<GetVehiclesOkResponse>>
    > getVehiclesAsync(RequestConfig requestConfig) throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(getVehiclesConfig, requestConfig);
      addErrorMapping(
        500,
        GetVehiclesInternalServerErrorResponse.class,
        (message, code, body, headers) -> new InternalServerError(message, body, headers)
      );
      Request request = buildGetVehiclesRequest(resolvedConfig);
      CompletableFuture<Response> futureResponse = executeAsync(request, resolvedConfig);
      return futureResponse.thenApplyAsync(response -> {
        byte[] bodyBytes = ModelConverter.readBytes(response);
        return new VehicleServiceSpecSdkResponse<>(
          response,
          bodyBytes,
          ModelConverter.convert(bodyBytes, new TypeReference<List<GetVehiclesOkResponse>>() {})
        );
      });
    }

    /**
     * Create a vehicle
     *
     * @return response of {@code VehicleServiceSpecSdkResponse<CreateVehiclesCreatedResponse>}
     */
    public VehicleServiceSpecSdkResponse<CreateVehiclesCreatedResponse> createVehicles()
      throws ApiError {
      return this.createVehicles(CreateVehiclesParameters.builder().build());
    }

    /**
     * Create a vehicle
     *
     * @param requestParameters {@link CreateVehiclesParameters} Request Parameters Object
     * @return response of {@code VehicleServiceSpecSdkResponse<CreateVehiclesCreatedResponse>}
     */
    public VehicleServiceSpecSdkResponse<CreateVehiclesCreatedResponse> createVehicles(
      @NonNull CreateVehiclesParameters requestParameters
    ) throws ApiError {
      return this.createVehicles(requestParameters, null);
    }

    /**
     * Create a vehicle
     *
     * @param requestParameters {@link CreateVehiclesParameters} Request Parameters Object
     * @return response of {@code VehicleServiceSpecSdkResponse<CreateVehiclesCreatedResponse>}
     */
    public VehicleServiceSpecSdkResponse<CreateVehiclesCreatedResponse> createVehicles(
      @NonNull CreateVehiclesParameters requestParameters,
      RequestConfig requestConfig
    ) throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(createVehiclesConfig, requestConfig);
      addErrorMapping(400, CreateVehiclesBadRequestResponse.class, (message, code, body, headers) ->
        new BadRequestError(message, body, headers)
      );
      addErrorMapping(409, CreateVehiclesConflictResponse.class, (message, code, body, headers) ->
        new ConflictError(message, (CreateVehiclesConflictResponse) body, headers)
      );
      addErrorMapping(
        500,
        CreateVehiclesInternalServerErrorResponse.class,
        (message, code, body, headers) -> new InternalServerError(message, body, headers)
      );
      Request request = buildCreateVehiclesRequest(requestParameters, resolvedConfig);
      Response response = execute(request, resolvedConfig);
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return new VehicleServiceSpecSdkResponse<>(
        response,
        bodyBytes,
        ModelConverter.convert(bodyBytes, new TypeReference<CreateVehiclesCreatedResponse>() {})
      );
    }

    /**
     * Create a vehicle
     *
     * @return response of {@code CompletableFuture<VehicleServiceSpecSdkResponse<CreateVehiclesCreatedResponse>>}
     */
    public CompletableFuture<
      VehicleServiceSpecSdkResponse<CreateVehiclesCreatedResponse>
    > createVehiclesAsync() throws ApiError {
      return this.createVehiclesAsync(CreateVehiclesParameters.builder().build());
    }

    /**
     * Create a vehicle
     *
     * @param requestParameters {@link CreateVehiclesParameters} Request Parameters Object
     * @return response of {@code CompletableFuture<VehicleServiceSpecSdkResponse<CreateVehiclesCreatedResponse>>}
     */
    public CompletableFuture<
      VehicleServiceSpecSdkResponse<CreateVehiclesCreatedResponse>
    > createVehiclesAsync(@NonNull CreateVehiclesParameters requestParameters) throws ApiError {
      return this.createVehiclesAsync(requestParameters, null);
    }

    /**
     * Create a vehicle
     *
     * @param requestParameters {@link CreateVehiclesParameters} Request Parameters Object
     * @return response of {@code CompletableFuture<VehicleServiceSpecSdkResponse<CreateVehiclesCreatedResponse>>}
     */
    public CompletableFuture<
      VehicleServiceSpecSdkResponse<CreateVehiclesCreatedResponse>
    > createVehiclesAsync(
      @NonNull CreateVehiclesParameters requestParameters,
      RequestConfig requestConfig
    ) throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(createVehiclesConfig, requestConfig);
      addErrorMapping(400, CreateVehiclesBadRequestResponse.class, (message, code, body, headers) ->
        new BadRequestError(message, body, headers)
      );
      addErrorMapping(409, CreateVehiclesConflictResponse.class, (message, code, body, headers) ->
        new ConflictError(message, (CreateVehiclesConflictResponse) body, headers)
      );
      addErrorMapping(
        500,
        CreateVehiclesInternalServerErrorResponse.class,
        (message, code, body, headers) -> new InternalServerError(message, body, headers)
      );
      Request request = buildCreateVehiclesRequest(requestParameters, resolvedConfig);
      CompletableFuture<Response> futureResponse = executeAsync(request, resolvedConfig);
      return futureResponse.thenApplyAsync(response -> {
        byte[] bodyBytes = ModelConverter.readBytes(response);
        return new VehicleServiceSpecSdkResponse<>(
          response,
          bodyBytes,
          ModelConverter.convert(bodyBytes, new TypeReference<CreateVehiclesCreatedResponse>() {})
        );
      });
    }

    /**
     * Retrieve a vehicle
     *
     * @param id long
     * @return response of {@code VehicleServiceSpecSdkResponse<GetVehiclesByIdOkResponse>}
     */
    public VehicleServiceSpecSdkResponse<GetVehiclesByIdOkResponse> getVehiclesById(long id)
      throws ApiError {
      return this.getVehiclesById(id, null);
    }

    /**
     * Retrieve a vehicle
     *
     * @param id long
     * @return response of {@code VehicleServiceSpecSdkResponse<GetVehiclesByIdOkResponse>}
     */
    public VehicleServiceSpecSdkResponse<GetVehiclesByIdOkResponse> getVehiclesById(
      long id,
      RequestConfig requestConfig
    ) throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(getVehiclesByIdConfig, requestConfig);
      addErrorMapping(404, GetVehiclesByIdNotFoundResponse.class, (message, code, body, headers) ->
        new NotFoundError(message, (GetVehiclesByIdNotFoundResponse) body, headers)
      );
      addErrorMapping(
        500,
        GetVehiclesByIdInternalServerErrorResponse.class,
        (message, code, body, headers) -> new InternalServerError(message, body, headers)
      );
      Request request = buildGetVehiclesByIdRequest(id, resolvedConfig);
      Response response = execute(request, resolvedConfig);
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return new VehicleServiceSpecSdkResponse<>(
        response,
        bodyBytes,
        ModelConverter.convert(bodyBytes, new TypeReference<GetVehiclesByIdOkResponse>() {})
      );
    }

    /**
     * Retrieve a vehicle
     *
     * @param id long
     * @return response of {@code CompletableFuture<VehicleServiceSpecSdkResponse<GetVehiclesByIdOkResponse>>}
     */
    public CompletableFuture<
      VehicleServiceSpecSdkResponse<GetVehiclesByIdOkResponse>
    > getVehiclesByIdAsync(long id) throws ApiError {
      return this.getVehiclesByIdAsync(id, null);
    }

    /**
     * Retrieve a vehicle
     *
     * @param id long
     * @return response of {@code CompletableFuture<VehicleServiceSpecSdkResponse<GetVehiclesByIdOkResponse>>}
     */
    public CompletableFuture<
      VehicleServiceSpecSdkResponse<GetVehiclesByIdOkResponse>
    > getVehiclesByIdAsync(long id, RequestConfig requestConfig) throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(getVehiclesByIdConfig, requestConfig);
      addErrorMapping(404, GetVehiclesByIdNotFoundResponse.class, (message, code, body, headers) ->
        new NotFoundError(message, (GetVehiclesByIdNotFoundResponse) body, headers)
      );
      addErrorMapping(
        500,
        GetVehiclesByIdInternalServerErrorResponse.class,
        (message, code, body, headers) -> new InternalServerError(message, body, headers)
      );
      Request request = buildGetVehiclesByIdRequest(id, resolvedConfig);
      CompletableFuture<Response> futureResponse = executeAsync(request, resolvedConfig);
      return futureResponse.thenApplyAsync(response -> {
        byte[] bodyBytes = ModelConverter.readBytes(response);
        return new VehicleServiceSpecSdkResponse<>(
          response,
          bodyBytes,
          ModelConverter.convert(bodyBytes, new TypeReference<GetVehiclesByIdOkResponse>() {})
        );
      });
    }

    /**
     * Update a collection
     *
     * @param id long
     * @param updateVehiclesByIdRequest {@link UpdateVehiclesByIdRequest} Request Body
     * @return response of {@code VehicleServiceSpecSdkResponse<UpdateVehiclesByIdOkResponse>}
     */
    public VehicleServiceSpecSdkResponse<UpdateVehiclesByIdOkResponse> updateVehiclesById(
      long id,
      @NonNull UpdateVehiclesByIdRequest updateVehiclesByIdRequest
    ) throws ApiError {
      return this.updateVehiclesById(id, updateVehiclesByIdRequest, null);
    }

    /**
     * Update a collection
     *
     * @param id long
     * @param updateVehiclesByIdRequest {@link UpdateVehiclesByIdRequest} Request Body
     * @return response of {@code VehicleServiceSpecSdkResponse<UpdateVehiclesByIdOkResponse>}
     */
    public VehicleServiceSpecSdkResponse<UpdateVehiclesByIdOkResponse> updateVehiclesById(
      long id,
      @NonNull UpdateVehiclesByIdRequest updateVehiclesByIdRequest,
      RequestConfig requestConfig
    ) throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(updateVehiclesByIdConfig, requestConfig);
      addErrorMapping(
        400,
        UpdateVehiclesByIdBadRequestResponse.class,
        (message, code, body, headers) -> new BadRequestError(message, body, headers)
      );
      addErrorMapping(
        500,
        UpdateVehiclesByIdInternalServerErrorResponse.class,
        (message, code, body, headers) -> new InternalServerError(message, body, headers)
      );
      Request request = buildUpdateVehiclesByIdRequest(
        id,
        updateVehiclesByIdRequest,
        resolvedConfig
      );
      Response response = execute(request, resolvedConfig);
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return new VehicleServiceSpecSdkResponse<>(
        response,
        bodyBytes,
        ModelConverter.convert(bodyBytes, new TypeReference<UpdateVehiclesByIdOkResponse>() {})
      );
    }

    /**
     * Update a collection
     *
     * @param id long
     * @param updateVehiclesByIdRequest {@link UpdateVehiclesByIdRequest} Request Body
     * @return response of {@code CompletableFuture<VehicleServiceSpecSdkResponse<UpdateVehiclesByIdOkResponse>>}
     */
    public CompletableFuture<
      VehicleServiceSpecSdkResponse<UpdateVehiclesByIdOkResponse>
    > updateVehiclesByIdAsync(
      long id,
      @NonNull UpdateVehiclesByIdRequest updateVehiclesByIdRequest
    ) throws ApiError {
      return this.updateVehiclesByIdAsync(id, updateVehiclesByIdRequest, null);
    }

    /**
     * Update a collection
     *
     * @param id long
     * @param updateVehiclesByIdRequest {@link UpdateVehiclesByIdRequest} Request Body
     * @return response of {@code CompletableFuture<VehicleServiceSpecSdkResponse<UpdateVehiclesByIdOkResponse>>}
     */
    public CompletableFuture<
      VehicleServiceSpecSdkResponse<UpdateVehiclesByIdOkResponse>
    > updateVehiclesByIdAsync(
      long id,
      @NonNull UpdateVehiclesByIdRequest updateVehiclesByIdRequest,
      RequestConfig requestConfig
    ) throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(updateVehiclesByIdConfig, requestConfig);
      addErrorMapping(
        400,
        UpdateVehiclesByIdBadRequestResponse.class,
        (message, code, body, headers) -> new BadRequestError(message, body, headers)
      );
      addErrorMapping(
        500,
        UpdateVehiclesByIdInternalServerErrorResponse.class,
        (message, code, body, headers) -> new InternalServerError(message, body, headers)
      );
      Request request = buildUpdateVehiclesByIdRequest(
        id,
        updateVehiclesByIdRequest,
        resolvedConfig
      );
      CompletableFuture<Response> futureResponse = executeAsync(request, resolvedConfig);
      return futureResponse.thenApplyAsync(response -> {
        byte[] bodyBytes = ModelConverter.readBytes(response);
        return new VehicleServiceSpecSdkResponse<>(
          response,
          bodyBytes,
          ModelConverter.convert(bodyBytes, new TypeReference<UpdateVehiclesByIdOkResponse>() {})
        );
      });
    }

    /**
     * Delete a vehicle
     *
     * @param id long
     * @return response of {@code VehicleServiceSpecSdkResponse<Void>}
     */
    public VehicleServiceSpecSdkResponse<Void> deleteVehiclesById(long id) throws ApiError {
      return this.deleteVehiclesById(id, null);
    }

    /**
     * Delete a vehicle
     *
     * @param id long
     * @return response of {@code VehicleServiceSpecSdkResponse<Void>}
     */
    public VehicleServiceSpecSdkResponse<Void> deleteVehiclesById(
      long id,
      RequestConfig requestConfig
    ) throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(deleteVehiclesByIdConfig, requestConfig);
      addErrorMapping(
        500,
        DeleteVehiclesByIdInternalServerErrorResponse.class,
        (message, code, body, headers) -> new InternalServerError(message, body, headers)
      );
      Request request = buildDeleteVehiclesByIdRequest(id, resolvedConfig);
      Response response = execute(request, resolvedConfig);
      byte[] bodyBytes = ModelConverter.readBytes(response);
      return new VehicleServiceSpecSdkResponse<Void>(response, bodyBytes, null);
    }

    /**
     * Delete a vehicle
     *
     * @param id long
     * @return response of {@code CompletableFuture<VehicleServiceSpecSdkResponse<Void>>}
     */
    public CompletableFuture<VehicleServiceSpecSdkResponse<Void>> deleteVehiclesByIdAsync(long id)
      throws ApiError {
      return this.deleteVehiclesByIdAsync(id, null);
    }

    /**
     * Delete a vehicle
     *
     * @param id long
     * @return response of {@code CompletableFuture<VehicleServiceSpecSdkResponse<Void>>}
     */
    public CompletableFuture<VehicleServiceSpecSdkResponse<Void>> deleteVehiclesByIdAsync(
      long id,
      RequestConfig requestConfig
    ) throws ApiError {
      RequestConfig resolvedConfig = getResolvedConfig(deleteVehiclesByIdConfig, requestConfig);
      addErrorMapping(
        500,
        DeleteVehiclesByIdInternalServerErrorResponse.class,
        (message, code, body, headers) -> new InternalServerError(message, body, headers)
      );
      Request request = buildDeleteVehiclesByIdRequest(id, resolvedConfig);
      return executeAsync(request, resolvedConfig).thenApplyAsync(response -> null);
    }
  }
}
