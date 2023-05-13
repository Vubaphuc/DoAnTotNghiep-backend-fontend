import { yupResolver } from "@hookform/resolvers/yup";
import { useForm } from "react-hook-form";
import { useNavigate } from "react-router-dom";
import { hoaDonSchemas } from "../../../schema/nhanvien/nhanvienletan/nhanVienLeTanSchemas";


const hookTaoHoaDonSanPham = () => {

    const navigate = useNavigate();

    const { control, register,handleSubmit, setValue, watch, formState: { errors } } = useForm({
        resolver: yupResolver(hoaDonSchemas),
        mode: "all"
    });

    const onTaoHoaDon = (data) => {
        console.log(data)
    }

    return {
        control, register, handleSubmit,setValue, watch, errors, onTaoHoaDon
    }
}

export default hookTaoHoaDonSanPham;