package configmanager

import (
	"example.com/vehicle-service-spec-sdk/vehicleservicespecsdkconfig"
	"time"
)

// ConfigManager manages configuration across all services with synchronized updates.
// Provides centralized configuration management and OAuth token handling for multiple services.
type ConfigManager struct {
	vehicles vehicleservicespecsdkconfig.Config
}

// NewConfigManager creates a new configuration manager with the provided config and optional OAuth token service.
// Initializes service-specific configs and sets up OAuth token management if enabled.
func NewConfigManager(config vehicleservicespecsdkconfig.Config) *ConfigManager {
	return &ConfigManager{
		vehicles: config,
	}
}

// SetBaseURL updates the BaseURL configuration parameter across all services.
// Changes are applied synchronously to all registered service configurations.
func (c *ConfigManager) SetBaseURL(baseURL string) {
	c.vehicles.SetBaseURL(baseURL)
}

// SetTimeout updates the Timeout configuration parameter across all services.
// Changes are applied synchronously to all registered service configurations.
func (c *ConfigManager) SetTimeout(timeout time.Duration) {
	c.vehicles.SetTimeout(timeout)
}

// SetRetryConfig updates the retry configuration across all services.
// Changes are applied synchronously to all registered service configurations.
func (c *ConfigManager) SetRetryConfig(retry vehicleservicespecsdkconfig.RetryConfig) {
	c.vehicles.SetRetryConfig(retry)
}

// GetVehicles returns the configuration for the Vehicles service.
// Returns a pointer to the service-specific config for use in API calls.
func (c *ConfigManager) GetVehicles() *vehicleservicespecsdkconfig.Config {
	return &c.vehicles
}

// GetBaseURL returns the currently configured base URL.
// All services share the same base URL; this reads it from the first service's config.
func (c *ConfigManager) GetBaseURL() string {
	return c.vehicles.BaseURL
}
