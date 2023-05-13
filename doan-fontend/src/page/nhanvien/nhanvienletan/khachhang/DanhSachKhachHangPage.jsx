import React, { useEffect, useState } from "react";
import ReactPaginate from "react-paginate";
import { Link } from "react-router-dom";
import {
  useLazyDanhSachOKQuery,
  useLazyDanhSachPENDINGQuery,
} from "../../../../app/apis/nhanvienletanApi/khachHangApi";

function DanhSachKhachHangPage() {
  const [status, setStatus] = useState("OK");

  const [getSanPhamOk, { data: OKData, isLoading: OKLoangding }] =
    useLazyDanhSachOKQuery();
  const [getSanPHamPending, { data: pendingData, isLoading: pendingLoading }] =
    useLazyDanhSachPENDINGQuery();

  useEffect(() => {
    getSanPhamOk({
      page: 1,
      pageSize: 10,
    }),
      getSanPHamPending({
        page: 1,
        pageSize: 10,
      });
  }, []);

  if (OKLoangding || pendingLoading) {
    return <h2>Loading...</h2>;
  }

  console.log(OKData);
  console.log(pendingData);

  const handlePageClick = (page) => {
    status === "OK" ? 
    getSanPhamOk({
      page: page.selected + 1,
      pageSize: 10,
    }) : 
    getSanPHamPending({
      page: page.selected + 1,
      pageSize: 10,
    })
  };

  const handleStatusChange = (event) => {
    setStatus(event.target.value);
  };

  console.log(status);

  return (
    <>
      <section className="content">
        <div className="container-fluid">
          <div className="row py-2">
            <div className="col-12">
              <Link to={"/"} className="btn btn-primary">
                <i className="fas fa-plus"></i> Viết bài
              </Link>
              <Link to={"/"} className="btn btn-info">
                <i className="fas fa-redo"></i> Refresh
              </Link>
            </div>
          </div>
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
                      value={status}
                      onChange={handleStatusChange}
                    >
                      <option value="OK">OK</option>
                      <option value="PENDING">PENDING</option>
                    </select>
                  </div>
                  <table className="table table-bordered table-hover">
                    <thead>
                      <tr>
                        <th>Mã Khách Hàng</th>
                        <th>Họ và Tên</th>
                        <th>Số Điện Thoại</th>
                        <th>Email</th>
                        <th>Số lượng sản phẩm</th>
                        <th>Trạng Thái</th>
                      </tr>
                    </thead>
                    <tbody>
                      {status === "OK" &&
                        OKData &&
                        OKData.data.map((dataOK) => (
                          <tr key={dataOK.id}>
                            <td>
                              <Link to={"/"} className="text-decoration-none">
                                {dataOK?.maKhachHang}
                              </Link>
                            </td>
                            <td>
                              <Link to={"/"} className="text-decoration-none">
                                {dataOK?.fullName}
                              </Link>
                            </td>
                            <td>{dataOK?.phone}</td>
                            <td>{dataOK?.email}</td>
                            <td>{dataOK?.soLuongSP}</td>
                            <td>{dataOK?.trangThai}</td>
                          </tr>
                        ))}
                      {status === "PENDING" &&
                        pendingData &&
                        pendingData.data.map((dataPending) => (
                          <tr key={dataPending.id}>
                            <td>
                              <Link to={"/"} className="text-decoration-none">
                                {dataPending?.maKhachHang}
                              </Link>
                            </td>
                            <td>
                              <Link to={"/"} className="text-decoration-none">
                                {dataPending?.fullName}
                              </Link>
                            </td>
                            <td>{dataPending?.phone}</td>
                            <td>{dataPending?.email}</td>
                            <td>{dataPending?.soLuongSP}</td>
                            <td>{dataPending?.trangThai}</td>
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
                      pageCount={status === "OK" ? OKData?.totalPages : pendingData?.totalPages}
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

export default DanhSachKhachHangPage;
