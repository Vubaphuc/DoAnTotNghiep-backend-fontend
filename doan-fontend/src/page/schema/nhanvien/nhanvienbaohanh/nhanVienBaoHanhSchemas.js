import * as yup from "yup";

export const dangKySanPhamBaoHanhCoTinhPhiSchems = yup.object({
  tenLoi: yup.string().required("Mô tả lỗi không được để trống"),
  nguyenNhanLoi: yup.string().required("Nguyên nhân lỗi không được để trống"),
  giaTien: yup
  .number()
  .required("số lượng không được để trống")
  .integer("số lượng phải là số nguyên"),
});

export const dangKySanPhamBaoHanhKhongTinhPhiSchems = yup.object({
  tenLoi: yup.string().required("Mô tả lỗi không được để trống"),
  nguyenNhanLoi: yup.string().required("Nguyên nhân lỗi không được để trống"),
});

export const dangKyNhanVienLeTanSchemas = yup.object({
  maNhanVien: yup.string().required("Nhân Viên lễ tân không được để trống"),
});
