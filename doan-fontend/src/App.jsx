import "./App.css";
import { Route, Routes } from "react-router-dom";
import Layout from "./components/Layout";
import PrivateRoutes from "./components/PrivateRoutes";
import { ToastContainer, toast } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";
import NhanVienLeTanPage from "./page/nhanvien/nhanvienletan/NhanVienLeTanPage";
import QuanLySanPhamPage from "./page/admin/QuanLySanPhamPage";
import NhanVienSuaChuaPage from "./page/nhanvien/nhanviensuachua/NhanVienSuaChuaPage";
import QuanLyNhanVienPage from "./page/admin/QuanLyNhanVienPage";
import AuthorizeRoutes from "./components/AuthorizeRoutes";
import NotFound from "./page/notfound/NotFound";
import LoginPage from "./page/login/LoginPage";
import AdminPage from "./page/admin/AdminPage";
import Khach from "./page/khach/Khach";
import ForgotPassword from "./page/login/ForgotPassword";
import DoiMatKhau from "./page/nhanvien/DoiMatKhau";
import DangKyNhanVienSuaChuaPage from "./page/nhanvien/nhanvienletan/sanpham/DangKyNhanVienSuaChuaPage";
import ThongTinTaiKhoan from "./page/nhanvien/ThongTinTaiKhoan";
import NhanVienKho from "./page/nhanvien/nhanvienkho/NhanVienKho";
import NhanVienBaoHanhPage from "./page/nhanvien/nhanvienbaohanh/NhanVienBaoHanhPage";
import DanhSachSanPhamChuaSuaChua from "./page/nhanvien/nhanvienletan/sanpham/DanhSachSanPhamChuaSua";
import CapNhatThongTinSuaChuaSP from "./page/nhanvien/nhanviensuachua/CapNhatThongTinSuaChuaSP";
import TimKiemSanPhamPage from "./page/nhanvien/nhanvienletan/timkiem/TimKiemSanPhamPage";
import DanhSachKhachHangPage from "./page/nhanvien/nhanvienletan/khachhang/DanhSachKhachHangPage";
import DangKyKhachHangPage from "./page/nhanvien/nhanvienletan/khachhang/DangKyKhachHangPage";
import HoaDonVaBaoHanhPage from "./page/nhanvien/nhanvienletan/hoadonvabaohanh/HoaDonVaBaoHanhPage";
import DangKyVatLieuPage from "./page/nhanvien/nhanvienkho/vatlieu/DangKyVatLieuPage";
import DanhSachOderPage from "./page/nhanvien/nhanvienkho/oder/DanhSachOderPage";
import TimKiemOderNNVKPage from "./page/nhanvien/nhanvienkho/timkiem/TimKiemOderNNVKPage";
import TimKiemVatLieuNVKPage from "./page/nhanvien/nhanvienkho/timkiem/TimKiemVatLieuNVKPage";
import DanhSachVenderPage from "./page/nhanvien/nhanvienkho/vatlieu/DanhSachVenderPage";
import ThemVenderMoiPage from "./page/nhanvien/nhanvienkho/vatlieu/ThemVenderMoiPage";
import ThemLoaiLinhKienMoiPAge from "./page/nhanvien/nhanvienkho/vatlieu/ThemLoaiLinhKienMoiPAge";
import VendorChiTietPage from "./page/nhanvien/nhanvienkho/vatlieu/VendorChiTietPage";
import DanhSachVatLieuConHangPage from "./page/nhanvien/nhanviensuachua/DanhSachVatLieuConHangPage";
import OderVatLieuNVSCPage from "./page/nhanvien/nhanviensuachua/OderVatLieuNVSCPage";
import DanhSachStatusOrderPage from "./page/nhanvien/nhanviensuachua/DanhSachStatusOrderPage";
import ChiTietOrderPage from "./page/nhanvien/nhanviensuachua/ChiTietOrderPage";
import DangKySanPhamBaoHanhPage from "./page/nhanvien/nhanvienbaohanh/DangKySanPhamBaoHanhPage";
import ThongTinChiTietKhachHangPage from "./page/nhanvien/nhanvienletan/khachhang/ThongTinChiTietKhachHangPage";
import TaoHoaDonPage from "./page/nhanvien/nhanvienletan/hoadonvabaohanh/TaoHoaDonPage";
import ChiTietSanPhamTheoIdPage from "./page/nhanvien/nhanvienletan/sanpham/ChiTietSanPhamTheoIdPage";
import ChiTietMotOrderPage from "./page/nhanvien/nhanvienkho/oder/ChiTietMotOrderPage";
import DangKySanPhamMoiPage from "./page/nhanvien/nhanvienletan/sanpham/DangKySanPhamMoiPage";
import TimKiemSanPhamNVBHPage from "./page/nhanvien/nhanvienbaohanh/TimKiemSanPhamNVBHPage";
import TimKiemBaoHanh from "./page/nhanvien/nhanvienbaohanh/TimKiemBaoHanh";
import DangKyNhanVienSuaChua from "./page/nhanvien/nhanvienbaohanh/DangKyNhanVienSuaChua";
import ChuyenSanPhamSangBenSuaChua from "./page/nhanvien/nhanvienbaohanh/ChuyenSanPhamSangBenSuaChua";

