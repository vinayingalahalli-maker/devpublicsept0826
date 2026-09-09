package vehicleservicespecsdk

import (
	"example.com/vehicle-service-spec-sdk/internal/clients/rest/hooks"
	"example.com/vehicle-service-spec-sdk/internal/configmanager"
	"example.com/vehicle-service-spec-sdk/vehicles"
	"time"
)

// VehicleServiceSpecSDK is the main SDK client that provides access to all service endpoints.
// It manages configuration, authentication, and service instances with centralized settings.
type VehicleServiceSpecSDK struct {
	Vehicles *vehicles.Service
	manager  *configmanager.ConfigManager
}

func NewVehicleServiceSpecSDK(config Config) *VehicleServiceSpecSDK {
	vehicles := vehicles.NewService()

	manager := configmanager.NewConfigManager(config)
	hook := hooks.NewDefaultHook()
	vehicles.WithConfigManager(manager)
	vehicles.WithHook(hook)

	return &VehicleServiceSpecSDK{
		Vehicles: vehicles,
		manager:  manager,
	}
}

func (v *VehicleServiceSpecSDK) SetBaseURL(baseURL string) {
	v.manager.SetBaseURL(baseURL)
}

func (v *VehicleServiceSpecSDK) SetTimeout(timeout time.Duration) {
	v.manager.SetTimeout(timeout)
}

// SetEnvironment configures the SDK to use the specified environment's base URL.
func (v *VehicleServiceSpecSDK) SetEnvironment(environment Environment) {
	v.manager.SetBaseURL(string(environment))
}

// c029837e0e474b76bc487506e8799df5e3335891efe4fb02bda7a1441840310c
