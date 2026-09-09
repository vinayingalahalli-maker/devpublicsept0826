package com.vehicleservicespecsdk;

import com.vehicleservicespecsdk.config.VehicleServiceSpecSdkConfig;
import com.vehicleservicespecsdk.http.Environment;
import com.vehicleservicespecsdk.http.interceptors.DefaultHeadersInterceptor;
import com.vehicleservicespecsdk.http.interceptors.LoggingInterceptor;
import com.vehicleservicespecsdk.http.interceptors.RetryInterceptor;
import com.vehicleservicespecsdk.logging.Logger;
import com.vehicleservicespecsdk.services.VehiclesService;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;

/**
 * this is my vehicle service description
 */
public class VehicleServiceSpecSdk {

  public final VehiclesService vehicles;

  private final VehicleServiceSpecSdkConfig config;

  /**
   * Constructs a new instance of VehicleServiceSpecSdk with default configuration.
   */
  public VehicleServiceSpecSdk() {
    // Default configs
    this(VehicleServiceSpecSdkConfig.builder().build());
  }

  /**
   * Constructs a new instance of VehicleServiceSpecSdk with custom configuration.
   * Initializes all services, HTTP client, and optional OAuth token manager.
   *
   * @param config The SDK configuration including base URL, authentication, timeout, and retry settings
   */
  public VehicleServiceSpecSdk(VehicleServiceSpecSdkConfig config) {
    this.config = config;

    // A user-supplied client is augmented (not replaced): the SDK derives its client from
    // the injected instance so its transport settings and interceptors are preserved, then
    // layers the SDK's own interceptors on top.
    final OkHttpClient customHttpClient = config.getHttpClient();
    final OkHttpClient.Builder httpClientBuilder =
      (customHttpClient != null
          ? customHttpClient.newBuilder()
          : new OkHttpClient.Builder()).addInterceptor(new DefaultHeadersInterceptor(config))
        .addInterceptor(new RetryInterceptor(config.getRetryConfig()))
        // Logging is added last so it observes the fully-decorated request (auth headers
        // included, then redacted). Silent by default — see LogConfig.
        .addInterceptor(new LoggingInterceptor(Logger.from(config.getLogConfig())));

    // Only apply the SDK's default read timeout when building the client ourselves; a
    // user-supplied client owns its own transport (timeout) settings.
    if (customHttpClient == null) {
      httpClientBuilder.readTimeout(config.getTimeout(), TimeUnit.MILLISECONDS);
    }

    final OkHttpClient httpClient = httpClientBuilder.build();

    this.vehicles = new VehiclesService(httpClient, config);
  }

  /**
   * Sets the environment for all API requests.
   *
   * @param environment The environment to use (e.g., DEFAULT, PRODUCTION, STAGING)
   */
  public void setEnvironment(Environment environment) {
    setBaseUrl(environment.getUrl());
  }

  /**
   * Sets the base URL for all API requests.
   *
   * @param baseUrl The base URL to use for API requests
   */
  public void setBaseUrl(String baseUrl) {
    this.config.setBaseUrl(baseUrl);
  }
}
// c029837e0e474b76bc487506e8799df5e3335891efe4fb02bda7a1441840310c
