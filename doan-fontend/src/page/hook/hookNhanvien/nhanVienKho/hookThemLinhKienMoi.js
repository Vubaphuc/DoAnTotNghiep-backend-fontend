import { yupResolver } from "@hookform/resolvers/yup";
import { useForm } from "react-hook-form";
import { useNavigate } from "react-router-dom";
import { dangKyLinhKienSchemas } from "../../../schema/nhanvien/nhanvienkho/nhanVienKhoSchemas";
import { useTaoMoiLinhKienMutation } from "../../../../app/apis/nhanvienkhoApis/vatLieuNVKApi";
import { toast } from "react-toastify";


const hookThemLinhKienMoi = () => {

    const navigate = useNavigate();

    const [taoMoiLinhKien] = useTaoMoiLinhKienMutation();

    const { register, handleSubmit, formState: { errors } } = useForm({
        resolver: yupResolver(dangKyLinhKienSchemas),
        mode: "all"
    });

    const onDangKyLinhKien = (data) => {
        console.log(data);
        taoMoiLinhKien(data)
        .unwrap()
        .then(() => {
            toast.success("Đăng ký thành công");
            navigate("/nhan-vien/kho");
        })
        .catch((err) => {
            toast.error(err.data.message);
        })
    }


    return {
        register, handleSubmit, errors, onDangKyLinhKien
    }

}

export default hookThemLinhKienMoi;