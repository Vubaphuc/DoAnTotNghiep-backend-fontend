import React from "react";
import { Controller } from "react-hook-form";
import { Link } from "react-router-dom";
import Select from "react-select";
import addressQuery from "../../../address/address";
import { getAddress, getHangSanXuaOptions } from "../../../options/options";
import hookDangKyKhachHangMoi from "../../../hook/hookNhanvien/hookNhanVienLeTan/hookDangKyKhachHangMoi";


function DangKyKhachHangPage() {

  const { control, register, handleSubmit, errors, onDangKyKhachHang } =
    hookDangKyKhachHangMoi();

  const { provinces } = addressQuery();

  const addressoption = getAddress(provinces);


  return (
    <>
      <section className="content">
        <div className="container-fluid">
          <form onSubmit={handleSubmit(onDangKyKhachHang)}>
            <div className="row py-2">
              <div className="col-6">
                <Link to={"/nhan-vien/le-tan"} className="btn btn-default">
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
                          <label>Trạng thái</label>
                          <Controller
                            name="addressKH"
                            control={control}
                            render={({ field }) => (
                              <div>
                                <Select
                                  {...field}
                                  placeholder="--chọn địa chỉ--"
                                  options={addressoption}
                                  value={addressoption.find(
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

export default DangKyKhachHangPage;
