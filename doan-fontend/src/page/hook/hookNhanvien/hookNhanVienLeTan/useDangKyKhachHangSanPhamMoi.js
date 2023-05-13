import { yupResolver } from "@hookform/resolvers/yup";
import { useForm } from "react-hook-form";
import { useNavigate } from "react-router-dom";
import { useDangKyKhachHangSanPhamMutation } from "../../../../app/apis/nhanvienletanApi/dangKyKhachHangSanPhamApi";
import { toast } from "react-toastify";
import { dangKyKhachHangSanPhamSchemas } from "../../../schema/nhanvien/nhanvienletan/nhanVienLeTanSchemas";


const useDangKyKhachHangSanPhamMoi = () => {

    const navigate = useNavigate();

    const [dangKyKhachHangSanPhamMoi]  = useDangKyKhachHangSanPhamMutation();


    const { control, register, setValue, handleSubmit, watch, formState: { errors } } = useForm({
        resolver: yupResolver(dangKyKhachHangSanPhamSchemas),
        mode: "all"
    })

    const onDangKy = (data) => {
       

        dangKyKhachHangSanPhamMoi(data)
            .unwrap()
            .then(() => {
                toast.success("Đăng ký thành công")
                navigate("/nhan-vien/le-tan");
            })
            .catch((err) => {
                toast.error(err.data.message)
            })
    }

    return {
        control, register, setValue, handleSubmit, watch, errors, onDangKy
    }

}

export default useDangKyKhachHangSanPhamMoi;