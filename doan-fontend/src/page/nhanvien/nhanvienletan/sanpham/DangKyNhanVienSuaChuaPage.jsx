import React, { useEffect } from "react";
import { Controller, useForm } from "react-hook-form";
import { Link, useParams } from "react-router-dom";
import Select from "react-select";
import { getNhanViens } from "../../../options/options";
import { useSanPhamTheoIdQuery } from "../../../../app/apis/nhanvienletanApi/sanPhamApi";
import hookCapNhatThongTinNhanVienSuaChua from "../../../hook/hookNhanvien/hookNhanVienLeTan/hookCapNhatThongTinNhanVienSuaChua";
import useFetchNhanVienQuery from "../../../hook/hookNhanvien/useFetchNhanVienQurey";

function DangKyNhanVienSuaChuaPage() {
  const { sanPhamId } = useParams();

  const { control, handleSubmit, errors, onCapNhatNhanVien } =
    hookCapNhatThongTinNhanVienSuaChua(sanPhamId);

  const { suaChuaData, suaChuaLoading } = useFetchNhanVienQuery();
  const { data: sanPhamData, isLoading: sanPhamLoading, isFetching } =
    useSanPhamTheoIdQuery(sanPhamId);

    useEffect(() => {

    }, [isFetching])

  if (suaChuaLoading || sanPhamLoading) {
    return <h2>Loading....</h2>;
  }

  console.log(suaChuaData)

  const danhSachNhanVienSuaChuaOptions = getNhanViens(suaChuaData);

  return (
    <>
      <section className="content">
        <div className="container-fluid">
          <form onSubmit={handleSubmit(onCapNhatNhanVien)}>
            <div className="row py-2">
              <div className="col-6">
                <Link
                  to={"/nhan-vien/le-tan/dk-sc"}
                  className="btn btn-default"
                >
                  <i className="fas fa-chevron-left"></i> Quay lại
                </Link>
                <button type="submit" className="btn btn-info px-4">
                  Lưu
                </button>
              </div>
            </div>
            <div className="row">
              <div className="col-12">
                <div className="card">
                  <div className="card-body">
                    <div className="table-sp-kh">
                      <div className="col-md-5">
                        <h4 className="mb-4">Thông Tin Sản Phẩm</h4>
                        <div className="form-group">
                          <label>Hãng Điện Thoại</label>
                          <input
                            type="text"
                            className="form-control"
                            id="hang-san-pham"
                            defaultValue={sanPhamData?.hangSanXuat}
                            disabled
                          />
                        </div>
                        <div className="form-group">
                          <label>Model</label>
                          <input
                            type="text"
                            className="form-control"
                            id="model"
                            defaultValue={sanPhamData?.model}
                            disabled
                          />
                        </div>
                        <div className="form-group">
                          <label>Số IME</label>
                          <input
                            type="text"
                            className="form-control"
                            id="so-IME"
                            defaultValue={sanPhamData?.ime}
                            disabled
                          />
                        </div>
                        <div className="form-group">
                          <label>Mổ Tả Lỗi</label>
                          <input
                            type="text"
                            className="form-control"
                            id="ten-loi"
                            defaultValue={sanPhamData?.tenLoi}
                            disabled
                          />
                        </div>
                      </div>
                      <div className="col-md-5">
                        <h4 className="mb-4">Thông Tin Nhân Viên Sửa Chữa</h4>
                        <div className="form-group">
                          <label className="mb-3">Nhân Viên Sửa Chữa</label>
                          <Controller
                            name="maNhanVien"
                            control={control}
                            render={({ field }) => (
                              <div>
                                <Select
                                  {...field}
                                  placeholder="--Chọn Nhân Viên--"
                                  options={danhSachNhanVienSuaChuaOptions}
                                  value={danhSachNhanVienSuaChuaOptions.find(
                                    (c) => c.value === field.value
                                  )}
                                  onChange={(val) => field.onChange(val.value)}
                                />
                              </div>
                            )}
                          />
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </form>
        </div>
      </section>
    </>
  );
}

export default DangKyNhanVienSuaChuaPage;
