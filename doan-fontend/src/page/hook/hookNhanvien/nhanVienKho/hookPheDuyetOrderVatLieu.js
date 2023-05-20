import { useNavigate } from "react-router-dom";
import { usePheDuyetOrderVatLieu_NVKMutation } from "../../../../app/apis/nhanvienkhoApis/oderVatLieuNVKApi";
import { useForm } from "react-hook-form";
import { yupResolver } from "@hookform/resolvers/yup";
import { pheDuyetOrderSchemas } from "../../../schema/nhanvien/nhanvienkho/nhanVienKhoSchemas";
import { toast } from "react-toastify";


const hookPheDuyetOrderVatLieu = (orderId) => {

    const id = orderId;

    const navigate = useNavigate();

    const [addPheDuyetOrder] = usePheDuyetOrderVatLieu_NVKMutation();

    const { control, register, handleSubmit, formState: { errors } } = useForm({
        resolver: yupResolver(pheDuyetOrderSchemas),
        mode: "all"
    });

    const onPheDuyet = (data) => {

        const newData = {...data, id: id}


        addPheDuyetOrder(newData)
        .unwrap()
        .then(() => {
            toast.success("Phê Duyệt Thành Công");
            navigate("/nhan-vien/kho/oder");
        })
        .catch((err) => {
            toast.error(err.data.message);
        })
    }

    return {
        control, register, handleSubmit, errors, onPheDuyet
    }
}

export default hookPheDuyetOrderVatLieu;