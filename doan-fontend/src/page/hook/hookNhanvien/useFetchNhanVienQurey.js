import { useDanhSachNhanVienLeTanQuery } from "../../../app/apis/nhanVienBaoHanh/nhanVienBaoHanhApi";
import { useDanhSachNhanVienSuaChuaQuery } from "../../../app/apis/nhanvienletanApi/nhanVienLeTanApi";

const useFetchNhanVienQuery = () => {

    const { data: leTanData, isLoading: leTanLoading } = useDanhSachNhanVienLeTanQuery();

    const { data: suaChuaData, isLoading: suaChuaLoading } = useDanhSachNhanVienSuaChuaQuery();

   
    return {
        suaChuaData, suaChuaLoading, leTanData, leTanLoading
    }

   
}

export default useFetchNhanVienQuery;