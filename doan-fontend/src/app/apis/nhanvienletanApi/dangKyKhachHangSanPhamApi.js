import { createApi, fetchBaseQuery } from "@reduxjs/toolkit/dist/query/react";


const END_POINT = "http://localhost:8080/dang-ky";

export const dangKyKhachHangSanPhamApi = createApi ({
    reducerPath: "dangKyKhachHangSanPhamApi",
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
        dangKyKhachHangSanPham: builder.mutation ({
            query: (data) => ({
                url: "new",
                method: "POST",
                body: data,
            }),
        }),
    }),

});

export const {
    useDangKyKhachHangSanPhamMutation
} = dangKyKhachHangSanPhamApi;