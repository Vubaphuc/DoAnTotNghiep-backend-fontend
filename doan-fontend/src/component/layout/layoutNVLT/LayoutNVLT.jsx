import React from 'react'
import SideBarNVLT from '../../sidebar/sidebarNVLT/SideBarNVLT'
import Header from '../../header/Header'
import { Outlet } from 'react-router-dom'

function LayoutNVLT() {
  return (
    <>

        <SideBarNVLT />

        <div>
            
            <Header />

            <Outlet />

        </div>
    </>
  )
}

export default LayoutNVLT