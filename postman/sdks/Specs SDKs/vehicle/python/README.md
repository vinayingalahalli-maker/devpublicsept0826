# VehicleServiceSpecSdk Python SDK 1.0.0

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
- [Sample Usage](#sample-usage)
- [Async Usage](#async-usage)
- [Services](#services)
- [Models](#models)

# Setup & Configuration

## Supported Language Versions

This SDK is compatible with the following versions: `Python >= 3.9`

## Installation

To get started with the SDK, we recommend installing using `pip`:

```bash
pip install vehicle_service_spec_sdk
```

If you are using Python 3, you can use `pip3` instead:

```bash
pip3 install vehicle_service_spec_sdk
```

## Setting a Custom Timeout

You can set a custom timeout for the SDK's HTTP requests as follows:

```py
from vehicle_service_spec_sdk import VehicleServiceSpecSdk

sdk = VehicleServiceSpecSdk(timeout=10)
```

# Sample Usage

Below is a comprehensive example demonstrating how to authenticate and call a simple endpoint:

```py
from vehicle_service_spec_sdk import VehicleServiceSpecSdk

sdk = VehicleServiceSpecSdk(
    timeout=10
)

result = sdk.vehicles.get_vehicles()

print(result)

```

# Async Usage

The SDK includes an Async Client for making asynchronous API requests. This is useful for applications that need non-blocking operations, like web servers or apps with a graphical user interface.

```py
import asyncio
from vehicle_service_spec_sdk import VehicleServiceSpecSdkAsync

sdk = VehicleServiceSpecSdkAsync(
    timeout=10
)


async def main():
  result = await sdk.vehicles.get_vehicles()
  print(result)

asyncio.run(main())
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
| [CreateVehiclesRequest](documentation/models/CreateVehiclesRequest.md)                                                 |             |
| [CreateVehiclesCreatedResponse](documentation/models/CreateVehiclesCreatedResponse.md)                                 |             |
| [GetVehiclesByIdOkResponse](documentation/models/GetVehiclesByIdOkResponse.md)                                         |             |
| [UpdateVehiclesByIdRequest](documentation/models/UpdateVehiclesByIdRequest.md)                                         |             |
| [UpdateVehiclesByIdOkResponse](documentation/models/UpdateVehiclesByIdOkResponse.md)                                   |             |
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
