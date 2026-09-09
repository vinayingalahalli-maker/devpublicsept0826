package com.example;

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
