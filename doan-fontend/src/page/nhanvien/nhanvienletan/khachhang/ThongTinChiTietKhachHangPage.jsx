import React, { useState } from "react";
import { Link, useParams } from "react-router-dom";
import { useDanhSachSanPhamTheoIdKhachHangQuery } from "../../../../app/apis/nhanvienletanApi/khachHangApi";

function ThongTinChiTietKhachHangPage() {
  
  const { khachHangId } = useParams();
  const [count, setCount] = useState(0);



  const { data: sanPhamData, isLoading: sanPhamLoading } =
    useDanhSachSanPhamTheoIdKhachHangQuery(khachHangId);

  if (sanPhamLoading) {
    return <h2>Loading...</h2>;
  }

  console.log(sanPhamData)

  const handlePageClick = (page) => {};

  return (
    <>
      <section className="content">
        <div className="container-fluid">
          <div className="row py-2">
            <div className="col-6">
              <Link to={"/nhan-vien/le-tan/ds-kh"} className="btn btn-default">
                <i className="fas fa-chevron-left"></i> Quay lại
              </Link>
            </div>
          </div>
          <div className="row">
            <div className="col-12">
              <div className="card">
                <div className="card-body">
                  <table className="table table-bordered table-hover">
                    <thead>
                      <tr>
                        <th>STT</th>
                        <th>Model</th>
                        <th>Hãng Điện Thoại</th>
                        <th>Số IME</th>
                        <th>Tên Lỗi</th>
                        <th>Trạng Thái</th>
                      </tr>
                    </thead>
                    <tbody>
                      {sanPhamData &&
                        sanPhamData?.data.map((sanPham,index) => (
                          <tr key={sanPham.id}>
                            <td>{count + index + 1}</td>
                            <td>
                              <Link to={`/nhan-vien/le-tan/ds-sp/${sanPham.id}`} className="text-decoration-none">
                                {sanPham.model}
                              </Link>
                            </td>
                            <td>
                              <Link to={`/nhan-vien/le-tan/ds-sp/${sanPham.id}`} className="text-decoration-none">
                                {sanPham.hangSanXuat}
                              </Link>
                            </td>
                            <td>{sanPham.ime}</td>
                            <td>{sanPham.tenLoi}</td>
                            <td>{sanPham.trangThai}</td>
                          </tr>
                        ))}
                    </tbody>
                  </table>
                </div>
              </div>
            </div>
          </div>
        </div>
      </section>
    </>
  );
}

export default ThongTinChiTietKhachHangPage;
