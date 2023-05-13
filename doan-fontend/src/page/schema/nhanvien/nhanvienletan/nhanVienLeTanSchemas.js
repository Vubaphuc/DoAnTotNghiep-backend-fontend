import * as yup from "yup";

export const dangKyKhachHangSanPhamSchemas = yup.object({
  fullNameKH: yup.string().required("Họ và Tên không được để trống"),
  phoneKH: yup.string().required("Số Điện Thoại không được để trống"),
  emailKH: yup.string().required("Email không được để trống"),
  addressKH: yup.string().required("Địa chỉ không được để trống"),
  hangSanPham: yup.string().required("Hãng sản xuất không được để trống"),
  model: yup.string().required("Dòng máy không được để trống"),
  soIME: yup.string().required("Số IME không được để trống"),
  tenLoi: yup.string().required("Mô tả lỗi không được để trống"),
  soLuong: yup.string().required("Số Lượng không được để trống"),
  giaTien: yup.string().required("Giá Tiền không được để trống"),
});


export const hoaDonSchemas = yup.object({
    fullNameKH: yup.string().required("Họ và Tên không được để trống"),
    phoneKH: yup.string().required("Số Điện Thoại không được để trống"),
    emailKH: yup.string().required("Email không được để trống"),
    maSanPham: yup.string().required("Địa chỉ không được để trống"),
    hangSanPham: yup.string().required("Hãng sản xuất không được để trống"),
    model: yup.string().required("Dòng máy không được để trống"),
    soIME: yup.string().required("Số IME không được để trống"),
    tenLoi: yup.string().required("Mô tả lỗi không được để trống"),
    viTriSua: yup.string().required("Vị Trí Sửa không được để trống"),
    loaiBaoHanh: yup.string().required("Loại Bảo hành không được để trống"),
    thoiGianBaoHanh: yup.string().required("Thời gian bảo hành không được để trống"),
    soLuong: yup.number().integer().required("Số Lượng không được để trống"),
    giaTien: yup.number().required("Giá Tiền không được để trống"),
    thanhTien: yup.number().required("Giá Tiền không được để trống"),
  });
