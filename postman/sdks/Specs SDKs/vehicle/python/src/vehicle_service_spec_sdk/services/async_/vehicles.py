from typing import Awaitable, Optional, Any, List, Union
from .utils.to_async import to_async
from ..vehicles import VehiclesService
from ...net.sdk_config import SdkConfig
from ...models.utils.sentinel import SENTINEL
from ...models import (
    GetVehiclesOkResponse,
    CreateVehiclesCreatedResponse,
    CreateVehiclesRequest,
    GetVehiclesByIdOkResponse,
    UpdateVehiclesByIdOkResponse,
    UpdateVehiclesByIdRequest,
)


class VehiclesServiceAsync(VehiclesService):
    """
    Async Wrapper for VehiclesServiceAsync
    """

    def get_vehicles(
        self, *, request_config: Optional[SdkConfig] = None
    ) -> Awaitable[List[GetVehiclesOkResponse]]:
        return to_async(super().get_vehicles)(request_config=request_config)

    def create_vehicles(
        self,
        request_body: CreateVehiclesRequest = None,
        x_mock_response_code: int = SENTINEL,
        *,
        request_config: Optional[SdkConfig] = None,
    ) -> Awaitable[CreateVehiclesCreatedResponse]:
        return to_async(super().create_vehicles)(
            request_body, x_mock_response_code, request_config=request_config
        )

    def get_vehicles_by_id(
        self, id_: int, *, request_config: Optional[SdkConfig] = None
    ) -> Awaitable[GetVehiclesByIdOkResponse]:
        return to_async(super().get_vehicles_by_id)(id_, request_config=request_config)

    def update_vehicles_by_id(
        self,
        id_: int,
        request_body: UpdateVehiclesByIdRequest = None,
        *,
        request_config: Optional[SdkConfig] = None,
    ) -> Awaitable[UpdateVehiclesByIdOkResponse]:
        return to_async(super().update_vehicles_by_id)(
            id_, request_body, request_config=request_config
        )

    def delete_vehicles_by_id(
        self, id_: int, *, request_config: Optional[SdkConfig] = None
    ) -> Awaitable[None]:
        return to_async(super().delete_vehicles_by_id)(
            id_, request_config=request_config
        )
