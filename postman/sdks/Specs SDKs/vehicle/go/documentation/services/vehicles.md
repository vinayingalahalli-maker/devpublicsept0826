# Vehicles

A list of all methods in the `Vehicles` service. Click on the method name to view detailed information about that method.

| Methods                                   | Description                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    |
| :---------------------------------------- | :--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| [GetVehicles](#getvehicles)               |                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                |
| [CreateVehicles](#createvehicles)         | Creates a new vehicle record in the system. **Endpoint:** `POST {{baseUrl}}/vehicles` **Request Body (JSON)** \| Field \| Type \| Description \| \|-------\|------\|-------------\| \| `nickName` \| string \| A friendly name or alias for the vehicle \| \| `vin` \| string \| Vehicle Identification Number (VIN) \| \| `make` \| string \| Manufacturer of the vehicle (e.g. Ford, Toyota) \| \| `model` \| string \| Model name of the vehicle \| \| `year` \| string \| Model year of the vehicle \| \| `miles` \| integer \| Current odometer reading in miles \| **Responses** \| Status \| Meaning \| \|--------\|---------\| \| `201 Created` \| Vehicle was successfully created \| \| `400 Bad Request` \| One or more required attributes are missing from the request body \| \| `409 Conflict` \| A vehicle with the same VIN already exists \| \| `500 Internal Server Error` \| An unexpected error occurred on the server \| |
| [GetVehiclesByID](#getvehiclesbyid)       |                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                |
| [UpdateVehiclesByID](#updatevehiclesbyid) |                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                |
| [DeleteVehiclesByID](#deletevehiclesbyid) |                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                |

## GetVehicles

- HTTP Method: `GET`
- Endpoint: `/vehicles`

**Parameters**

| Name | Type    | Required | Description                 |
| :--- | :------ | :------- | :-------------------------- |
| ctx  | Context | ✅       | Default go language context |

**Return Type**

`[]GetVehiclesOkResponse`

**Example Usage Code Snippet**

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

## CreateVehicles

Creates a new vehicle record in the system. **Endpoint:** `POST {{baseUrl}}/vehicles` **Request Body (JSON)** \| Field \| Type \| Description \| \|-------\|------\|-------------\| \| `nickName` \| string \| A friendly name or alias for the vehicle \| \| `vin` \| string \| Vehicle Identification Number (VIN) \| \| `make` \| string \| Manufacturer of the vehicle (e.g. Ford, Toyota) \| \| `model` \| string \| Model name of the vehicle \| \| `year` \| string \| Model year of the vehicle \| \| `miles` \| integer \| Current odometer reading in miles \| **Responses** \| Status \| Meaning \| \|--------\|---------\| \| `201 Created` \| Vehicle was successfully created \| \| `400 Bad Request` \| One or more required attributes are missing from the request body \| \| `409 Conflict` \| A vehicle with the same VIN already exists \| \| `500 Internal Server Error` \| An unexpected error occurred on the server \|

- HTTP Method: `POST`
- Endpoint: `/vehicles`

**Parameters**

| Name                  | Type                        | Required | Description                   |
| :-------------------- | :-------------------------- | :------- | :---------------------------- |
| ctx                   | Context                     | ✅       | Default go language context   |
| createVehiclesRequest | CreateVehiclesRequest       | ✅       |                               |
| params                | CreateVehiclesRequestParams | ✅       | Additional request parameters |

**Return Type**

`CreateVehiclesCreatedResponse`

**Example Usage Code Snippet**

```go
import (
  "fmt"
  "encoding/json"
  "context"
  "example.com/vehicle-service-spec-sdk"
  "example.com/vehicle-service-spec-sdk/vehicles"
)

config := vehicleservicespecsdk.NewConfig()

client := vehicleservicespecsdk.NewVehicleServiceSpecSDK(config)


params := vehicles.CreateVehiclesRequestParams{
  XMockResponseCode: vehicleservicespecsdk.Ptr(int64(8)),
}


request := vehicles.CreateVehiclesRequest{
  NickName: vehicleservicespecsdk.Ptr("nickName"),
  Vin: vehicleservicespecsdk.Ptr("vin"),
  Make: vehicleservicespecsdk.Ptr("make"),
  Model: vehicleservicespecsdk.Ptr("model"),
  Year: vehicleservicespecsdk.Ptr("year"),
  Miles: vehicleservicespecsdk.Ptr(int64(3)),
}

response, err := client.Vehicles.CreateVehicles(context.Background(), request, params)
if err != nil {
  panic(err)
}

fmt.Println(response)
```

## GetVehiclesByID

- HTTP Method: `GET`
- Endpoint: `/vehicles/{id}`

**Parameters**

| Name | Type    | Required | Description                 |
| :--- | :------ | :------- | :-------------------------- |
| ctx  | Context | ✅       | Default go language context |
| id   | int64   | ✅       |                             |

**Return Type**

`GetVehiclesByIDOkResponse`

**Example Usage Code Snippet**

```go
import (
  "fmt"
  "encoding/json"
  "context"
  "example.com/vehicle-service-spec-sdk"
)

config := vehicleservicespecsdk.NewConfig()

client := vehicleservicespecsdk.NewVehicleServiceSpecSDK(config)

response, err := client.Vehicles.GetVehiclesByID(context.Background(), int64(9))
if err != nil {
  panic(err)
}

fmt.Println(response)
```

## UpdateVehiclesByID

- HTTP Method: `PATCH`
- Endpoint: `/vehicles/{id}`

**Parameters**

| Name                      | Type                      | Required | Description                 |
| :------------------------ | :------------------------ | :------- | :-------------------------- |
| ctx                       | Context                   | ✅       | Default go language context |
| id                        | int64                     | ✅       |                             |
| updateVehiclesByIDRequest | UpdateVehiclesByIDRequest | ✅       |                             |

**Return Type**

`UpdateVehiclesByIDOkResponse`

**Example Usage Code Snippet**

```go
import (
  "fmt"
  "encoding/json"
  "context"
  "example.com/vehicle-service-spec-sdk"
  "example.com/vehicle-service-spec-sdk/vehicles"
)

config := vehicleservicespecsdk.NewConfig()

client := vehicleservicespecsdk.NewVehicleServiceSpecSDK(config)


request := vehicles.UpdateVehiclesByIDRequest{
  NickName: vehicleservicespecsdk.Ptr("nickName"),
  Vin: vehicleservicespecsdk.Ptr("vin"),
  Make: vehicleservicespecsdk.Ptr("make"),
  Model: vehicleservicespecsdk.Ptr("model"),
  Year: vehicleservicespecsdk.Ptr("year"),
  Miles: vehicleservicespecsdk.Ptr(int64(1)),
}

response, err := client.Vehicles.UpdateVehiclesByID(context.Background(), int64(9), request)
if err != nil {
  panic(err)
}

fmt.Println(response)
```

## DeleteVehiclesByID

- HTTP Method: `DELETE`
- Endpoint: `/vehicles/{id}`

**Parameters**

| Name | Type    | Required | Description                 |
| :--- | :------ | :------- | :-------------------------- |
| ctx  | Context | ✅       | Default go language context |
| id   | int64   | ✅       |                             |

**Return Type**

`any`

**Example Usage Code Snippet**

```go
import (
  "fmt"
  "encoding/json"
  "context"
  "example.com/vehicle-service-spec-sdk"
)

config := vehicleservicespecsdk.NewConfig()

client := vehicleservicespecsdk.NewVehicleServiceSpecSDK(config)

response, err := client.Vehicles.DeleteVehiclesByID(context.Background(), int64(9))
if err != nil {
  panic(err)
}

fmt.Println(response)
```
