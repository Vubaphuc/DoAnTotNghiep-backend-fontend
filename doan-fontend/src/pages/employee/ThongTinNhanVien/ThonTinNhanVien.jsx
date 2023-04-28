import React from "react";

function ThonTinNhanVien() {
  return (
    <>
      <nav>
        <main className="employee-details">
          <div className="employee">
            <div className="employee-avatar avatar">
              <label>Avatar</label>
              <img src="../mau-ban-dau/anh.jpg" alt="avatar.pgn" />
              <button className="change-avatar-btn">Thay đổi ảnh đại diện</button>
            </div>
            <div className="employee-full-name">
              <label>Họ và tên</label>
              <input type="text" id="fullName" />
            </div>
            <div className="employee-email">
              <label>Email</label>
              <input type="text" className="form-control" id="email" />
            </div>
            <div className="employee-phone">
              <label>Số điện thoại</label>
              <input type="text" id="phone" />
            </div>
            <div className="employee-address">
              <label>Địa chỉ</label>
              <input type="text" id="address" />
            </div>
          </div>
        </main>
      </nav>
    </>
  );
}

export default ThonTinNhanVien;
