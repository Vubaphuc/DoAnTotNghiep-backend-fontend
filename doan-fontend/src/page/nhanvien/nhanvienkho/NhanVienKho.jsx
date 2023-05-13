import React, { useEffect, useState } from "react";
import ReactPaginate from "react-paginate";
import { Link } from "react-router-dom";
import { useLazyDanhSachVatLieuAllQuery } from "../../../app/apis/nhanvienkhoApis/vatLieuNVKApi";

function NhanVienKho() {
  const [count, setCount] = useState(0);

  const [getVatLieu, { data: vatLieuData, isLoading: vatLieuLoading }] =
    useLazyDanhSachVatLieuAllQuery();

  useEffect(() => {
    getVatLieu({
      page: 1,
      pageSize: 10,
    });
  }, []);

  if (vatLieuLoading) {
    return <h2>Loading....</h2>;
  }

  console.log(vatLieuData);

  const handlePageClick = (page) => {
    getVatLieu({
      page: page.selected + 1,
      pageSize: 10,
    });
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
                        <th>STT</th>
                        <th>Mã Vật Liệu</th>
                        <th>Tên Model</th>
                        <th>Loại Linh Kiện</th>
                        <th>Số Lượng</th>
                      </tr>
                    </thead>
                    <tbody>
                      {vatLieuData?.data &&
                        vatLieuData?.data.map((vatLieu, index) => (
                          <tr key={vatLieu?.code}>
                            <td>{count + index + 1}</td>
                            <td>{vatLieu?.code}</td>
                            <td>{vatLieu?.tenModel}</td>
                            <td>{vatLieu?.loaiLinhKien}</td>
                            <td>{vatLieu?.soLuong}</td>
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
                      pageCount={vatLieuData?.totalPages}
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

export default NhanVienKho;
