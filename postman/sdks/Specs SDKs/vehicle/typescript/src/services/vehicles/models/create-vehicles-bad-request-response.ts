import { z } from 'zod';
import { ThrowableError } from '../../../http/errors/throwable-error';

export type ICreateVehiclesBadRequestResponseSchema = {
  message?: string;
};

export const createVehiclesBadRequestResponseResponse = z.lazy(() => {
  return z
    .object({
      message: z.string().optional(),
    })
    .transform((data) => ({
      message: data['message'],
    }));
});

export class CreateVehiclesBadRequestResponse extends ThrowableError {
  constructor(
    public message: string,
    protected response?: unknown,
  ) {
    super(message);
  }

  static from(message: string, response?: unknown): CreateVehiclesBadRequestResponse {
    const error = new CreateVehiclesBadRequestResponse(message, response);
    const result = createVehiclesBadRequestResponseResponse.safeParse(response);
    const parsedResponse = (result.success ? result.data : response || {}) as z.infer<
      typeof createVehiclesBadRequestResponseResponse
    >;

    error.message = parsedResponse.message || '';

    return error;
  }

  public throw() {
    const error = CreateVehiclesBadRequestResponse.from(this.message, this.response);
    error.metadata = this.metadata;
    throw error;
  }
}
