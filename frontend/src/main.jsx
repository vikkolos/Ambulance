import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import UserInfoProvider from './context/UserInfoProvider.jsx'
import DriverInfoProvider from './context/DriverInfoProvider.jsx'
import './index.css'
import App from './App.jsx'

createRoot(document.getElementById('root')).render(
  <StrictMode>
    <UserInfoProvider>
      <DriverInfoProvider>
        <App />
      </DriverInfoProvider>
    </UserInfoProvider>
  </StrictMode>,
)
