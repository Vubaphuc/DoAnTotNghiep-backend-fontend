import * as yup from "yup";

export const dangKyVatLieuMoiSchemas = yup.object().shape({
  maVatLieu: yup.string().required("Mã vật liệu không được để trống"),
  tenModel: yup.string().required("Tên Model không được để trống"),
  venderId: yup.number().required("Vender không được để trống"),
  loaiLinhKienId: yup.number().required("Loại linh kiện không được để trống"),
  soLuong: yup
    .number()
    .required("số lượng không được để trống")
    .integer("số lượng phải là số nguyên"),
});

export const dangKyVenderSchemas = yup.object().shape({
  name: yup.string().required("Tên Vender không được để trống"),
});

export const dangKyLinhKienSchemas = yup.object().shape({
  name: yup.string().required("Tên linh kiện không được để trống"),
  thoiGianBaoHanh: yup
    .number()
    .required("thời gian không được để trống")
    .integer("thời gian tính theo tháng"),
});

export const capNhatSoLuongVatLieuSchemas = yup.object().shape({
  soLuong: yup
    .number()
    .required("số lượng không được để trống")
    .integer("số lượng phải là số nguyên"),
});

export const pheDuyetOrderSchemas = yup.object().shape({
  maVatLieu: yup.string().required("Mã Vật Liệu không được để trống"),
  soLuong: yup
  .number()
  .required("số lượng không được để trống")
  .integer("số lượng phải là số nguyên"),
  trangThai: yup.boolean().test(
    "is-true",
    "Trạng thái phải là OK",
    value => value === true
  ).required("Trạng thái không được trống")
});
