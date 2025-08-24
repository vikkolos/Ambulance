import UserLogin from "./pages/UserLogin"
import DriverLogin from "./pages/DriverLogin"
import UserInfoProvider from "./context/UserInfoProvider"
function App() {

  return (
    <UserInfoProvider>
     <UserLogin/>
    </UserInfoProvider>
  )
}

export default App
