import React, { useState } from "react";
import { useSearchHistoryOrderMaterialQuery } from "../../../../app/apis/nhanvienkhoApis/oderVatLieuNVKApi";
import ReactPaginate from "react-paginate";

function TimKiemOderNNVKPage() {
  const [term, setTerm] = useState("");
  const [page, setPage] = useState(0);

  const { data: orderData, isLoading: orderLoading } = useSearchHistoryOrderMaterialQuery({page: page + 1, pageSize: 10, term: term});

  if (orderLoading) {
    return <h2>Loading...</h2>
  }

  console.log(orderData)

  const handleOnChane = (e) => {
    setTerm(e.target.value);
  };

  const handlePageClick = (page) => {
    setPage(page.selected);
  }

  return (
    <>
      <div className="search-container">
        <input
          className="input-search"
          type="text"
          placeholder="Tìm kiếm..."
          value={term}
          onChange={handleOnChane}
        />
        <div className="search-results mt-3">
          {term !== "" && (
            <div>
              <table className="table table-bordered table-hover">
                <thead>
                  <tr>
                    <th>Mã Order</th>
                    <th>Mã Vật Liệu</th>
                    <th>Tên Model</th>
                    <th>Loại Linh Kiện</th>
                    <th>Vendor</th>
                    <th>Số Lượng</th>
                    <th>Trạng Thái</th>
                    <th>Mã Nhân Viên Order</th>
                    <th>Tên Nhân Viên Order</th>
                    <th>Ngày Order</th>
                    <th>Mã Nhân Viên Phê Duyệt</th>
                    <th>Tên Nhân Viên Phê Duyệt</th>
                    <th>Ngày Phê Duyệt</th>
                  </tr>
                </thead>
                <tbody>
                  {orderData && orderData?.data.map((order) => (                 
                  <tr key={order.id}>
                    <td>{order.orderCode ? order.orderCode : ""}</td>
                    <td>{order.maVatLieu ? order.maVatLieu : ""}</td>
                    <td>{order.tenModel ? order.tenModel : ""}</td>
                    <td>{order.loaiLinhKien ? order.loaiLinhKien : ""}</td>
                    <td>{order.nameVendor ? order.nameVendor : ""}</td>
                    <td>{order.quantity ? order.quantity : ""}</td>
                    <td>{order?.status === true ? "OK" : "PENDING"}</td>
                    <td>{order.maNhanVienOrder ? order.maNhanVienOrder : ""}</td>
                    <td>{order.fullNameNhanVienOrder ? order.fullNameNhanVienOrder : ""}</td>
                    <td>{order.ngayOrder ? new Date(order.ngayOrder).toLocaleDateString() : ""}</td>
                    <td>{order.maNhanVienPhDuyet ? order.maNhanVienPhDuyet : ""}</td>
                    <td>{order.fullNameNhanVienPheDuyet ? order.fullNameNhanVienPheDuyet : ""}</td>
                    <td>{order.ngayPheDuyet ? new Date(order.ngayPheDuyet).toLocaleDateString() : ""}</td>
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
                  pageCount={orderData?.totalPages}
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
          {term === "" && (
            <p>Không có kết quả tìm kiếm nào !!!</p>
          )}
        </div>
      </div>
    </>
  );
}

export default TimKiemOderNNVKPage;
