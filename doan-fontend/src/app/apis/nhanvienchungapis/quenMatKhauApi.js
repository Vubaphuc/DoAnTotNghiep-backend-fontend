import { createApi, fetchBaseQuery } from "@reduxjs/toolkit/dist/query/react";


const END_POINT = "http://localhost:8080/nhan-vien"

export const quenMatKhauApi = createApi ({
    reducerPath: "nhanVienChungApi",
    baseQuery: fetchBaseQuery({ baseUrl: END_POINT }),
    endpoints: (builder) => ({
        forgotPassword: builder.mutation({
            query: (data) => ({
                url: "quen-mat-khau",
                method: "POST",
                body: data,
            }),
        }),
    }),
});

export const {
    useForgotPasswordMutation
} = quenMatKhauApi;