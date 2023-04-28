import React from 'react'
import Header from '../../header/Header'
import { Outlet } from 'react-router-dom'
import SideBar from '../../sidebar/sidebarNVSC/SideBar'

function Layout() {
  return (
    <>
        <SideBar />

        <div>
          <Header />

          <Outlet />
        </div>

    </>
  )
}

export default Layout