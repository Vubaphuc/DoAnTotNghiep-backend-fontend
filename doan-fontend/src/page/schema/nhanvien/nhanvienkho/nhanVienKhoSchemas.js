import * as yup from "yup";

export const dangKyVatLieuMoiSchemas = yup.object({
  maVatLieu: yup.string().required("Mã vật liệu không được để trống"),
  tenModel: yup.string().required("Tên Model không được để trống"),
  venderId: yup.number().required("Vender không được để trống"),
  loaiLinhKienId: yup.number().required("Loại linh kiện không được để trống"),
  soLuong: yup
    .number()
    .required("số lượng không được để trống")
    .integer("số lượng phải là số nguyên"),
});

export const dangKyVenderSchemas = yup.object({
  name: yup.string().required("Tên Vender không được để trống"),
});

export const dangKyLinhKienSchemas = yup.object({
  name: yup.string().required("Tên linh kiện không được để trống"),
  thoiGianBaoHanh: yup
    .number()
    .required("thời gian không được để trống")
    .integer("thời gian tính theo tháng"),
});

export const capNhatSoLuongVatLieuSchemas = yup.object({
  soLuong: yup
    .number()
    .required("số lượng không được để trống")
    .integer("số lượng phải là số nguyên"),
});
