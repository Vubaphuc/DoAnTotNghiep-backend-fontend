import React from "react";
import "../../static/css/login.css";

function LoginPage() {
  return (
    <>
      <div className="login-page">
        <div className="form-login">
          <form className="login-form">
            <input type="text" placeholder="Nhập Email" />
            <input type="password" placeholder="Nhập Password" />
            <button type="submit">login</button>
          </form>
        </div>
      </div>
    </>
  );
}

export default LoginPage;
