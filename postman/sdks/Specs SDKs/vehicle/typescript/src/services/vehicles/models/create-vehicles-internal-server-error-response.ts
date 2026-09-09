import { z } from 'zod';
import { ThrowableError } from '../../../http/errors/throwable-error';

export type ICreateVehiclesInternalServerErrorResponseSchema = {
  message?: string;
};

export const createVehiclesInternalServerErrorResponseResponse = z.lazy(() => {
  return z
    .object({
      message: z.string().optional(),
    })
    .transform((data) => ({
      message: data['message'],
    }));
});

export class CreateVehiclesInternalServerErrorResponse extends ThrowableError {
  constructor(
    public message: string,
    protected response?: unknown,
  ) {
    super(message);
  }

  static from(message: string, response?: unknown): CreateVehiclesInternalServerErrorResponse {
    const error = new CreateVehiclesInternalServerErrorResponse(message, response);
    const result = createVehiclesInternalServerErrorResponseResponse.safeParse(response);
    const parsedResponse = (result.success ? result.data : response || {}) as z.infer<
      typeof createVehiclesInternalServerErrorResponseResponse
    >;

    error.message = parsedResponse.message || '';

    return error;
  }

  public throw() {
    const error = CreateVehiclesInternalServerErrorResponse.from(this.message, this.response);
    error.metadata = this.metadata;
    throw error;
  }
}
