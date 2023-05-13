import React, { useEffect, useState } from "react";
import ReactPaginate from "react-paginate";
import { Link } from "react-router-dom";
import {
  useLazyDanhSachStatusOKOrderQuery,
  useLazyDanhSachStatusPENDINGOrderQuery,
} from "../../../app/apis/nhanviensuachuaApis/vatLieuNVSCApi";

function DanhSachStatusOrderPage() {
  const [trangThai, setTrangThai] = useState("PENDING");


  const [getOrderStatusOk, { data: statusOkData, isLoading: statusOkLoading }] =
    useLazyDanhSachStatusOKOrderQuery();
  const [
    getOrderStatusPending,
    { data: statusPendingData, isLoading: statusPendingLoading },
  ] = useLazyDanhSachStatusPENDINGOrderQuery();


  useEffect(() => {
    getOrderStatusOk({
      page: 1,
      pageSize: 10,
    }) ,
      getOrderStatusPending({
        page: 1,
        pageSize: 10,
      });
  }, []);

  if (statusOkLoading || statusPendingLoading) {
    return <h2>Loading....</h2>;
  }

  console.log(statusPendingData);

  const handlePageClick = (page) => {
    trangThai === "PENDING"
      ? getOrderStatusPending({
          page: page.selected + 1,
          pageSize: 10,
        })
      : getOrderStatusOk({
          page: page.selected + 1,
          pageSize: 10,
        });
  };

  const handleStatusChange = (e) => {
    setTrangThai(e.target.value);
  };

  console.log(trangThai);

  return (
    <>
      <section className="content">
        <div className="container-fluid">
          <div className="row py-2"></div>
          <div className="row">
            <div className="col-12">
              <div className="card">
                <div className="card-body">
                  <div className="btn-lua-chon">
                    <label htmlFor="statusSelect" className="mb-2">
                      Trạng Thái:
                    </label>
                    <select
                      id="statusSelect"
                      className="form-control"
                      value={trangThai}
                      onChange={handleStatusChange}
                    >
                      <option value="OK">OK</option>
                      <option value="PENDING">PENDING</option>
                    </select>
                  </div>
                  <table className="table table-bordered table-hover">
                    <thead>
                      <tr>
                        <th>ID Order</th>
                        <th>Mã Oder</th>
                        <th>Mã Vật Liệu</th>
                        <th>Tên Model</th>
                        <th>Loại Linh Kiện</th>
                        <th>Số Lượng</th>
                        <th>Mã Nhân Viên Oder</th>
                        <th>Tên Nhân Viên Oder</th>
                        <th>Trạng Thái</th>
                      </tr>
                    </thead>
                    <tbody>
                      {trangThai === "PENDING" &&
                        statusPendingData &&
                        statusPendingData?.data.map((orderPD) => (
                          <tr key={orderPD?.id}>
                            <td>
                              <Link to={`/nhan-vien/sua-chua/order/${orderPD?.id}`} className="text-decoration-none">
                                {orderPD?.id}
                              </Link>
                            </td>
                            <td>
                              <Link to={`/nhan-vien/sua-chua/order/${orderPD?.id}`} className="text-decoration-none">
                                {orderPD?.maOder}
                              </Link>
                            </td>
                            <td>
                              <Link to={`/nhan-vien/sua-chua/order/${orderPD?.id}`} className="text-decoration-none">
                                {orderPD?.maVatLieu}
                              </Link>
                            </td>
                            <td>{orderPD?.tenModel}</td>
                            <td>{orderPD?.loaiLinhKien}</td>
                            <td>{orderPD?.soLuong}</td>
                            <td>{orderPD?.maNhanVienOrder}</td>
                            <td>{orderPD?.fullNameNguoiOrder}</td>
                            <td>
                              {orderPD?.status === false ? "PENDING" : "OK"}
                            </td>
                          </tr>
                        ))}
                      {trangThai === "OK" &&
                        statusOkData &&
                        statusOkData?.data.map((orderOK) => (
                          <tr key={orderOK?.id}>
                            <td>
                              <Link to={`/nhan-vien/sua-chua/order/${orderOK?.id}`} className="text-decoration-none">
                                {orderOK?.id}
                              </Link>
                            </td>
                            <td>
                              <Link to={`/nhan-vien/sua-chua/order/${orderOK?.id}`} className="text-decoration-none">
                                {orderOK?.maOder}
                              </Link>
                            </td>
                            <td>
                              <Link to={`/nhan-vien/sua-chua/order/${orderOK?.id}`} className="text-decoration-none">
                                {orderOK?.maVatLieu}
                              </Link>
                            </td>
                            <td>{orderOK?.tenModel}</td>
                            <td>{orderOK?.loaiLinhKien}</td>
                            <td>{orderOK?.soLuong}</td>
                            <td>{orderOK?.maNhanVienOrder}</td>
                            <td>{orderOK?.fullNameNguoiOrder}</td>
                            <td>
                              {orderOK?.status === false ? "PENDING" : "OK"}
                            </td>
                          </tr>
                        ))}
                    </tbody>
                  </table>
                  <div
                    className="d-flex justify-content-center mt-3"
                    id="pagination"
                  >
                    <ReactPaginate
                      nextLabel="next >"
                      onPageChange={handlePageClick}
                      pageRangeDisplayed={3}
                      marginPagesDisplayed={2}
                      pageCount={
                        trangThai === "PENDING"
                          ? statusPendingData?.totalPages
                          : statusOkData?.totalPages
                      }
                      previousLabel="< previous"
                      pageClassName="page-item"
                      pageLinkClassName="page-link"
                      previousClassName="page-item"
                      previousLinkClassName="page-link"
                      nextClassName="page-item"
                      nextLinkClassName="page-link"
                      breakLabel="..."
                      breakClassName="page-item"
                      breakLinkClassName="page-link"
                      containerClassName="pagination"
                      activeClassName="active"
                      renderOnZeroPageCount={null}
                    />
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </section>
    </>
  );
}

export default DanhSachStatusOrderPage;
