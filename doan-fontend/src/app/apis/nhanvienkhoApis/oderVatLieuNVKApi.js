import { createApi, fetchBaseQuery } from "@reduxjs/toolkit/dist/query/react";


const END_POINT = "http://localhost:8080/nhan-vien-kho/oder";

export const oderVatLieuNVKApi = createApi ({
    reducerPath: "oderVatLieuNVKApi",
    baseQuery: fetchBaseQuery ({
        baseUrl: END_POINT,
        prepareHeaders: (heades, { getState }) => {

            const token = getState().auth.token;

            if (token) {
                heades.set("Authorization", `Bearer ${token}`);
            }
            return heades;
        },
    }),
    endpoints: (builder) => ({
    }),

});

export const {
} = oderVatLieuNVKApi;