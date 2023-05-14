import { configureStore } from "@reduxjs/toolkit";
import authReducer from "./slice/authSlice";
import { quenMatKhauApi } from "./apis/nhanvienchungapis/quenMatKhauApi";
import { thongtinCaNhanApi } from "./apis/nhanvienchungapis/thongTinCaNhanApi";
import { sanPhamApi } from "./apis/nhanvienletanApi/sanPhamApi";
import { nhanVienLeTanApi } from "./apis/nhanvienletanApi/nhanVienLeTanApi";
import { nhanVienSuaChuaSPApi } from "./apis/nhanviensuachuaApis/nhanVienSuaChuaSPApi";
import { khachHangApi } from "./apis/nhanvienletanApi/khachHangApi";
import { authApi } from "./apis/login/authApi";
import { oderVatLieuNVKApi } from "./apis/nhanvienkhoApis/oderVatLieuNVKApi";
import { vatLieuApi } from "./apis/nhanvienkhoApis/vatLieuNVKApi";
import { venderNVKApi } from "./apis/nhanvienkhoApis/venderNVKApi";
import { vatLieuNVSCApi } from "./apis/nhanviensuachuaApis/vatLieuNVSCApi";
import { hoaDonNVLTApi } from "./apis/nhanvienletanApi/hoaDonNVLTApi";
import { nhanVienBaoHanhApi } from "./apis/nhanVienBaoHanh/nhanVienBaoHanhApi";

// Context API + useReducer có thể thay thế cho redux
const store = configureStore({
    reducer: {
        [authApi.reducerPath]: authApi.reducer,
        [nhanVienLeTanApi.reducerPath]: nhanVienLeTanApi.reducer,
        [quenMatKhauApi.reducerPath]: quenMatKhauApi.reducer,
        [thongtinCaNhanApi.reducerPath]: thongtinCaNhanApi.reducer,
        [sanPhamApi.reducerPath]: sanPhamApi.reducer,
        auth: authReducer,
        [nhanVienLeTanApi.reducerPath]: nhanVienLeTanApi.reducer,
        [nhanVienSuaChuaSPApi.reducerPath]: nhanVienSuaChuaSPApi.reducer,
        [khachHangApi.reducerPath]: khachHangApi.reducer,
        [oderVatLieuNVKApi.reducerPath]: oderVatLieuNVKApi.reducer,
        [vatLieuApi.reducerPath]: vatLieuApi.reducer,
        [venderNVKApi.reducerPath]: venderNVKApi.reducer,
        [vatLieuNVSCApi.reducerPath]: vatLieuNVSCApi.reducer,
        [hoaDonNVLTApi.reducerPath]: hoaDonNVLTApi.reducer,
        [nhanVienBaoHanhApi.reducerPath]: nhanVienBaoHanhApi.reducer
    },
    middleware: (getDefaultMiddleware) =>
        getDefaultMiddleware().concat(
            authApi.middleware,
            nhanVienLeTanApi.middleware,
            quenMatKhauApi.middleware,
            thongtinCaNhanApi.middleware,
            sanPhamApi.middleware,
            nhanVienLeTanApi.middleware,
            nhanVienSuaChuaSPApi.middleware,
            khachHangApi.middleware,
            oderVatLieuNVKApi.middleware,
            vatLieuApi.middleware,
            venderNVKApi.middleware,
            vatLieuNVSCApi.middleware,
            hoaDonNVLTApi.middleware,
            nhanVienBaoHanhApi.middleware
        ),
});

export default store;