import React from "react";
import { Link, useParams } from "react-router-dom";
import { useChiTietOrderTheoIdQuery } from "../../../app/apis/nhanviensuachuaApis/vatLieuNVSCApi";

function ChiTietOrderPage() {
  const { orderId } = useParams();

  const { data: orderData, isLoading: orderLoading } =
    useChiTietOrderTheoIdQuery(orderId);

  if (orderLoading) {
    return <h2>Loading...</h2>;
  }

  console.log(orderData);

  return (
    <>
      <section className="content">
        <div className="container-fluid">
          <form>
            <div className="row py-2">
              <div className="col-6">
                <Link
                  to={"/nhan-vien/sua-chua/order"}
                  className="btn btn-default"
                >
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
                        <h4 className="mb-2">Thông Tin Vật Liệu</h4>
                        <div className="form-group">
                          <label className="mb-2 mt-2">Mã Order</label>
                          <input
                            type="text"
                            className="form-control"
                            id="full-name"
                            defaultValue={orderData?.maOrder}
                            readOnly
                          />
                        </div>
                        <div className="form-group">
                          <label className="mb-2 mt-2">Mã Vật Liệu</label>
                          <input
                            type="text"
                            className="form-control"
                            id="full-name"
                            defaultValue={orderData?.maVatLieu}
                            readOnly
                          />
                        </div>
                        <div className="form-group">
                          <label className="mb-2 mt-2">Tên Model</label>
                          <input
                            type="text"
                            className="form-control"
                            id="tenModel"
                            defaultValue={orderData?.tenModel}
                            readOnly
                          />
                        </div>
                        <div className="form-group">
                          <label className="mb-2 mt-2">Loại Linh Kiện</label>
                          <input
                            type="text"
                            className="form-control"
                            id="tenModel"
                            defaultValue={orderData?.loaiLinhKien}
                            readOnly
                          />
                        </div>
                        <div className="form-group">
                          <label className="mb-2 mt-2">số lượng</label>
                          <input
                            type="text"
                            className="form-control"
                            id="soLuong"
                            defaultValue={orderData?.soLuong}
                            readOnly
                          />
                        </div>
                        <div className="form-group">
                          <label className="mb-2 mt-2">Trạng Thái</label>
                          <input
                            type="text"
                            className="form-control"
                            id="soLuong"
                            defaultValue={orderData?.trangThai === true ? "OK" : "PENDING"}
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

export default ChiTietOrderPage;
