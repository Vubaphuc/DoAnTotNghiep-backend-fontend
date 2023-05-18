import { yupResolver } from "@hookform/resolvers/yup";
import { useForm } from "react-hook-form";
import { useNavigate } from "react-router-dom";
import { toast } from "react-toastify";
import { dangKyKhachHangMoiSchemas } from "../../../schema/nhanvien/nhanvienletan/nhanVienLeTanSchemas";
import { useDangKyKhachHangMoiMutation } from "../../../../app/apis/nhanvienletanApi/khachHangApi"




const hookDangKyKhachHangMoi = () => {

    const navigate = useNavigate();

    const [dangKyKhachHangMoi] = useDangKyKhachHangMoiMutation();


    const { control, register, setValue, handleSubmit, watch, formState: { errors } } = useForm({
        resolver: yupResolver(dangKyKhachHangMoiSchemas),
        mode: "all"
    })

    const onDangKyKhachHang = (data) => {

        dangKyKhachHangMoi(data)
            .unwrap()
            .then((rs) => {
                toast.success("Đăng ký thành công");
                navigate(`/nhan-vien/le-tan/dk-kh/${rs.id}`);
            })
            .catch((err) => {
                toast.error(err.data.message)
            })
    }

    return {
        control, register, setValue, handleSubmit, watch, errors, onDangKyKhachHang
    }

}

export default hookDangKyKhachHangMoi;