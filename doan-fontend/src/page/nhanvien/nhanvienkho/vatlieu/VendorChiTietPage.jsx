import React, { useEffect } from "react";
import ReactPaginate from "react-paginate";
import { Link, useParams } from "react-router-dom";
import { useLazyDanhSachVatLieuTheoVendorQuery } from "../../../../app/apis/nhanvienkhoApis/venderNVKApi";

function VendorChiTietPage() {
  const { vendorCode } = useParams();

  const [getVL, { data: vatLieuData, isLoading: vatLieuLoading }] =
    useLazyDanhSachVatLieuTheoVendorQuery();

  useEffect(() => {
    getVL({
      page: 1,
      pageSize: 10,
      vendorId: vendorCode,
    });
  }, []);

  if (vatLieuLoading) {
    return <h2>Loading....</h2>;
  }

  console.log(vatLieuData);

  const handlePageClick = (page) => {
    console.log(page);
  };

  return (
    <>
      <section className="content">
        <div className="container-fluid">
          <div className="row py-2">
            <div className="col-12">
              <Link to={"/nhan-vien/kho/vender"} className="btn btn-default">
                Quay Lại
              </Link>
              <Link
                to={`/nhan-vien/kho/${vendorCode}`}
                className="btn btn-info"
              >
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
                        <th>Mã Vật Liệu</th>
                        <th>Tên Model</th>
                        <th>Loại Linh Kiện</th>
                        <th>Tên Vendor</th>
                        <th>Số Lượng</th>
                      </tr>
                    </thead>
                    <tbody>
                      {vatLieuData?.data &&
                        vatLieuData?.data.map((vatLieu) => (
                          <tr key={vatLieu?.id}>
                            <td>{vatLieu?.code}</td>
                            <td>{vatLieu?.tenModel}</td>
                            <td>{vatLieu?.loaiLinhKien}</td>
                            <td>{vatLieu?.nameVendor}</td>
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

export default VendorChiTietPage;
