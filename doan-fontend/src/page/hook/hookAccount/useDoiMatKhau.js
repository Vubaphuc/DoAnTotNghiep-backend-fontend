import { yupResolver } from "@hookform/resolvers/yup";
import { useForm } from "react-hook-form";
import { useNavigate } from "react-router-dom";
import { toast } from "react-toastify";
import { useSelector } from "react-redux";
import { useDoiMatKhauMutation } from "../../../app/apis/nhanvienchungapis/thongTinCaNhanApi";
import { doiMatKhauSchema } from "../../schema/account/accountSchemas";



const useDoiMatKhau = () => {

    const navigate = useNavigate();

    const { auth } = useSelector((state) => state.auth);

    const roles = auth.roles.map((role) => role.name);

    const [doiMatKhau] = useDoiMatKhauMutation(); 

    const { register, handleSubmit, formState: { errors } } = useForm({
        resolver: yupResolver(doiMatKhauSchema),
        mode: "all"
    });

    const onDoiMatKhau = (data) => {

        doiMatKhau(data)
            .unwrap()
            .then(() => {
                toast.success("Cập Nhật Thành Công")
            })
            .catch((err) => {
                toast.error(err.data.message);
        })
    
    }

    return {
        register, handleSubmit, errors, onDoiMatKhau
    }



}

export default useDoiMatKhau;