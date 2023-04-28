import React from "react";

function SideBarNVLT() {
  return (
    <>
      <div className="sidebar">
        <div className="nhan-vien">
          <h3>Loại Nhân Viên</h3>
        </div>
        <div className="menu">
          <div className="menu-item">
            <h5>Quản lý Sản Phẩm</h5>
            <ul>
              <li>
                <Link to={"/nhan-vien/sua-chua/danh-sach"}>
                  Danh Sách sản phẩm
                </Link>
              </li>
              <li>
                <Link to={"/nhan-vien/sua-chua/sua"}>
                  Sửa thông tin sản phẩm
                </Link>
              </li>
              <li>
                <Link to={"/nhan-vien/sua-chua/history"}>
                  Tìm kiếm lịch sử sản phẩm
                </Link>
              </li>
            </ul>
          </div>
          <div className="menu-item">
            <h5>Quản lý khách hàng</h5>
            <ul>
              <li>
                <Link to={"/nhan-vien/sua-chua/create-oder"}>
                  Thêm khách hàng mới
                </Link>
              </li>
              <li>
                <Link to={"/nhan-vien/sua-chua/sua-oder"}>
                  Tìm kiếm khách hàng
                </Link>
              </li>
              <li>
                <Link to={"/nhan-vien/sua-chua/xoa-oder"}>
                  Sửa thông tin khách hàng
                </Link>
              </li>
            </ul>
          </div>
          <div className="menu-item">
            <h5>Quản lý hóa đơn</h5>
            <ul>
              <li>
                <Link to={"/nhan-vien/sua-chua/create-oder"}>
                  Tạo hóa đơn mới
                </Link>
              </li>
              <li>
                <Link to={"/nhan-vien/sua-chua/xoa-oder"}>
                  Sửa thông tin Hóa đơn
                </Link>
              </li>
              <li>
                <Link to={"/nhan-vien/sua-chua/sua-oder"}>
                  Tìm kiếm hóa đơn
                </Link>
              </li>
            </ul>
          </div>
          <div className="menu-item">
            <h5>Quản lý user</h5>
            <ul>
              <li>
                <Link to={"/nhan-vien/sua-chua/thong-tin"}>
                  Thông tin nhân viên
                </Link>
              </li>
              <li>
                <Link to={"/nhan-vien/sua-chua/doi-mat-khau"}>
                  Đổi mật khẩu
                </Link>
              </li>
            </ul>
          </div>
        </div>
      </div>
    </>
  );
}

export default SideBarNVLT;
