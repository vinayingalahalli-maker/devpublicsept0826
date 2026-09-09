import { z } from 'zod';
import { ThrowableError } from '../../../http/errors/throwable-error';

export type IGetVehiclesInternalServerErrorResponseSchema = {
  message?: string;
};

export const getVehiclesInternalServerErrorResponseResponse = z.lazy(() => {
  return z
    .object({
      message: z.string().optional(),
    })
    .transform((data) => ({
      message: data['message'],
    }));
});

export class GetVehiclesInternalServerErrorResponse extends ThrowableError {
  constructor(
    public message: string,
    protected response?: unknown,
  ) {
    super(message);
  }

  static from(message: string, response?: unknown): GetVehiclesInternalServerErrorResponse {
    const error = new GetVehiclesInternalServerErrorResponse(message, response);
    const result = getVehiclesInternalServerErrorResponseResponse.safeParse(response);
    const parsedResponse = (result.success ? result.data : response || {}) as z.infer<
      typeof getVehiclesInternalServerErrorResponseResponse
    >;

    error.message = parsedResponse.message || '';

    return error;
  }

  public throw() {
    const error = GetVehiclesInternalServerErrorResponse.from(this.message, this.response);
    error.metadata = this.metadata;
    throw error;
  }
}
