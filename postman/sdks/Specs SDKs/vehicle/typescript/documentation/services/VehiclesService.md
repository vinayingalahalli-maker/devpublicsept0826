# VehiclesService

A list of all methods in the `VehiclesService` service. Click on the method name to view detailed information about that method.

| Methods                                   | Description                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    |
| :---------------------------------------- | :--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| [getVehicles](#getvehicles)               |                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                |
| [createVehicles](#createvehicles)         | Creates a new vehicle record in the system. **Endpoint:** `POST {{baseUrl}}/vehicles` **Request Body (JSON)** \| Field \| Type \| Description \| \|-------\|------\|-------------\| \| `nickName` \| string \| A friendly name or alias for the vehicle \| \| `vin` \| string \| Vehicle Identification Number (VIN) \| \| `make` \| string \| Manufacturer of the vehicle (e.g. Ford, Toyota) \| \| `model` \| string \| Model name of the vehicle \| \| `year` \| string \| Model year of the vehicle \| \| `miles` \| integer \| Current odometer reading in miles \| **Responses** \| Status \| Meaning \| \|--------\|---------\| \| `201 Created` \| Vehicle was successfully created \| \| `400 Bad Request` \| One or more required attributes are missing from the request body \| \| `409 Conflict` \| A vehicle with the same VIN already exists \| \| `500 Internal Server Error` \| An unexpected error occurred on the server \| |
| [getVehiclesById](#getvehiclesbyid)       |                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                |
| [updateVehiclesById](#updatevehiclesbyid) |                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                |
| [deleteVehiclesById](#deletevehiclesbyid) |                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                |

## getVehicles

- HTTP Method: `GET`
- Endpoint: `/vehicles`

**Return Type**

`GetVehiclesOkResponse[]`

**Example Usage Code Snippet**

```typescript
import { VehicleServiceSpecSdk } from 'vehicle-service-spec-sdk';

(async () => {
  const vehicleServiceSpecSdk = new VehicleServiceSpecSdk({});

  const data = await vehicleServiceSpecSdk.vehicles.getVehicles();

  console.log(data);
})();
```

## createVehicles

Creates a new vehicle record in the system. **Endpoint:** `POST {{baseUrl}}/vehicles` **Request Body (JSON)** \| Field \| Type \| Description \| \|-------\|------\|-------------\| \| `nickName` \| string \| A friendly name or alias for the vehicle \| \| `vin` \| string \| Vehicle Identification Number (VIN) \| \| `make` \| string \| Manufacturer of the vehicle (e.g. Ford, Toyota) \| \| `model` \| string \| Model name of the vehicle \| \| `year` \| string \| Model year of the vehicle \| \| `miles` \| integer \| Current odometer reading in miles \| **Responses** \| Status \| Meaning \| \|--------\|---------\| \| `201 Created` \| Vehicle was successfully created \| \| `400 Bad Request` \| One or more required attributes are missing from the request body \| \| `409 Conflict` \| A vehicle with the same VIN already exists \| \| `500 Internal Server Error` \| An unexpected error occurred on the server \|

- HTTP Method: `POST`
- Endpoint: `/vehicles`

**Parameters**

| Name              | Type                                                        | Required | Description       |
| :---------------- | :---------------------------------------------------------- | :------- | :---------------- |
| body              | [CreateVehiclesRequest](../models/CreateVehiclesRequest.md) | ❌       | The request body. |
| xMockResponseCode | number                                                      | ❌       |                   |

**Return Type**

`CreateVehiclesCreatedResponse`

**Example Usage Code Snippet**

```typescript
import { CreateVehiclesRequest, VehicleServiceSpecSdk } from 'vehicle-service-spec-sdk';

(async () => {
  const vehicleServiceSpecSdk = new VehicleServiceSpecSdk({});

  const createVehiclesRequest: CreateVehiclesRequest = {
    nickName: 'nickName',
    vin: 'vin',
    make: 'make',
    model: 'model',
    year: 'year',
    miles: 9,
  };

  const data = await vehicleServiceSpecSdk.vehicles.createVehicles(createVehiclesRequest, {
    xMockResponseCode: 5,
  });

  console.log(data);
})();
```

## getVehiclesById

- HTTP Method: `GET`
- Endpoint: `/vehicles/{id}`

**Parameters**

| Name | Type   | Required | Description |
| :--- | :----- | :------- | :---------- |
| id   | number | ✅       |             |

**Return Type**

`GetVehiclesByIdOkResponse`

**Example Usage Code Snippet**

```typescript
import { VehicleServiceSpecSdk } from 'vehicle-service-spec-sdk';

(async () => {
  const vehicleServiceSpecSdk = new VehicleServiceSpecSdk({});

  const data = await vehicleServiceSpecSdk.vehicles.getVehiclesById(1);

  console.log(data);
})();
```

## updateVehiclesById

- HTTP Method: `PATCH`
- Endpoint: `/vehicles/{id}`

**Parameters**

| Name | Type                                                                | Required | Description       |
| :--- | :------------------------------------------------------------------ | :------- | :---------------- |
| body | [UpdateVehiclesByIdRequest](../models/UpdateVehiclesByIdRequest.md) | ❌       | The request body. |
| id   | number                                                              | ✅       |                   |

**Return Type**

`UpdateVehiclesByIdOkResponse`

**Example Usage Code Snippet**

```typescript
import { UpdateVehiclesByIdRequest, VehicleServiceSpecSdk } from 'vehicle-service-spec-sdk';

(async () => {
  const vehicleServiceSpecSdk = new VehicleServiceSpecSdk({});

  const updateVehiclesByIdRequest: UpdateVehiclesByIdRequest = {
    nickName: 'nickName',
    vin: 'vin',
    make: 'make',
    model: 'model',
    year: 'year',
    miles: 123,
  };

  const data = await vehicleServiceSpecSdk.vehicles.updateVehiclesById(
    1,
    updateVehiclesByIdRequest,
  );

  console.log(data);
})();
```

## deleteVehiclesById

- HTTP Method: `DELETE`
- Endpoint: `/vehicles/{id}`

**Parameters**

| Name | Type   | Required | Description |
| :--- | :----- | :------- | :---------- |
| id   | number | ✅       |             |

**Example Usage Code Snippet**

```typescript
import { VehicleServiceSpecSdk } from 'vehicle-service-spec-sdk';

(async () => {
  const vehicleServiceSpecSdk = new VehicleServiceSpecSdk({});

  const data = await vehicleServiceSpecSdk.vehicles.deleteVehiclesById(1);

  console.log(data);
})();
```
