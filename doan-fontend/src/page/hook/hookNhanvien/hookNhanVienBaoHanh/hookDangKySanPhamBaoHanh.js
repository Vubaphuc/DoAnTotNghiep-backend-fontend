import { yupResolver } from "@hookform/resolvers/yup";
import { useForm } from "react-hook-form";
import { useNavigate } from "react-router-dom";
import { dangKySanPhamBaoHanhSchems } from "../../../schema/nhanvien/nhanvienbaohanh/nhanVienBaoHanhSchemas";


const hookDangKySanPhamBaoHanh = () => {

    const navigate = useNavigate();

    const { control, register, handleSubmit, formState: { errors } } = useForm({
        resolver: yupResolver(dangKySanPhamBaoHanhSchems),
        mode: "all"
    });

    const onDangKySanPhamBaoHanh = (data) => {
        console.log(data)
    }

    return {
        control, register, handleSubmit, errors, onDangKySanPhamBaoHanh
    }


}

export default hookDangKySanPhamBaoHanh;