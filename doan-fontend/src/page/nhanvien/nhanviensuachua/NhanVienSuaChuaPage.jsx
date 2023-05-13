import React, { useEffect } from "react";
import ReactPaginate from "react-paginate";
import { Link } from "react-router-dom";
import { useLazyDanhSachSanPhamSuaChuaTheoIdNguoiSuaQuery } from "../../../app/apis/nhanviensuachuaApis/nhanVienSuaChuaSPApi";

function NhanVienSuaChuaPage() {
  const [getSanPham, { data: sanPhamData, isLoading: sanPhamLoading }] =
    useLazyDanhSachSanPhamSuaChuaTheoIdNguoiSuaQuery();

  useEffect(() => {
    getSanPham({
      page: 1,
      pageSize: 10,
    });
  }, []);

  if (sanPhamLoading) {
    return <h2>Loading....</h2>;
  }

  const handlePageClick = (page) => {
    console.log(page);
  };

  return (
    <>
      <section className="content">
        <div className="container-fluid">
          <div className="row py-2"></div>
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
                        <th>Trạng Thái</th>
                      </tr>
                    </thead>
                    <tbody>
                      {sanPhamData &&
                        sanPhamData.data.map((sanPham) => (
                          <tr key={sanPham.id}>
                            <td>
                              <Link
                                to={`/nhan-vien/sua-chua/${sanPham.id}`}
                                className="text-decoration-none"
                              >
                                {sanPham.model}
                              </Link>
                            </td>
                            <td>
                              <Link
                                to={`/nhan-vien/sua-chua/${sanPham.id}`}
                                className="text-decoration-none"
                              >
                                {sanPham.hangSanXuat}
                              </Link>
                            </td>
                            <td>{sanPham.ime}</td>
                            <td>{sanPham.tenLoi}</td>
                            <td>{sanPham.trangThai}</td>
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

export default NhanVienSuaChuaPage;
