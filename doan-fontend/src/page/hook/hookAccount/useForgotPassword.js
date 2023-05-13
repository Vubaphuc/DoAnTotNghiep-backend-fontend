import { yupResolver } from "@hookform/resolvers/yup";
import { useForm } from "react-hook-form";
import { useNavigate } from "react-router-dom";
import { toast } from "react-toastify";
import { useForgotPasswordMutation } from "../../../app/apis/nhanvienchungapis/quenMatKhauApi";
import { forgotPasswordSchema } from "../../schema/account/accountSchemas";


const useForgotPassword = () => {

    const navigate = useNavigate();

    const [sendEmail] = useForgotPasswordMutation();

    const { register, handleSubmit, formState: { errors } } = useForm({
        resolver: yupResolver(forgotPasswordSchema),
        mode: "all"
    });

    const onSendEmail = (data) => {
        
        console.log(data);
        sendEmail(data)
            .unwrap()
            .then(() => {
                toast.success("Gửi thành công. Hãy kiểm tra lại email của bạn");
                navigate("/login")
            })
            .catch((err) => {
                toast.error(err.data.message);
            })
    }

    return {
        register, handleSubmit, errors, onSendEmail
    }

}

export default useForgotPassword;