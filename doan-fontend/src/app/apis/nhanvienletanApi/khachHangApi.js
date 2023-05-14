import { createApi, fetchBaseQuery } from "@reduxjs/toolkit/dist/query/react";


const END_POINT = "http://localhost:8080/le-tan/khach-hang";

export const khachHangApi = createApi ({
    reducerPath: "khachHangApi",
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
        danhSachOK: builder.query ({
            query: ({page,pageSize}) => `san-pham-ok?page=${page}&pageSize=${pageSize}`
        }),
        danhSachPENDING: builder.query ({
            query: ({page,pageSize}) => `san-pham-pending?page=${page}&pageSize=${pageSize}`
        }),
        searchKhachHangTheoTenOK: builder.query ({
            query: ({page,pageSize,tenKhachHang}) => `san-pham/search-OK?page=${page}&pageSize=${pageSize}&tenKhachHang=${tenKhachHang}`
        }),
        searchKhachHangTheoTenPeding: builder.query ({
            query: ({page,pageSize,tenKhachHang}) => `san-pham/search-Pending?page=${page}&pageSize=${pageSize}&tenKhachHang=${tenKhachHang}`
        })
    }),

});

export const {
    useLazyDanhSachOKQuery,
    useLazyDanhSachPENDINGQuery,
    useSearchKhachHangTheoTenOKQuery,
    useSearchKhachHangTheoTenPedingQuery
} = khachHangApi;