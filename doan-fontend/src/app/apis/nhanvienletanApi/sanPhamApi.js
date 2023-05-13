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
    endpoints: (builder) => ({
        danhSachSanPhamChuaSua: builder.query ({
            query: ({page,pageSize}) => `moi-dang-ky?page=${page}&pageSize=${pageSize}`                   
        }),
        danhSachSanPhamOKNVLT: builder.query ({
            query: ({page,pageSize}) => `sua-xong?page=${page}&pageSize=${pageSize}`   
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
        }),
    }),

});

export const {
    useLazyDanhSachSanPhamChuaSuaQuery,
    useSanPhamTheoIdQuery,
    useCapNhatSanPhamTheoIdMutation,
    useLazyDanhSachSanPhamOKNVLTQuery
} = sanPhamApi;