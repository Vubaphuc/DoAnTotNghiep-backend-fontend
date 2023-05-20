import React, { useEffect } from "react";
import { useState } from "react";
import ReactPaginate from "react-paginate";
import { Link } from "react-router-dom";
import {
  useLazyDanhSachOrderOk_NVKQuery,
  useLazyDanhSachOrderPending_NVKQuery,
} from "../../../../app/apis/nhanvienkhoApis/oderVatLieuNVKApi";

function DanhSachOderPage() {
  const [status, setStatus] = useState("PENDING");
  const [page, setPage] = useState(0);
  const [count, setCount] = useState(0);

  const [getOrderOk, { data: OKData, isLoading: OkLoading }] =
    useLazyDanhSachOrderOk_NVKQuery();
  const [getOrderPending, { data: PendingData, isLoading: pendingLoading }] =
    useLazyDanhSachOrderPending_NVKQuery();

  useEffect(() => {
    getOrderOk({
      page: page + 1,
      pageSize: 10,
    }),
      getOrderPending({
        page: page + 1,
        pageSize: 10,
      });
  }, []);

  if (OkLoading || pendingLoading) {
    return <h2>Loading...</h2>;
  }

  console.log(PendingData);
  console.log(OKData)

  const handlePageClick = (page) => {
    setPage(page.selected);
  };

  const handleStatusChange = (e) => {
    setStatus(e.target.value);
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
                        <th>Loại Linh Kiện</th>
                        <th>Số Lượng</th>
                        <th>Mã Nhân Viên Oder</th>
                        <th>Tên Nhân Viên Oder</th>
                      </tr>
                    </thead>
                    <tbody>
                      {status === "PENDING" &&
                        PendingData &&
                        PendingData?.data.map((order, index) => (
                          <tr key={order.id}>
                            <td>{count + index + 1}</td>
                            <td>
                              <Link to={`/nhan-vien/kho/oder/${order.id}`} className="text-decoration-none">
                                {order.maOder}
                              </Link>
                            </td>
                            <td>
                              <Link to={`/nhan-vien/kho/oder/${order.id}`} className="text-decoration-none">
                                {order.tenModel}
                              </Link>
                            </td>
                            <td>{order.loaiLinhKien}</td>
                            <td>{order.soLuong}</td>
                            <td>{order.maNhanVienOrder}</td>
                            <td>{order.fullNameNguoiOrder}</td>
                          </tr>
                        ))}
                      {status === "OK" &&
                        OKData &&
                        OKData?.data.map((order, index) => (
                          <tr key={order.id}>
                            <td>{count + index + 1}</td>
                            <td>
                              <Link to={`/nhan-vien/kho/oder/${order.id}`} className="text-decoration-none">
                                {order.maOder}
                              </Link>
                            </td>
                            <td>
                              <Link to={`/nhan-vien/kho/oder/${order.id}`} className="text-decoration-none">
                                {order.tenModel}
                              </Link>
                            </td>
                            <td>{order.loaiLinhKien}</td>
                            <td>{order.soLuong}</td>
                            <td>{order.maNhanVienOrder}</td>
                            <td>{order.fullNameNguoiOrder}</td>
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
                      pageCount={status === "OK" ? OKData?.totalPages : PendingData?.totalPages}
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
