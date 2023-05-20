import { createApi, fetchBaseQuery } from "@reduxjs/toolkit/dist/query/react";


const END_POINT = "http://localhost:8080/nhan-vien-kho/oder";

export const oderVatLieuNVKApi = createApi ({
    reducerPath: "oderVatLieuNVKApi",
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
        danhSachOrderPending_NVK: builder.query ({
            query: ({page, pageSize}) => `danh-sach-pending?page=${page}&pageSize=${pageSize}`,
            providesTags: ['Product'],
        }),
        danhSachOrderOk_NVK: builder.query ({
            query: ({page,pageSize}) => `danh-sach-ok?page=${page}&pageSize=${pageSize}`,
            providesTags: ['Product'],
        }),
        chiTietMotOrderTheoId_NVK: builder.query ({
            query: (id) => `chi-tiet/${id}`,
            providesTags: ['Product'],
        }),
        pheDuyetOrderVatLieu_NVK: builder.mutation ({
            query: ({id, ...data}) => ({
                url: `phe-duyet/${id}`,
                method: "PUT",
                body: data,
            }),
            invalidatesTags: ['Product'],
        }),
        searchHistoryOrderMaterial: builder.query ({
            query: ({page,pageSize,term}) => `danh-sach?page=${page}&pageSize=${pageSize}&term=${term}`,
            providesTags: ['Product'],
        })
    }),

});

export const {
    useLazyDanhSachOrderPending_NVKQuery,
    useLazyDanhSachOrderOk_NVKQuery,
    useChiTietMotOrderTheoId_NVKQuery,
    usePheDuyetOrderVatLieu_NVKMutation,
    useSearchHistoryOrderMaterialQuery,
} = oderVatLieuNVKApi;