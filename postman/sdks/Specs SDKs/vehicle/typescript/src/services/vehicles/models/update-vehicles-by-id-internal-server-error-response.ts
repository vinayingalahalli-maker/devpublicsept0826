import { z } from 'zod';
import { ThrowableError } from '../../../http/errors/throwable-error';

export type IUpdateVehiclesByIdInternalServerErrorResponseSchema = {
  message?: string;
};

export const updateVehiclesByIdInternalServerErrorResponseResponse = z.lazy(() => {
  return z
    .object({
      message: z.string().optional(),
    })
    .transform((data) => ({
      message: data['message'],
    }));
});

export class UpdateVehiclesByIdInternalServerErrorResponse extends ThrowableError {
  constructor(
    public message: string,
    protected response?: unknown,
  ) {
    super(message);
  }

  static from(message: string, response?: unknown): UpdateVehiclesByIdInternalServerErrorResponse {
    const error = new UpdateVehiclesByIdInternalServerErrorResponse(message, response);
    const result = updateVehiclesByIdInternalServerErrorResponseResponse.safeParse(response);
    const parsedResponse = (result.success ? result.data : response || {}) as z.infer<
      typeof updateVehiclesByIdInternalServerErrorResponseResponse
    >;

    error.message = parsedResponse.message || '';

    return error;
  }

  public throw() {
    const error = UpdateVehiclesByIdInternalServerErrorResponse.from(this.message, this.response);
    error.metadata = this.metadata;
    throw error;
  }
}
