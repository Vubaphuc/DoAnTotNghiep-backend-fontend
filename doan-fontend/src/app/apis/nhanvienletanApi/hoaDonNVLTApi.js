import { createApi, fetchBaseQuery } from "@reduxjs/toolkit/dist/query/react";


const END_POINT = "http://localhost:8080/le-tan/hoa-don";

export const hoaDonNVLTApi = createApi ({
    reducerPath: "hoaDonNVLTApi",
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
        chiTietSanPhamOK: builder.query ({
            query: (id) => `san-pham/${id}`
        })
    }),

});

export const {
    useChiTietSanPhamOKQuery
} = hoaDonNVLTApi;