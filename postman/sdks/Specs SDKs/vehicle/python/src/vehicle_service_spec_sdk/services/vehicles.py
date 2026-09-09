from typing import Any, Optional, List, Union
from .utils.validator import Validator
from .utils.base_service import BaseService
from ..net.transport.serializer import Serializer
from ..net.sdk_config import SdkConfig
from ..net.environment.environment import Environment
from ..models.utils.sentinel import SENTINEL
from ..models.utils.cast_models import cast_models
from ..models import (
    CreateVehiclesBadRequestResponse,
    CreateVehiclesConflictResponse,
    CreateVehiclesCreatedResponse,
    CreateVehiclesInternalServerErrorResponse,
    CreateVehiclesRequest,
    DeleteVehiclesByIdInternalServerErrorResponse,
    GetVehiclesByIdInternalServerErrorResponse,
    GetVehiclesByIdNotFoundResponse,
    GetVehiclesByIdOkResponse,
    GetVehiclesInternalServerErrorResponse,
    GetVehiclesOkResponse,
    UpdateVehiclesByIdBadRequestResponse,
    UpdateVehiclesByIdInternalServerErrorResponse,
    UpdateVehiclesByIdOkResponse,
    UpdateVehiclesByIdRequest,
)


class VehiclesService(BaseService):
    """
    Service class for VehiclesService operations.
    Provides methods to interact with VehiclesService-related API endpoints.
    Inherits common functionality from BaseService including authentication and request handling.
    """

    def __init__(self, *args, **kwargs):
        """Initialize the service and method-level configurations."""
        super().__init__(*args, **kwargs)
        self._get_vehicles_config: SdkConfig = {}
        self._create_vehicles_config: SdkConfig = {}
        self._get_vehicles_by_id_config: SdkConfig = {}
        self._update_vehicles_by_id_config: SdkConfig = {}
        self._delete_vehicles_by_id_config: SdkConfig = {}

    def set_get_vehicles_config(self, config: SdkConfig):
        """
        Sets method-level configuration for get_vehicles.

        :param SdkConfig config: Configuration dictionary to override service-level defaults.
        :return: The service instance for method chaining.
        """
        self._get_vehicles_config = config
        return self

    def set_create_vehicles_config(self, config: SdkConfig):
        """
        Sets method-level configuration for create_vehicles.

        :param SdkConfig config: Configuration dictionary to override service-level defaults.
        :return: The service instance for method chaining.
        """
        self._create_vehicles_config = config
        return self

    def set_get_vehicles_by_id_config(self, config: SdkConfig):
        """
        Sets method-level configuration for get_vehicles_by_id.

        :param SdkConfig config: Configuration dictionary to override service-level defaults.
        :return: The service instance for method chaining.
        """
        self._get_vehicles_by_id_config = config
        return self

    def set_update_vehicles_by_id_config(self, config: SdkConfig):
        """
        Sets method-level configuration for update_vehicles_by_id.

        :param SdkConfig config: Configuration dictionary to override service-level defaults.
        :return: The service instance for method chaining.
        """
        self._update_vehicles_by_id_config = config
        return self

    def set_delete_vehicles_by_id_config(self, config: SdkConfig):
        """
        Sets method-level configuration for delete_vehicles_by_id.

        :param SdkConfig config: Configuration dictionary to override service-level defaults.
        :return: The service instance for method chaining.
        """
        self._delete_vehicles_by_id_config = config
        return self

    @cast_models
    def get_vehicles(
        self, *, request_config: Optional[SdkConfig] = None
    ) -> List[GetVehiclesOkResponse]:
        """get_vehicles

        ...
        :raises RequestError: Raised when a request fails, with optional HTTP status code and details.
        ...
        :return: The parsed response data.
        :rtype: List[GetVehiclesOkResponse]
        """

        resolved_config = self._get_resolved_config(
            self._get_vehicles_config, request_config
        )

        serialized_request = (
            Serializer(
                f"{resolved_config.get('base_url') or self.base_url or Environment.DEFAULT.url}/vehicles",
                [],
                resolved_config,
            )
            .add_error(500, GetVehiclesInternalServerErrorResponse)
            .serialize()
            .set_method("GET")
        )

        response, status, _ = self.send_request(serialized_request)
        return [
            GetVehiclesOkResponse.model_validate(item)
            for item in (response if isinstance(response, list) else [])
        ]

    @cast_models
    def create_vehicles(
        self,
        request_body: CreateVehiclesRequest = None,
        x_mock_response_code: int = SENTINEL,
        *,
        request_config: Optional[SdkConfig] = None,
    ) -> CreateVehiclesCreatedResponse:
        """Creates a new vehicle record in the system. **Endpoint:** `POST {{baseUrl}}/vehicles` **Request Body (JSON)** | Field | Type | Description | |-------|------|-------------| | `nickName` | string | A friendly name or alias for the vehicle | | `vin` | string | Vehicle Identification Number (VIN) | | `make` | string | Manufacturer of the vehicle (e.g. Ford, Toyota) | | `model` | string | Model name of the vehicle | | `year` | string | Model year of the vehicle | | `miles` | integer | Current odometer reading in miles | **Responses** | Status | Meaning | |--------|---------| | `201 Created` | Vehicle was successfully created | | `400 Bad Request` | One or more required attributes are missing from the request body | | `409 Conflict` | A vehicle with the same VIN already exists | | `500 Internal Server Error` | An unexpected error occurred on the server |

        :param request_body: The request body., defaults to None
        :type request_body: CreateVehiclesRequest, optional
        :param x_mock_response_code: x_mock_response_code, defaults to None
        :type x_mock_response_code: int, optional
        ...
        :raises RequestError: Raised when a request fails, with optional HTTP status code and details.
        ...
        :return: The parsed response data.
        :rtype: CreateVehiclesCreatedResponse
        """

        Validator(CreateVehiclesRequest).is_optional().validate(request_body)
        Validator(int).is_optional().validate(x_mock_response_code)

        resolved_config = self._get_resolved_config(
            self._create_vehicles_config, request_config
        )

        serialized_request = (
            Serializer(
                f"{resolved_config.get('base_url') or self.base_url or Environment.DEFAULT.url}/vehicles",
                [],
                resolved_config,
            )
            .add_header("x-mock-response-code", x_mock_response_code)
            .add_error(400, CreateVehiclesBadRequestResponse)
            .add_error(409, CreateVehiclesConflictResponse)
            .add_error(500, CreateVehiclesInternalServerErrorResponse)
            .serialize()
            .set_method("POST")
            .set_body(request_body)
        )

        response, status, _ = self.send_request(serialized_request)
        return (
            None
            if response in (b"", "")
            else CreateVehiclesCreatedResponse.model_validate(response)
        )

    @cast_models
    def get_vehicles_by_id(
        self, id_: int, *, request_config: Optional[SdkConfig] = None
    ) -> GetVehiclesByIdOkResponse:
        """get_vehicles_by_id

        :param id_: id_
        :type id_: int
        ...
        :raises RequestError: Raised when a request fails, with optional HTTP status code and details.
        ...
        :return: The parsed response data.
        :rtype: GetVehiclesByIdOkResponse
        """

        Validator(int).validate(id_)

        resolved_config = self._get_resolved_config(
            self._get_vehicles_by_id_config, request_config
        )

        serialized_request = (
            Serializer(
                f"{resolved_config.get('base_url') or self.base_url or Environment.DEFAULT.url}/vehicles/{{id}}",
                [],
                resolved_config,
            )
            .add_path("id", id_)
            .add_error(404, GetVehiclesByIdNotFoundResponse)
            .add_error(500, GetVehiclesByIdInternalServerErrorResponse)
            .serialize()
            .set_method("GET")
        )

        response, status, _ = self.send_request(serialized_request)
        return (
            None
            if response in (b"", "")
            else GetVehiclesByIdOkResponse.model_validate(response)
        )

    @cast_models
    def update_vehicles_by_id(
        self,
        id_: int,
        request_body: UpdateVehiclesByIdRequest = None,
        *,
        request_config: Optional[SdkConfig] = None,
    ) -> UpdateVehiclesByIdOkResponse:
        """update_vehicles_by_id

        :param request_body: The request body., defaults to None
        :type request_body: UpdateVehiclesByIdRequest, optional
        :param id_: id_
        :type id_: int
        ...
        :raises RequestError: Raised when a request fails, with optional HTTP status code and details.
        ...
        :return: The parsed response data.
        :rtype: UpdateVehiclesByIdOkResponse
        """

        Validator(UpdateVehiclesByIdRequest).is_optional().validate(request_body)
        Validator(int).validate(id_)

        resolved_config = self._get_resolved_config(
            self._update_vehicles_by_id_config, request_config
        )

        serialized_request = (
            Serializer(
                f"{resolved_config.get('base_url') or self.base_url or Environment.DEFAULT.url}/vehicles/{{id}}",
                [],
                resolved_config,
            )
            .add_path("id", id_)
            .add_error(400, UpdateVehiclesByIdBadRequestResponse)
            .add_error(500, UpdateVehiclesByIdInternalServerErrorResponse)
            .serialize()
            .set_method("PATCH")
            .set_body(request_body)
        )

        response, status, _ = self.send_request(serialized_request)
        return (
            None
            if response in (b"", "")
            else UpdateVehiclesByIdOkResponse.model_validate(response)
        )

    @cast_models
    def delete_vehicles_by_id(
        self, id_: int, *, request_config: Optional[SdkConfig] = None
    ) -> None:
        """delete_vehicles_by_id

        :param id_: id_
        :type id_: int
        ...
        :raises RequestError: Raised when a request fails, with optional HTTP status code and details.
        ...
        :return: The parsed response data.
        :rtype: None
        """

        Validator(int).validate(id_)

        resolved_config = self._get_resolved_config(
            self._delete_vehicles_by_id_config, request_config
        )

        serialized_request = (
            Serializer(
                f"{resolved_config.get('base_url') or self.base_url or Environment.DEFAULT.url}/vehicles/{{id}}",
                [],
                resolved_config,
            )
            .add_path("id", id_)
            .add_error(500, DeleteVehiclesByIdInternalServerErrorResponse)
            .serialize()
            .set_method("DELETE")
        )

        response, status, content = self.send_request(serialized_request)
