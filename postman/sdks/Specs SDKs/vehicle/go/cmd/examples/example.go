package main

import (
	"bufio"
	"fmt"
	"os"
	"strings"

	"context"
	"example.com/vehicle-service-spec-sdk"
)

func main() {
	loadEnv()

	config := vehicleservicespecsdk.NewConfig()
	client := vehicleservicespecsdk.NewVehicleServiceSpecSDK(config)

	response, err := client.Vehicles.GetVehicles(context.Background())
	if err != nil {
		panic(err)
	}
	fmt.Printf("%+v", response)
}

func loadEnv() error {
	file, err := os.Open(".env")
	if err != nil {
		return err
	}
	defer file.Close()

	scanner := bufio.NewScanner(file)
	for scanner.Scan() {
		line := scanner.Text()
		parts := strings.SplitN(line, "=", 2)
		if len(parts) != 2 {
			continue
		}
		key := strings.TrimSpace(parts[0])
		value := strings.TrimSpace(parts[1])
		os.Setenv(key, value)
	}

	if err := scanner.Err(); err != nil {
		return err
	}

	return nil
}
