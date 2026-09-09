import { z } from 'zod';
import { ThrowableError } from '../../../http/errors/throwable-error';

export type ICreateVehiclesConflictResponseSchema = {
  message?: string;
};

export const createVehiclesConflictResponseResponse = z.lazy(() => {
  return z
    .object({
      message: z.string().optional(),
    })
    .transform((data) => ({
      message: data['message'],
    }));
});

export class CreateVehiclesConflictResponse extends ThrowableError {
  constructor(
    public message: string,
    protected response?: unknown,
  ) {
    super(message);
  }

  static from(message: string, response?: unknown): CreateVehiclesConflictResponse {
    const error = new CreateVehiclesConflictResponse(message, response);
    const result = createVehiclesConflictResponseResponse.safeParse(response);
    const parsedResponse = (result.success ? result.data : response || {}) as z.infer<
      typeof createVehiclesConflictResponseResponse
    >;

    error.message = parsedResponse.message || '';

    return error;
  }

  public throw() {
    const error = CreateVehiclesConflictResponse.from(this.message, this.response);
    error.metadata = this.metadata;
    throw error;
  }
}
