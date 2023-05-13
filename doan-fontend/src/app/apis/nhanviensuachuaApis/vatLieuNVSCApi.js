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
    endpoints: (builder) => ({
        danhSachVatLieuConHang: builder.query ({
            query: ({page, pageSize}) => `danh-sach?page=${page}&pageSize=${pageSize}`
        }),
        danhSachStatusOKOrder: builder.query ({
            query: ({page, pageSize}) => `order/danh-sach-ok?page=${page}&pageSize=${pageSize}`
        }),
        danhSachStatusPENDINGOrder: builder.query ({
            query: ({page, pageSize}) => `order/danh-sach-pending?page=${page}&pageSize=${pageSize}`
        }),
        danhSachVatLieuTheoModelVaLinhKien: builder.query ({
            query: ({tenModel, tenLinhKien}) => `tao/danh-sach?tenModel=${tenModel}&tenLinhKien=${tenLinhKien}`
        }),
        chiTietVatLieuTheoCode: builder.query ({
            query: (code) => `chi-tiet/${code}`
        }),
        taoMoiOrderVatLieu: builder.mutation ({
            query: (data) => ({
                url: "order",
                method: "POST",
                body: data,
            }),
        }),
    }),

});

export const {
    useLazyDanhSachVatLieuConHangQuery,
    useDanhSachVatLieuConHangQuery,
    useLazyDanhSachStatusOKOrderQuery,
    useLazyDanhSachStatusPENDINGOrderQuery,
    useChiTietVatLieuTheoCodeQuery,
    useTaoMoiOrderVatLieuMutation,
    useDanhSachVatLieuTheoModelVaLinhKienQuery
} = vatLieuNVSCApi;