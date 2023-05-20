import React from "react";
import { useState } from "react";
import ReactPaginate from "react-paginate";
import { Link } from "react-router-dom";
import {
  useGetDanhSachSanPhamBaoHanhOKQuery,
  useGetDanhSachSanPhamBaoHanhPendingQuery,
  useGetDanhSachSanPhamBaoHanhTatCaQuery,
} from "../../../app/apis/nhanVienBaoHanh/nhanVienBaoHanhApi";

function NhanVienBaoHanhPage() {
  const [status, setStatus] = useState("OK");
  const [term, setTerm] = useState("");
  const [pageOK, setPageOK] = useState(0);
  const [pagePD, setPagePD] = useState(0);
  const [pageTC, setPageTC] = useState(0);

  const { data: sanPhamOKData, isLoading: OKLoading } =
    useGetDanhSachSanPhamBaoHanhOKQuery({
      page: pageOK + 1,
      pageSize: 10,
      term: term,
    });
  const { data: sanPhamPendingData, isLoading: PendingLoading } =
    useGetDanhSachSanPhamBaoHanhPendingQuery({
      page: pagePD + 1,
      pageSize: 10,
      term: term,
    });
  const { data: tatCaData, isLoading: tatCaLoading } =
    useGetDanhSachSanPhamBaoHanhTatCaQuery({
      page: pageTC + 1,
      pageSize: 10,
      term: term,
    });

  if (OKLoading || PendingLoading || tatCaLoading) {
    return <h2>Loading...</h2>;
  }

  console.log(sanPhamOKData);
  console.log(sanPhamPendingData);
  console.log(tatCaData);

  const handlePageClick = (page) => {
    if (status === "OK") {
      setPageOK(page.selected);
    } else if (status === "PENDING") {
      setPagePD(page.selected);
    } else {
      setPageTC(page.selected);
    }
  };

  const handleChangeTerm = (e) => {
    setTerm(e.target.value);
  };

  const handleStatusChange = (e) => {
    setStatus(e.target.value);
    setTerm("");
  };

  return (
    <>
      <section className="content">
        <div className="container-fluid">
          <div className="search-container">
            <input
              className="input-search mb-4"
              type="text"
              placeholder="Tìm kiếm..."
              value={term}
              onChange={handleChangeTerm}
            />
          </div>
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
              <option value="PENDING">Pending</option>
              <option value="TATCA">Tất Cả</option>
            </select>
          </div>
          {status === "OK" &&
            (sanPhamOKData && sanPhamOKData.data.length > 0 ? (
              <div className="search-results mt-3">
                <div className="row">
                  <div className="col-12">
                    <div className="card">
                      <div className="card-body">
                        <table className="table table-bordered table-hover">
                          <thead>
                            <tr>
                              <th>Model</th>
                              <th>Hãng Điện Thoại</th>
                              <th>Số IME</th>
                              <th>Họ Và Tên Khách Hàng</th>
                              <th>Số Điện Thoại Khách Hàng</th>
                              <th>Loại Bảo Hành</th>
                              <th>Trạng Thái</th>
                              <th>Số Lần Bảo Hành</th>
                            </tr>
                          </thead>
                          <tbody>
                            {sanPhamOKData.data.map((product) => (
                              <tr key={product.id}>
                                <td>
                                  <Link
                                    to={"/"}
                                    className="text-decoration-none"
                                  >
                                    {product.model}
                                  </Link>
                                </td>
                                <td>
                                  <Link
                                    to={"/"}
                                    className="text-decoration-none"
                                  >
                                    {product.hangSanXuat}
                                  </Link>
                                </td>
                                <td>{product.ime}</td>
                                <td>{product.tenLoi}</td>
                                <td>{product.fullNameKH}</td>
                                <td>{product.phoneKh}</td>
                                <td>
                                  {product.repair === true
                                    ? "Có Tính Phí"
                                    : "Không Tính Phí"}
                                </td>
                                <td>
                                  {product.isStatus === true ? "OK" : "PENDING"}
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
                            pageCount={1}
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
            ) : (
              <div className="search-results mt-3">
                <p>Không có sản phẩm nào.</p>
              </div>
            ))}
          {status === "PENDING" &&
            (sanPhamPendingData && sanPhamPendingData.data.length > 0 ? (
              <div className="search-results mt-3">
                <div className="row">
                  <div className="col-12">
                    <div className="card">
                      <div className="card-body">
                        <table className="table table-bordered table-hover">
                          <thead>
                            <tr>
                              <th>Model</th>
                              <th>Hãng Điện Thoại</th>
                              <th>Số IME</th>
                              <th>Họ Và Tên Khách Hàng</th>
                              <th>Số Điện Thoại Khách Hàng</th>
                              <th>Loại Bảo Hành</th>
                              <th>Trạng Thái</th>
                              <th>Số Lần Bảo Hành</th>
                            </tr>
                          </thead>
                          <tbody>
                            {sanPhamPendingData.data.map((product) => (
                              <tr key={product.id}>
                                <td>
                                  <Link
                                    to={"/"}
                                    className="text-decoration-none"
                                  >
                                    {product.model}
                                  </Link>
                                </td>
                                <td>
                                  <Link
                                    to={"/"}
                                    className="text-decoration-none"
                                  >
                                    {product.hangSanXuat}
                                  </Link>
                                </td>
                                <td>{product.ime}</td>
                                <td>{product.tenLoi}</td>
                                <td>{product.fullNameKH}</td>
                                <td>{product.phoneKh}</td>
                                <td>
                                  {product.repair === true
                                    ? "Có Tính Phí"
                                    : "Không Tính Phí"}
                                </td>
                                <td>
                                  {product.isStatus === true ? "OK" : "PENDING"}
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
                            pageCount={1}
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
            ) : (
              <div className="search-results mt-3">
                <p>Không có sản phẩm nào.</p>
              </div>
            ))}
          {status === "TATCA" &&
            (tatCaData && tatCaData.data.length > 0 ? (
              <div className="search-results mt-3">
                <div className="row">
                  <div className="col-12">
                    <div className="card">
                      <div className="card-body">
                        <table className="table table-bordered table-hover">
                          <thead>
                            <tr>
                              <th>Model</th>
                              <th>Hãng Điện Thoại</th>
                              <th>Số IME</th>
                              <th>Tên Lỗi</th>
                              <th>Họ Và Tên Khách Hàng</th>
                              <th>Số Điện Thoại Khách Hàng</th>
                              <th>Loại Bảo Hành</th>
                              <th>Trạng Thái</th>
                            </tr>
                          </thead>
                          <tbody>
                            {tatCaData.data.map((product) => (
                              <tr key={product.id}>
                                <td>{product.model}</td>
                                <td>{product.hangSanXuat}</td>
                                <td>{product.ime}</td>
                                <td>{product.tenLoi}</td>
                                <td>{product.fullNameKH}</td>
                                <td>{product.phoneKh}</td>
                                <td>
                                  {product.repair === true
                                    ? "Có Tính Phí"
                                    : "Không Tính Phí"}
                                </td>
                                <td>
                                  {product.isStatus === true ? "OK" : "PENDING"}
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
                            pageCount={1}
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
            ) : (
              <div className="search-results mt-3">
                <p>Không có sản phẩm nào.</p>
              </div>
            ))}
        </div>
      </section>
    </>
  );
}

export default NhanVienBaoHanhPage;
