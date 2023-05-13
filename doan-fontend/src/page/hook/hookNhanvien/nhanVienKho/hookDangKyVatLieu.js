import { yupResolver } from "@hookform/resolvers/yup";
import { useForm } from "react-hook-form";
import { useNavigate } from "react-router-dom";
import { dangKyVatLieuMoiSchemas } from "../../../schema/nhanvien/nhanvienkho/nhanVienKhoSchemas";
import { useTaoMoiVatLieuMutation } from "../../../../app/apis/nhanvienkhoApis/vatLieuNVKApi";
import { toast } from "react-toastify";


const dangKyVatLieu = () => {

    const navigate = useNavigate();

    const [taoMoiVatLieu] = useTaoMoiVatLieuMutation();
    

    const { control, register, handleSubmit, formState: { errors } } = useForm({
        resolver: yupResolver(dangKyVatLieuMoiSchemas),
        mode: "all"
    });

    const onDangKyVatLieu = (data) => {

        console.log(data);
        taoMoiVatLieu(data)
        .unwrap()
        .then(() => {
            toast.success("Đăng ký thành công");
            navigate("");
        })
        .catch((err) => {
            toast.error(err.data.message)
        })
    }


    return {
        control, register, handleSubmit, errors, onDangKyVatLieu
    }

}

export default dangKyVatLieu;