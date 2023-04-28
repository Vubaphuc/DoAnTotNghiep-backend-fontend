import React from "react";

function DoiMatKhau() {
  return (
    <>
      <main>
        <div className="password-form">
          <div>
            <label htmlFor="oldpassword">Mật khẩu cũ</label>
            <input type="text" id="oldpassword" />
          </div>
          <div>
            <label htmlFor="newpassword">Mật khẩu mới</label>
            <input type="text" id="newpassword" />
          </div>
          <div>
            <label htmlFor="confirmnewpassword">Xác nhận mật khẩu mới</label>
            <input type="text" id="confirmnewpassword" />
          </div>
          <div className="employee-address">
            <button className="update-btn">Cập nhật mật khẩu</button>
          </div>
        </div>
      </main>
    </>
  );
}

export default DoiMatKhau;
