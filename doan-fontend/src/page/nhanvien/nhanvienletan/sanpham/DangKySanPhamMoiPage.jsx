import React from "react";
import hookDangKySanPhamMoi from "../../../hook/hookNhanvien/hookNhanVienLeTan/hookDangKySanPhamMoi";
import { Link, useParams } from "react-router-dom";
import { getHangSanXuaOptions } from "../../../options/options";
import { Controller } from "react-hook-form";
import Select from "react-select";
import { useChiTietKhachHangTheoIdQuery } from "../../../../app/apis/nhanvienletanApi/khachHangApi";

function DangKySanPhamMoiPage() {
  const { khachHangId } = useParams();

  const { control, register, handleSubmit, errors, onDangKySanPham } =
    hookDangKySanPhamMoi(khachHangId);

    const { data: khachHangData, isLoading: khachHangLoading } = useChiTietKhachHangTheoIdQuery(khachHangId);

    if (khachHangLoading) {
      return <h2>Loading....</h2>
    }

  const hangSanXuatOptions = getHangSanXuaOptions();

  return (
    <>
      <section className="content">
        <div className="container-fluid">
          <form onSubmit={handleSubmit(onDangKySanPham)}>
            <div className="row py-2">
              <div className="col-6">
                <Link
                  to={"/nhan-vien/le-tan/dk-kh"}
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
                        <h4 className="mb-4">Thông Tin Khách Hàng</h4>
                        <div className="form-group">
                          <label>Mã Khách Hàng</label>
                          <input
                            type="text"
                            className="form-control"
                            id="full-name"
                            defaultValue={khachHangData?.maKhachHang}
                            readOnly
                          />
                        </div>
                        <div className="form-group">
                          <label>Họ Và Tên</label>
                          <input
                            type="text"
                            className="form-control"
                            id="full-name"
                            defaultValue={khachHangData?.fullName}
                            readOnly
                          />
                        </div>
                        <div className="form-group">
                          <label>Số Điện Thoại</label>
                          <input
                            type="text"
                            className="form-control"
                            id="phone"
                            defaultValue={khachHangData?.phoneNumber}
                            readOnly
                          />
                        </div>
                        <div className="form-group">
                          <label>Email</label>
                          <input
                            type="text"
                            className="form-control"
                            id="email"
                            defaultValue={khachHangData?.email}
                            readOnly
                          />
                        </div>
                        <div className="form-group">
                          <label>Address</label>
                          <input
                            type="text"
                            className="form-control"
                            id="email"
                            defaultValue={khachHangData?.address}
                            readOnly
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
                                  options={hangSanXuatOptions}
                                  value={hangSanXuatOptions.find(
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
                          <label>Giá Tiền</label>
                          <input
                            type="text"
                            className="form-control"
                            id="gia-tien"
                            {...register("giaTien")}
                          />
                          <p className="text-danger fst-italic mt-2">
                            {errors.giaTien?.message}
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

export default DangKySanPhamMoiPage;
