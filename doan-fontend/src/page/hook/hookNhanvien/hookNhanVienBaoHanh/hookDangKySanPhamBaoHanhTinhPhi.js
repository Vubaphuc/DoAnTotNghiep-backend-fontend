import { yupResolver } from "@hookform/resolvers/yup";
import { useForm } from "react-hook-form";
import { useNavigate } from "react-router-dom";
import { dangKySanPhamBaoHanhCoTinhPhiSchems } from "../../../schema/nhanvien/nhanvienbaohanh/nhanVienBaoHanhSchemas";
import { toast } from "react-toastify";
import { useRegisterWarrantyMoneyMutation } from "../../../../app/apis/nhanVienBaoHanh/nhanVienBaoHanhApi";


const hookDangKySanPhamBaoHanhTinhPhi = (productId) => {

    const id = productId;

    const navigate = useNavigate();

    const [registerMoney] = useRegisterWarrantyMoneyMutation();


    const { register, handleSubmit , formState: { errors } } = useForm({
        resolver: yupResolver(dangKySanPhamBaoHanhCoTinhPhiSchems),
        mode: "all"
    });

    const onDangKyTinhPhi = (data) => {

        const newData = {...data, id: id};

        registerMoney(newData)
        .unwrap()
        .then(() => {
            toast.success("Đăng Ký Thành Công");
            navigate("/nhan-vien/bao-hanh");
        })
        .catch((err) => {
            toast.error(err.data.message);
        })

    }

    return {
         register, handleSubmit, errors, onDangKyTinhPhi
    }


}

export default hookDangKySanPhamBaoHanhTinhPhi;