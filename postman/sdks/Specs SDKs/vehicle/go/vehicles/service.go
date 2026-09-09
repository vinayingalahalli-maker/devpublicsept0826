package vehicles

import (
	"context"
	restClient "example.com/vehicle-service-spec-sdk/internal/clients/rest"
	"example.com/vehicle-service-spec-sdk/internal/clients/rest/hooks"
	"example.com/vehicle-service-spec-sdk/internal/clients/rest/httptransport"
	"example.com/vehicle-service-spec-sdk/internal/configmanager"
	"example.com/vehicle-service-spec-sdk/sharedmodels"
	"example.com/vehicle-service-spec-sdk/vehicleservicespecsdkconfig"
	"time"
)

// Service provides methods to interact with Vehicles-related API endpoints.
// It uses a configuration manager for settings and supports custom hooks for request/response interception.
type Service struct {
	manager                  *configmanager.ConfigManager
	hook                     hooks.Hook
	getVehiclesConfig        []vehicleservicespecsdkconfig.RequestOption
	createVehiclesConfig     []vehicleservicespecsdkconfig.RequestOption
	getVehiclesByIDConfig    []vehicleservicespecsdkconfig.RequestOption
	updateVehiclesByIDConfig []vehicleservicespecsdkconfig.RequestOption
	deleteVehiclesByIDConfig []vehicleservicespecsdkconfig.RequestOption
}

func NewService() *Service {
	return &Service{
		manager: configmanager.NewConfigManager(vehicleservicespecsdkconfig.Config{}),
	}
}

// WithConfigManager sets the configuration manager for this service.
// Returns the service instance for method chaining.
func (api *Service) WithConfigManager(manager *configmanager.ConfigManager) *Service {
	api.manager = manager
	return api
}

// WithHook sets a custom hook for request/response interception.
// Returns the service instance for method chaining.
func (api *Service) WithHook(hook hooks.Hook) *Service {
	api.hook = hook
	return api
}

func (api *Service) config() *vehicleservicespecsdkconfig.Config {
	return api.manager.GetVehicles()
}

func (api *Service) getHook() hooks.Hook {
	return api.hook
}

func (api *Service) SetBaseURL(baseURL string) {
	config := api.config()
	config.SetBaseURL(baseURL)
}

func (api *Service) SetTimeout(timeout time.Duration) {
	config := api.config()
	config.SetTimeout(timeout)
}

// SetGetVehiclesConfig sets method-level configuration for GetVehicles.
// Options are applied to every future call to GetVehicles and take
// precedence over service-level config. Per-call options still take highest precedence.
func (api *Service) SetGetVehiclesConfig(opts ...vehicleservicespecsdkconfig.RequestOption) *Service {
	api.getVehiclesConfig = opts
	return api
}

// SetCreateVehiclesConfig sets method-level configuration for CreateVehicles.
// Options are applied to every future call to CreateVehicles and take
// precedence over service-level config. Per-call options still take highest precedence.
func (api *Service) SetCreateVehiclesConfig(opts ...vehicleservicespecsdkconfig.RequestOption) *Service {
	api.createVehiclesConfig = opts
	return api
}

// SetGetVehiclesByIDConfig sets method-level configuration for GetVehiclesByID.
// Options are applied to every future call to GetVehiclesByID and take
// precedence over service-level config. Per-call options still take highest precedence.
func (api *Service) SetGetVehiclesByIDConfig(opts ...vehicleservicespecsdkconfig.RequestOption) *Service {
	api.getVehiclesByIDConfig = opts
	return api
}

// SetUpdateVehiclesByIDConfig sets method-level configuration for UpdateVehiclesByID.
// Options are applied to every future call to UpdateVehiclesByID and take
// precedence over service-level config. Per-call options still take highest precedence.
func (api *Service) SetUpdateVehiclesByIDConfig(opts ...vehicleservicespecsdkconfig.RequestOption) *Service {
	api.updateVehiclesByIDConfig = opts
	return api
}

// SetDeleteVehiclesByIDConfig sets method-level configuration for DeleteVehiclesByID.
// Options are applied to every future call to DeleteVehiclesByID and take
// precedence over service-level config. Per-call options still take highest precedence.
func (api *Service) SetDeleteVehiclesByIDConfig(opts ...vehicleservicespecsdkconfig.RequestOption) *Service {
	api.deleteVehiclesByIDConfig = opts
	return api
}

func (api *Service) GetVehicles(ctx context.Context, opts ...vehicleservicespecsdkconfig.RequestOption) ([]GetVehiclesOkResponse, error) {
	config := *api.config()
	for _, opt := range api.getVehiclesConfig {
		opt(&config)
	}
	for _, opt := range opts {
		opt(&config)
	}

	httpRequest := httptransport.NewRequestBuilder().WithContext(ctx).
		WithMethod("GET").
		WithPath("/vehicles").
		WithConfig(config).
		WithContentType(httptransport.ContentTypeJSON).
		WithResponseContentType(httptransport.ContentTypeJSON).
		WithSecuritySchemes(nil).
		Build()

	httpClient := restClient.NewRestClient[[]GetVehiclesOkResponse, []byte](config, api.getHook())
	resp, err := httpClient.Call(*httpRequest)
	if err != nil {
		return nil, sharedmodels.NewVehicleServiceSpecSDKError[[]byte](err)
	}

	return resp.Data, nil
}

