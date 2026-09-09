package vehicles

import "encoding/json"

type UpdateVehiclesByIDOkResponse struct {
	ID       *int64  `json:"id,omitempty" xml:"id,omitempty"`
	NickName *string `json:"nickName,omitempty" xml:"nickName,omitempty"`
	Vin      *string `json:"vin,omitempty" xml:"vin,omitempty"`
	Make     *string `json:"make,omitempty" xml:"make,omitempty"`
	Model    *string `json:"model,omitempty" xml:"model,omitempty"`
	Year     *string `json:"year,omitempty" xml:"year,omitempty"`
	Miles    *int64  `json:"miles,omitempty" xml:"miles,omitempty"`
}

func (u UpdateVehiclesByIDOkResponse) String() string {
	jsonData, err := json.MarshalIndent(u, "", "  ")
	if err != nil {
		return "error converting struct: UpdateVehiclesByIDOkResponse to string"
	}
	return string(jsonData)
}