function App() {
  return (
    <>
      <Routes>
        <Route element={<PrivateRoutes />}>
          <Route path="/nhan-vien" element={<Layout />}>
            <Route path="le-tan">
              {/* Trang nhân viên lễ tân */}
              <Route
                element={<AuthorizeRoutes requireRoles={["NHANVIENLETAN"]} />}
              >
                <Route index element={<NhanVienLeTanPage />} />
                <Route path="dk-sc" element={<DanhSachSanPhamChuaSuaChua />} />
                <Route path="dk-sc/:sanPhamId" element={<DangKyNhanVienSuaChuaPage />} />
                <Route path="tim-kiem" element={<TimKiemSanPhamPage />} />
                <Route path="ds-kh" element={<DanhSachKhachHangPage />} />
                <Route path="dk-kh" element={<DangKyKhachHangPage />} />
                <Route path="dk-kh/:khachHangId" element={<DangKySanPhamMoiPage />} />
                <Route path="hd-bh" element={<TaoHoaDonPage />} />
                <Route path="hd-bh/:sanPhamId" element={<HoaDonVaBaoHanhPage />} />
                <Route path="ds-kh/:khachHangId" element={<ThongTinChiTietKhachHangPage />} />
                <Route path="ds-sp/:sanPhamId" element={<ChiTietSanPhamTheoIdPage />} />
              </Route>

              {/* các đường dẫn còn lại */}
              <Route path="*" element={<NotFound />} />
            </Route>

            <Route path="sua-chua">
              {/* trang nhân viên sửa chữa */}
              <Route
                element={<AuthorizeRoutes requireRoles={["NHANVIENSUACHUA"]} />}
              >
                <Route index element={<NhanVienSuaChuaPage />} />
                <Route path=":sanPhamId" element={<CapNhatThongTinSuaChuaSP />} />
                <Route path="vat-lieu" element={<DanhSachVatLieuConHangPage />} />
                <Route path="vat-lieu/:vatLieuCode" element={<OderVatLieuNVSCPage />} />
                <Route path="order" element={<DanhSachStatusOrderPage />} />
                <Route path="order/:orderId" element={<ChiTietOrderPage />} />
              </Route>
            </Route>

            <Route path="kho">
              {/* trang nhân viên kho */}
              <Route
                element={<AuthorizeRoutes requireRoles={["NHANVIENKHO"]} />}
              >
                <Route index element={<NhanVienKho />} />
                <Route path="dang-ky" element={<DangKyVatLieuPage />} />
                <Route path="oder" element={<DanhSachOderPage />} />
                <Route path="oder/:orderId" element={<ChiTietMotOrderPage />} />
                <Route path="search-oder" element={<TimKiemOderNNVKPage />} />
                <Route path="search-vat-lieu" element={<TimKiemVatLieuNVKPage />} />
                <Route path="vender" element={<DanhSachVenderPage />} />
                <Route path="vender/new-vender" element={<ThemVenderMoiPage />} />
                <Route path="linh-kien/new-linh-kien" element={<ThemLoaiLinhKienMoiPAge />} />
                <Route path=":vendorCode" element={<VendorChiTietPage />} />
              </Route>
            </Route>

            <Route path="bao-hanh">
              {/* trang nhân viên kho */}
              <Route
                element={<AuthorizeRoutes requireRoles={["NHANVIENBAOHANH"]} />}
              >
                <Route index element={<NhanVienBaoHanhPage />} />
                <Route path="search/san-pham" element={<TimKiemSanPhamNVBHPage />} />
                <Route path="dang-ky/:productId" element={<DangKySanPhamBaoHanhPage />} />
                <Route path="dang-ky/sua-chua/:productId" element={<ChuyenSanPhamSangBenSuaChua />} />
                <Route path="search/bao-hanh" element={<TimKiemBaoHanh />} />
                <Route path="dang-ky/sua-chua" element={<DangKyNhanVienSuaChua />} />
              </Route>
            </Route>

            {/* phần trang chung của nhân viên */}
            <Route path="thong-tin">
              <Route
                element={
                  <AuthorizeRoutes
                    requireRoles={[
                      "NHANVIENSUACHUA",
                      "NHANVIENLETAN",
                      "ADMIN",
                      "NHANVIENKHO",
                      "NHANVIENBAOHANH",
                    ]}
                  />
                }
              >
                <Route path="doi-mat-khau" element={<DoiMatKhau />} />
                <Route path="tai-khoan" element={<ThongTinTaiKhoan />} />
              </Route>
            </Route>

            <Route path="*" element={<NotFound />} />
          </Route>

          {/* Phần role ADMIN */}
          <Route path="/admin" element={<Layout />}>
            <Route element={<AuthorizeRoutes requireRoles={["ADMIN"]} />}>
              <Route index element={<AdminPage />} />

              <Route path="nhan-vien">
                {/* Quản lý Nhân viên */}
                <Route element={<AuthorizeRoutes requireRoles={["ADMIN"]} />}>
                  <Route index element={<QuanLyNhanVienPage />} />
                </Route>
                {/* các đường dẫn còn lại */}
                <Route path="*" element={<NotFound />} />
              </Route>

              <Route path="san-pham">
                {/* Quản lý sản phẩm */}
                <Route element={<AuthorizeRoutes requireRoles={["ADMIN"]} />}>
                  <Route index element={<QuanLySanPhamPage />} />
                </Route>
                {/* các đường dẫn còn lại */}
                <Route path="*" element={<NotFound />} />
              </Route>

              <Route path="*" element={<NotFound />} />
            </Route>
          </Route>
        </Route>

        {/* trang login */}
        <Route path="/login" element={<LoginPage />} />
        <Route path="/quen-mat-khau" element={<ForgotPassword />} />

        <Route path="/" element={<Khach />} />

        {/* Trang chế độ khách */}
        {/* <Route path="/khach" /> */}

        {/* các đường dẫn khác */}
        <Route path="*" element={<NotFound />} />
      </Routes>

      <ToastContainer
        position="top-right"
        autoClose={2000}
        hideProgressBar
        newestOnTop={false}
        closeOnClick
        rtl={false}
        pauseOnFocusLoss
        draggable
        pauseOnHover
        theme="colored"
      />
    </>
  );
}

export default App;
