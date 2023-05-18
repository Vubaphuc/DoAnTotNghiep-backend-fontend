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
  tagTypes: ['Product'],
  endpoints: (builder) => ({
    danhSachTatCaLinhKien: builder.query({
      query: ({ page, pageSize }) =>
        `linh-kien/danh-sach?page=${page}&pageSize=${pageSize}`,
        providesTags: ['Product']
    }),
    danhSachVatLieuAll: builder.query({
        query: ({ page, pageSize }) =>
          `danh-sach?page=${page}&pageSize=${pageSize}`,
          providesTags: ['Product']
      }),
    taoMoiLinhKien: builder.mutation({
      query: (data) => ({
        url: "linh-kien/tao-moi",
        method: "POST",
        body: data,
      }),
      invalidatesTags: ['Product'],
    }),
    taoMoiVatLieu: builder.mutation({
      query: (data) => ({
        url: "tao-moi",
        method: "POST",
        body: data,
      }),
      invalidatesTags: ['Product'],
    }),
    searchHistoryMaterial: builder.query ({
      query: ({page,pageSize,term}) => `history?page=${page}&pageSize=${pageSize}&term=${term}`,
      providesTags: ['Product'],
    })
  }),
});

export const {
  useLazyDanhSachTatCaLinhKienQuery,
  useDanhSachTatCaLinhKienQuery,
  useTaoMoiLinhKienMutation,
  useTaoMoiVatLieuMutation,
  useLazyDanhSachVatLieuAllQuery,
  useSearchHistoryMaterialQuery
} = vatLieuApi;
