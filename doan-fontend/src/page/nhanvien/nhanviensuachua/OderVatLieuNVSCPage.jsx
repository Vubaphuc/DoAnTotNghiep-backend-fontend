import React from "react";
import { Controller, useForm } from "react-hook-form";
import { Link, useParams } from "react-router-dom";
import Select from "react-select";
import hookOrderVatLieuSuaChua from "../../hook/hookNhanvien/hookNhanVienSuaChua/hookOrderVatLieuSuaChua";
import { useChiTietVatLieuTheoCodeQuery } from "../../../app/apis/nhanviensuachuaApis/vatLieuNVSCApi";

function OderVatLieuNVSCPage() {
  const { vatLieuCode } = useParams();

  const { register, handleSubmit, errors, onOrderVatLieu } =
    hookOrderVatLieuSuaChua();

  const { data: vatLieuData, isLoading: vatLieuLoading } =
    useChiTietVatLieuTheoCodeQuery(vatLieuCode);

  if (vatLieuLoading) {
    return <h2>Loading...</h2>;
  }

  return (
    <>
      <section className="content">
        <div className="container-fluid">
          <form onSubmit={handleSubmit(onOrderVatLieu)}>
            <div className="row py-2">
              <div className="col-6">
                <Link to={"/nhan-vien/sua-chua/vat-lieu"} className="btn btn-default">
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
                            defaultValue={vatLieuData?.code}
                            readOnly
                            {...register("code")}
                          />
                        </div>
                        <div className="form-group">
                          <label className="mb-2 mt-2">Tên Vật Liệu</label>
                          <input
                            type="text"
                            className="form-control"
                            id="tenModel"
                            defaultValue={vatLieuData?.tenModel}
                            readOnly
                          />
                        </div>
                        <div className="form-group">
                          <label className="mb-2 mt-2">Loại Linh Kiện</label>
                          <input
                            type="text"
                            className="form-control"
                            id="tenModel"
                            defaultValue={vatLieuData?.loaiLinhKien}
                            readOnly
                            {...register("loaiLinhKien")}
                          />
                        </div>
                        <div className="form-group">
                          <label className="mb-2 mt-2">số lượng</label>
                          <input
                            type="text"
                            className="form-control"
                            id="soLuong"
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

export default OderVatLieuNVSCPage;
