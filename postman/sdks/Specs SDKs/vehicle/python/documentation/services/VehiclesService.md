# VehiclesService

A list of all methods in the `VehiclesService` service. Click on the method name to view detailed information about that method.

| Methods                                         | Description                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    |
| :---------------------------------------------- | :--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| [get_vehicles](#get_vehicles)                   |                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                |
| [create_vehicles](#create_vehicles)             | Creates a new vehicle record in the system. **Endpoint:** `POST {{baseUrl}}/vehicles` **Request Body (JSON)** \| Field \| Type \| Description \| \|-------\|------\|-------------\| \| `nickName` \| string \| A friendly name or alias for the vehicle \| \| `vin` \| string \| Vehicle Identification Number (VIN) \| \| `make` \| string \| Manufacturer of the vehicle (e.g. Ford, Toyota) \| \| `model` \| string \| Model name of the vehicle \| \| `year` \| string \| Model year of the vehicle \| \| `miles` \| integer \| Current odometer reading in miles \| **Responses** \| Status \| Meaning \| \|--------\|---------\| \| `201 Created` \| Vehicle was successfully created \| \| `400 Bad Request` \| One or more required attributes are missing from the request body \| \| `409 Conflict` \| A vehicle with the same VIN already exists \| \| `500 Internal Server Error` \| An unexpected error occurred on the server \| |
| [get_vehicles_by_id](#get_vehicles_by_id)       |                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                |
| [update_vehicles_by_id](#update_vehicles_by_id) |                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                |
| [delete_vehicles_by_id](#delete_vehicles_by_id) |                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                |

## get_vehicles

- HTTP Method: `GET`
- Endpoint: `/vehicles`

**Return Type**

`List[GetVehiclesOkResponse]`

**Example Usage Code Snippet**

```python
from vehicle_service_spec_sdk import VehicleServiceSpecSdk

sdk = VehicleServiceSpecSdk(
    timeout=10
)

result = sdk.vehicles.get_vehicles()

print(result)
```

## create_vehicles

Creates a new vehicle record in the system. **Endpoint:** `POST {{baseUrl}}/vehicles` **Request Body (JSON)** \| Field \| Type \| Description \| \|-------\|------\|-------------\| \| `nickName` \| string \| A friendly name or alias for the vehicle \| \| `vin` \| string \| Vehicle Identification Number (VIN) \| \| `make` \| string \| Manufacturer of the vehicle (e.g. Ford, Toyota) \| \| `model` \| string \| Model name of the vehicle \| \| `year` \| string \| Model year of the vehicle \| \| `miles` \| integer \| Current odometer reading in miles \| **Responses** \| Status \| Meaning \| \|--------\|---------\| \| `201 Created` \| Vehicle was successfully created \| \| `400 Bad Request` \| One or more required attributes are missing from the request body \| \| `409 Conflict` \| A vehicle with the same VIN already exists \| \| `500 Internal Server Error` \| An unexpected error occurred on the server \|

- HTTP Method: `POST`
- Endpoint: `/vehicles`

**Parameters**

| Name                 | Type                                                        | Required | Description       |
| :------------------- | :---------------------------------------------------------- | :------- | :---------------- |
| request_body         | [CreateVehiclesRequest](../models/CreateVehiclesRequest.md) | ❌       | The request body. |
| x_mock_response_code | int                                                         | ❌       |                   |

**Return Type**

`CreateVehiclesCreatedResponse`

**Example Usage Code Snippet**

```python
from vehicle_service_spec_sdk import VehicleServiceSpecSdk
from vehicle_service_spec_sdk.models import CreateVehiclesRequest

sdk = VehicleServiceSpecSdk(
    timeout=10
)

request_body = CreateVehiclesRequest(
    nick_name="nickName",
    vin="vin",
    make="make",
    model="model",
    year="year",
    miles=4
)

result = sdk.vehicles.create_vehicles(
    request_body=request_body,
    x_mock_response_code=10
)

print(result)
```

## get_vehicles_by_id

- HTTP Method: `GET`
- Endpoint: `/vehicles/{id}`

**Parameters**

| Name | Type | Required | Description |
| :--- | :--- | :------- | :---------- |
| id\_ | int  | ✅       |             |

**Return Type**

`GetVehiclesByIdOkResponse`

**Example Usage Code Snippet**

```python
from vehicle_service_spec_sdk import VehicleServiceSpecSdk

sdk = VehicleServiceSpecSdk(
    timeout=10
)

result = sdk.vehicles.get_vehicles_by_id(id_=1)

print(result)
```

## update_vehicles_by_id

- HTTP Method: `PATCH`
- Endpoint: `/vehicles/{id}`

**Parameters**

| Name         | Type                                                                | Required | Description       |
| :----------- | :------------------------------------------------------------------ | :------- | :---------------- |
| request_body | [UpdateVehiclesByIdRequest](../models/UpdateVehiclesByIdRequest.md) | ❌       | The request body. |
| id\_         | int                                                                 | ✅       |                   |

**Return Type**

`UpdateVehiclesByIdOkResponse`

**Example Usage Code Snippet**

```python
from vehicle_service_spec_sdk import VehicleServiceSpecSdk
from vehicle_service_spec_sdk.models import UpdateVehiclesByIdRequest

sdk = VehicleServiceSpecSdk(
    timeout=10
)

request_body = UpdateVehiclesByIdRequest(
    nick_name="nickName",
    vin="vin",
    make="make",
    model="model",
    year="year",
    miles=7
)

result = sdk.vehicles.update_vehicles_by_id(
    request_body=request_body,
    id_=1
)

print(result)
```

## delete_vehicles_by_id

- HTTP Method: `DELETE`
- Endpoint: `/vehicles/{id}`

**Parameters**

| Name | Type | Required | Description |
| :--- | :--- | :------- | :---------- |
| id\_ | int  | ✅       |             |

**Return Type**

`DeleteVehiclesByIdInternalServerErrorResponse`

**Example Usage Code Snippet**

```python
from vehicle_service_spec_sdk import VehicleServiceSpecSdk

sdk = VehicleServiceSpecSdk(
    timeout=10
)

result = sdk.vehicles.delete_vehicles_by_id(id_=1)

print(result)
```
