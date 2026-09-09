from vehicle_service_spec_sdk import VehicleServiceSpecSdk

sdk = VehicleServiceSpecSdk(timeout=10)

result = sdk.vehicles.get_vehicles()

print(result)
