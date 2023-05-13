import * as yup from "yup";

export const capNhatThongTinSuaChuaSchams = yup.object({
  nguyenNhanLoi: yup.string().required("Nguyên Nhân không được để trống"),
  viTriSua: yup.string().required("Vị trí sửa không được để trống"),
  trangThai: yup.string().required("Trạng thái không được để trống"),
});

export const orderVatLieuSuaChuaSchemas = yup.object({
  soLuong: yup
    .number()
    .positive()
    .integer("số lượng phải là số nguyên")
    .required("số lượng không được để trống"),
});

export const taoOrderMoiSchemas = yup.object({
  maVatLieu: yup.string().required("Mã Vật Liệu không được để trống"),
  tenModel: yup.string().required("Tên Model không được để trống"),
  loaiLinhKien: yup.string().required("Loại Linh kiện không được để trống"),
  soLuong: yup
    .number()
    .positive()
    .integer("số lượng phải là số nguyên")
    .required("số lượng không được để trống"),
});
