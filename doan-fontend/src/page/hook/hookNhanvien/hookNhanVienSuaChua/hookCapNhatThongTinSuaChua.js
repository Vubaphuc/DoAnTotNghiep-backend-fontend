import { yupResolver } from "@hookform/resolvers/yup";
import { useForm } from "react-hook-form";
import { useNavigate } from "react-router-dom";
import { useCapNhatChiTietSuaChuaSanPhamMutation } from "../../../../app/apis/nhanviensuachuaApis/nhanVienSuaChuaSPApi";
import { capNhatThongTinSuaChuaSchams } from "../../../schema/nhanvien/nhanviensuachua/nhanVienSuaChuaSchemas";
import { toast } from "react-toastify";

function hookCapNhatThongTinNhanVienSuaChua (sanPhamId) {

    const id = sanPhamId;

    const navigate = useNavigate();

    const [capNhatChiTietSuaChuaSanPham] = useCapNhatChiTietSuaChuaSanPhamMutation();


    const { control, register, handleSubmit, formState: { errors } } = useForm({
        resolver: yupResolver(capNhatThongTinSuaChuaSchams),
        mode: "all"
    });


    const onCapNhatThongTinSuaChua = (data) => {
        const newData = {...data,id: id};

        console.log(newData)

        capNhatChiTietSuaChuaSanPham(newData)
            .unwrap()
            .then(() => {
                toast.success("Cập nhật thành công");
                navigate("/nhan-vien/sua-chua")
            })
            .catch((err) => {
                toast.error(err.data.message)
            })
    }

    return {
        control, register, handleSubmit, errors, onCapNhatThongTinSuaChua
    }

}

export default hookCapNhatThongTinNhanVienSuaChua;