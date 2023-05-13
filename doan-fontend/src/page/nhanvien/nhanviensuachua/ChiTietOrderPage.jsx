import React from "react";
import { Link } from "react-router-dom";

function ChiTietOrderPage() {
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
                <button type="submit" className="btn btn-info px-4">
                  Order
                </button>
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
                          <label className="mb-2 mt-2">Mã Vật Liệu</label>
                          <input
                            type="text"
                            className="form-control"
                            id="full-name"
                          />
                        </div>
                        <div className="form-group">
                          <label className="mb-2 mt-2">Tên Vật Liệu</label>
                          <input
                            type="text"
                            className="form-control"
                            id="tenModel"
                            
                          />
                        </div>
                        <div className="form-group">
                          <label className="mb-2 mt-2">Loại Linh Kiện</label>
                          <input
                            type="text"
                            className="form-control"
                            id="tenModel"
                          />
                        </div>
                        <div className="form-group">
                          <label className="mb-2 mt-2">số lượng</label>
                          <input
                            type="text"
                            className="form-control"
                            id="soLuong"
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
