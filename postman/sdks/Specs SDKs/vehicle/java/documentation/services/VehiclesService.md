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

`List<GetVehiclesOkResponse>`

**Example Usage Code Snippet**

```java
import com.vehicleservicespecsdk.VehicleServiceSpecSdk;
import com.vehicleservicespecsdk.models.GetVehiclesOkResponse;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    VehicleServiceSpecSdk vehicleServiceSpecSdk = new VehicleServiceSpecSdk();

    List<GetVehiclesOkResponse> response = vehicleServiceSpecSdk.vehicles.getVehicles();

    System.out.println(response);
  }
}

```

## createVehicles

Creates a new vehicle record in the system. **Endpoint:** `POST {{baseUrl}}/vehicles` **Request Body (JSON)** \| Field \| Type \| Description \| \|-------\|------\|-------------\| \| `nickName` \| string \| A friendly name or alias for the vehicle \| \| `vin` \| string \| Vehicle Identification Number (VIN) \| \| `make` \| string \| Manufacturer of the vehicle (e.g. Ford, Toyota) \| \| `model` \| string \| Model name of the vehicle \| \| `year` \| string \| Model year of the vehicle \| \| `miles` \| integer \| Current odometer reading in miles \| **Responses** \| Status \| Meaning \| \|--------\|---------\| \| `201 Created` \| Vehicle was successfully created \| \| `400 Bad Request` \| One or more required attributes are missing from the request body \| \| `409 Conflict` \| A vehicle with the same VIN already exists \| \| `500 Internal Server Error` \| An unexpected error occurred on the server \|

- HTTP Method: `POST`
- Endpoint: `/vehicles`

**Parameters**

| Name              | Type                                                              | Required | Description               |
| :---------------- | :---------------------------------------------------------------- | :------- | :------------------------ |
| requestParameters | [CreateVehiclesParameters](../models/CreateVehiclesParameters.md) | ❌       | Request Parameters Object |

**Return Type**

`CreateVehiclesCreatedResponse`

**Example Usage Code Snippet**

```java
import com.vehicleservicespecsdk.VehicleServiceSpecSdk;
import com.vehicleservicespecsdk.models.CreateVehiclesCreatedResponse;
import com.vehicleservicespecsdk.models.CreateVehiclesParameters;
import com.vehicleservicespecsdk.models.CreateVehiclesRequest;

public class Main {

  public static void main(String[] args) {
    VehicleServiceSpecSdk vehicleServiceSpecSdk = new VehicleServiceSpecSdk();

    CreateVehiclesRequest createVehiclesRequest = CreateVehiclesRequest.builder()
      .nickName("nickName")
      .vin("vin")
      .make("make")
      .model("model")
      .year("year")
      .miles(3L)
      .build();

    CreateVehiclesParameters requestParameters = CreateVehiclesParameters.builder()
      .xMockResponseCode(7L)
      .requestBody(createVehiclesRequest)
      .build();

    CreateVehiclesCreatedResponse response = vehicleServiceSpecSdk.vehicles.createVehicles(
      requestParameters
    );

    System.out.println(response);
  }
}

```

## getVehiclesById

- HTTP Method: `GET`
- Endpoint: `/vehicles/{id}`

**Parameters**

| Name | Type | Required | Description |
| :--- | :--- | :------- | :---------- |
| id   | long | ✅       |             |

**Return Type**

`GetVehiclesByIdOkResponse`

**Example Usage Code Snippet**

```java
import com.vehicleservicespecsdk.VehicleServiceSpecSdk;
import com.vehicleservicespecsdk.models.GetVehiclesByIdOkResponse;

public class Main {

  public static void main(String[] args) {
    VehicleServiceSpecSdk vehicleServiceSpecSdk = new VehicleServiceSpecSdk();

    GetVehiclesByIdOkResponse response = vehicleServiceSpecSdk.vehicles.getVehiclesById(3L);

    System.out.println(response);
  }
}

```

## updateVehiclesById

- HTTP Method: `PATCH`
- Endpoint: `/vehicles/{id}`

**Parameters**

| Name                      | Type                                                                | Required | Description  |
| :------------------------ | :------------------------------------------------------------------ | :------- | :----------- |
| id                        | long                                                                | ✅       |              |
| updateVehiclesByIdRequest | [UpdateVehiclesByIdRequest](../models/UpdateVehiclesByIdRequest.md) | ❌       | Request Body |

**Return Type**

`UpdateVehiclesByIdOkResponse`

**Example Usage Code Snippet**

```java
import com.vehicleservicespecsdk.VehicleServiceSpecSdk;
import com.vehicleservicespecsdk.models.UpdateVehiclesByIdOkResponse;
import com.vehicleservicespecsdk.models.UpdateVehiclesByIdRequest;

public class Main {

  public static void main(String[] args) {
    VehicleServiceSpecSdk vehicleServiceSpecSdk = new VehicleServiceSpecSdk();

    UpdateVehiclesByIdRequest updateVehiclesByIdRequest = UpdateVehiclesByIdRequest.builder()
      .nickName("nickName")
      .vin("vin")
      .make("make")
      .model("model")
      .year("year")
      .miles(10L)
      .build();

    UpdateVehiclesByIdOkResponse response = vehicleServiceSpecSdk.vehicles.updateVehiclesById(
      3L,
      updateVehiclesByIdRequest
    );

    System.out.println(response);
  }
}

```

## deleteVehiclesById

- HTTP Method: `DELETE`
- Endpoint: `/vehicles/{id}`

**Parameters**

| Name | Type | Required | Description |
| :--- | :--- | :------- | :---------- |
| id   | long | ✅       |             |

**Example Usage Code Snippet**

```java
import com.vehicleservicespecsdk.VehicleServiceSpecSdk;

public class Main {

  public static void main(String[] args) {
    VehicleServiceSpecSdk vehicleServiceSpecSdk = new VehicleServiceSpecSdk();

    vehicleServiceSpecSdk.vehicles.deleteVehiclesById(3L);
  }
}

```
