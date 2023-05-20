import React from "react";
import { Link, useNavigate, useParams } from "react-router-dom";
import { useChiTietMotOrderTheoId_NVKQuery } from "../../../../app/apis/nhanvienkhoApis/oderVatLieuNVKApi";
import { toast } from "react-toastify";
import { Controller, useForm } from "react-hook-form";
import Select from "react-select";
import hookPheDuyetOrderVatLieu from "../../../hook/hookNhanvien/nhanVienKho/hookPheDuyetOrderVatLieu";

function ChiTietMotOrderPage() {
  const { orderId } = useParams();

  const { control, register, handleSubmit, errors, onPheDuyet } =
    hookPheDuyetOrderVatLieu(orderId);

  const { data: orderData, isLoading: orderLoading } =
    useChiTietMotOrderTheoId_NVKQuery(orderId);

  if (orderLoading) {
    return <h2>Loading...</h2>;
  }

  const StatusOptions = [
    { label: "OK", value: true },
    { label: "PENDING", value: false },
  ];
  console.log();

  const defaultStatus = {
    label: orderData.trangThai === true ? "OK" : "PENDING",
    value: orderData.trangThai,
  };

  return (
    <>
      <section className="content">
        <div className="container-fluid">
          <form onSubmit={handleSubmit(onPheDuyet)}>
            <div className="row py-2">
              <div className="col-6">
                <Link to={"/nhan-vien/kho/oder"} className="btn btn-default">
                  <i className="fas fa-chevron-left"></i> Quay lại
                </Link>
                <button type="submit" className="btn btn-info px-4">
                  Phê Duyệt
                </button>
              </div>
            </div>
            <div className="row">
              <div className="col-12">
                <div className="card">
                  <div className="card-body">
                    <div className="table-sp-kh">
                      <div className="col-md-5">
                        <h4 className="mb-2">Thông Tin Order</h4>
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
                            id="tenModel"
                            defaultValue={orderData?.maVatLieu}
                            readOnly
                            {...register("maVatLieu")}
                          />
                        </div>
                        <div className="form-group">
                          <label className="mb-2 mt-2">Tên Model</label>
                          <input
                            type="text"
                            className="form-control"
                            id="soLuong"
                            defaultValue={orderData?.tenModel}
                            readOnly
                          />
                        </div>
                        <div className="form-group">
                          <label className="mb-2 mt-2">Loại Linh Kiện</label>
                          <input
                            type="text"
                            className="form-control"
                            id="soLuong"
                            defaultValue={orderData?.loaiLinhKien}
                            readOnly
                          />
                        </div>
                        <div className="form-group">
                          <label className="mb-2 mt-2">Số Luọng</label>
                          <input
                            type="text"
                            className="form-control"
                            id="soLuong"
                            defaultValue={orderData?.soLuong}
                            readOnly
                            {...register("soLuong")}
                          />
                        </div>
                        <div className="form-group">
                          <label className="mb-2 mt-2">Loại Linh Kiện</label>
                          <Controller
                            name="trangThai"
                            control={control}
                            defaultValue={defaultStatus.value}
                            render={({ field }) => (
                              <div>
                                <Select
                                  {...field}
                                  placeholder="--Chọn Trạng Thái--"
                                  options={StatusOptions}
                                  value={StatusOptions.find(
                                    (c) => c.value === field.value
                                  )}
                                  onChange={(val) => field.onChange(val.value)}
                                />
                                <p className="text-danger fst-italic mt-2">
                                  {errors.trangThai?.message}
                                </p>
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

export default ChiTietMotOrderPage;
