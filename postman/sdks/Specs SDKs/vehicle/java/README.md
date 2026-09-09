# VehicleServiceSpecSdk Java SDK 1.0.0

Welcome to the VehicleServiceSpecSdk SDK documentation. This guide will help you get started with integrating and using the VehicleServiceSpecSdk SDK in your project.

## Versions

- SDK version: `1.0.0`

## About the API

this is my vehicle service description

## Table of Contents

- [Setup & Configuration](#setup--configuration)
  - [Supported Language Versions](#supported-language-versions)
  - [Installation](#installation)
- [Setting a Custom Timeout](#setting-a-custom-timeout)
- [Injecting a Custom HTTP Client](#injecting-a-custom-http-client)
- [Accessing the Raw HTTP Response](#accessing-the-raw-http-response)
- [Sample Usage](#sample-usage)
- [Services](#services)
- [Models](#models)

# Setup & Configuration

## Supported Language Versions

This SDK is compatible with the following versions: `Java >= 1.8`

## Installation

If you use Maven, place the following within the _dependency_ tag in your `pom.xml` file:

```XML
<dependency>
    <groupId>com</groupId>
    <artifactId>vehicleservicespecsdk</artifactId>
    <version>1.0.0</version>
</dependency>
```

If you use Gradle, paste the next line inside the _dependencies_ block of your `build.gradle` file:

```Gradle
implementation("com:vehicleservicespecsdk:1.0.0")
```

If you use JAR files, package the SDK by running the following command:

```shell
mvn compile assembly:single
```

Then, add the JAR file to your project's classpath.

## Setting a Custom Timeout

You can set a custom timeout for the SDK's HTTP requests as follows:

```java
import com.vehicleservicespecsdk.VehicleServiceSpecSdk;
import com.vehicleservicespecsdk.config.VehicleServiceSpecSdkConfig;

public class Main {

  public static void main(String[] args) {
    VehicleServiceSpecSdkConfig config = VehicleServiceSpecSdkConfig.builder()
      .timeout(10000)
      .build();
    VehicleServiceSpecSdk vehicleServiceSpecSdk = new VehicleServiceSpecSdk(config);
  }
}

```

## Injecting a Custom HTTP Client

You can supply your own `OkHttpClient` — for example to configure a proxy, a shared connection pool, custom TLS, timeouts, or your own interceptors. The SDK derives its client from the one you provide (preserving your transport settings and interceptors) and layers its own interceptors (such as authentication and retry) on top, so the SDK keeps working as usual.

```java
OkHttpClient customClient = new OkHttpClient.Builder().addInterceptor(new MyInterceptor()).build();

VehicleServiceSpecSdk vehicleServiceSpecSdk = new VehicleServiceSpecSdk(
  VehicleServiceSpecSdkConfig.builder().httpClient(customClient).build()
);

```

`MyInterceptor` above is a placeholder for your own `okhttp3.Interceptor`.

> Your client's interceptors are added ahead of the SDK's, so on the outbound request they run before the SDK adds its own headers. A logging interceptor placed this way will **not** see SDK-injected headers such as authentication.

> **Timeout precedence:** when you inject a client, the config-level `timeout` is not applied — your client's own timeout settings are preserved. Per-request, method, and service-level timeout overrides still apply, layered on top of your client.

## Accessing the Raw HTTP Response

Every service method returns the parsed response body by default. When you also need the status code, response headers, or the raw HTTP response, call the same method through the per-call `withRawResponse()` accessor. The default methods are unchanged, so this is fully opt-in.

```java
VehicleServiceSpecSdkResponse<List<GetVehiclesOkResponse>> response =
    vehicleServiceSpecSdk.vehicles.withRawResponse().getVehicles();

response.getData();
response.getMetadata().getStatusCode();
response.getMetadata().getHeaders();
response.getRaw();
```

`getData()` returns the same value the default method would; `getMetadata()` exposes the status code and headers, and `getRaw()` exposes the underlying HTTP response.

# Sample Usage

Below is a comprehensive example demonstrating how to authenticate and call a simple endpoint:

```java
import com.vehicleservicespecsdk.VehicleServiceSpecSdk;
import com.vehicleservicespecsdk.exceptions.ApiError;
import com.vehicleservicespecsdk.models.GetVehiclesOkResponse;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    VehicleServiceSpecSdk vehicleServiceSpecSdk = new VehicleServiceSpecSdk();

    try {
      List<GetVehiclesOkResponse> response = vehicleServiceSpecSdk.vehicles.getVehicles();

      System.out.println(response);
    } catch (ApiError e) {
      e.printStackTrace();
    }

    System.exit(0);
  }
}

```

## Services

The SDK provides various services to interact with the API.

<details>
<summary>Below is a list of all available services with links to their detailed documentation:</summary>

| Name                                                         |
| :----------------------------------------------------------- |
| [VehiclesService](documentation/services/VehiclesService.md) |

</details>

## Models

The SDK includes several models that represent the data structures used in API requests and responses. These models help in organizing and managing the data efficiently.

<details>
<summary>Below is a list of all available models with links to their detailed documentation:</summary>

| Name                                                                                                                   | Description |
| :--------------------------------------------------------------------------------------------------------------------- | :---------- |
| [GetVehiclesOkResponse](documentation/models/GetVehiclesOkResponse.md)                                                 |             |
| [CreateVehiclesCreatedResponse](documentation/models/CreateVehiclesCreatedResponse.md)                                 |             |
| [CreateVehiclesRequest](documentation/models/CreateVehiclesRequest.md)                                                 |             |
| [CreateVehiclesParameters](documentation/models/CreateVehiclesParameters.md)                                           |             |
| [GetVehiclesByIdOkResponse](documentation/models/GetVehiclesByIdOkResponse.md)                                         |             |
| [UpdateVehiclesByIdOkResponse](documentation/models/UpdateVehiclesByIdOkResponse.md)                                   |             |
| [UpdateVehiclesByIdRequest](documentation/models/UpdateVehiclesByIdRequest.md)                                         |             |
| [GetVehiclesInternalServerErrorResponse](documentation/models/GetVehiclesInternalServerErrorResponse.md)               |             |
| [CreateVehiclesBadRequestResponse](documentation/models/CreateVehiclesBadRequestResponse.md)                           |             |
| [CreateVehiclesConflictResponse](documentation/models/CreateVehiclesConflictResponse.md)                               |             |
| [CreateVehiclesInternalServerErrorResponse](documentation/models/CreateVehiclesInternalServerErrorResponse.md)         |             |
| [GetVehiclesByIdNotFoundResponse](documentation/models/GetVehiclesByIdNotFoundResponse.md)                             |             |
| [GetVehiclesByIdInternalServerErrorResponse](documentation/models/GetVehiclesByIdInternalServerErrorResponse.md)       |             |
| [UpdateVehiclesByIdBadRequestResponse](documentation/models/UpdateVehiclesByIdBadRequestResponse.md)                   |             |
| [UpdateVehiclesByIdInternalServerErrorResponse](documentation/models/UpdateVehiclesByIdInternalServerErrorResponse.md) |             |
| [DeleteVehiclesByIdInternalServerErrorResponse](documentation/models/DeleteVehiclesByIdInternalServerErrorResponse.md) |             |

</details>
