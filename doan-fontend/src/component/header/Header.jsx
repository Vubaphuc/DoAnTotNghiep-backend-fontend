import React from "react";

function Header() {
  return (
    <>
      <header>
        <div></div>
        <div className="header-menu">
          <ul>
            <li>
              <a href="#">Tên Nhân Viên</a>
            </li>
            <li>
              <a href="#">Bộ phận</a>
            </li>
            <li>
              <button className="btn">Logout</button>
            </li>
          </ul>
        </div>
      </header>
    </>
  );
}

export default Header;
