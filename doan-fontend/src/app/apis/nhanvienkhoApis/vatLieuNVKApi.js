import { createApi, fetchBaseQuery } from "@reduxjs/toolkit/dist/query/react";

const END_POINT = "http://localhost:8080/nhan-vien-kho/vat-lieu";

export const vatLieuApi = createApi({
  reducerPath: "vatLieuApi",
  baseQuery: fetchBaseQuery({
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
    danhSachTatCaLinhKien: builder.query({
      query: ({ page, pageSize }) =>
        `linh-kien/danh-sach?page=${page}&pageSize=${pageSize}`,
    }),
    danhSachVatLieuAll: builder.query({
        query: ({ page, pageSize }) =>
          `danh-sach?page=${page}&pageSize=${pageSize}`,
      }),
    taoMoiLinhKien: builder.mutation({
      query: (data) => ({
        url: "linh-kien/tao-moi",
        method: "POST",
        body: data,
      }),
    }),
    taoMoiVatLieu: builder.mutation({
      query: (data) => ({
        url: "tao-moi",
        method: "POST",
        body: data,
      }),
    }),
  }),
});

export const {
  useLazyDanhSachTatCaLinhKienQuery,
  useDanhSachTatCaLinhKienQuery,
  useTaoMoiLinhKienMutation,
  useTaoMoiVatLieuMutation,
  useLazyDanhSachVatLieuAllQuery
} = vatLieuApi;
