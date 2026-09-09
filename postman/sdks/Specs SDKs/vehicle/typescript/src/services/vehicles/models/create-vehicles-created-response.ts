import { z } from 'zod';

/**
 * Zod schema for the CreateVehiclesCreatedResponse model.
 * Defines the structure and validation rules for this data type.
 * This is the shape used in application code - what developers interact with.
 */
export const createVehiclesCreatedResponse = z.lazy(() => {
  return z.object({
    id: z.number().optional(),
    nickName: z.string().optional(),
    vin: z.string().optional(),
    make: z.string().optional(),
    model: z.string().optional(),
    year: z.string().optional(),
    miles: z.string().optional(),
  });
});

/**
 * @typedef {CreateVehiclesCreatedResponse} createVehiclesCreatedResponse
 * @property {number} id
 * @property {string} nickName
 * @property {string} vin
 * @property {string} make
 * @property {string} model
 * @property {string} year
 * @property {string} miles
 */
export type CreateVehiclesCreatedResponse = z.infer<typeof createVehiclesCreatedResponse>;

/**
 * Zod schema for mapping API responses to the CreateVehiclesCreatedResponse application shape.
 * Handles any property name transformations from the API schema.
 * If property names match the API schema exactly, this is identical to the application shape.
 */
export const createVehiclesCreatedResponseResponse = z.lazy(() => {
  return z
    .object({
      id: z.number().optional(),
      nickName: z.string().optional(),
      vin: z.string().optional(),
      make: z.string().optional(),
      model: z.string().optional(),
      year: z.string().optional(),
      miles: z.string().optional(),
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
 * Zod schema for mapping the CreateVehiclesCreatedResponse application shape to API requests.
 * Handles any property name transformations required by the API schema.
 * If property names match the API schema exactly, this is identical to the application shape.
 */
export const createVehiclesCreatedResponseRequest = z.lazy(() => {
  return z
    .object({
      id: z.number().optional(),
      nickName: z.string().optional(),
      vin: z.string().optional(),
      make: z.string().optional(),
      model: z.string().optional(),
      year: z.string().optional(),
      miles: z.string().optional(),
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
