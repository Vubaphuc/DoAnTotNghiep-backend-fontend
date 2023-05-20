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
  tagTypes: ['Product'],
  endpoints: (builder) => ({
    nhanVienSuaChua: builder.query ({
        query: () => "danh-sach/sua-chua",
        providesTags: ['Product'],
    }),
    searchHistoryProductByTerm: builder.query ({
      query: ({page,pageSize,term}) => `search/history-product?page=${page}&pageSize=${pageSize}&term=${term}`,
      providesTags: ['Product'],
    }),
    findProductAndCustomerById: builder.query ({
      query: (id) => `product/${id}`,
      providesTags: ['Product'],
    }),
    registerWarrantyMoney: builder.mutation ({
      query: (data) => ({
        url: "dang-ky/tinh-phi",
        method: "POST",
        body: data,
      }),
      invalidatesTags: ['Product'],
    }),
    registerWarrantyNoMoney: builder.mutation ({
      query: (data) => ({
        url: "dang-ky/khong-tinh-phi",
        method: "POST",
        body: data,
      }),
      invalidatesTags: ['Product'],
    }),
    getDanhSachSanPhamBaoHanhPending: builder.query ({
      query: ({page,pageSize,term}) => `danh-sach/pending?page=${page}&pageSize=${pageSize}&term=${term}`,
      providesTags: ['Product'],
    }),
    getDanhSachSanPhamBaoHanhOK: builder.query ({
      query: ({page,pageSize,term}) => `danh-sach/ok?page=${page}&pageSize=${pageSize}&term=${term}`,
      providesTags: ['Product'],
    }),
    getDanhSachSanPhamBaoHanhTatCa: builder.query ({
      query: ({page,pageSize,term}) => `danh-sach/tat-ca?page=${page}&pageSize=${pageSize}&term=${term}`,
      providesTags: ['Product'],
    }),
    getProductById: builder.query ({
      query: (id) => `san-pham/bao-hanh/${id}`,
      providesTags: ['Product'],
    }),
  }),
});

export const {
    useNhanVienSuaChuaQuery,
    useSearchHistoryProductByTermQuery,
    useFindProductAndCustomerByIdQuery,
    useRegisterWarrantyMoneyMutation,
    useRegisterWarrantyNoMoneyMutation,
    useGetDanhSachSanPhamBaoHanhOKQuery,
    useGetDanhSachSanPhamBaoHanhPendingQuery,
    useGetDanhSachSanPhamBaoHanhTatCaQuery,
    useGetProductByIdQuery
} = nhanVienBaoHanhApi;
