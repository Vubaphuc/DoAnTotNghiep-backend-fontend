import { createApi, fetchBaseQuery } from "@reduxjs/toolkit/dist/query/react";


const END_POINT = "http://localhost:8080/le-tan";

export const nhanVienLeTanApi = createApi ({
    reducerPath: "nhanVienLeTanApi",
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
        danhSachNhanVienSuaChua: builder.query ({
            query: () => "sua-chua",                  
        }),
    }),

});

export const {
    useDanhSachNhanVienSuaChuaQuery
} = nhanVienLeTanApi;