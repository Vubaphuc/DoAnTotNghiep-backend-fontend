import * as yup from "yup";

export const capNhatThongTinSuaChuaSchams = yup.object({
  nguyenNhanLoi: yup.string().required("Nguyên Nhân không được để trống"),
  viTriSua: yup
    .number()
    .integer("số lượng phải là số nguyên")
    .required("số lượng không được để trống"),
    trangThai: yup.boolean().test(
      "is-true",
      "Trạng thái phải là OK",
      value => value === true
    ).required("Trạng thái không được trống"),
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
