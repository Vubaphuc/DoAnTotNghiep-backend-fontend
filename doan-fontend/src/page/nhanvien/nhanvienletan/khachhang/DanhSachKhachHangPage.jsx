import React, { useState } from "react";
import ReactPaginate from "react-paginate";
import { Link } from "react-router-dom";
import {
  useSearchKhachHangTheoTenOKQuery,
  useSearchKhachHangTheoTenPedingQuery,
} from "../../../../app/apis/nhanvienletanApi/khachHangApi";

function DanhSachKhachHangPage() {
  const [status, setStatus] = useState("OK");
  const [term, setTerm] = useState("");
  const [pageOK, setPageOK] = useState(0);
  const [pagePD, setPagePD] = useState(0);

  const { data: khachHangData, isLoading: okLoading } =
    useSearchKhachHangTheoTenOKQuery({
      page: pageOK + 1,
      pageSize: 10,
      term: term,
    });

  const { data: khachHangPeding, isLoading: pendingLoading } =
    useSearchKhachHangTheoTenPedingQuery({
      page: pagePD + 1,
      pageSize: 10,
      term: term,
    });

  if (pendingLoading || okLoading) {
    return <h2>Loading...</h2>;
  }

  console.log(khachHangPeding);

  const handlePageClick = (page) => {
    status === "OK" ? setPageOK(page.selected) : setPagePD(page.selected);
  };

  const handleStatusChange = (event) => {
    setStatus(event.target.value);
    setTerm("");
  };

  const handleChaneNameCustomer = (e) => {
    setTerm(e.target.value);
  };

  return (
    <>
      <section className="content">
        <div className="container-fluid">
          <div className="search-container">
            <input
              className="input-search mb-4"
              type="text"
              placeholder="Tìm kiếm khách hàng..."
              value={term}
              onChange={handleChaneNameCustomer}
            />
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
                      <option value="PENDING">Tất Cả</option>
                    </select>
                  </div>
                  {status === "OK" && (
                    <table className="table table-bordered table-hover">
                      <thead>
                        <tr>
                          <th>Mã Khách Hàng</th>
                          <th>Họ và Tên</th>
                          <th>Số Điện Thoại</th>
                          <th>Email</th>
                          <th>Số lượng sản phẩm</th>
                          <th>Trạng Thái</th>
                          <th>Lựa Chọn</th>
                        </tr>
                      </thead>
                      <tbody>
                        {khachHangData &&
                          khachHangData.data.map((dataOK) => (
                            <tr key={dataOK.id}>
                              <td>
                                <Link
                                  to={`/nhan-vien/le-tan/ds-kh/${dataOK.id}`}
                                  className="text-decoration-none"
                                >
                                  {dataOK?.maKhachHang}
                                </Link>
                              </td>
                              <td>
                                <Link
                                  to={`/nhan-vien/le-tan/ds-kh/${dataOK.id}`}
                                  className="text-decoration-none"
                                >
                                  {dataOK?.fullName}
                                </Link>
                              </td>
                              <td>{dataOK?.phone}</td>
                              <td>{dataOK?.email}</td>
                              <td>{dataOK?.soLuongSP}</td>
                              <td>
                                {dataOK?.trangThai === true ? "OK" : "PENDING"}
                              </td>
                              <td>
                                <Link
                                  to={`/nhan-vien/le-tan/dk-kh/${dataOK?.id}`}
                                  className="btn btn-info px-2"
                                >
                                  Thêm Sản Phẩm
                                </Link>
                              </td>
                            </tr>
                          ))}
                      </tbody>
                    </table>
                  )}
                  {status === "PENDING" && (
                    <table className="table table-bordered table-hover">
                      <thead>
                        <tr>
                          <th>Mã Khách Hàng</th>
                          <th>Họ và Tên</th>
                          <th>Số Điện Thoại</th>
                          <th>Email</th>
                          <th>Số lượng sản phẩm</th>
                          <th>Lựa Chọn</th>
                        </tr>
                      </thead>
                      <tbody>
                        {khachHangPeding &&
                          khachHangPeding.data.map((dataPending) => (
                            <tr key={dataPending.id}>
                              <td>
                                <Link
                                  to={`/nhan-vien/le-tan/ds-kh/${dataPending.id}`}
                                  className="text-decoration-none"
                                >
                                  {dataPending?.maKhachHang}
                                </Link>
                              </td>
                              <td>
                                <Link
                                  to={`/nhan-vien/le-tan/ds-kh/${dataPending.id}`}
                                  className="text-decoration-none"
                                >
                                  {dataPending?.fullName}
                                </Link>
                              </td>
                              <td>{dataPending?.phone}</td>
                              <td>{dataPending?.email}</td>
                              <td>{dataPending?.soLuongSP}</td>
                              <td>
                                <Link
                                  to={`/nhan-vien/le-tan/dk-kh/${dataPending?.id}`}
                                  className="btn btn-info px-2"
                                >
                                  Thêm Sản Phẩm
                                </Link>
                              </td>
                            </tr>
                          ))}
                      </tbody>
                    </table>
                  )}
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
                        status === "OK"
                          ? khachHangData?.totalPages
                          : khachHangPeding?.totalPages
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

export default DanhSachKhachHangPage;
