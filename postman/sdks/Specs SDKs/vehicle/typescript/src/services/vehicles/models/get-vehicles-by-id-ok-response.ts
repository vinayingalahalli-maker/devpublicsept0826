import { z } from 'zod';

/**
 * Zod schema for the GetVehiclesByIdOkResponse model.
 * Defines the structure and validation rules for this data type.
 * This is the shape used in application code - what developers interact with.
 */
export const getVehiclesByIdOkResponse = z.lazy(() => {
  return z.object({
    id: z.string().optional(),
    nickName: z.string().optional(),
    vin: z.string().optional(),
    make: z.string().optional(),
    model: z.string().optional(),
    year: z.string().optional(),
    miles: z.number().optional(),
  });
});

/**
 * @typedef {GetVehiclesByIdOkResponse} getVehiclesByIdOkResponse
 * @property {string} id
 * @property {string} nickName
 * @property {string} vin
 * @property {string} make
 * @property {string} model
 * @property {string} year
 * @property {number} miles
 */
export type GetVehiclesByIdOkResponse = z.infer<typeof getVehiclesByIdOkResponse>;

/**
 * Zod schema for mapping API responses to the GetVehiclesByIdOkResponse application shape.
 * Handles any property name transformations from the API schema.
 * If property names match the API schema exactly, this is identical to the application shape.
 */
export const getVehiclesByIdOkResponseResponse = z.lazy(() => {
  return z
    .object({
      id: z.string().optional(),
      nickName: z.string().optional(),
      vin: z.string().optional(),
      make: z.string().optional(),
      model: z.string().optional(),
      year: z.string().optional(),
      miles: z.number().optional(),
    })
    .transform((data) => ({
      id: data['id'],
      nickName: data['nickName'],
      vin: data['vin'],
      make: data['make'],
      model: data['model'],
      year: data['year'],
      miles: data['miles'],
    }));
});

/**
 * Zod schema for mapping the GetVehiclesByIdOkResponse application shape to API requests.
 * Handles any property name transformations required by the API schema.
 * If property names match the API schema exactly, this is identical to the application shape.
 */
export const getVehiclesByIdOkResponseRequest = z.lazy(() => {
  return z
    .object({
      id: z.string().optional(),
      nickName: z.string().optional(),
      vin: z.string().optional(),
      make: z.string().optional(),
      model: z.string().optional(),
      year: z.string().optional(),
      miles: z.number().optional(),
    })
    .transform((data) => ({
      id: data['id'],
      nickName: data['nickName'],
      vin: data['vin'],
      make: data['make'],
      model: data['model'],
      year: data['year'],
      miles: data['miles'],
    }));
});
