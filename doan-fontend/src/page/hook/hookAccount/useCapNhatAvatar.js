
import { useNavigate } from "react-router-dom";
import { useForm } from "react-hook-form";
import { useCapNhatNhatAvatarMutation } from "../../../app/apis/nhanvienchungapis/thongTinCaNhanApi";
import useFetchQuery from "./useFetchQuery";
import { useState } from "react";
import axios from "axios";


const useCapNhatAvatar = () => {

    const [files, setFiles] = useState(null)

    const { token } = useFetchQuery();

    const navigate = useNavigate();


    const handleChangeAvatar = async () => {

        const formData = new FormData();

        formData.append("avatar", files);

        try {

          const headers = {
            Authorization: `Bearer ${token}`,
          };

          const rs = await axios.post(
            "http://localhost:8080/nhan-vien/upload-avatar",
            formData,
            {
              headers
            },
            {
              headers: {
                "Content-Type": "multipart/form-data",
              },
            }
          );
          

          navigate("/nhan-vien/thong-tin/tai-khoan")

        } catch (error) {

          console.log(error);
          
        }
      };


    return {
        setFiles, handleChangeAvatar
    }

}

export default useCapNhatAvatar;