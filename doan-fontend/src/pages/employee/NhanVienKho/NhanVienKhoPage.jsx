import React from "react";

function NhanVienKhoPage() {
  return (
    <>
      <nav>
        <div className="search-box">
          <div className="search">
            <div className="form-search">
              <input type="text" placeholder="Tìm kiếm Sản phẩm" />
            </div>
          </div>
        </div>
        <div className="table">
          <table className="fixed_headers">
            <thead>
              <tr>
                <th>STT</th>
                <th>Model</th>
                <th>IME</th>
                <th>Tên Lỗi</th>
                <th>Ngày Nhận</th>
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
                  <a href="#">G2B027516960Z</a>
                </td>
                <td>
                  {" "}
                  <a href="#">Vỡ Glass</a>
                </td>
                <td>
                  {" "}
                  <a href="#">06-02-1991</a>
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
                  <a href="#">G2B027516960Z</a>
                </td>
                <td>
                  {" "}
                  <a href="#">Vỡ Glass</a>
                </td>
                <td>
                  {" "}
                  <a href="#">06-02-1991</a>
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
                  tabindex="0"
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
                  tabindex="0"
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
                  tabindex="0"
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
                        <label>CN</label>
                        <input
                          type="text"
                          className="form-control"
                          id="title"
                        />
                      </div>
                      <div className="form-group">
                        <label>Tên lỗi</label>
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
                      <div className="form-group">
                        <label>Bộ Phận</label>
                        <input
                          type="text"
                          className="form-control"
                          id="bo-phan"
                        />
                      </div>
                    </div>
                    <div className="col-md-4">
                      <div className="form-group">
                        <label>Vị trí gây Lỗi</label>
                        <input
                          type="text"
                          className="form-control"
                          id="vi-tri"
                        />
                      </div>
                      <div className="form-group">
                        <label>Nguyên Nhân</label>
                        <textarea
                          type="text"
                          className="form-control"
                          id="chu-thich"
                          name="chu-thich"
                        ></textarea>
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
                        <label>Trạng thái</label>
                        <select id="status" className="form-control">
                          <option value="0">OK</option>
                          <option value="1">Hủy</option>
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
                Lưu
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

export default NhanVienKhoPage;
