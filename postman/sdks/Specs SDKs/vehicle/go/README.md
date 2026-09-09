# VehicleServiceSpecSDK Go SDK 1.0.0

Welcome to the VehicleServiceSpecSDK SDK documentation. This guide will help you get started with integrating and using the VehicleServiceSpecSDK SDK in your project.

## Versions

- SDK version: `1.0.0`

## About the API

this is my vehicle service description

## Table of Contents

- [Setup & Configuration](#setup--configuration)
  - [Supported Language Versions](#supported-language-versions)
- [Setting a Custom Timeout](#setting-a-custom-timeout)
- [Sample Usage](#sample-usage)
- [Services](#services)
  - [Response Wrappers](#response-wrappers)
- [Models](#models)

# Setup & Configuration

## Supported Language Versions

This SDK is compatible with the following versions: `Go >= 1.19.0`

## Setting a Custom Timeout

You can set a custom timeout for the SDK's HTTP requests as follows:

```go
import "time"

config := vehicleservicespecsdk.NewConfig()

sdk := vehicleservicespecsdk.NewVehicleServiceSpecSDK(config)

sdk.SetTimeout(10 * time.Second)
```

# Sample Usage

Below is a comprehensive example demonstrating how to authenticate and call a simple endpoint:

```go
import (
  "fmt"
  "encoding/json"
  "context"
  "example.com/vehicle-service-spec-sdk"
)

config := vehicleservicespecsdk.NewConfig()

client := vehicleservicespecsdk.NewVehicleServiceSpecSDK(config)

response, err := client.Vehicles.GetVehicles(context.Background())
if err != nil {
  panic(err)
}

fmt.Println(response)

```

## Services

The SDK provides various services to interact with the API.

<details>
<summary>Below is a list of all available services with links to their detailed documentation:</summary>

| Name                                           |
| :--------------------------------------------- |
| [Vehicles](documentation/services/vehicles.md) |

</details>

### Response Wrappers

All services use response wrappers to provide a consistent interface to return the responses from the API.

The response wrapper itself is a generic struct that contains the response data and metadata.

<details>
<summary>Below are the response wrappers used in the SDK:</summary>

#### `VehicleServiceSpecSDKResponse[T]`

This response wrapper is used to return the response data from the API. It contains the following fields:

| Name     | Type                                    | Description                                 |
| :------- | :-------------------------------------- | :------------------------------------------ |
| Data     | `T`                                     | The body of the API response                |
| Metadata | `VehicleServiceSpecSDKResponseMetadata` | Status code and headers returned by the API |

#### `VehicleServiceSpecSDKError[T]`

This response wrapper is used to return an error. It contains the following fields:

| Name     | Type                                 | Description                                                       |
| :------- | :----------------------------------- | :---------------------------------------------------------------- |
| Err      | `error`                              | The error that occurred                                           |
| Data     | `*T`                                 | The deserialized error response data (nil if unmarshaling failed) |
| Body     | `[]byte`                             | The raw body of the API response                                  |
| Metadata | `VehicleServiceSpecSDKErrorMetadata` | Status code and headers returned by the API                       |

#### `VehicleServiceSpecSDKResponseMetadata`

This struct is shared by both response wrappers and contains the following fields:

| Name       | Type                | Description                                      |
| :--------- | :------------------ | :----------------------------------------------- |
| Headers    | `map[string]string` | A map containing the headers returned by the API |
| StatusCode | `int`               | The status code returned by the API              |

</details>

## Models

The SDK includes several models that represent the data structures used in API requests and responses. These models help in organizing and managing the data efficiently.

<details>
<summary>Below is a list of all available models with links to their detailed documentation:</summary>

| Name                                                                                      | Description |
| :---------------------------------------------------------------------------------------- | :---------- |
| [GetVehiclesOkResponse](documentation/models/get_vehicles_ok_response.md)                 |             |
| [CreateVehiclesCreatedResponse](documentation/models/create_vehicles_created_response.md) |             |
| [CreateVehiclesRequest](documentation/models/create_vehicles_request.md)                  |             |
| [GetVehiclesByIDOkResponse](documentation/models/get_vehicles_by_id_ok_response.md)       |             |
| [UpdateVehiclesByIDOkResponse](documentation/models/update_vehicles_by_id_ok_response.md) |             |
| [UpdateVehiclesByIDRequest](documentation/models/update_vehicles_by_id_request.md)        |             |

</details>
