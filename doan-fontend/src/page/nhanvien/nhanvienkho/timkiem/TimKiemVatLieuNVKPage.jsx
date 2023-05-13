import React from "react";
import { useState } from "react";
import { Link } from "react-router-dom";

function TimKiemVatLieuNVKPage() {
  const [terms, setTerm] = useState("");

  const handleSearchTermChange = (event) => {
    setTerm(event.target.value);
  };

  return (
    <>
      <div class="search-container">
        <input className="input-search" type="text" placeholder="Tìm kiếm..." />
        <button type="submit">Tìm kiếm</button>
        <div class="search-results">
          <p>Kết quả tìm kiếm sẽ xuất hiện ở đây.</p>
        </div>
      </div>
    </>
  );
}

export default TimKiemVatLieuNVKPage;
