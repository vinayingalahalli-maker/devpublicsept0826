import { z } from 'zod';
import { ThrowableError } from '../../../http/errors/throwable-error';

export type IUpdateVehiclesByIdBadRequestResponseSchema = {
  message?: string;
};

export const updateVehiclesByIdBadRequestResponseResponse = z.lazy(() => {
  return z
    .object({
      message: z.string().optional(),
    })
    .transform((data) => ({
      message: data['message'],
    }));
});

export class UpdateVehiclesByIdBadRequestResponse extends ThrowableError {
  constructor(
    public message: string,
    protected response?: unknown,
  ) {
    super(message);
  }

  static from(message: string, response?: unknown): UpdateVehiclesByIdBadRequestResponse {
    const error = new UpdateVehiclesByIdBadRequestResponse(message, response);
    const result = updateVehiclesByIdBadRequestResponseResponse.safeParse(response);
    const parsedResponse = (result.success ? result.data : response || {}) as z.infer<
      typeof updateVehiclesByIdBadRequestResponseResponse
    >;

    error.message = parsedResponse.message || '';

    return error;
  }

  public throw() {
    const error = UpdateVehiclesByIdBadRequestResponse.from(this.message, this.response);
    error.metadata = this.metadata;
    throw error;
  }
}
