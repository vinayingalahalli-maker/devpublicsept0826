# VehicleServiceSpecSdk TypeScript SDK 1.0.0

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
- [Services](#services)
- [Models](#models)

# Setup & Configuration

## Supported Language Versions

This SDK is compatible with the following versions: `TypeScript >= 4.8.4`

## Installation

To get started with the SDK, we recommend installing using `npm` or `yarn`:

```bash
npm install vehicle-service-spec-sdk
```

or

```bash
yarn add vehicle-service-spec-sdk
```

## Setting a Custom Timeout

You can set a custom timeout for the SDK's HTTP requests as follows:

```ts
const vehicleServiceSpecSdk = new VehicleServiceSpecSdk({ timeout: 10000 });
```

# Sample Usage

Below is a comprehensive example demonstrating how to authenticate and call a simple endpoint:

```ts
import { VehicleServiceSpecSdk } from 'vehicle-service-spec-sdk';

(async () => {
  const vehicleServiceSpecSdk = new VehicleServiceSpecSdk({});

  const data = await vehicleServiceSpecSdk.vehicles.getVehicles();

  console.log(data);
})();
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
| [GetVehiclesInternalServerErrorResponse](documentation/models/GetVehiclesInternalServerErrorResponse.md)               |             |
| [CreateVehiclesCreatedResponse](documentation/models/CreateVehiclesCreatedResponse.md)                                 |             |
| [CreateVehiclesRequest](documentation/models/CreateVehiclesRequest.md)                                                 |             |
| [CreateVehiclesBadRequestResponse](documentation/models/CreateVehiclesBadRequestResponse.md)                           |             |
| [CreateVehiclesConflictResponse](documentation/models/CreateVehiclesConflictResponse.md)                               |             |
| [CreateVehiclesInternalServerErrorResponse](documentation/models/CreateVehiclesInternalServerErrorResponse.md)         |             |
| [GetVehiclesByIdOkResponse](documentation/models/GetVehiclesByIdOkResponse.md)                                         |             |
| [GetVehiclesByIdNotFoundResponse](documentation/models/GetVehiclesByIdNotFoundResponse.md)                             |             |
| [GetVehiclesByIdInternalServerErrorResponse](documentation/models/GetVehiclesByIdInternalServerErrorResponse.md)       |             |
| [UpdateVehiclesByIdOkResponse](documentation/models/UpdateVehiclesByIdOkResponse.md)                                   |             |
| [UpdateVehiclesByIdRequest](documentation/models/UpdateVehiclesByIdRequest.md)                                         |             |
| [UpdateVehiclesByIdBadRequestResponse](documentation/models/UpdateVehiclesByIdBadRequestResponse.md)                   |             |
| [UpdateVehiclesByIdInternalServerErrorResponse](documentation/models/UpdateVehiclesByIdInternalServerErrorResponse.md) |             |
| [DeleteVehiclesByIdInternalServerErrorResponse](documentation/models/DeleteVehiclesByIdInternalServerErrorResponse.md) |             |

</details>
