import { yupResolver } from "@hookform/resolvers/yup";
import { useForm } from "react-hook-form";
import { useNavigate } from "react-router-dom";
import { dangKyVenderSchemas } from "../../../schema/nhanvien/nhanvienkho/nhanVienKhoSchemas";
import { useTaoMoiVenderMutation } from "../../../../app/apis/nhanvienkhoApis/venderNVKApi";
import { toast } from "react-toastify";


const hookThemVenderMoi = () => {

    const navigate = useNavigate();

    const [taoMoiVenDer] = useTaoMoiVenderMutation();


    const { register, handleSubmit, formState: { errors }
     } = useForm({
        resolver: yupResolver(dangKyVenderSchemas),
        mode: "all"
    });
    const onDangKyVender = (data) => {
        console.log(data)
        taoMoiVenDer(data)
        .unwrap()
        .then(() => {
            toast.success("Cập nhật thành công");
            navigate("/nhan-vien/kho/vender");
        })
        .catch((err)=> {
            toast.error(err.data.message);
        })
    }

    return {
        register, handleSubmit, errors, onDangKyVender
    }


}

export default hookThemVenderMoi;