import { createApi, fetchBaseQuery } from "@reduxjs/toolkit/dist/query/react";


const END_POINT = "http://localhost:8080/nhan-vien-sua-chua/vat-lieu";

export const vatLieuNVSCApi = createApi ({
    reducerPath: "vatLieuNVSCApi",
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
        danhSachVatLieuConHang: builder.query ({
            query: ({page, pageSize}) => `danh-sach?page=${page}&pageSize=${pageSize}`,
            providesTags: ['Product']
        }),
        danhSachStatusOKOrder: builder.query ({
            query: ({page, pageSize}) => `order/danh-sach-ok?page=${page}&pageSize=${pageSize}`,
            providesTags: ['Product']
        }),
        danhSachStatusPENDINGOrder: builder.query ({
            query: ({page, pageSize}) => `order/danh-sach-pending?page=${page}&pageSize=${pageSize}`,
            providesTags: ['Product']
        }),
        chiTietVatLieuTheoCode: builder.query ({
            query: (code) => `chi-tiet/${code}`,
            providesTags: ['Product']
        }),
        taoMoiOrderVatLieu: builder.mutation ({
            query: (data) => ({
                url: "order",
                method: "POST",
                body: data,
            }),
            invalidatesTags: ['Product'],
        }),
        chiTietOrderTheoId: builder.query ({
            query: (id) => `order/${id}`,
            providesTags: ['Product']
        })
    }),

});

export const {
    useLazyDanhSachVatLieuConHangQuery,
    useDanhSachVatLieuConHangQuery,
    useLazyDanhSachStatusOKOrderQuery,
    useLazyDanhSachStatusPENDINGOrderQuery,
    useChiTietVatLieuTheoCodeQuery,
    useTaoMoiOrderVatLieuMutation,
    useChiTietOrderTheoIdQuery
} = vatLieuNVSCApi;