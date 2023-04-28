import React from "react";

function ProductList() {
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
    </>
  );
}

export default ProductList;
