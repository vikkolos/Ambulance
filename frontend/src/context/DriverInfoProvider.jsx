import React, { useState,createContext } from 'react'

export const driverInfo = createContext();


function DriverInfoProvider({children}) {
    const [driverName,setDriverName]= useState("");
    const [driverEmail,setDriverEmail ]= useState("");
    const [driverAdhar,setDriverAadhar ]= useState("");
    const [driverVehicalNumber,setDriverVehicalNumber ]= useState("");
    const [driverLicence,setDriverLicence ]= useState("");
    const [role,setRole] = useState("")
  return (
    <driverInfo.Provider value={{ driverName,setDriverName,driverEmail,setDriverEmail ,driverAdhar,setDriverAadhar,setRole,driverVehicalNumber,setDriverVehicalNumber,driverLicence,setDriverLicence}}>
        {children}
    </driverInfo.Provider>
  )
}

export default DriverInfoProvider;