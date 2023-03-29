import { Route, Routes } from 'react-router-dom'
import LoginUser from './component/login/LoginUser'

function App() {

  return (
    <>
        <Routes>

              <Route path="/login">
              <Route index element={<LoginUser />} />
              </Route>

        </Routes>
    </>
  )
}

export default App
