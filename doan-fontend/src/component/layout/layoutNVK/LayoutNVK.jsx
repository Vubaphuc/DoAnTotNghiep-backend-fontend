import React from 'react'
import SideBarNVK from '../../sidebar/sidebarNVK/SideBarNVK'
import Header from '../../header/Header'
import { Outlet } from 'react-router-dom'

function LayoutNVK() {
  return (
    <>
        <SideBarNVK />

        <div>

            <Header />

            <Outlet />

        </div>

    </>
  )
}

export default LayoutNVK