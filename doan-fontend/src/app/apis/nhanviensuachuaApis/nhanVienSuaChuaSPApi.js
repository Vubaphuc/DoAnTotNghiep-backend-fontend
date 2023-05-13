import { createApi, fetchBaseQuery } from "@reduxjs/toolkit/dist/query/react";


const END_POINT = "http://localhost:8080/sua-chua";

export const nhanVienSuaChuaSPApi = createApi ({
    reducerPath: "nhanVienSuaChuaSPApi",
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
        danhSachSanPhamSuaChuaTheoIdNguoiSua: builder.query ({
            query: ({page, pageSize}) => `ds-sp?page=${page}&pageSize=${pageSize}`
        }),
        chiTietSanPhamTheoId: builder.query ({
            query: (id) => `san-pham/${id}`
        }),
        capNhatChiTietSuaChuaSanPham: builder.mutation ({
            query: ({id,...data}) => ({
                url: `cap-nhat/${id}`,
                method: "PUT",
                body: data,
            }),
        }),
    }),

});

export const {
    useLazyDanhSachSanPhamSuaChuaTheoIdNguoiSuaQuery,
    useChiTietSanPhamTheoIdQuery,
    useCapNhatChiTietSuaChuaSanPhamMutation
} = nhanVienSuaChuaSPApi;