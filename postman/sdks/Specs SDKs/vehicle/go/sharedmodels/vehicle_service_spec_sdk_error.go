package sharedmodels

import (
	"example.com/vehicle-service-spec-sdk/internal/clients/rest/httptransport"
	"net/http"
)

// VehicleServiceSpecSDKError wraps API errors with detailed metadata including status code, headers, and raw response.
// It implements the error interface and provides structured access to error information.
type VehicleServiceSpecSDKError[T any] struct {
	Err      error
	Data     *T
	Body     []byte
	Raw      *http.Response
	Metadata VehicleServiceSpecSDKErrorMetadata
}

// VehicleServiceSpecSDKErrorMetadata contains HTTP metadata associated with an error response.
type VehicleServiceSpecSDKErrorMetadata struct {
	Headers    map[string]string
	StatusCode int
}

// NewVehicleServiceSpecSDKError creates a new VehicleServiceSpecSDKError from an internal transport error.
// It extracts error details, body, status code, and headers into a user-facing error structure.
func NewVehicleServiceSpecSDKError[T any](transportError *httptransport.ErrorResponse[T]) *VehicleServiceSpecSDKError[T] {
	return &VehicleServiceSpecSDKError[T]{
		Err:  transportError.GetError(),
		Data: transportError.Data,
		Body: transportError.GetBody(),
		Raw:  transportError.Raw,
		Metadata: VehicleServiceSpecSDKErrorMetadata{
			StatusCode: transportError.GetStatusCode(),
			Headers:    transportError.GetHeaders(),
		},
	}
}

// Error implements the error interface, returning the error message string.
func (e *VehicleServiceSpecSDKError[T]) Error() string {
	if e == nil || e.Err == nil {
		return ""
	}
	return e.Err.Error()
}

// Unwrap returns the underlying error, enabling errors.Is and errors.As to traverse the chain.
func (e *VehicleServiceSpecSDKError[T]) Unwrap() error {
	return e.Err
}

// GetData returns the deserialized error response data.
// Returns nil if unmarshaling failed or the response body was empty.
func (e *VehicleServiceSpecSDKError[T]) GetData() *T {
	return e.Data
}

// GetBody returns the raw response body bytes from the error response.
// Returns nil if no response body was received.
func (e *VehicleServiceSpecSDKError[T]) GetBody() []byte {
	return e.Body
}
