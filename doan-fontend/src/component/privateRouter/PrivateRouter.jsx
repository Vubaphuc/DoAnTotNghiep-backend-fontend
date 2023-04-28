import React from 'react'
import { Outlet } from 'react-router-dom'

function PrivateRouter() {
  return (
    <>
    
        <Outlet />
    </>
  )
}

export default PrivateRouter