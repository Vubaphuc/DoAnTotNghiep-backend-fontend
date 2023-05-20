import React, { useState } from "react";
import ReactPaginate from "react-paginate";
import { Link } from "react-router-dom";

function TimKiemBaoHanh() {
  const [term, setTerm] = useState("");
  const [page, setPage] = useState(0);

  const handleSearchTermChange = (e) => {
    setTerm(e.target.value);
  };

  const handlePageClick = (page) => {
    setPage(page.selected);
  };

  return (
    <>
      <section className="content">
        <div className="container-fluid">
          <div className="search-container">
            <input
              className="input-search mb-4"
              type="text"
              placeholder="Tìm kiếm sản phẩm..."
              value={term}
              onChange={handleSearchTermChange}
            />
          </div>
          <div>
            <div>
              <div className="search-results mt-3">
                {term !== "" && (
                  <div>
                    <div>
                      <table className="table table-bordered table-hover">
                        <thead>
                          <tr>
                            <th>Model</th>
                            <th>Hãng Điện Thoại</th>
                            <th>Số IME</th>
                            <th>Tên Lỗi</th>
                            <th>Mã Nhân Viên nhận</th>
                            <th>Tên Nhân Viên Nhận</th>
                            <th>Ngày Nhận</th>
                            <th>Vị Trí Sửa</th>
                            <th>Loại Linh Kiện</th>
                            <th>Mã Nhân Viên Sửa Chữa</th>
                            <th>Tên Nhân Viên Sửa Chữa</th>
                            <th>Ngày Hoàn Thành</th>
                            <th>Mã Nhân Viên Trả Sản Phẩm</th>
                            <th>Tên Nhân Viên Trả Sản Phẩm</th>
                            <th>Ngày Trả Sản Phẩm</th>
                            <th>Mã Số Bảo Hành</th>
                            <th>Số lần Bảo Hành</th>
                            <th>Lựa Chọn</th>
                          </tr>
                        </thead>
                        <tbody>
                          <tr>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                          </tr>
                        </tbody>
                      </table>
                    </div>
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
                )}
                {term === "" && <p>Không Có Sản Phẩm Tìm Kiếm Nào !!!</p>}
              </div>
            </div>
          </div>
        </div>
      </section>
    </>
  );
}

export default TimKiemBaoHanh;
