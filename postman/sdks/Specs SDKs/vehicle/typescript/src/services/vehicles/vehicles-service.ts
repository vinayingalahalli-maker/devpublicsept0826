import { z } from 'zod';
import { BaseService } from '../base-service';
import { ContentType, HttpResponse, SdkConfig } from '../../http/types';
import { RequestBuilder } from '../../http/transport/request-builder';
import { SerializationStyle } from '../../http/serialization/base-serializer';
import { ThrowableError } from '../../http/errors/throwable-error';
import { Environment } from '../../http/environment';
import {
  GetVehiclesOkResponse,
  getVehiclesOkResponseResponse,
} from './models/get-vehicles-ok-response';
import { GetVehiclesInternalServerErrorResponse } from './models/get-vehicles-internal-server-error-response';
import {
  CreateVehiclesRequest,
  createVehiclesRequestRequest,
} from './models/create-vehicles-request';
import {
  CreateVehiclesCreatedResponse,
  createVehiclesCreatedResponseResponse,
} from './models/create-vehicles-created-response';
import { CreateVehiclesBadRequestResponse } from './models/create-vehicles-bad-request-response';
import { CreateVehiclesConflictResponse } from './models/create-vehicles-conflict-response';
import { CreateVehiclesInternalServerErrorResponse } from './models/create-vehicles-internal-server-error-response';
import { CreateVehiclesParams } from './request-params';
import {
  GetVehiclesByIdOkResponse,
  getVehiclesByIdOkResponseResponse,
} from './models/get-vehicles-by-id-ok-response';
import { GetVehiclesByIdNotFoundResponse } from './models/get-vehicles-by-id-not-found-response';
import { GetVehiclesByIdInternalServerErrorResponse } from './models/get-vehicles-by-id-internal-server-error-response';
import {
  UpdateVehiclesByIdRequest,
  updateVehiclesByIdRequestRequest,
} from './models/update-vehicles-by-id-request';
import {
  UpdateVehiclesByIdOkResponse,
  updateVehiclesByIdOkResponseResponse,
} from './models/update-vehicles-by-id-ok-response';
import { UpdateVehiclesByIdBadRequestResponse } from './models/update-vehicles-by-id-bad-request-response';
import { UpdateVehiclesByIdInternalServerErrorResponse } from './models/update-vehicles-by-id-internal-server-error-response';
import { DeleteVehiclesByIdInternalServerErrorResponse } from './models/delete-vehicles-by-id-internal-server-error-response';

/**
 * Service class for VehiclesService operations.
 * Provides methods to interact with VehiclesService-related API endpoints.
 * All methods return promises and handle request/response serialization automatically.
 */
export class VehiclesService extends BaseService {
  protected getVehiclesConfig?: Partial<SdkConfig>;

  protected createVehiclesConfig?: Partial<SdkConfig>;

  protected getVehiclesByIdConfig?: Partial<SdkConfig>;

  protected updateVehiclesByIdConfig?: Partial<SdkConfig>;

  protected deleteVehiclesByIdConfig?: Partial<SdkConfig>;

