import { useNavigate } from "react-router-dom";
import { useCapNhatSanPhamTheoIdMutation } from "../../../../app/apis/nhanvienletanApi/sanPhamApi";
import { useForm } from "react-hook-form";
import { yupResolver } from "@hookform/resolvers/yup";
import { dangKyNhanVienSuaChuaSchemas } from "../../../schema/product/dangKyNhanVienSuaChuaSchemas";
import { toast } from "react-toastify";


function hookCapNhatThongTinNhanVienSuaChua (sanPhamId) {

    const id = sanPhamId;

    const navigate = useNavigate();

    const [addNhanVienSuaChua] = useCapNhatSanPhamTheoIdMutation();



    const { control, handleSubmit, formState: { errors } } = useForm({
        resolver: yupResolver(dangKyNhanVienSuaChuaSchemas),
        mode: "all"
    });

    const onCapNhatNhanVien = (data) => {

        console.log(data)

        const newData = {...data, id: id};
        addNhanVienSuaChua(newData)
            .unwrap()
            .then(() => {
                toast.success("Cập nhật thành công");

                navigate("/nhan-vien/le-tan/dk-sc");
            })
            .catch((err) => {
                toast.error(err.data.message)
            })

    }

    return {
        control, handleSubmit, errors, onCapNhatNhanVien
    }

}

export default hookCapNhatThongTinNhanVienSuaChua;