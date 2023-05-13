import { useDanhSachTatCaLinhKienQuery } from "../../../../app/apis/nhanvienkhoApis/vatLieuNVKApi";
import { useDanhSachTatCaVenderQuery } from "../../../../app/apis/nhanvienkhoApis/venderNVKApi";

const danhSachVenderVaLinhKien = () => {

  const { data: linhKienData, isLoading: linhKienLoading } = useDanhSachTatCaLinhKienQuery({ page: 1,
    pageSize: 10,});

  const { data: venderData, isLoading: venderLoading } = useDanhSachTatCaVenderQuery({
    page: 1,
    pageSize: 10,
  });


  return {
    linhKienData, linhKienLoading, venderData, venderLoading
  }
};

export default danhSachVenderVaLinhKien;
