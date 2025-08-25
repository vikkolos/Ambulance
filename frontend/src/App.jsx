import UserLogin from "./pages/UserLogin"
import DriverLogin from "./pages/DriverLogin"
import UserInfoProvider from "./context/UserInfoProvider"
function App() {

  return (
    <UserInfoProvider>
     <DriverLogin/>
    </UserInfoProvider>
  )
}

export default App
