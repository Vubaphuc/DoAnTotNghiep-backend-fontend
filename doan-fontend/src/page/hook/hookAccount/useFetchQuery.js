import axios from "axios";
import { useEffect } from "react";
import { useState } from "react";
import { useSelector } from "react-redux";

const useFetchQuery = () => {


  const [avatarUrl, setAvatarUrl] = useState("");
  const { auth, token } = useSelector((state) => state.auth);

  useEffect(() => {
    getAvatar();
  });

  const getAvatar = async () => {
    try {
      const headers = {
        Authorization: `Bearer ${token}`,
      };
      const rs = await axios.get(
        `http://localhost:8080/nhan-vien/avatar/${auth.id}`,
        {
          headers,
          responseType: "arraybuffer",
        }
      );

      const base64String = btoa(
        new Uint8Array(rs.data).reduce(
          (data, byte) => data + String.fromCharCode(byte),
          ""
        )
      );
      const imgSrc = `data:image/png;base64,${base64String}`;
      setAvatarUrl(imgSrc);
    } catch (error) {

    }
  };

  return {
    auth, avatarUrl, token
  };
};

export default useFetchQuery;
