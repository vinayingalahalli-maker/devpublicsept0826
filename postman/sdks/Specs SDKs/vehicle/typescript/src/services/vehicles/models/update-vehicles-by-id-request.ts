import { z } from 'zod';

/**
 * Zod schema for the UpdateVehiclesByIdRequest model.
 * Defines the structure and validation rules for this data type.
 * This is the shape used in application code - what developers interact with.
 */
export const updateVehiclesByIdRequest = z.lazy(() => {
  return z.object({
    nickName: z.string().optional(),
    vin: z.string().optional(),
    make: z.string().optional(),
    model: z.string().optional(),
    year: z.string().optional(),
    miles: z.number().optional(),
  });
});

/**
 * @typedef {UpdateVehiclesByIdRequest} updateVehiclesByIdRequest
 * @property {string} nickName
 * @property {string} vin
 * @property {string} make
 * @property {string} model
 * @property {string} year
 * @property {number} miles
 */
export type UpdateVehiclesByIdRequest = z.infer<typeof updateVehiclesByIdRequest>;

/**
 * Zod schema for mapping API responses to the UpdateVehiclesByIdRequest application shape.
 * Handles any property name transformations from the API schema.
 * If property names match the API schema exactly, this is identical to the application shape.
 */
export const updateVehiclesByIdRequestResponse = z.lazy(() => {
  return z
    .object({
      nickName: z.string().optional(),
      vin: z.string().optional(),
      make: z.string().optional(),
      model: z.string().optional(),
      year: z.string().optional(),
      miles: z.number().optional(),
    })
    .transform((data) => ({
      nickName: data['nickName'],
      vin: data['vin'],
      make: data['make'],
      model: data['model'],
      year: data['year'],
      miles: data['miles'],
    }));
});

/**
 * Zod schema for mapping the UpdateVehiclesByIdRequest application shape to API requests.
 * Handles any property name transformations required by the API schema.
 * If property names match the API schema exactly, this is identical to the application shape.
 */
export const updateVehiclesByIdRequestRequest = z.lazy(() => {
  return z
    .object({
      nickName: z.string().optional(),
      vin: z.string().optional(),
      make: z.string().optional(),
      model: z.string().optional(),
      year: z.string().optional(),
      miles: z.number().optional(),
    })
    .transform((data) => ({
      nickName: data['nickName'],
      vin: data['vin'],
      make: data['make'],
      model: data['model'],
      year: data['year'],
      miles: data['miles'],
    }));
});
