import { Route, Routes } from "react-router-dom";
import LoginPage from "./pages/login/LoginPage";
import PrivateRouter from "./component/privateRouter/PrivateRouter";
import Layout from "./component/layout/layoutNVSC/Layout";
import NhanVienSuaChuaPage from "./pages/employee/NhanVienSuaChua/NhanVienSuaChuaPage";
import NhanVienLeTanPage from "./pages/employee/NhanVienLeTan/NhanVienLeTanPage";
import NhanVienKhoPage from "./pages/employee/NhanVienKho/NhanVienKhoPage";
import ThonTinNhanVien from "./pages/employee/ThongTinNhanVien/ThonTinNhanVien";
import DoiMatKhau from "./pages/employee/DoiMatKhau/DoiMatKhau";
import ProductList from "./pages/employee/NhanVienSuaChua/SanPham/ProductList";
import ProductHistory from "./pages/employee/NhanVienSuaChua/SanPham/ProductHistory";
import ProductPut from "./pages/employee/NhanVienSuaChua/SanPham/ProductPut";
import OderPut from "./pages/employee/NhanVienSuaChua/Oder/OderPut";
import DeleteOder from "./pages/employee/NhanVienSuaChua/Oder/DeleteOder";
import OderCreate from "./pages/employee/NhanVienSuaChua/Oder/OderCreate";
import Register from "./pages/admin/account/Register";

function App() {
  return (
    <>
      <Routes>
        {/* chế độ khách */}
        <Route path="/khach-hang">
          <Route element={<PrivateRouter />}></Route>
        </Route>

        {/* chế độ nhân viên */}

        <Route element={<PrivateRouter />}>
          <Route path="/nhan-vien" element={<Layout />}>
            <Route path="sua-chua">
              <Route index element={<NhanVienSuaChuaPage />} />
              <Route path="history" element={<ProductHistory />} />
              <Route path="sua-oder" element={<OderPut />} />
              <Route path="xoa-oder" element={<DeleteOder />} />
              <Route path="create-oder" element={<OderCreate />} />
              <Route path="sua" element={<ProductPut />} />
              <Route path="danh-sach" element={<ProductList />} />
              <Route path="thong-tin" element={<ThonTinNhanVien />} />
              <Route path="doi-mat-khau" element={<DoiMatKhau />} />
            </Route>

            <Route path="le-tan">
              {/* Home */}
              <Route index element={<NhanVienLeTanPage />} />
              {/* Oder */}
              {/* Thông tin nhân viên */}
            </Route>
            <Route path="kho">
              {/* Home */}
              <Route index element={<NhanVienKhoPage />} />
              {/* Oder */}
              {/* Thông tin nhân viên */}
            </Route>
          </Route>
        </Route>

        {/* chế độ admin */}
        <Route path="admin">
          <Route element={<PrivateRouter />}></Route>
        </Route>

        {/* chế độ login */}
        <Route path="/login" element={<LoginPage />} />
        <Route path="/register" element={<Register />} />
        <Route path="*" />
      </Routes>
    </>
  );
}

export default App;
