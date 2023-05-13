import React from "react";
import { Controller, useForm } from "react-hook-form";
import { Link } from "react-router-dom";
import Select from "react-select";
import hookTaoHoaDonSanPham from "../../../hook/hookNhanvien/hookNhanVienLeTan/hookTaoHoaDonSanPham";

function HoaDonVaBaoHanhPage() {
  const { control, register, handleSubmit,setValue, watch, errors, onTaoHoaDon } =
    hookTaoHoaDonSanPham();

  return (
    <>
      <section className="content">
        <div className="container-fluid">
          <form onSubmit={handleSubmit(onTaoHoaDon)}>
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
                {/* đoạn này để thêm sản phẩm thứ n + 1 */}
                <div className="card">
                  <div className="card-body">
                    <div className="table-sp-kh">
                      <div className="col-md-5">
                        <h4 className="mb-4">Hóa Đơn</h4>
                        <div className="form-group">
                          <label>Họ Và Tên Khách Hàng</label>
                          <input
                            type="text"
                            className="form-control"
                            id="fullNameKH"
                            {...register("fullNameKH")}
                          />
                        </div>
                        <div className="form-group">
                          <label>Số điện thoại</label>
                          <input
                            type="text"
                            className="form-control"
                            id="phoneKH"
                            {...register("phoneKH")}
                          />
                        </div>
                        <div className="form-group">
                          <label>Email</label>
                          <input
                            type="text"
                            className="form-control"
                            id="emailKH"
                            {...register("emailKH")}
                          />
                        </div>
                        <div className="form-group">
                          <label>Mã Sản Phẩm</label>
                          <input
                            type="text"
                            className="form-control"
                            id="maSanPham"
                            {...register("maSanPham")}
                          />
                        </div>
                        <div className="form-group">
                          <label>Hãng Sản Xuất</label>
                          <input
                            type="text"
                            className="form-control"
                            id="hangSanPham"
                            {...register("hangSanPham")}
                          />
                        </div>
                        <div className="form-group">
                          <label>Tên Model</label>
                          <input
                            type="text"
                            className="form-control"
                            id="model"
                            {...register("model")}
                          />
                        </div>
                        <div className="form-group">
                          <label>Số IME</label>
                          <input
                            type="text"
                            className="form-control"
                            id="soIME"
                            {...register("soIME")}
                          />
                        </div>
                        <div className="form-group">
                          <label>Tên Lỗi</label>
                          <input
                            type="text"
                            className="form-control"
                            id="tenLoi"
                            {...register("tenLoi")}
                          />
                        </div>
                        <div className="form-group">
                          <label>Vị Trí Sửa</label>
                          <input
                            type="text"
                            className="form-control"
                            id="viTriSua"
                            {...register("viTriSua")}
                          />
                        </div>
                        <div className="form-group">
                          <label>Loại Bảo Hành</label>
                          <input
                            type="text"
                            className="form-control"
                            id="loaiBaoHanh"
                            {...register("loaiBaoHanh")}
                          />
                        </div>
                        <div className="form-group">
                          <label>Thời gian bảo hành</label>
                          <input
                            type="text"
                            className="form-control"
                            id="thoiGianBaoHanh"
                            {...register("thoiGianBaoHanh")}
                          />
                        </div>
                        <div className="form-group">
                          <label>Số lượng</label>
                          <input
                            type="text"
                            className="form-control"
                            id="so-luong"
                            {...register("soLuong")}
                          />
                        </div>
                        <div className="form-group">
                          <label>Giá Tiền</label>
                          <input
                            type="text"
                            className="form-control"
                            id="giaTien"
                            {...register("giaTien")}
                          />
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

export default HoaDonVaBaoHanhPage;
