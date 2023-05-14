import { yupResolver } from "@hookform/resolvers/yup";
import { useForm } from "react-hook-form";
import { useNavigate } from "react-router-dom";
import { dangKyNhanVienLeTanSchemas } from "../../../schema/nhanvien/nhanvienbaohanh/nhanVienBaoHanhSchemas";


function hookDangKyNhanVienLeTan (sanPhamId) {

    const navigate = useNavigate();

    const { control, register, handleSubmit, formState: { errors } } = useForm({
        resolver: yupResolver(dangKyNhanVienLeTanSchemas),
        mode: "all"
    });

    const onDangKyNhanVienLeTan = (data) => {
        console.log(data);
    }

    return {
        control, register, handleSubmit, errors, onDangKyNhanVienLeTan
    }

}

export default hookDangKyNhanVienLeTan;