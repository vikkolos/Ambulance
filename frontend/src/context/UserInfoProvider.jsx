import React, { useState,createContext } from 'react'

export const userInfo = createContext();


function UserInfoProvider({children}) {
    const [userName,setUserName]= useState("");
    const [userEmail,setUserEmail ]= useState("");
  return (
    <userInfo.Provider value={{ userName, setUserName, userEmail, setUserEmail }}>
        {children}
    </userInfo.Provider>
  )
}

export default UserInfoProvider;