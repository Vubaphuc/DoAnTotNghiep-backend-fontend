import React from "react";
import ReactPaginate from "react-paginate";
import { Link } from "react-router-dom";
import danhSachLayTuApi from "../danhSachLayTuApi/danhSachLayTuApi";

function DanhSachSanPhamChuaSuaChua() {
  const { sanPhamChuaSuaData, isLoading, sanPhamChuaSua } = danhSachLayTuApi();

  if (isLoading) {
    return <h2>Loading....</h2>;
  }

  const handlePageClick = (page) => {
    sanPhamChuaSua({
      page: page.selected + 1,
      pageSize: 10
    })
  };

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
                  <table className="table table-bordered table-hover">
                    <thead>
                      <tr>
                        <th>Model</th>
                        <th>Hãng Điện Thoại</th>
                        <th>Số IME</th>
                        <th>Tên Lỗi</th>
                      </tr>
                    </thead>
                    <tbody>
                      {sanPhamChuaSuaData &&
                        sanPhamChuaSuaData.data.map((sanPham) => (
                          <tr key={sanPham.id}>
                            <td>
                              <Link to={`/nhan-vien/le-tan/dk-sc/${sanPham.id}`} className="text-decoration-none">
                                {sanPham.model}
                              </Link>
                            </td>
                            <td>
                              <Link to={`/nhan-vien/le-tan/dk-sc/${sanPham.id}`} className="text-decoration-none">
                                {sanPham.hangSanXuat}
                              </Link>
                            </td>
                            <td>{sanPham.ime}</td>
                            <td>{sanPham.ten_loi}</td>
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
                      pageCount={sanPhamChuaSuaData?.totalPages}
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

export default DanhSachSanPhamChuaSuaChua;
