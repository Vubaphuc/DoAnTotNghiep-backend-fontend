import React from "react";
import { useState } from "react";
import ReactPaginate from "react-paginate";
import { Link } from "react-router-dom";
import { useSearchHistoryMaterialQuery } from "../../../../app/apis/nhanvienkhoApis/vatLieuNVKApi";

function TimKiemVatLieuNVKPage() {
  const [term, setTerm] = useState("");
  const [page, setPage] = useState(0);

  const { data: materialData, isLoading: materialLoading } =
    useSearchHistoryMaterialQuery({ page: page + 1, pageSize: 10, term: term });

  if (materialLoading) {
    return <h2>Loading...</h2>;
  }

  console.log(materialData);

  const handleSearchTermChange = (event) => {
    setTerm(event.target.value);
  };

  const handlePageClick = (page) => {
    setPage(page.selected);
  };

  return (
    <>
      <div className="search-container">
        <input
          className="input-search"
          type="text"
          placeholder="Tìm kiếm..."
          value={term}
          onChange={handleSearchTermChange}
        />
        <div className="search-results mt-3">
          {term !== "" && (
            <div>
              <table className="table table-bordered table-hover">
                <thead>
                  <tr>
                    <th>Mã Vật Liệu</th>
                    <th>Tên Model</th>
                    <th>Loại Linh Kiện</th>
                    <th>Vendor</th>
                    <th>Số Lượng</th>
                    <th>Mã Nhân Viên Nhập</th>
                    <th>Tên Nhân Viên Nhập</th>
                    <th>Ngày Nhập</th>
                    <th>Ngày Cập Nhật</th>
                  </tr>
                </thead>
                <tbody>
                  {materialData &&
                    materialData?.data.map((material) => (
                      <tr key={material.id}>
                        <td>{material.maVatLieu ? material.maVatLieu : ""}</td>
                        <td>{material.tenModel ? material.tenModel : ""}</td>
                        <td>{material.loaiLinhKien ? material.loaiLinhKien : ""}</td>
                        <td>{material.nameVendor ? material.nameVendor : ""}</td>
                        <td>{material.soLuong ? material.soLuong : ""}</td>
                        <td>{material.maNhanVienNhap ? material.maNhanVienNhap : ""}</td>
                        <td>{material.fullNameNhanVienNhap ? material.fullNameNhanVienNhap : ""}</td>
                        <td>{material.ngayNhap ? new Date(material.ngayNhap).toLocaleDateString() : ""}</td>
                        <td>{material.ngayCapNhat ? new Date(material.ngayCapNhat).toLocaleDateString() : ""}</td>
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
                  pageCount={materialData?.totalPages}
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
          {term === "" && <p>Không có kết quả tìm kiếm nào !!!</p>}
        </div>
      </div>
    </>
  );
}

export default TimKiemVatLieuNVKPage;
