import { z } from 'zod';
import { ThrowableError } from '../../../http/errors/throwable-error';

export type IGetVehiclesByIdInternalServerErrorResponseSchema = {
  message?: string;
};

export const getVehiclesByIdInternalServerErrorResponseResponse = z.lazy(() => {
  return z
    .object({
      message: z.string().optional(),
    })
    .transform((data) => ({
      message: data['message'],
    }));
});

export class GetVehiclesByIdInternalServerErrorResponse extends ThrowableError {
  constructor(
    public message: string,
    protected response?: unknown,
  ) {
    super(message);
  }

  static from(message: string, response?: unknown): GetVehiclesByIdInternalServerErrorResponse {
    const error = new GetVehiclesByIdInternalServerErrorResponse(message, response);
    const result = getVehiclesByIdInternalServerErrorResponseResponse.safeParse(response);
    const parsedResponse = (result.success ? result.data : response || {}) as z.infer<
      typeof getVehiclesByIdInternalServerErrorResponseResponse
    >;

    error.message = parsedResponse.message || '';

    return error;
  }

  public throw() {
    const error = GetVehiclesByIdInternalServerErrorResponse.from(this.message, this.response);
    error.metadata = this.metadata;
    throw error;
  }
}
