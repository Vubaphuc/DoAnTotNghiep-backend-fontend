import { createApi, fetchBaseQuery } from "@reduxjs/toolkit/dist/query/react";

const END_POINT = "http://localhost:8080/nhan-vien";

export const thongtinCaNhanApi = createApi ({
    reducerPath: "doiMatKhauApi",
    baseQuery: fetchBaseQuery ({
        baseUrl:END_POINT,
        prepareHeaders: (headers, { getState }) => {
            const token = getState().auth.token;

            if (token) {
                headers.set("Authorization", `Bearer ${token}`);
            }
            return headers;
        },
    }),
    endpoints: (builder) => ({
        doiMatKhau: builder.mutation ({
            query: (data) => ({
                url: "doi-mat-khau",
                method: "PUT",
                body: data,
            }),
        }),
        capNhatThongTinCaNhan: builder.mutation ({
            query: (data) => ({
                url: "cap-nhat",
                method: "PUT",
                body: data,
            }),
        }),
        anhDaiDien: builder.query ({
            query: (id) => `avatar/${id}`
        }),
        capNhatNhatAvatar: builder.mutation ({
            query: (data) => ({
                url: "upload-avatar",
                method: "POST",
                body: data,
            })
        })
    }),
});;

export const { 
    useDoiMatKhauMutation,
    useCapNhatThongTinCaNhanMutation,
    useAnhDaiDienQuery,
    useCapNhatNhatAvatarMutation
} = thongtinCaNhanApi;