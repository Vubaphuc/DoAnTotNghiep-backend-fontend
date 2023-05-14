import React from "react";
import { Controller, useForm } from "react-hook-form";
import { Link } from "react-router-dom";
import Select from "react-select";
import hookDangKyNhanVienLeTan from "../../hook/hookNhanvien/hookNhanVienBaoHanh/hookDangKyNhanVienLeTan";
import useFetchNhanVienQuery from "../../hook/hookNhanvien/useFetchNhanVienQurey";
import { getNhanViens } from "../../options/options";

function ChuyenSanPhamSangBenLeTan() {

  const { control, handleSubmit, errors, register, onDangKyNhanVienLeTan } = hookDangKyNhanVienLeTan();

  const { leTanData, leTanLoading } = useFetchNhanVienQuery();
  if (leTanLoading) {
    return <h2>Loading...</h2>
  }
  const nhanVienOptions = getNhanViens(leTanData.data);


  return (
    <>
      <section className="content">
        <div className="container-fluid">
          <form onSubmit={handleSubmit(onDangKyNhanVienLeTan)}>
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
                            readOnly
                          />
                        </div>
                        <div className="form-group">
                          <label>Model</label>
                          <input
                            type="text"
                            className="form-control"
                            id="model"
                            readOnly
                          />
                        </div>
                        <div className="form-group">
                          <label>Số IME</label>
                          <input
                            type="text"
                            className="form-control"
                            id="so-IME"
                            readOnly
                          />
                        </div>
                        <div className="form-group">
                          <label>Mổ Tả Lỗi</label>
                          <input
                            type="text"
                            className="form-control"
                            id="ten-loi"
                            readOnly
                          />
                        </div>
                      </div>
                      <div className="col-md-5">
                        <h4 className="mb-4">Thông Tin Nhân Viên Lễ Tân</h4>
                        <div className="form-group">
                          <label className="mb-3">Nhân Viên Lễ Tân</label>
                          <Controller
                            name="maNhanVien"
                            control={control}
                            render={({ field }) => (
                              <div>
                                <Select
                                  {...field}
                                  placeholder="--Chọn Nhân Viên--"
                                  options={nhanVienOptions}
                                  value={nhanVienOptions.find((c) => 
                                    c.value === field.value 
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

export default ChuyenSanPhamSangBenLeTan;
