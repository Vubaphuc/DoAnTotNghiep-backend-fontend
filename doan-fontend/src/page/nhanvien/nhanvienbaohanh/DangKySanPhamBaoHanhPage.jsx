import React, { useState } from "react";
import { Link, useParams } from "react-router-dom";
import { useFindProductAndCustomerByIdQuery } from "../../../app/apis/nhanVienBaoHanh/nhanVienBaoHanhApi";
import hookDangKySanPhamBaoHanhTinhPhi from "../../hook/hookNhanvien/hookNhanVienBaoHanh/hookDangKySanPhamBaoHanhTinhPhi";
import hookDangKySanPhamBaoHanhKhongTinhPhi from "../../hook/hookNhanvien/hookNhanVienBaoHanh/hookDangKySanPhamBaoHanhKhongTinhPhi";

function DangKySanPhamBaoHanhPage() {
  const { productId } = useParams();
  const [status, setStatus] = useState("KHONGTINHPHI");

  const {
    register: registerC,
    handleSubmit: handleSubmitC,
    errors: errorsC,
    onDangKyTinhPhi,
  } = hookDangKySanPhamBaoHanhTinhPhi(productId);

  const {
    register: registerK,
    handleSubmit: handleSubmitK,
    errors: errorsK,
    onDangKyKhongTinhPhi,
  } = hookDangKySanPhamBaoHanhKhongTinhPhi(productId);

  const { data: productData, isLoading: productLoading } =
    useFindProductAndCustomerByIdQuery(productId);

  if (productLoading) {
    return <h2>Loading...</h2>;
  }

  const handleStatusChange = (e) => {
    setStatus(e.target.value);
  };

  return (
    <>
      <section className="content">
        <div className="container-fluid">
          <div className="row py-2">
            <div className="col-6">
              <Link to={"/nhan-vien/bao-hanh"} className="btn btn-default">
                <i className="fas fa-chevron-left"></i> Quay lại
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
                          defaultValue={productData?.fullNameKh}
                          readOnly
                        />
                      </div>
                      <div className="form-group">
                        <label>Số Điện Thoại</label>
                        <input
                          type="text"
                          className="form-control"
                          id="phone"
                          defaultValue={productData?.phoneKh}
                          readOnly
                        />
                      </div>
                      <div className="form-group">
                        <label>Email</label>
                        <input
                          type="text"
                          className="form-control"
                          id="email"
                          defaultValue={productData?.emailKh}
                          readOnly
                        />
                      </div>
                      <div className="form-group">
                        <label>Địa Chỉ</label>
                        <input
                          type="text"
                          className="form-control"
                          id="model"
                          defaultValue={productData?.addressKh}
                          readOnly
                        />
                      </div>
                    </div>
                    <div className="col-md-5">
                      <h4 className="mb-4">Thông Tin Sản Phẩm</h4>
                      <div className="form-group">
                        <label>Hãng Điện Thoại</label>
                        <input
                          type="text"
                          className="form-control"
                          id="model"
                          defaultValue={productData?.phoneKh}
                          readOnly
                        />
                      </div>
                      <div className="form-group">
                        <label>Model</label>
                        <input
                          type="text"
                          className="form-control"
                          id="model"
                          defaultValue={productData?.model}
                          readOnly
                        />
                      </div>
                      <div className="form-group">
                        <label>Số IME</label>
                        <input
                          type="text"
                          className="form-control"
                          id="so-IME"
                          defaultValue={productData?.ime}
                          readOnly
                        />
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <div className="input-bh">
          <select
            id="statusSelect"
            className="form-control"
            value={status}
            onChange={handleStatusChange}
          >
            <option value="TINHPHI">Tính Phí </option>
            <option value="KHONGTINHPHI">Không Tính Phí</option>
          </select>
        </div>
        {status === "TINHPHI" ? (
          <form onSubmit={handleSubmitC(onDangKyTinhPhi)}>
            <div className="container-fluid">
              <div className="row py-2">
                <div className="col-6">
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
                          <h4 className="mb-4">Thông Tin Bảo Hành</h4>
                          <div className="form-group">
                            <label>Tên Lỗi</label>
                            <input
                              type="text"
                              className="form-control"
                              id="full-name"
                              {...registerC("tenLoi")}
                            />
                            <p className="text-danger fst-italic mt-2">
                              {errorsC.tenLoi?.message}
                            </p>
                          </div>
                          <div className="form-group">
                            <label>Nguyên Nhân Lỗi</label>
                            <input
                              type="text"
                              className="form-control"
                              id="phone"
                              {...registerC("nguyenNhanLoi")}
                            />
                            <p className="text-danger fst-italic mt-2">
                              {errorsC.nguyenNhanLoi?.message}
                            </p>
                          </div>
                          <div className="form-group">
                            <label>Giá Tiền</label>
                            <input
                              type="text"
                              className="form-control"
                              id="email"
                              {...registerC("giaTien")}
                            />
                            <p className="text-danger fst-italic mt-2">
                              {errorsC.giaTien?.message}
                            </p>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </form>
        ) : (
          <form onSubmit={handleSubmitK(onDangKyKhongTinhPhi)}>
            <div className="container-fluid">
              <div className="row py-2">
                <div className="col-6">
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
                          <h4 className="mb-4">Thông Tin Bảo Hành</h4>
                          <div className="form-group">
                            <label>Tên Lỗi</label>
                            <input
                              type="text"
                              className="form-control"
                              id="full-name"
                              {...registerK("tenLoi")}
                            />
                            <p className="text-danger fst-italic mt-2">
                              {errorsK.tenLoi?.message}
                            </p>
                          </div>
                          <div className="form-group">
                            <label>Nguyên Nhân Lỗi</label>
                            <input
                              type="text"
                              className="form-control"
                              id="phone"
                              {...registerK("nguyenNhanLoi")}
                            />
                            <p className="text-danger fst-italic mt-2">
                              {errorsK.nguyenNhanLoi?.message}
                            </p>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </form>
        )}
      </section>
    </>
  );
}

export default DangKySanPhamBaoHanhPage;