  /**
   * Sets method-level configuration for getVehicles.
   * @param config - Partial configuration to override service-level defaults
   * @returns This service instance for method chaining
   */
  setGetVehiclesConfig(config: Partial<SdkConfig>): this {
    this.getVehiclesConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for createVehicles.
   * @param config - Partial configuration to override service-level defaults
   * @returns This service instance for method chaining
   */
  setCreateVehiclesConfig(config: Partial<SdkConfig>): this {
    this.createVehiclesConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for getVehiclesById.
   * @param config - Partial configuration to override service-level defaults
   * @returns This service instance for method chaining
   */
  setGetVehiclesByIdConfig(config: Partial<SdkConfig>): this {
    this.getVehiclesByIdConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for updateVehiclesById.
   * @param config - Partial configuration to override service-level defaults
   * @returns This service instance for method chaining
   */
  setUpdateVehiclesByIdConfig(config: Partial<SdkConfig>): this {
    this.updateVehiclesByIdConfig = config;
    return this;
  }

  /**
   * Sets method-level configuration for deleteVehiclesById.
   * @param config - Partial configuration to override service-level defaults
   * @returns This service instance for method chaining
   */
  setDeleteVehiclesByIdConfig(config: Partial<SdkConfig>): this {
    this.deleteVehiclesByIdConfig = config;
    return this;
  }

  /**
   *
   * @param {Partial<SdkConfig>} [requestConfig] - The request configuration for retry and validation.
   * @returns {Promise<HttpResponse<GetVehiclesOkResponse[]>>} - 200 - Success
   */
  async getVehicles(requestConfig?: Partial<SdkConfig>): Promise<GetVehiclesOkResponse[]> {
    const resolvedConfig = this.getResolvedConfig(this.getVehiclesConfig, requestConfig);
    const request = new RequestBuilder()
      .setConfig(resolvedConfig)
      .setBaseUrl(resolvedConfig)
      .setMethod('GET')
      .setPath('/vehicles')
      .setRequestSchema(z.any())
      .setRequestContentType(ContentType.Json)
      .addResponse({
        schema: z.array(getVehiclesOkResponseResponse),
        contentType: ContentType.Json,
        status: 200,
      })
      .addError({
        error: GetVehiclesInternalServerErrorResponse,
        contentType: ContentType.Json,
        status: 500,
      })
      .build();
    return this.client.callDirect<GetVehiclesOkResponse[]>(request);
  }

  /**
 * Creates a new vehicle record in the system.
**Endpoint:** `POST {{baseUrl}}/vehicles`

**Request Body (JSON)**

| Field | Type | Description |
|-------|------|-------------|
| `nickName` | string | A friendly name or alias for the vehicle |
| `vin` | string | Vehicle Identification Number (VIN) |
| `make` | string | Manufacturer of the vehicle (e.g. Ford, Toyota) |
| `model` | string | Model name of the vehicle |
| `year` | string | Model year of the vehicle |
| `miles` | integer | Current odometer reading in miles |

**Responses**

| Status | Meaning |
|--------|---------|
| `201 Created` | Vehicle was successfully created |
| `400 Bad Request` | One or more required attributes are missing from the request body |
| `409 Conflict` | A vehicle with the same VIN already exists |
| `500 Internal Server Error` | An unexpected error occurred on the server |
 * @param {number} [params.xMockResponseCode] - 
 * @param {Partial<SdkConfig>} [requestConfig] - The request configuration for retry and validation.
 * @returns {Promise<HttpResponse<CreateVehiclesCreatedResponse>>} - 201 - Success
 */
  async createVehicles(
    body: CreateVehiclesRequest,
    params?: CreateVehiclesParams,
    requestConfig?: Partial<SdkConfig>,
  ): Promise<CreateVehiclesCreatedResponse> {
    const resolvedConfig = this.getResolvedConfig(this.createVehiclesConfig, requestConfig);
    z.object({ xMockResponseCode: z.number().optional() }).parse(params ?? {});
    const request = new RequestBuilder()
      .setConfig(resolvedConfig)
      .setBaseUrl(resolvedConfig)
      .setMethod('POST')
      .setPath('/vehicles')
      .setRequestSchema(createVehiclesRequestRequest)
      .setRequestContentType(ContentType.Json)
      .addResponse({
        schema: createVehiclesCreatedResponseResponse,
        contentType: ContentType.Json,
        status: 201,
      })
      .addError({
        error: CreateVehiclesBadRequestResponse,
        contentType: ContentType.Json,
        status: 400,
      })
      .addError({
        error: CreateVehiclesConflictResponse,
        contentType: ContentType.Json,
        status: 409,
      })
      .addError({
        error: CreateVehiclesInternalServerErrorResponse,
        contentType: ContentType.Json,
        status: 500,
      })
      .addHeaderParam({
        key: 'x-mock-response-code',
        value: params?.xMockResponseCode,
      })
      .addHeaderParam({ key: 'Content-Type', value: 'application/json' })
      .addBody(body)
      .build();
    return this.client.callDirect<CreateVehiclesCreatedResponse>(request);
  }

  /**
   *
   * @param {number} id -
   * @param {Partial<SdkConfig>} [requestConfig] - The request configuration for retry and validation.
   * @returns {Promise<HttpResponse<GetVehiclesByIdOkResponse>>} - 200 - Success
   */
  async getVehiclesById(
    id: number,
    requestConfig?: Partial<SdkConfig>,
  ): Promise<GetVehiclesByIdOkResponse> {
    const resolvedConfig = this.getResolvedConfig(this.getVehiclesByIdConfig, requestConfig);
    const request = new RequestBuilder()
      .setConfig(resolvedConfig)
      .setBaseUrl(resolvedConfig)
      .setMethod('GET')
      .setPath('/vehicles/{id}')
      .setRequestSchema(z.any())
      .setRequestContentType(ContentType.Json)
      .addResponse({
        schema: getVehiclesByIdOkResponseResponse,
        contentType: ContentType.Json,
        status: 200,
      })
      .addError({
        error: GetVehiclesByIdNotFoundResponse,
        contentType: ContentType.Json,
        status: 404,
      })
      .addError({
        error: GetVehiclesByIdInternalServerErrorResponse,
        contentType: ContentType.Json,
        status: 500,
      })
      .addPathParam({
        key: 'id',
        value: id,
      })
      .build();
    return this.client.callDirect<GetVehiclesByIdOkResponse>(request);
  }

  /**
   *
   * @param {number} id -
   * @param {Partial<SdkConfig>} [requestConfig] - The request configuration for retry and validation.
   * @returns {Promise<HttpResponse<UpdateVehiclesByIdOkResponse>>} - 200 - Success
   */
  async updateVehiclesById(
    id: number,
    body: UpdateVehiclesByIdRequest,
    requestConfig?: Partial<SdkConfig>,
  ): Promise<UpdateVehiclesByIdOkResponse> {
    const resolvedConfig = this.getResolvedConfig(this.updateVehiclesByIdConfig, requestConfig);
    const request = new RequestBuilder()
      .setConfig(resolvedConfig)
      .setBaseUrl(resolvedConfig)
      .setMethod('PATCH')
      .setPath('/vehicles/{id}')
      .setRequestSchema(updateVehiclesByIdRequestRequest)
      .setRequestContentType(ContentType.Json)
      .addResponse({
        schema: updateVehiclesByIdOkResponseResponse,
        contentType: ContentType.Json,
        status: 200,
      })
      .addError({
        error: UpdateVehiclesByIdBadRequestResponse,
        contentType: ContentType.Json,
        status: 400,
      })
      .addError({
        error: UpdateVehiclesByIdInternalServerErrorResponse,
        contentType: ContentType.Json,
        status: 500,
      })
      .addPathParam({
        key: 'id',
        value: id,
      })
      .addHeaderParam({ key: 'Content-Type', value: 'application/json' })
      .addBody(body)
      .build();
    return this.client.callDirect<UpdateVehiclesByIdOkResponse>(request);
  }

  /**
   *
   * @param {number} id -
   * @param {Partial<SdkConfig>} [requestConfig] - The request configuration for retry and validation.
   * @returns {Promise<HttpResponse<any>>} - 204 - Success
   */
  async deleteVehiclesById(id: number, requestConfig?: Partial<SdkConfig>): Promise<void> {
    const resolvedConfig = this.getResolvedConfig(this.deleteVehiclesByIdConfig, requestConfig);
    const request = new RequestBuilder()
      .setConfig(resolvedConfig)
      .setBaseUrl(resolvedConfig)
      .setMethod('DELETE')
      .setPath('/vehicles/{id}')
      .setRequestSchema(z.any())
      .setRequestContentType(ContentType.Json)
      .addResponse({
        schema: z.undefined(),
        contentType: ContentType.NoContent,
        status: 204,
      })
      .addError({
        error: DeleteVehiclesByIdInternalServerErrorResponse,
        contentType: ContentType.Json,
        status: 500,
      })
      .addPathParam({
        key: 'id',
        value: id,
      })
      .build();
    return this.client.callDirect<void>(request);
  }
}
