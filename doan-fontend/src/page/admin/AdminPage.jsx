import React from "react";
import ReactPaginate from "react-paginate";
import { Link } from "react-router-dom";

function AdminPage() {
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
                        <th>Tiêu đề</th>
                        <th>Tác giả</th>
                        <th>Danh mục</th>
                        <th>Trạng thái</th>
                        <th>Ngày tạo</th>
                      </tr>
                    </thead>
                    <tbody>
                          <tr >
                            <td>
                              <Link to={"/"}>
                                email
                              </Link>
                            </td>
                            <td>
                              <Link to={"/"}>
                                tên
                              </Link>
                            </td>
                            <td>
                              ADMIN
                            </td>
                            <td>
                                statues
                            </td>
                            <td>
                              ngày giờ
                            </td>
                          </tr>
                    </tbody>
                  </table>
                  <div
                    className="d-flex justify-content-center mt-3"
                    id="pagination"
                  >
                    <ReactPaginate
                      nextLabel="next >"
                      onPageChange={""}
                      pageRangeDisplayed={3}
                      marginPagesDisplayed={2}
                      pageCount={3}
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

export default AdminPage;
