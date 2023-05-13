import React from "react";
import { Controller } from "react-hook-form";
import { Link } from "react-router-dom";
import Select from "react-select";
import useDangKyKhachHangSanPhamMoi from "../../../hook/hookNhanvien/hookNhanVienLeTan/useDangKyKhachHangSanPhamMoi";
import addressQuery from "../../../address/address";
import { getAddress, getHangSanXuaOptions } from "../../../options/options";
import { useEffect } from "react";

function DangKyKhachHangPage() {
  const { control, register, setValue, handleSubmit, watch, errors, onDangKy } =
    useDangKyKhachHangSanPhamMoi();

  const { provinces } = addressQuery();

  const addressoption = getAddress(provinces);

  const soLuong = watch("soLuong");
  const giaTien = watch("giaTien");

  const thanhTien = parseFloat(soLuong) * parseFloat(giaTien);

  useEffect(() => {
    setValue("thanhTien", thanhTien);
  }, [thanhTien, setValue]);

  const handleReaderAvatar = (e) => {
    const file = e.target.files[0];

    const reader = new FileReader();

    reader.onload = () => {
      const avatarImg = document.getElementById("san-pham");
      avatarImg.src = reader.result;
    };

    reader.readAsDataURL(file);
  };

  const hangSanXuatOptions = getHangSanXuaOptions();

  return (
    <>
      <section className="content">
        <div className="container-fluid">
          <form onSubmit={handleSubmit(onDangKy)}>
            <div className="row py-2">
              <div className="col-6">
                <Link to={"/nhan-vien/le-tan"} className="btn btn-default">
                  <i className="fas fa-chevron-left"></i> Quay lại
                </Link>
                <button type="submit" className="btn btn-info px-4">
                  Lưu
                </button>
                <Link
                  to={"/nhan-vien/le-tan/them-sp"}
                  className="btn btn-secondary"
                >
                  Thêm Sản phẩm
                </Link>
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
                        <div className="form-group mt-3">
                          <label className="form-label">
                            Hình ảnh sản phẩm
                          </label>
                          <div className="avatar-preview mb-3 rounded">
                            <img
                              src=""
                              alt="avatar"
                              id="san-pham"
                              className="rounded"
                            />
                          </div>
                          <label className="btn btn-warning" htmlFor="input">
                            Chọn ảnh
                          </label>
                          <input
                            type="file"
                            id="input"
                            className="d-none"
                            onChange={(e) => handleReaderAvatar(e)}
                          />
                          <button
                            type="button"
                            className="btn btn-primary"
                            data-bs-toggle="modal"
                            data-bs-target="#modal-change-password"
                          >
                            Lưu Ảnh
                          </button>
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
                        <div className="form-group">
                          <label>Thành Tiền</label>
                          <input
                            type="text"
                            className="form-control"
                            id="thanh-tien"
                            {...register("thanhTien")}
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
