import React from 'react'
import SideBarKH from '../../sidebar/sidebarkhachhang/SideBarKH'
import Header from '../../header/Header'
import { Outlet } from 'react-router-dom'

function LayoutKH() {
  return (
    <>
        <SideBarKH />

        <div>
            
            <Header />

            <Outlet />

        </div>
    </>
  )
}

export default LayoutKH