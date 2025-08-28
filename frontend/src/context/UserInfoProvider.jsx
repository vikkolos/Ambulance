import React, { useState,createContext } from 'react'

export const userInfo = createContext();


function UserInfoProvider({children}) {
    const [userName,setUserName]= useState("");
    const [userEmail,setUserEmail ]= useState("");
    const [role,setRole ]= useState("");
  return (
    <userInfo.Provider value={{ userName, setUserName, userEmail, setUserEmail,role,setRole}}> 
        {children}
    </userInfo.Provider>
  )
}

export default UserInfoProvider;