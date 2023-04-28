import React from "react";

function Register() {
  return (
    <>
      <form>
        <div class="form-group">
          <label for="username">Tên đăng nhập:</label>
          <input
            type="text"
            class="form-control"
            id="username"
            placeholder="Nhập tên đăng nhập"
          />
        </div>
        <div class="form-group">
          <label for="email">Email:</label>
          <input
            type="email"
            class="form-control"
            id="email"
            placeholder="Nhập email"
          />
        </div>
        <div class="form-group">
          <label for="password">Mật khẩu:</label>
          <input
            type="password"
            class="form-control"
            id="password"
            placeholder="Nhập mật khẩu"
          />
        </div>
        <div class="form-group">
          <label for="confirm-password">Xác nhận mật khẩu:</label>
          <input
            type="password"
            class="form-control"
            id="confirm-password"
            placeholder="Xác nhận mật khẩu"
          />
        </div>
        <button type="submit" class="btn btn-primary">
          Đăng ký
        </button>
      </form>
    </>
  );
}

export default Register;
