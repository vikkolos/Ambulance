import React, { useState } from 'react'
import { FaAngleLeft } from "react-icons/fa6";
import { FcGoogle } from "react-icons/fc";
import { FaGoogleWallet } from "react-icons/fa";



function DriverLogin() {

  const [hasAccount, setHasAccount] = useState(false);
  const [driverName,setDriverName]= useState(null);
  const [aadharNumber,setAadharNumber]= useState(null);
  const [driverEmail,setDriverEmail ]= useState(null);
  const [driverPassword,setDriverPassword ]= useState(null);
  


  // This function is used to toggle between the login and registration forms.
  const toggleUserAccount = () => {
    setHasAccount(!hasAccount);
  }

  return (
    <>
        <div className="inset-0 fixed flex flex-col items-start justify-center h-screen w-screen overflow-hidden">
            <div className='h-1/2 w-full bg-[#4DD0E1]'>
              <div className='cursor-pointer flex items-center justify-center  w-8 h-8  rounded-sm m-2 mt-3 bg-white/25 backdrop-blur-md '><FaAngleLeft className='text-2xl text-white'/></div>
                  <div className=' flex items-center justify-center flex-col'>
                    <FaGoogleWallet className='text-white text-5xl' />
                    <span className='text-3xl font-bold text-white'>{hasAccount ? 'Log in Account' : 'Create an Account'}</span>
                  </div>
               </div>
            <div className='h-1/2 w-full bg-[#f0f0f08e] '>
            </div>

            {/* This form or new user(patient) registration page which allows to create an account as a patient. */}

            <form className={`${hasAccount && 'translate-y-[100%] opacity-0 '}  px-5 py-3 rounded-md bg-white h-[79%] w-[94%] absolute left-1/2 bottom-[2%] translate-x-[-50%] z-10} transition-all duration-500 ease-in-out`}>
                  <p className='p-1 mt-3 font-semibold text-[#646464]'>Name</p>
                  <input className='bg-[#f0f0f07b] font-[300px] text-[#363535e0] w-full rounded-md px-3 py-1.5'  type="text" placeholder='Enter FullName '
                  value={driverName} onChange={(e)=>setDriverName(e.target.value.trim()) } required/>
                  <p className='p-1 mt-3 font-semibold text-[#646464]'>Aadhar Number</p>
                  <input className='bg-[#f0f0f07b] font-[300px] text-[#363535e0] w-full rounded-md px-3 py-1.5'  type="number" placeholder='Enter Aadhar Number'
                  value={aadharNumber}  onChange={(e)=>setAadharNumber(e.target.value)} required/>
                  <p className='mt-2 p-1  font-semibold text-[#646464]'>Email</p>
                  <input className='bg-[#f0f0f07b] font-[300px] text-[#363535e0] w-full rounded-md px-3 py-1.5'  type="email" placeholder='xyz@gmail.com' 
                   value={driverEmail}  onChange={(e)=>setDriverEmail(e.target.value)} required/>
                  <p className='mt-2 p-1  font-semibold text-[#646464]'>Password</p>
                  <input  className='bg-[#f0f0f07b] font-[300px] text-[#363535e0] w-full rounded-md px-3 py-1.5' type="password" placeholder='Enter password'
                   value={driverPassword}  onChange={(e)=>setDriverPassword(e.target.value)} required />
                  <button className='cursor-pointer w-full font-semibold p-2 mt-8 bg-[#00BCD4] text-white rounded-sm'>Create Account</button>
                          <div className='flex items-center justify-between mt-4'>
                            <span className='w-[45%] h-[1px] bg-[#9a9696]'></span>
                            <span className='font-semibold text-[#9a9696]'>Or</span>
                            <span className='w-[45%] h-[1px] bg-[#9a9696]'></span>
                          </div>
                          <div className='flex items-center justify-center mt-4 p-2 border-1 border-[#F0F0F0] rounded-md cursor-pointer hover:bg-[#E0E0E0]'>
                            <FcGoogle />
                            <span className='ml-2 font-semibold'>Continue with Google</span>
                          </div>
                  <span className='flex items-center justify-center w-full mt-5 text-[#525151]'>Already have an account? <span onClick={()=>toggleUserAccount(false)} className=' hover:cursor-pointer ml-4 text-blue-400 font-semibold'>Log In</span></span>
            </form>

            {/* This form or user(patient) login page which allows to login an account as a patient. */}

            <form className={`${!hasAccount && 'translate-y-[100%] opacity-0 '} px-5 py-3 rounded-md bg-white h-[79%] w-[94%] absolute left-1/2 bottom-[2%] translate-x-[-50%] z-10} transition-all duration-500 ease-in-out`}>
                
                <p className='mt-3 p-1  font-semibold text-[#646464]'>Email</p>
                <input className='bg-[#f0f0f07b] font-[300px] text-[#363535e0] w-full rounded-md px-3 py-1.5'  type="email" placeholder='xyz@gmail.com' required/>
                <p className='mt-2 p-1  font-semibold text-[#646464]'>Password</p>
                <input  className='bg-[#f0f0f07b] font-[300px] text-[#363535e0] w-full rounded-md px-3 py-1.5' type="password" placeholder='Enter password' required/>
                <button className='cursor-pointer w-full font-semibold p-2 mt-8 bg-[#00BCD4] text-white rounded-sm'>Log In</button>
                    <div className='flex items-center justify-between mt-4'>
                      <span className='w-[45%] h-[1px] bg-[#9a9696]'></span>
                      <span className='font-semibold text-[#9a9696]'>Or</span>
                      <span className='w-[45%] h-[1px] bg-[#9a9696]'></span>
                    </div>
                    <div className='flex items-center justify-center mt-4 p-2 border-1 border-[#F0F0F0] rounded-md cursor-pointer hover:bg-[#E0E0E0]'>
                      <FcGoogle />
                      <span className='ml-2 font-semibold'>Continue with Google</span>
                    </div>
                <span className='flex items-center justify-center w-full mt-5 text-[#525151]'><span onClick={()=>toggleUserAccount(true)} className='ml-4 text-blue-400 font-semibold hover:cursor-pointer'>Create new account</span></span>
            </form>

        </div>
    </>
  )
}

export default DriverLogin