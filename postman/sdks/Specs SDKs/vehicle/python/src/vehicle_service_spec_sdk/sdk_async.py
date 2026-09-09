from typing import Union
from .net.environment import Environment
from .sdk import VehicleServiceSpecSdk
from .services.async_.vehicles import VehiclesServiceAsync


class VehicleServiceSpecSdkAsync(VehicleServiceSpecSdk):
    """
    VehicleServiceSpecSdkAsync is the asynchronous version of the VehicleServiceSpecSdk SDK Client.
    """

    def __init__(
        self,
        *,
        base_url: Union[Environment, str, None] = None,
        timeout: float = None,
        timeout_ms: int = None,
        retry: "RetryConfig" = None,
    ):
        super().__init__(
            base_url=base_url, timeout=timeout, timeout_ms=timeout_ms, retry=retry
        )

        self.vehicles = VehiclesServiceAsync(base_url=self._base_url)
        if retry is not None:
            self.set_retry(retry)
