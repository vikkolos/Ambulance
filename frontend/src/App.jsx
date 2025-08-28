import UserLogin from "./pages/UserLogin"
import DriverLogin from "./pages/DriverLogin"
import Home from "./pages/Home.jsx"
import { BrowserRouter, Route, Routes } from "react-router-dom"

import Wrapper from "./wrapper/Wrapper.jsx"

function App() {

  return (
    <BrowserRouter>
      <Routes>
          <Route
            path="/home"
            // element={<Wrapper><Home /></Wrapper>} 
            element={<Home />} 
          />
        <Route
          path="/user"
          element={<UserLogin />}
        />
        <Route
          path="/driver"
          element={<DriverLogin />} 
        />
      </Routes>
    </BrowserRouter>
  )
}

export default App
