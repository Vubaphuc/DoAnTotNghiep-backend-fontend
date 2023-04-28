import React from "react";

function SideBarNVK() {
  return (
    <>
      <div className="sidebar">
        <div className="nhan-vien">
          <h3>Nhân Viên Kho</h3>
        </div>
        <div className="menu">
          <div className="menu-item">
            <h5>Quản lý Kho</h5>
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
            <h5>Oder</h5>
            <ul>
              <li>
                <Link to={"/nhan-vien/sua-chua/create-oder"}>
                  Tạo Oder vật liệu mới
                </Link>
              </li>
              <li>
                <Link to={"/nhan-vien/sua-chua/sua-oder"}>Sửa Oder</Link>
              </li>
              <li>
                <Link to={"/nhan-vien/sua-chua/xoa-oder"}>Xóa Oder</Link>
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

export default SideBarNVK;
