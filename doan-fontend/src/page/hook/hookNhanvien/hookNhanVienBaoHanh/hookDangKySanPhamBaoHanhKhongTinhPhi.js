import { yupResolver } from "@hookform/resolvers/yup";
import { useForm } from "react-hook-form";
import { useNavigate } from "react-router-dom";
import { dangKySanPhamBaoHanhKhongTinhPhiSchems } from "../../../schema/nhanvien/nhanvienbaohanh/nhanVienBaoHanhSchemas";
import { useRegisterWarrantyNoMoneyMutation } from "../../../../app/apis/nhanVienBaoHanh/nhanVienBaoHanhApi";
import { toast } from "react-toastify";

const hookDangKySanPhamBaoHanhKhongTinhPhi = (productId) => {

    const id = productId;

    const navigate = useNavigate();

    const [registerNoMoney] = useRegisterWarrantyNoMoneyMutation();

    const { register, handleSubmit, formState: { errors } } = useForm({
        resolver: yupResolver(dangKySanPhamBaoHanhKhongTinhPhiSchems),
        mode: "all"
    });

    const onDangKyKhongTinhPhi = (data) => {
        const newData = {...data, id: id}
        registerNoMoney(newData)
        .unwrap()
        .then(() => {
            toast.success("Đăng Ký Thành Công");
            navigate("/nhan-vien/bao-hanh");
        })
        .catch((err) => {
            toast.error(err.data.message)
        })
    }

    return {
        register, handleSubmit, errors, onDangKyKhongTinhPhi
    }

}

export default hookDangKySanPhamBaoHanhKhongTinhPhi;