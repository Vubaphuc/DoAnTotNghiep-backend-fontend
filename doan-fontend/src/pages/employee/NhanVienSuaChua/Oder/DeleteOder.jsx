import React from "react";

function DeleteOder() {
  return (
    <>
      <nav>
        <div className="search-box">
          <div className="search">
            <div className="form-search">
              <input type="text" placeholder="Tìm kiếm Oder" />
            </div>
          </div>
        </div>
        <div className="table">
          <table className="fixed_headers">
            <thead>
              <tr>
                <th>STT</th>
                <th>Mã Oder</th>
                <th>tên kỹ sữ</th>
                <th>trạng thái</th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <td>
                  <a href="#">1</a>
                </td>
                <td>
                  <a href="#">A047F</a>
                </td>
                <td>
                  <a href="#">Vũ Bá Phúc</a>
                </td>
                <td>
                  {" "}
                  <a href="#">PENDING</a>
                </td>
              </tr>
              <tr>
                <td>
                  <a href="#">2</a>
                </td>
                <td>
                  <a href="#">A047F</a>
                </td>
                <td>
                  <a href="#">Vũ Bá Phúc</a>
                </td>
                <td>
                  {" "}
                  <a href="#">OK</a>
                </td>
              </tr>
            </tbody>
          </table>
          <div className="pagination">
            <ul>
              <li>
                <a
                  href="#"
                  aria-controls="example2"
                  data-dt-idx="0"
                  tabIndex="0"
                  className="link-page page"
                >
                  Previous
                </a>
              </li>
              <li>
                <a
                  href="#"
                  aria-controls="example2"
                  data-dt-idx="1"
                  tabIndex="0"
                  className="link-page page-number"
                >
                  1
                </a>
              </li>
              <li>
                <a
                  href="#"
                  aria-controls="example2"
                  data-dt-idx="7"
                  tabIndex="0"
                  className="link-page page"
                >
                  Next
                </a>
              </li>
            </ul>
          </div>
        </div>
      </nav>
      <footer>
        <div className="container-fluid">
          <div className="row">
            <div className="col-12">
              <div className="card">
                <div className="card-body">
                  <div className="row">
                    <div className="col-md-8">
                      <div className="form-group">
                        <label>Mã Oder</label>
                        <input
                          type="text"
                          className="form-control"
                          id="title"
                        />
                      </div>
                      <div className="form-group">
                        <label>Số CN</label>
                        <input
                          type="text"
                          className="form-control"
                          id="title"
                        />
                      </div>
                      <div className="form-group">
                        <label>Tên Vật Liệu</label>
                        <select id="status" className="form-control">
                          <option value="0">LCD</option>
                          <option value="1">Chết nguồn</option>
                        </select>
                      </div>
                      <div className="form-group">
                        <label>Model</label>
                        <input
                          type="text"
                          className="form-control"
                          id="model"
                        />
                      </div>
                      <div className="form-group">
                        <label>Tên Kỹ Sư</label>
                        <input
                          type="text"
                          className="form-control"
                          id="ky-su"
                        />
                      </div>
                    </div>
                    <div className="col-md-4">
                      <div className="form-group">
                        <label>Bộ Phận</label>
                        <input
                          type="text"
                          className="form-control"
                          id="bo-phan"
                        />
                      </div>
                      <div className="form-group">
                        <label>Số lượng Oder</label>
                        <input
                          type="text"
                          className="form-control"
                          id="vi-tri"
                        />
                      </div>
                      <div className="form-group">
                        <label>Chú thích</label>
                        <textarea
                          type="text"
                          className="form-control"
                          id="chu-thich"
                          name="chu-thich"
                        ></textarea>
                      </div>
                      <div className="form-group">
                        <label>Hình thức đổi</label>
                        <select id="status" className="form-control">
                          <option value="0">Cấp mới</option>
                          <option value="1">Đổi</option>
                        </select>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div className="menu-btn">
            <div className="back">
              <button type="button" className="save">
                Quay Lại
              </button>
            </div>
            <div className="red">
              <button type="button" className="danger">
                Xóa
              </button>
            </div>
          </div>
        </div>
      </footer>
    </>
  );
}

export default DeleteOder;
