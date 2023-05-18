import React, { useState } from "react";
import { useGetDanhSachSanPhamBaoHanhPendingQuery } from "../../../app/apis/nhanVienBaoHanh/nhanVienBaoHanhApi";
import ReactPaginate from "react-paginate";
import { Link } from "react-router-dom";

function DangKyNhanVienSuaChua() {
    const [term, setTerm] = useState("");
    const [page, setPage] = useState(0);

    const { data: sanPhamPendingData, isLoading: pendingLoading } = useGetDanhSachSanPhamBaoHanhPendingQuery({page: page + 1 , pageSize: 10, term: term})

    if (pendingLoading) {
        return <h2>Loading....</h2>
    }
    
    const handleChangeTerm = (e) => {
        setTerm(e.target.value);
    }

    const handlePageClick = (page) => {
        setPage(page.selected);
    }

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
          {sanPhamPendingData && sanPhamPendingData.data.length > 0 ? (
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
                                <Link to={`/nhan-vien/bao-hanh/dang-ky/sua-chua/${product.id}`} className="text-decoration-none">
                                  {product.model}
                                </Link>
                              </td>
                              <td>
                                <Link to={`/nhan-vien/bao-hanh/dang-ky/sua-chua/${product.id}`} className="text-decoration-none">
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
          )}
        </div>
      </section>
    </>
  );
}

export default DangKyNhanVienSuaChua;
