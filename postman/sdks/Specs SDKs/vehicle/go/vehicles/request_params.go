package vehicles

// CreateVehiclesRequestParams holds the optional parameters for the API request.
type CreateVehiclesRequestParams struct {
	XMockResponseCode *int64 `explode:"false" serializationStyle:"simple" headerParam:"x-mock-response-code"`
}
