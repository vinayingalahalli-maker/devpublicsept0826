import { z } from 'zod';
import { ThrowableError } from '../../../http/errors/throwable-error';

export type IGetVehiclesByIdNotFoundResponseSchema = {
  message?: string;
};

export const getVehiclesByIdNotFoundResponseResponse = z.lazy(() => {
  return z
    .object({
      message: z.string().optional(),
    })
    .transform((data) => ({
      message: data['message'],
    }));
});

export class GetVehiclesByIdNotFoundResponse extends ThrowableError {
  constructor(
    public message: string,
    protected response?: unknown,
  ) {
    super(message);
  }

  static from(message: string, response?: unknown): GetVehiclesByIdNotFoundResponse {
    const error = new GetVehiclesByIdNotFoundResponse(message, response);
    const result = getVehiclesByIdNotFoundResponseResponse.safeParse(response);
    const parsedResponse = (result.success ? result.data : response || {}) as z.infer<
      typeof getVehiclesByIdNotFoundResponseResponse
    >;

    error.message = parsedResponse.message || '';

    return error;
  }

  public throw() {
    const error = GetVehiclesByIdNotFoundResponse.from(this.message, this.response);
    error.metadata = this.metadata;
    throw error;
  }
}
