import { yupResolver } from "@hookform/resolvers/yup";
import { useForm } from "react-hook-form";
import { useNavigate } from "react-router-dom";
import { orderVatLieuSuaChuaSchemas } from "../../../schema/nhanvien/nhanviensuachua/nhanVienSuaChuaSchemas";
import { useTaoMoiOrderVatLieuMutation } from "../../../../app/apis/nhanviensuachuaApis/vatLieuNVSCApi";
import { toast } from "react-toastify";


const hookOrderVatLieuSuaChua = () => {

    const navigate = useNavigate();

    const [taoMoiOrderVatLieu] = useTaoMoiOrderVatLieuMutation();

    const { register, handleSubmit, formState: { errors } } = useForm({
        resolver: yupResolver(orderVatLieuSuaChuaSchemas),
        mode: "all"
    });

    const onOrderVatLieu = (data) => {
        
        taoMoiOrderVatLieu(data)
        .unwrap()
        .then(() => {
            toast.success("Tạo Order Thành công");
            
        })
        .catch((err) => {
            toast.error(err.data.message)
        })
    }

    return {
        register, handleSubmit, errors, onOrderVatLieu
    }

}

export default hookOrderVatLieuSuaChua;