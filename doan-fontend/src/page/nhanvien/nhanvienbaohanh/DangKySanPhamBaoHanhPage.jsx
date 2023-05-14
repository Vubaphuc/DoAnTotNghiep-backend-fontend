import React, { useState } from "react";
import { Controller, useForm } from "react-hook-form";
import { Link } from "react-router-dom";
import Select from "react-select";
import hookDangKySanPhamBaoHanh from "../../hook/hookNhanvien/hookNhanVienBaoHanh/hookDangKySanPhamBaoHanh";
import { getAddress, getHangSanXuaOptions, getNhanViens } from "../../options/options";
import addressQuery from "../../address/address";

function DangKySanPhamBaoHanhPage() {
  const [status, setStatus] = useState("OK");

  const { control, register, handleSubmit, errors, onDangKySanPhamBaoHanh } =
    hookDangKySanPhamBaoHanh();

  const { provinces } = addressQuery();

  const addressOptions = getAddress(provinces);

  const hangSanPhamOptions = getHangSanXuaOptions();

  return (
    <>
      <section className="content">
        <div className="container-fluid">
          <form onSubmit={handleSubmit(onDangKySanPhamBaoHanh)}>
            <div className="row py-2">
              <div className="col-6">
                <Link to={"/nhan-vien/bao-hanh"} className="btn btn-default">
                  <i className="fas fa-chevron-left"></i> Quay lại
                </Link>
                <button type="submit" className="btn btn-info px-4">
                  Đăng Ký
                </button>
              </div>
            </div>
            <div className="row">
              <div className="col-12">
                <div className="card">
                  <div className="card-body">
                    <div className="table-sp-kh">
                      <div className="col-md-5">
                        <h4 className="mb-4">Thông Tin Khách Hàng</h4>
                        <div className="form-group">
                          <label>Họ Và Tên</label>
                          <input
                            type="text"
                            className="form-control"
                            id="full-name"
                            {...register("fullNameKH")}
                          />
                          <p className="text-danger fst-italic mt-2">
                            {errors.fullNameKH?.message}
                          </p>
                        </div>
                        <div className="form-group">
                          <label>Số Điện Thoại</label>
                          <input
                            type="text"
                            className="form-control"
                            id="phone"
                            {...register("phoneKH")}
                          />
                          <p className="text-danger fst-italic mt-2">
                            {errors.phoneKH?.message}
                          </p>
                        </div>
                        <div className="form-group">
                          <label>Email</label>
                          <input
                            type="text"
                            className="form-control"
                            id="email"
                            {...register("emailKH")}
                          />
                          <p className="text-danger fst-italic mt-2">
                            {errors.emailKH?.message}
                          </p>
                        </div>
                        <div className="form-group">
                          <label>Địa Chỉ</label>
                          <Controller
                            name="addressKH"
                            control={control}
                            render={({ field }) => (
                              <div>
                                <Select
                                  {...field}
                                  placeholder="--chọn địa chỉ--"
                                  options={addressOptions}
                                  value={addressOptions.find(
                                    (c) => c.value === field.value
                                  )}
                                  onChange={(val) => field.onChange(val.value)}
                                />
                              </div>
                            )}
                          />
                        </div>
                      </div>
                      <div className="col-md-5">
                        <h4 className="mb-4">Thông Tin Sản Phẩm</h4>
                        <div className="form-group">
                          <label>Hãng Điện Thoại</label>
                          <Controller
                            name="hangSanPham"
                            control={control}
                            render={({ field }) => (
                              <div>
                                <Select
                                  {...field}
                                  placeholder="--Chọn Hãng Sản Xuất--"
                                  options={hangSanPhamOptions}
                                  value={hangSanPhamOptions.find(
                                    (c) => c.value === field.value
                                  )}
                                  onChange={(val) => field.onChange(val.value)}
                                />
                              </div>
                            )}
                          />
                        </div>
                        <div className="form-group">
                          <label>Model</label>
                          <input
                            type="text"
                            className="form-control"
                            id="model"
                            {...register("model")}
                          />
                          <p className="text-danger fst-italic mt-2">
                            {errors.model?.message}
                          </p>
                        </div>
                        <div className="form-group">
                          <label>Số IME</label>
                          <input
                            type="text"
                            className="form-control"
                            id="so-IME"
                            {...register("soIME")}
                          />
                          <p className="text-danger fst-italic mt-2">
                            {errors.soIME?.message}
                          </p>
                        </div>
                        <div className="form-group">
                          <label>Mổ Tả Lỗi</label>
                          <input
                            type="text"
                            className="form-control"
                            id="ten-loi"
                            {...register("tenLoi")}
                          />
                          <p className="text-danger fst-italic mt-2">
                            {errors.tenLoi?.message}
                          </p>
                        </div>
                        <div className="form-group">
                          <label>Số Lượng</label>
                          <input
                            type="text"
                            className="form-control"
                            id="so-luong"
                            {...register("soLuong")}
                          />
                          <p className="text-danger fst-italic mt-2">
                            {errors.soLuong?.message}
                          </p>
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

export default DangKySanPhamBaoHanhPage;
