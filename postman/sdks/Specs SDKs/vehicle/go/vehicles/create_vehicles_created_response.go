package vehicles

import "encoding/json"

type CreateVehiclesCreatedResponse struct {
	ID       *int64  `json:"id,omitempty" xml:"id,omitempty"`
	NickName *string `json:"nickName,omitempty" xml:"nickName,omitempty"`
	Vin      *string `json:"vin,omitempty" xml:"vin,omitempty"`
	Make     *string `json:"make,omitempty" xml:"make,omitempty"`
	Model    *string `json:"model,omitempty" xml:"model,omitempty"`
	Year     *string `json:"year,omitempty" xml:"year,omitempty"`
	Miles    *string `json:"miles,omitempty" xml:"miles,omitempty"`
}

func (c CreateVehiclesCreatedResponse) String() string {
	jsonData, err := json.MarshalIndent(c, "", "  ")
	if err != nil {
		return "error converting struct: CreateVehiclesCreatedResponse to string"
	}
	return string(jsonData)
}
