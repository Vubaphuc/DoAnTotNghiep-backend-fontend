import { yupResolver } from "@hookform/resolvers/yup";
import { useForm } from "react-hook-form";
import { useNavigate } from "react-router-dom";
import { hoaDonSchemas } from "../../../schema/nhanvien/nhanvienletan/nhanVienLeTanSchemas";
import { toast } from "react-toastify";
import { useTaoHoaDonSanPhamMutation } from "../../../../app/apis/nhanvienletanApi/sanPhamApi";


const hookTaoHoaDonSanPham = () => {

    const navigate = useNavigate();

    const [taoHoaDonSanPham] = useTaoHoaDonSanPhamMutation();

    const { control, register,handleSubmit, setValue, watch, formState: { errors } } = useForm({
        resolver: yupResolver(hoaDonSchemas),
        mode: "all"
    });

    const onTaoHoaDon = (data) => {

        taoHoaDonSanPham(data)
        .unwrap()
        .then(() => {
            toast.success("Tạo Hóa Đơn Thành Công");
            navigate("/nhan-vien/le-tan");
        })
        .catch((err) => {
            toast.error(err.data.message);
        })
    }

    return {
        control, register, handleSubmit,setValue, watch, errors, onTaoHoaDon
    }
}

export default hookTaoHoaDonSanPham;