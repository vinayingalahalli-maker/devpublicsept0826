package sharedmodels

import (
	"encoding/json"
	"example.com/vehicle-service-spec-sdk/internal/clients/rest/httptransport"
	"net/http"
)

// VehicleServiceSpecSDKResponse is the user-facing wrapper for API responses.
// It contains the deserialized data, raw HTTP response, and metadata like headers and status code.
type VehicleServiceSpecSDKResponse[T any] struct {
	Data     T
	Raw      *http.Response
	Metadata VehicleServiceSpecSDKResponseMetadata
}

// VehicleServiceSpecSDKResponseMetadata contains HTTP metadata from the API response.
// Includes status code and headers for inspection and debugging.
type VehicleServiceSpecSDKResponseMetadata struct {
	Headers    map[string]string
	StatusCode int
}

// NewVehicleServiceSpecSDKResponse creates a new response wrapper from an internal transport response.
// Extracts data and metadata into a user-facing structure.
func NewVehicleServiceSpecSDKResponse[T any](resp *httptransport.Response[T]) *VehicleServiceSpecSDKResponse[T] {
	return &VehicleServiceSpecSDKResponse[T]{
		Data: resp.Data,
		Raw:  resp.Raw,
		Metadata: VehicleServiceSpecSDKResponseMetadata{
			StatusCode: resp.StatusCode,
			Headers:    resp.Headers,
		},
	}
}

// GetData returns the deserialized response data.
func (r *VehicleServiceSpecSDKResponse[T]) GetData() T {
	return r.Data
}

// String returns a JSON representation of the response for debugging.
// Returns an error message if JSON marshaling fails.
func (r VehicleServiceSpecSDKResponse[T]) String() string {
	jsonData, err := json.MarshalIndent(r, "", "  ")
	if err != nil {
		return "error converting struct: VehicleServiceSpecSDKResponse to string"
	}
	return string(jsonData)
}
