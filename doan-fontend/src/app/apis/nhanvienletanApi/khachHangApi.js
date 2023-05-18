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
    tagTypes: ['Product','khachHangApi'],
    endpoints: (builder) => ({
        searchKhachHangTheoTenOK: builder.query ({
            query: ({page,pageSize,term}) => `san-pham/search-OK?page=${page}&pageSize=${pageSize}&term=${term}`,
            providesTags: ['Product'],
        }),
        searchKhachHangTheoTenPeding: builder.query ({
            query: ({page,pageSize,term}) => `san-pham/search-Pending?page=${page}&pageSize=${pageSize}&term=${term}`,
            providesTags: ['Product'],
        }),
        danhSachSanPhamTheoIdKhachHang: builder.query ({
            query: (id) => `san-pham/${id}`,
            providesTags: ['Product'],
        }),
        dangKyKhachHangMoi: builder.mutation ({
            query: (data) => ({
                url: "dang-ky",
                method: "POST",
                body: data,
            }),
            invalidatesTags: ['Product'],
        }),
        chiTietKhachHangTheoId: builder.query ({
            query: (id) => `${id}`,
            providesTags: ['Product'],
        }),
    }),

});

export const {
    useSearchKhachHangTheoTenOKQuery,
    useSearchKhachHangTheoTenPedingQuery,
    useDanhSachSanPhamTheoIdKhachHangQuery,
    useDangKyKhachHangMoiMutation,
    useChiTietKhachHangTheoIdQuery,
} = khachHangApi;