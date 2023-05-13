import { yupResolver } from "@hookform/resolvers/yup";
import { useForm } from "react-hook-form";
import { useNavigate } from "react-router-dom";
import { taoOrderMoiSchemas } from "../../../schema/nhanvien/nhanviensuachua/nhanVienSuaChuaSchemas";

const hookTaoOrderMoi = () => {

    const navigate = useNavigate();

    const { control, register, handleSubmit, watch, formState: { errors } } = useForm({
        resolver: yupResolver(taoOrderMoiSchemas),
        mode: "all"
    });

    const onTaoOrderMoi = (data) => {
        console.log(data)
    }

    return {
        control, register, handleSubmit, watch, errors, onTaoOrderMoi
    }
}

export default hookTaoOrderMoi;