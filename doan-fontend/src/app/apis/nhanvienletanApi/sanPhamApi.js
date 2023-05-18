import { createApi, fetchBaseQuery } from "@reduxjs/toolkit/dist/query/react";


const END_POINT = "http://localhost:8080/le-tan/san-pham";

export const sanPhamApi = createApi ({
    reducerPath: "sanPhamApi",
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
        danhSachSanPhamChuaSua: builder.query ({
            query: ({page,pageSize,term}) => `moi-dang-ky?page=${page}&pageSize=${pageSize}&term=${term}`  ,
            providesTags: ['Product']                 
        }),
        danhSachSanPhamOKNVLT: builder.query ({
            query: ({page,pageSize,term}) => `sua-xong?page=${page}&pageSize=${pageSize}&term=${term}` ,
            providesTags: ['Product']  
        }),
        sanPhamTheoId: builder.query ({
            query: (id) => `chi-tiet/${id}`  
        }),
        capNhatSanPhamTheoId: builder.mutation ({
            query: ({id,...data}) => ({
                url: `cap-nhat/${id}`,
                method: "PUT",
                body: data
            }), 
            invalidatesTags: ['Product'] ,
        }),
        searchHistorySanPham: builder.query ({
            query: ({page,pageSize,term}) => `tat-ca?page=${page}&pageSize=${pageSize}&term=${term}`,
            providesTags: ['Product'] 
        }),
        dangKySanPhamMoi: builder.mutation ({
            query: (data) => ({
                url: "tao-moi",
                method: "POST",
                body: data,
            }),
            invalidatesTags: ['Product'],
        }),
        taoHoaDonSanPham: builder.mutation ({
            query: (data) => ({
                url: "san-pham",
                method: "POST",
                body: data,
            }),
            invalidatesTags: ['Product'],
        }),
    }),

});

export const {
    useDanhSachSanPhamChuaSuaQuery,
    useSanPhamTheoIdQuery,
    useCapNhatSanPhamTheoIdMutation,
    useLazyDanhSachSanPhamOKNVLTQuery,
    useDanhSachSanPhamOKNVLTQuery,
    useSearchHistorySanPhamQuery,
    useDangKySanPhamMoiMutation,
    useTaoHoaDonSanPhamMutation
} = sanPhamApi;