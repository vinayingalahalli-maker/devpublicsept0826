import { z } from 'zod';
import { ThrowableError } from '../../../http/errors/throwable-error';

export type IDeleteVehiclesByIdInternalServerErrorResponseSchema = {
  message?: string;
};

export const deleteVehiclesByIdInternalServerErrorResponseResponse = z.lazy(() => {
  return z
    .object({
      message: z.string().optional(),
    })
    .transform((data) => ({
      message: data['message'],
    }));
});

export class DeleteVehiclesByIdInternalServerErrorResponse extends ThrowableError {
  constructor(
    public message: string,
    protected response?: unknown,
  ) {
    super(message);
  }

  static from(message: string, response?: unknown): DeleteVehiclesByIdInternalServerErrorResponse {
    const error = new DeleteVehiclesByIdInternalServerErrorResponse(message, response);
    const result = deleteVehiclesByIdInternalServerErrorResponseResponse.safeParse(response);
    const parsedResponse = (result.success ? result.data : response || {}) as z.infer<
      typeof deleteVehiclesByIdInternalServerErrorResponseResponse
    >;

    error.message = parsedResponse.message || '';

    return error;
  }

  public throw() {
    const error = DeleteVehiclesByIdInternalServerErrorResponse.from(this.message, this.response);
    error.metadata = this.metadata;
    throw error;
  }
}
