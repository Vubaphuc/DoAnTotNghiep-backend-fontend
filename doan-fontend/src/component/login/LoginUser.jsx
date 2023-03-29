import React, { useState } from "react";

function LoginUser() {
  const [isActive, setIsActive] = useState("");
  const [display, setDisPlay] = useState("");

  const handlerDisplayClick = (event) => {
    if (event.target.className === "btnLogin-popup") {
      setDisPlay("display");
    } else if (event.target.closest(".icon-close")) {
      setDisPlay("");
    }
  };

  const handlerClick = (event) => {
    if (event.target.className === "login-link") {
      setIsActive("active-popup");
    } else if (event.target.className === "register-link") {
      setIsActive("active");
    }
  };

  return (
    <>
      <header>
        <h2 className="logo">Logo</h2>
        <nav className="navigation">
          <a href="#">Home</a>
          <a href="#">About</a>
          <a href="#">Services</a>
          <a href="#">Contact</a>
          <button className="btnLogin-popup" onClick={handlerDisplayClick}>
            Login
          </button>
        </nav>
      </header>

      <div className={`wrapper ${isActive} ${display}`}>
        <button className="icon-close" onClick={handlerDisplayClick}>
          <ion-icon name="close"></ion-icon>
        </button>

        <div className="form-box login">
          <h2>Login</h2>
          <form action="#">
            <div className="input-box">
              <span className="icon">
                <ion-icon name="mail"></ion-icon>
              </span>
              <input type="email" required />
              <label htmlFor="#">Email</label>
            </div>
            <div className="input-box">
              <span className="icon">
                <ion-icon name="lock-closed"></ion-icon>
              </span>
              <input type="password" required />
              <label htmlFor="#">Password</label>
            </div>
            <div className="remember-forgot">
              <label htmlFor="">
                <input type="checkbox" />
                Remember me
              </label>
              <a href="#">Forgot Password</a>
            </div>
            <button type="submit" className="btn">
              Login
            </button>
            <div className="login-register">
              <p>
                Don't have an Account?
                <a href="#" className="register-link" onClick={handlerClick}>
                  Register
                </a>
              </p>
            </div>
          </form>
        </div>

        <div className="form-box register">
          <h2>Register</h2>
          <form action="#">
            <div className="input-box">
              <span className="icon">
                <ion-icon name="person"></ion-icon>
              </span>
              <input type="text" required />
              <label htmlFor="#">Username</label>
            </div>

            <div className="input-box">
              <span className="icon">
                <ion-icon name="mail"></ion-icon>
              </span>
              <input type="email" required />
              <label htmlFor="#">Email</label>
            </div>

            <div className="input-box">
              <span className="icon">
                <ion-icon name="lock-closed"></ion-icon>
              </span>
              <input type="password" required />
              <label htmlFor="#">Password</label>
            </div>

            <div className="remember-forgot">
              <label htmlFor="">
                <input type="checkbox" />I agree to the terms & conditions
              </label>
            </div>

            <button type="submit" className="btn">
              Register
            </button>

            <div className="login-register">
              <p>
                Already have an Account?
                <a href="#" className="login-link" onClick={handlerClick}>
                  Login
                </a>
              </p>
            </div>
          </form>
        </div>
      </div>
    </>
  );
}

export default LoginUser;
