import { useDanhSachNhanVienSuaChuaQuery } from "../../../app/apis/nhanvienletanApi/nhanVienLeTanApi";
import { useNhanVienSuaChuaQuery } from "../../../app/apis/nhanVienBaoHanh/nhanVienBaoHanhApi";

const useFetchNhanVienQuery = () => {

    const { data: nhanVienData, isLoading: nhanVienLoading } = useNhanVienSuaChuaQuery();

    const { data: suaChuaData, isLoading: suaChuaLoading } = useDanhSachNhanVienSuaChuaQuery();

   
    return {
        suaChuaData, suaChuaLoading, nhanVienData, nhanVienLoading
    }

   
}

export default useFetchNhanVienQuery;