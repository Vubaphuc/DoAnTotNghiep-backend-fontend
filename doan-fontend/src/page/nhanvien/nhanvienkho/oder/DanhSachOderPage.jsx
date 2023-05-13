import React from "react";
import { useState } from "react";
import ReactPaginate from "react-paginate";
import { Link } from "react-router-dom";

function DanhSachOderPage() {

  const [status, setStatus] = useState("PENDING")

  const handlePageClick = (page) => {};

  const handleStatusChange = (e) => {
    setStatus(e.target.value)
  }

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
                        <th>STT</th>
                        <th>Mã Oder</th>
                        <th>Tên Vật liệu</th>
                        <th>Số Lượng</th>
                        <th>Mã Nhân Viên Oder</th>
                        <th>Tên Nhân Viên Oder</th>
                        <th>Loại nhân viên</th>
                      </tr>
                    </thead>
                    <tbody>
                      <tr>
                        <td>1</td>
                        <td>
                          <Link
                            to={"/"}
                            className="text-decoration-none"
                          ></Link>
                        </td>
                        <td>
                          <Link
                            to={"/"}
                            className="text-decoration-none"
                          ></Link>
                        </td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                      </tr>
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
                      pageCount={2}
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

export default DanhSachOderPage;
