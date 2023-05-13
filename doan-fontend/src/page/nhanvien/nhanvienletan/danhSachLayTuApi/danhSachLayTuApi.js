import { useEffect } from "react";
import { useLazyDanhSachSanPhamChuaSuaQuery } from "../../../../app/apis/nhanvienletanApi/sanPhamApi";


const danhSachLayTuApi = () => {

    const [sanPhamChuaSua, { data: sanPhamChuaSuaData, isLoading }] = useLazyDanhSachSanPhamChuaSuaQuery();

    useEffect(() => {
        sanPhamChuaSua({
            page: 1,
            pageSize: 10,
        });
    }, [])


    return {
        sanPhamChuaSuaData, isLoading, sanPhamChuaSua
    }


}

export default danhSachLayTuApi;