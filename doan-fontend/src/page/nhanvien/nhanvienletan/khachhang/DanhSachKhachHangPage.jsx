import React, { useState } from "react";
import ReactPaginate from "react-paginate";
import { Link } from "react-router-dom";
import {
  useSearchKhachHangTheoTenOKQuery,
  useSearchKhachHangTheoTenPedingQuery
} from "../../../../app/apis/nhanvienletanApi/khachHangApi";

function DanhSachKhachHangPage() {
  const [status, setStatus] = useState("OK");
  const [tenKhachHang, setTenKhachHang] = useState("");


    const { data: khachHangData, isLoading: okLoading } = useSearchKhachHangTheoTenOKQuery({page: 1, pageSize: 10, tenKhachHang: tenKhachHang});
    const { data: khachHangPeding, isLoading: pendingLoading } = useSearchKhachHangTheoTenPedingQuery({page: 1, pageSize: 10, tenKhachHang: tenKhachHang});


  if (pendingLoading || okLoading) {
    return <h2>Loading...</h2>;
  }

  

  const handlePageClick = (page) => {
    status === "OK"
      ? getSanPhamOk({
          page: page.selected + 1,
          pageSize: 10,
        })
      : getSanPHamPending({
          page: page.selected + 1,
          pageSize: 10,
        });
  };


  const handleStatusChange = (event) => {
    setStatus(event.target.value);
    setTenKhachHang("");
  };

  const handleChaneNameCustomer = (e) => {
    setTenKhachHang(e.target.value);
  }


  return (
    <>
      <section className="content">
        <div className="container-fluid">
          <div className="search-container">
            <input
              className="input-search mb-4"
              type="text"
              placeholder="Tìm kiếm theo tên khách hàng..."
              value={tenKhachHang}
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
                        khachHangData &&
                        khachHangData.data.map((dataOK) => (
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
                        khachHangPeding &&
                        khachHangPeding.data.map((dataPending) => (
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
