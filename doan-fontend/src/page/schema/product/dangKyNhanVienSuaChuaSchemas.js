import * as yup from "yup";

export const dangKyNhanVienSuaChuaSchemas = yup.object ({
    maNhanVien: yup.string().required("Nhân Viên sữa chữa không được để trống"),
});