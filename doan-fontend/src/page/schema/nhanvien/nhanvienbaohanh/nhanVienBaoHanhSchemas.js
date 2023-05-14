import * as yup from "yup";

export const dangKySanPhamBaoHanhSchems = yup.object({
  fullNameKH: yup.string().required("Họ và Tên không được để trống"),
  phoneKH: yup.string().required("Số Điện Thoại không được để trống"),
  emailKH: yup
    .string()
    .required("Email không được để trống")
    .matches(
      /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/,
      "Email không hợp lệ"
    ),
  addressKH: yup.string().required("Địa chỉ không được để trống"),

  hangSanPham: yup.string().required("Hãng sản xuất không được để trống"),
  model: yup.string().required("Dòng máy không được để trống"),
  soIME: yup.string().required("Số IME không được để trống"),
  tenLoi: yup.string().required("Mô tả lỗi không được để trống"),
  soLuong: yup.number().required("Số lượng không được để trống"),
});

export const dangKyNhanVienLeTanSchemas = yup.object ({
    maNhanVien: yup.string().required("Nhân Viên sữa chữa không được để trống"),
});
