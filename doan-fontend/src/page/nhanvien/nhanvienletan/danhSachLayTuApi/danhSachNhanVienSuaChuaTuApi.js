import { useDanhSachNhanVienSuaChuaQuery } from "../../../../app/apis/nhanvienletanApi/nhanVienLeTanApi";


const danhSachNhanVienSuaChuaTuApi = () => {

    const { data: nhanVienSuaChuaData, isLoading: loadingSuaChua } = useDanhSachNhanVienSuaChuaQuery();


    return {
        nhanVienSuaChuaData, loadingSuaChua
    }


}

export default danhSachNhanVienSuaChuaTuApi;