import { Environment } from './http/environment';
import { SdkConfig } from './http/types';
import { VehiclesService } from './services/vehicles';

export * from './services/vehicles';

export * from './http';
export { Environment } from './http/environment';

export class VehicleServiceSpecSdk {
  public readonly vehicles: VehiclesService;

  constructor(public config: SdkConfig) {
    this.vehicles = new VehiclesService(this.config);
  }

  set baseUrl(baseUrl: string) {
    this.vehicles.baseUrl = baseUrl;
  }

  set environment(environment: Environment) {
    this.vehicles.baseUrl = environment;
  }

  set timeoutMs(timeoutMs: number) {
    this.vehicles.timeoutMs = timeoutMs;
  }
}

// c029837e0e474b76bc487506e8799df5e3335891efe4fb02bda7a1441840310c
