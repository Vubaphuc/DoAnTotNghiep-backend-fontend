import React from "react";
import { Controller } from "react-hook-form";
import { Link } from "react-router-dom";
import Select from "react-select";
import dangKyVatLieu from "../../../hook/hookNhanvien/nhanVienKho/hookDangKyVatLieu";
import danhSachVenderVaLinhKien from "./danhSachVenderVaLinhKien";
import { getLinhKien, getVender } from "../../../options/options";

function DangKyVatLieuPage() {

  const { venderData, linhKienData, venderLoading, linhKienLoading } = danhSachVenderVaLinhKien();

  const { control, handleSubmit, register, errors, onDangKyVatLieu } =
    dangKyVatLieu();

    if (venderLoading || linhKienLoading) {
      return <h2>Loading....</h2>
    }


    const venderOptions = getVender(venderData?.data);
    const linhKienOptions = getLinhKien(linhKienData?.data);

  return (
    <>
      <section className="content">
        <div className="container-fluid">
          <form onSubmit={handleSubmit(onDangKyVatLieu)}>
            <div className="row py-2">
              <div className="col-6">
                <Link to={"/nhan-vien/kho"} className="btn btn-default">
                  <i className="fas fa-chevron-left"></i> Quay lại
                </Link>
                <button type="submit" className="btn btn-info px-4">
                  Lưu
                </button>
                <Link
                  to={"/nhan-vien/kho/vender/new-vender"}
                  className="btn btn-default"
                >
                  Thêm Vender Mới
                </Link>
                <Link
                  to={"/nhan-vien/kho/linh-kien/new-linh-kien"}
                  className="btn btn-default"
                >
                  Thêm Loại Linh Kiện Mới
                </Link>
              </div>
            </div>
            <div className="row">
              <div className="col-12">
                <div className="card">
                  <div className="card-body">
                    <div className="intput-seach">
                      <label htmlFor="statusSelect" className="mb-2">
                        Nhập Mã Vật Liệu:
                      </label>
                      <input type="text" className="form-control mb-3" />
                    </div>
                    <div className="table-sp-kh">
                      <div className="col-md-5">
                        <h4 className="mb-2">Thông Tin Vật Liệu</h4>

                        <div className="form-group">
                          <label className="mb-2 mt-2">Mã Vật Liệu</label>
                          <input
                            type="text"
                            className="form-control"
                            id="full-name"
                            {...register("maVatLieu")}
                          />
                          <p className="text-danger fst-italic mt-2">
                            {errors.maVatLieu?.message}
                          </p>
                        </div>
                        <div className="form-group">
                          <label className="mb-2 mt-2">Tên Vật Liệu</label>
                          <input
                            type="text"
                            className="form-control"
                            id="tenModel"
                            {...register("tenModel")}
                          />
                          <p className="text-danger fst-italic mt-2">
                            {errors.tenModel?.message}
                          </p>
                        </div>
                        <div className="form-group">
                          <label className="mb-2 mt-2">Vender</label>
                          <Controller
                            name="venderId"
                            control={control}
                            render={({ field }) => (
                              <div>
                                <Select
                                  {...field}
                                  placeholder="--Chọn Vender--"
                                  options={venderOptions}
                                  value={venderOptions.find(
                                    (c) => c.value === field.value
                                  )}
                                  onChange={(val) => field.onChange(val.value)}
                                />
                              </div>
                            )}
                          />
                        </div>
                        <div className="form-group">
                          <label className="mb-2 mt-2">Loại Linh Kiện</label>
                          <Controller
                            name="loaiLinhKienId"
                            control={control}
                            render={({ field }) => (
                              <div>
                                <Select
                                  {...field}
                                  placeholder="--Chọn Loại Linh Kiện--"
                                  options={linhKienOptions}
                                  value={linhKienOptions.find(
                                    (c) => c.value === field.value
                                  )}
                                  onChange={(val) => field.onChange(val.value)}
                                />
                              </div>
                            )}
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

export default DangKyVatLieuPage;