// Creates a new vehicle record in the system.
//
// **Endpoint:** `POST {{baseUrl}}/vehicles`
//
// **Request Body (JSON)**
//
// | Field | Type | Description |
// |-------|------|-------------|
// | `nickName` | string | A friendly name or alias for the vehicle |
// | `vin` | string | Vehicle Identification Number (VIN) |
// | `make` | string | Manufacturer of the vehicle (e.g. Ford, Toyota) |
// | `model` | string | Model name of the vehicle |
// | `year` | string | Model year of the vehicle |
// | `miles` | integer | Current odometer reading in miles |
//
// **Responses**
//
// | Status | Meaning |
// |--------|---------|
// | `201 Created` | Vehicle was successfully created |
// | `400 Bad Request` | One or more required attributes are missing from the request body |
// | `409 Conflict` | A vehicle with the same VIN already exists |
// | `500 Internal Server Error` | An unexpected error occurred on the server |
func (api *Service) CreateVehicles(ctx context.Context, createVehiclesRequest CreateVehiclesRequest, params CreateVehiclesRequestParams, opts ...vehicleservicespecsdkconfig.RequestOption) (*CreateVehiclesCreatedResponse, error) {
	config := *api.config()
	for _, opt := range api.createVehiclesConfig {
		opt(&config)
	}
	for _, opt := range opts {
		opt(&config)
	}

	httpRequest := httptransport.NewRequestBuilder().WithContext(ctx).
		WithMethod("POST").
		WithPath("/vehicles").
		WithConfig(config).
		WithBody(createVehiclesRequest).
		AddHeader("CONTENT-TYPE", "application/json").
		WithOptions(params).
		WithContentType(httptransport.ContentTypeJSON).
		WithResponseContentType(httptransport.ContentTypeJSON).
		WithSecuritySchemes(nil).
		Build()

	httpClient := restClient.NewRestClient[CreateVehiclesCreatedResponse, []byte](config, api.getHook())
	resp, err := httpClient.Call(*httpRequest)
	if err != nil {
		return nil, sharedmodels.NewVehicleServiceSpecSDKError[[]byte](err)
	}

	return &resp.Data, nil
}

func (api *Service) GetVehiclesByID(ctx context.Context, id int64, opts ...vehicleservicespecsdkconfig.RequestOption) (*GetVehiclesByIDOkResponse, error) {
	config := *api.config()
	for _, opt := range api.getVehiclesByIDConfig {
		opt(&config)
	}
	for _, opt := range opts {
		opt(&config)
	}

	httpRequest := httptransport.NewRequestBuilder().WithContext(ctx).
		WithMethod("GET").
		WithPath("/vehicles/{id}").
		WithConfig(config).
		AddPathParam("id", id).
		WithContentType(httptransport.ContentTypeJSON).
		WithResponseContentType(httptransport.ContentTypeJSON).
		WithSecuritySchemes(nil).
		Build()

	httpClient := restClient.NewRestClient[GetVehiclesByIDOkResponse, []byte](config, api.getHook())
	resp, err := httpClient.Call(*httpRequest)
	if err != nil {
		return nil, sharedmodels.NewVehicleServiceSpecSDKError[[]byte](err)
	}

	return &resp.Data, nil
}

func (api *Service) UpdateVehiclesByID(ctx context.Context, id int64, updateVehiclesByIDRequest UpdateVehiclesByIDRequest, opts ...vehicleservicespecsdkconfig.RequestOption) (*UpdateVehiclesByIDOkResponse, error) {
	config := *api.config()
	for _, opt := range api.updateVehiclesByIDConfig {
		opt(&config)
	}
	for _, opt := range opts {
		opt(&config)
	}

	httpRequest := httptransport.NewRequestBuilder().WithContext(ctx).
		WithMethod("PATCH").
		WithPath("/vehicles/{id}").
		WithConfig(config).
		WithBody(updateVehiclesByIDRequest).
		AddHeader("CONTENT-TYPE", "application/json").
		AddPathParam("id", id).
		WithContentType(httptransport.ContentTypeJSON).
		WithResponseContentType(httptransport.ContentTypeJSON).
		WithSecuritySchemes(nil).
		Build()

	httpClient := restClient.NewRestClient[UpdateVehiclesByIDOkResponse, []byte](config, api.getHook())
	resp, err := httpClient.Call(*httpRequest)
	if err != nil {
		return nil, sharedmodels.NewVehicleServiceSpecSDKError[[]byte](err)
	}

	return &resp.Data, nil
}

func (api *Service) DeleteVehiclesByID(ctx context.Context, id int64, opts ...vehicleservicespecsdkconfig.RequestOption) (any, error) {
	config := *api.config()
	for _, opt := range api.deleteVehiclesByIDConfig {
		opt(&config)
	}
	for _, opt := range opts {
		opt(&config)
	}

	httpRequest := httptransport.NewRequestBuilder().WithContext(ctx).
		WithMethod("DELETE").
		WithPath("/vehicles/{id}").
		WithConfig(config).
		AddPathParam("id", id).
		WithContentType(httptransport.ContentTypeJSON).
		WithResponseContentType(httptransport.ContentTypeJSON).
		WithSecuritySchemes(nil).
		Build()

	httpClient := restClient.NewRestClient[any, []byte](config, api.getHook())
	resp, err := httpClient.Call(*httpRequest)
	if err != nil {
		return nil, sharedmodels.NewVehicleServiceSpecSDKError[[]byte](err)
	}

	return resp.Data, nil
}
