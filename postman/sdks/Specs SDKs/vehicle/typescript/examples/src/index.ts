import { VehicleServiceSpecSdk } from 'vehicle-service-spec-sdk';

(async () => {
  const vehicleServiceSpecSdk = new VehicleServiceSpecSdk({});

  const data = await vehicleServiceSpecSdk.vehicles.getVehicles();

  console.log(data);
})();
