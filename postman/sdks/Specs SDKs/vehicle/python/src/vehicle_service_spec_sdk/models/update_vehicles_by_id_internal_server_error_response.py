from __future__ import annotations
from pydantic import Field
from typing import Optional
from typing import Any
from .utils.base_error import BaseError
from .utils.base_model import BaseModel


# Pydantic validation model for UpdateVehiclesByIdInternalServerErrorResponse
class UpdateVehiclesByIdInternalServerErrorResponseData(BaseModel):
    """UpdateVehiclesByIdInternalServerErrorResponse

    :param message: message, defaults to None
    :type message: str, optional
    """

    message: Optional[str] = Field(default=None)


# Error exception class
class UpdateVehiclesByIdInternalServerErrorResponse(BaseError):
    """UpdateVehiclesByIdInternalServerErrorResponse

    :param message: message, defaults to None
    :type message: str, optional
    """

    _model_class = UpdateVehiclesByIdInternalServerErrorResponseData
