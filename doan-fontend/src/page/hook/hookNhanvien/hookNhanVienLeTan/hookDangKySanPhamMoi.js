import { yupResolver } from "@hookform/resolvers/yup";
import { useForm } from "react-hook-form";
import { useNavigate } from "react-router-dom";
import { dangKySanPhamMoiSchemas } from "../../../schema/nhanvien/nhanvienletan/nhanVienLeTanSchemas";
import { useDangKySanPhamMoiMutation } from "../../../../app/apis/nhanvienletanApi/sanPhamApi";
import { toast } from "react-toastify";


const hookDangKySanPhamMoi = (khachHangId) => {


    const id = khachHangId;

    const navigate = useNavigate();

    const [dangKySanPhamMoi] = useDangKySanPhamMoiMutation();


    const { control, register ,handleSubmit, formState: { errors } } = useForm({
        resolver: yupResolver(dangKySanPhamMoiSchemas),
        mode: "all"
    });

    const onDangKySanPham = (data) => {

        const newData = {...data, id: id}

        console.log(newData)

        dangKySanPhamMoi(newData)
        .unwrap()
        .then(() => {
            toast.success("Đăng Ký Thành Công");
            navigate("/nhan-vien/le-tan/dk-sc")
        })
        .catch((err) => {
            toast.error(err.data.message);
        })


    }

    return {
        control,register, handleSubmit, errors, onDangKySanPham
    }


}

export default hookDangKySanPhamMoi;