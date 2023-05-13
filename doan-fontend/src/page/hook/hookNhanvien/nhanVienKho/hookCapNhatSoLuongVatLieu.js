import { yupResolver } from "@hookform/resolvers/yup";
import { useForm } from "react-hook-form";
import { useNavigate } from "react-router-dom";


const capNhatSoLuongVatLieu = () => {

    const navigate = useNavigate();


    const { control, register, handleSubmit, formState: { errors } } = useForm({
        resolver: yupResolver(),
        mode: "all"
    });


    const onCapNhatSoLuongVatLieu = (data) => {
        console.log(data)
    }

    return {
        control, register, handleSubmit, errors, onCapNhatSoLuongVatLieu
    }

}

export default capNhatSoLuongVatLieu;