import React, { useEffect } from "react";
import { Controller, useForm } from "react-hook-form";
import { Link, useParams } from "react-router-dom";
import Select from "react-select";
import hookTaoHoaDonSanPham from "../../../hook/hookNhanvien/hookNhanVienLeTan/hookTaoHoaDonSanPham";
import { useChiTietSanPhamOKQuery } from "../../../../app/apis/nhanvienletanApi/hoaDonNVLTApi";

function HoaDonVaBaoHanhPage() {
  const { sanPhamId } = useParams();

  const id = sanPhamId;

  const { handleSubmit, setValue, onTaoHoaDon } = hookTaoHoaDonSanPham();
  useEffect(() => {
    setValue("id", id);
  }, [id, setValue]);

  const { data: sanPhamData, isLoading: sanPhhamLoading } =
    useChiTietSanPhamOKQuery(sanPhamId);

  if (sanPhhamLoading) {
    return <h2>Loading....</h2>;
  }

  console.log(sanPhamData);

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
                  Tạo 
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
                          <label>Mã Sản Phẩm</label>
                          <input
                            type="text"
                            className="form-control"
                            id="maSanPham"
                            defaultValue={sanPhamData?.id}
                            readOnly
                          />
                        </div>
                        <div className="form-group">
                          <label>Họ Và Tên Khách Hàng</label>
                          <input
                            type="text"
                            className="form-control"
                            id="fullNameKH"
                            defaultValue={sanPhamData?.fullNameKH}
                            readOnly
                          />
                        </div>
                        <div className="form-group">
                          <label>Số điện thoại</label>
                          <input
                            type="text"
                            className="form-control"
                            id="phoneKH"
                            defaultValue={sanPhamData?.phoneKH}
                            readOnly
                          />
                        </div>
                        <div className="form-group">
                          <label>Email</label>
                          <input
                            type="text"
                            className="form-control"
                            id="emailKH"
                            defaultValue={sanPhamData?.emailKH}
                            readOnly
                          />
                        </div>
                        <div className="form-group">
                          <label>Hãng Sản Phẩm</label>
                          <input
                            type="text"
                            className="form-control"
                            id="hangSanPham"
                            defaultValue={sanPhamData?.hangSanPham}
                            readOnly
                          />
                        </div>
                        <div className="form-group">
                          <label>Tên Model</label>
                          <input
                            type="text"
                            className="form-control"
                            id="model"
                            defaultValue={sanPhamData?.model}
                            readOnly
                          />
                        </div>
                        <div className="form-group">
                          <label>Số IME</label>
                          <input
                            type="text"
                            className="form-control"
                            id="soIME"
                            defaultValue={sanPhamData?.soIME}
                            readOnly
                          />
                        </div>
                        <div className="form-group">
                          <label>Tên Lỗi</label>
                          <input
                            type="text"
                            className="form-control"
                            id="tenLoi"
                            defaultValue={sanPhamData?.tenLoi}
                            readOnly
                          />
                        </div>
                        <div className="form-group">
                          <label>Vị Trí Sửa</label>
                          <input
                            type="text"
                            className="form-control"
                            id="viTriSua"
                            defaultValue={sanPhamData?.viTriSua}
                            readOnly
                          />
                        </div>
                        <div className="form-group">
                          <label>Loại Bảo Hành</label>
                          <input
                            type="text"
                            className="form-control"
                            id="loaiBaoHanh"
                            defaultValue={sanPhamData?.loaiBaoHanh}
                            readOnly
                          />
                        </div>
                        <div className="form-group">
                          <label>Thời gian bảo hành</label>
                          <input
                            type="text"
                            className="form-control"
                            id="thoiGianBaoHanh"
                            defaultValue={sanPhamData?.thoiGianBaoHanh}
                            readOnly
                          />
                        </div>
                        <div className="form-group">
                          <label>Số lượng</label>
                          <input
                            type="text"
                            className="form-control"
                            id="so-luong"
                            defaultValue={sanPhamData?.soLuong}
                            readOnly
                          />
                        </div>
                        <div className="form-group">
                          <label>Giá Tiền</label>
                          <input
                            type="text"
                            className="form-control"
                            id="giaTien"
                            defaultValue={sanPhamData?.giaTien}
                            readOnly
                          />
                        </div>
                        <div className="form-group">
                          <label>Thành Tiền</label>
                          <input
                            type="text"
                            className="form-control"
                            id="thanh-tien"
                            defaultValue={sanPhamData?.thanhTien}
                            readOnly
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
