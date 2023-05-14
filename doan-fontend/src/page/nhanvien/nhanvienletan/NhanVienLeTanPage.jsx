import React, { useEffect, useState } from "react";
import ReactPaginate from "react-paginate";
import { Link } from "react-router-dom";
import { useLazyDanhSachSanPhamOKNVLTQuery } from "../../../app/apis/nhanvienletanApi/sanPhamApi";

function NhanVienLeTanPage() {
  const [status, setStatus] = useState("KHACHHANG");

  const [getSanPham, { data: sanPhamData, isLoading: sanPhamLoading }] =
    useLazyDanhSachSanPhamOKNVLTQuery();

  useEffect(() => {
    getSanPham({
      page: 1,
      pageSize: 10,
    });
  }, []);

  if (sanPhamLoading) {
    return <h2>Loading....</h2>;
  }

  console.log(sanPhamData);

  const handlePageClick = (page) => {
    getSanPham({
      page: page.selected + 1,
      pageSize: 10,
    });
  };

  const handleStatusChange = (e) => {
    setStatus(e.target.value)
  }

  return (
    <>
      <section className="content">
        <div className="container-fluid">
          <div class="search-container">
            <input
              className="input-search mb-4"
              type="text"
              placeholder="Tìm kiếm..."
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
                      <option value="KHACHHANG">Khách Hàng</option>
                      <option value="BAOHANH">Bảo Hành</option>
                    </select>
                  </div>
                  <table className="table table-bordered table-hover">
                    <thead>
                      <tr>
                        <th>Model</th>
                        <th>Hãng Điện Thoại</th>
                        <th>Số IME</th>
                        <th>Tên Lỗi</th>
                        <th>Vị Trí Sửa</th>
                        <th>Số Lượng</th>
                        <th>Giá Tiền</th>
                        <th>Thành Tiền</th>
                        <th>Trạng Thái</th>
                      </tr>
                    </thead>
                    <tbody>
                      {status === "KHACHHANG" &&
                        sanPhamData &&
                        sanPhamData.data.map((sanPham) => (
                          <tr key={sanPham.id}>
                            <td>
                              <Link
                                to={`/nhan-vien/le-tan/hd-bh/${sanPham.id}`}
                                className="text-decoration-none"
                              >
                                {sanPham?.model}
                              </Link>
                            </td>
                            <td>
                              <Link
                                to={`/nhan-vien/le-tan/hd-bh/${sanPham.id}`}
                                className="text-decoration-none"
                              >
                                {sanPham?.hangSanXuat}
                              </Link>
                            </td>
                            <td>{sanPham?.ime}</td>
                            <td>{sanPham?.tenLoi}</td>
                            <td>{sanPham?.viTriSua}</td>
                            <td>{sanPham?.soLuong}</td>
                            <td>{sanPham?.giaTien}</td>
                            <td>{sanPham?.thanhTien}</td>
                            <td>{sanPham?.trangThai}</td>
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
                      pageCount={sanPhamData?.totalPages}
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

export default NhanVienLeTanPage;
