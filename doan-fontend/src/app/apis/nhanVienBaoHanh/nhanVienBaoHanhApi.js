import { createApi, fetchBaseQuery } from "@reduxjs/toolkit/dist/query/react";

const END_POINT = "http://localhost:8080/bao-hanh";

export const nhanVienBaoHanhApi = createApi({
  reducerPath: "nhanVienBaoHanhApi",
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
    danhSachNhanVienLeTan: builder.query ({
        query: () => "danh-sach/le-tan"
    }),
  }),
});

export const {
    useLazyDanhSachNhanVienLeTanQuery,
    useDanhSachNhanVienLeTanQuery
} = nhanVienBaoHanhApi;
