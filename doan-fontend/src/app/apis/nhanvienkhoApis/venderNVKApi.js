import { createApi, fetchBaseQuery } from "@reduxjs/toolkit/dist/query/react";


const END_POINT = "http://localhost:8080/nhan-vien-kho/vender";

export const venderNVKApi = createApi ({
    reducerPath: "venderNVKApi",
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
    tagTypes: ['Product'],
    endpoints: (builder) => ({
        danhSachTatCaVender: builder.query ({
            query: ({page,pageSize}) => `danh-sach?page=${page}&pageSize=${pageSize}`,
            providesTags: ['Product'],
        }),
        danhSachVatLieuTheoVendor: builder.query ({
            query: ({page,pageSize,vendorId}) => `chi-tiet?page=${page}&pageSize=${pageSize}&vendorId=${vendorId}`,
            providesTags: ['Product'],
        }),
        timKiemVenderTheoId: builder.query ({
            query: (id) => `search/${id}`,
            providesTags: ['Product'],
        }),
        timKiemVenderTheoTen: builder.query ({
            query: (name) => `tim-kiem/${name}`,
            providesTags: ['Product'],
        }),
        danhSachVenderCoTongSP: builder.query ({
            query: ({page,pageSize}) => `tong?page=${page}&pageSize=${pageSize}`,
            providesTags: ['Product'],
        }),
        taoMoiVender: builder.mutation ({
            query: (data) => ({
                url: "tao-moi",
                method: "POST",
                body: data,
            }),
            invalidatesTags: ['Product'],
        }),
        suaTenVender: builder.mutation ({
            query: ({id,...data}) => ({
                url: `sua-ten/${id}`,
                method: "PUT",
                body: data,
            }),
            invalidatesTags: ['Product'],
        }), 
    }),

});

export const {
    useLazyDanhSachTatCaVenderQuery,
    useDanhSachTatCaVenderQuery,
    useSuaTenVenderMutation,
    useTaoMoiVenderMutation,
    useTimKiemVenderTheoIdQuery,
    useTimKiemVenderTheoTenQuery,
    useLazyDanhSachVenderCoTongSPQuery,
    useLazyDanhSachVatLieuTheoVendorQuery
} = venderNVKApi;