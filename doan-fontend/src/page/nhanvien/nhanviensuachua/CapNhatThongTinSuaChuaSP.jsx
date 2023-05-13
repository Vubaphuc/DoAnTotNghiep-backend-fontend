import React from "react";
import { Controller, useForm } from "react-hook-form";
import { Link, useParams } from "react-router-dom";
import Select from "react-select";
import { getTypeOptions } from "../../options/options";
import hookCapNhatThongTinNhanVienSuaChua from "../../hook/hookNhanvien/hookNhanVienSuaChua/hookCapNhatThongTinSuaChua";
import { useChiTietSanPhamTheoIdQuery } from "../../../app/apis/nhanviensuachuaApis/nhanVienSuaChuaSPApi";

function CapNhatThongTinSuaChuaSP() {

    const { sanPhamId } = useParams();

    const { control, register, handleSubmit, errors, onCapNhatThongTinSuaChua } = hookCapNhatThongTinNhanVienSuaChua(sanPhamId);

    const { data: sanPhamData, isLoading: dataLoading } = useChiTietSanPhamTheoIdQuery(sanPhamId);

    if (dataLoading) {
        return <h2>Loading....</h2>
    }

    console.log(sanPhamData)

  

  const defaultStatus = getTypeOptions();

  return (
    <>
      <section className="content">
        <div className="container-fluid">
          <form onSubmit={handleSubmit(onCapNhatThongTinSuaChua)}>
            <div className="row py-2">
              <div className="col-6">
                <Link
                  to={"/nhan-vien/sua-chua"}
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
                        <h4 className="mb-4">Thông Tin Sửa Chữa</h4>
                        <div className="form-group">
                          <label>Nguyên Nhân</label>
                          <input
                            type="text"
                            className="form-control"
                            id="nguyen-nhan-loi"
                            {...register("nguyenNhanLoi")}
                          />
                          <p className="text-danger fst-italic mt-2">
                          {errors.nguyenNhanLoi?.message}
                        </p>
                        </div>
                        <div className="form-group">
                          <label>Vị trí Sửa</label>
                          <input
                            type="text"
                            className="form-control"
                            id="vi-tri-sua"
                            {...register("viTriSua")}
                          />
                          <p className="text-danger fst-italic mt-2">
                          {errors.viTriSua?.message}
                        </p>
                        </div>
                        <div className="form-group">
                          <label>Chú Thích</label>
                          <input
                            type="text"
                            className="form-control"
                            id="chu-thich"
                            {...register("chuThich")}
                          />
                        </div>
                        <div className="form-group">
                          <label className="mb-3">Trạng Thái</label>
                          <Controller
                            name="trangThai"
                            control={control}
                            defaultValue={defaultStatus[0].value}
                            render={({ field }) => (
                              <div>
                                <Select
                                  {...field}
                                  placeholder="--Chọn Trạng Thái--"
                                  options={defaultStatus}
                                  value={defaultStatus.find(
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

export default CapNhatThongTinSuaChuaSP;
