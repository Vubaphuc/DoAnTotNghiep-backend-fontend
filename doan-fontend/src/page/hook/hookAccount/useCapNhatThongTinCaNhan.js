import { yupResolver } from "@hookform/resolvers/yup";
import { useForm } from "react-hook-form";
import { useNavigate } from "react-router-dom";
import { useCapNhatThongTinCaNhanMutation } from "../../../app/apis/nhanvienchungapis/thongTinCaNhanApi";
import { toast } from "react-toastify";
import { capNhatThongTinCaNhanSchema } from "../../schema/account/accountSchemas";

const useCapNhatThongTinCaNhan = () => {

  const navigate = useNavigate();

  const [capNhatThongTinCaNhan] = useCapNhatThongTinCaNhanMutation();

  const {
    control,
    register,
    handleSubmit,
    formState: { errors },
  } = useForm({
    resolver: yupResolver(capNhatThongTinCaNhanSchema),
    mode: "all",
  });

  const onCapNhatThongTinCaNhan = (data) => {


    capNhatThongTinCaNhan(data)
      .unwrap()
      .then(() => {
        toast.success("Cập nhật thành công");
        navigate("/nhan-vien/thong-tin/tai-khoan");
      })
      .catch((err) => {
        toast.error(err.data.message);
      });
   };

  return {
    control,
    register,
    handleSubmit,
    errors,
    onCapNhatThongTinCaNhan,
  };
};

export default useCapNhatThongTinCaNhan;
