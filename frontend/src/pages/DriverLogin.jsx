import React, { useState, useContext } from 'react'
import { FaAngleLeft } from "react-icons/fa6";
import { FcGoogle } from "react-icons/fc";
import { FaGoogleWallet } from "react-icons/fa";
import { useNavigate } from 'react-router-dom';
import axios from 'axios';

import { driverInfo } from '../context/DriverInfoProvider';




function DriverLogin() {
  const navigate = useNavigate();

  const [hasAccount, setHasAccount] = useState(false);
  const [fullName, setFullName] = useState('');
  const [aadhar, setAadhar] = useState('');
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');

  const [error, setError] = useState('');

  const { setDriverEmail, setDriverName, setDriverAadhar, setRole, setDriverVehicalNumber, setDriverLicence } = useContext(driverInfo);



  // This function is used to toggle between the login and registration forms.
  const toggleUserAccount = () => {
    setHasAccount(!hasAccount);
  }

  const handleDriverSignup = async (e) => {
    e.preventDefault();
    const formData = {
      fullName,
      aadhar,
      email,
      password,
      role: 'DRIVER'
    };
    if(fullName.trim() === '' || aadhar.trim() === '' || email.trim() === '' || password.trim() === ''){
      setError("All fields are required");
      return;
    }else if(aadhar.length != 12){
      setError("Aadhar number must be 12 digits");
      return;
    }
    else if(password.length < 3){ 
      setError("Password must be at least 3 characters");
      return;
    }
    try {
      const response = await axios.post(`${import.meta.env.VITE_API_BASE_URL}/driver/signup`, formData, {
        headers: {
          'Content-Type': 'application/json'
        }
      });

      // Clear the form fields after successful submission
      setFullName('');
      setAadhar('');
      setEmail('');
      setPassword('');

      const { jwt: token, driver } = response.data;
      if (token) {
        localStorage.setItem('token', token);
      }
      if (driver) {
        const { fullName, email, aadhar ,role} = driver;
        setDriverName(fullName);
        setDriverEmail(email);
        setDriverAadhar(aadhar);
        setRole(role);
      }
      navigate('/home');
      // console.log("Driver signup successful data :", driver);

    } catch (error) {
      setError(error.response.data.error);
      console.log("Error during driver signup:", error);
    }
  }

  const handleDriverLogin = async (e) => {
    e.preventDefault();
    const formData = {
      email,
      password,
    };
    if(email.trim() === '' || password.trim() === ''){
      setError("All fields are required");
      return;
    }
    try {
      const response = await axios.post(`${import.meta.env.VITE_API_BASE_URL}/driver/login`, formData, {
        headers: {
          'Content-Type': 'application/json'
        }
      });

      // Clear the form fields after successful submission
      setFullName('');
      setAadhar('');
      setEmail('');
      setPassword('');

      const { jwt: token, driver } = response.data;
      if (token) {
        localStorage.setItem('token', token);
      }
      if (driver) {
        const { fullName, email, aadhar, vehicalNumber, licence, role } = driver;
        setDriverName(fullName);
        setDriverEmail(email);
        setDriverAadhar(aadhar);
        setRole(role);
        setDriverVehicalNumber(vehicalNumber);
        setDriverLicence(licence);

        // console.log("Driver signup successful data :", driver);
      }
      navigate('/home');


    } catch (error) {
      setError(error.response.data.error);
      console.log("Error during driver signup:", error);
    }
  }

  return (
    <>
      <div className="inset-0 fixed flex flex-col items-start justify-center h-screen w-screen overflow-hidden">
        <div className='h-1/2 w-full bg-[#4DD0E1]'>
          <div className='cursor-pointer flex items-center justify-center  w-8 h-8  rounded-sm m-2 mt-3 bg-white/25 backdrop-blur-md '><FaAngleLeft className='text-2xl text-white' /></div>
          <div className=' mt-[-30px] flex items-center justify-center flex-col'>
            <FaGoogleWallet className='text-white text-5xl' />
            <span className='text-3xl font-bold text-white'>{hasAccount ? 'Log in Account' : ''}</span>
          </div>
        </div>
        <div className='h-1/2 w-full bg-[#f0f0f08e] '>
        </div>

        {/* This form or new driver registration page which allows to create an account as a patient. */}

        <form className={`${hasAccount && 'translate-y-[100%] opacity-0 '}  px-5 py-3 rounded-md bg-white h-[calc(100%-100px)] w-[94%] absolute left-1/2 bottom-[2%] translate-x-[-50%] z-10} transition-all duration-500 ease-in-out`}>
          <p className={`text-red-500 text-sm font-[400] ${!error && 'hidden'}`} >* {error}</p>
          <p className='p-1 mt-3 font-semibold text-[#646464]'>Name</p>
          <input required className='bg-[#f0f0f07b] font-[300px] text-[#363535e0] w-full rounded-md px-3 py-1.5' type="text" placeholder='Enter FullName' value={fullName} onChange={(e) => setFullName(e.target.value)}  />
          <p className='p-1 mt-3 font-semibold text-[#646464]'>Aadhar Number</p>
          <input required className='bg-[#f0f0f07b] font-[300px] text-[#363535e0] w-full rounded-md px-3 py-1.5' type="number" placeholder='Enter Aadhar Number'
            value={aadhar} onChange={(e) => setAadhar(e.target.value)} />
          <p className='mt-2 p-1  font-semibold text-[#646464]'>Email</p>
          <input className='bg-[#f0f0f07b] font-[300px] text-[#363535e0] w-full rounded-md px-3 py-1.5' type="email" placeholder='xyz@gmail.com'
            value={email} onChange={(e) => setEmail(e.target.value)} required />
          <p className='mt-2 p-1  font-semibold text-[#646464]'>Password</p>
          <input className='bg-[#f0f0f07b] font-[300px] text-[#363535e0] w-full rounded-md px-3 py-1.5' type="password" placeholder='Enter password'
            value={password} onChange={(e) => setPassword(e.target.value)} required />
          <button className='cursor-pointer w-full font-semibold p-2 mt-8 bg-[#00BCD4] text-white rounded-sm' onClick={handleDriverSignup}>Create Account</button>
          <div className='flex items-center justify-between mt-4'>
            <span className='w-[45%] h-[1px] bg-[#9a9696]'></span>
            <span className='font-semibold text-[#9a9696]'>Or</span>
            <span className='w-[45%] h-[1px] bg-[#9a9696]'></span>
          </div>
          <div className='flex items-center justify-center mt-4 p-2 border-1 border-[#F0F0F0] rounded-md cursor-pointer hover:bg-[#E0E0E0]'>
            <FcGoogle />
            <span className='ml-2 font-semibold'>Continue with Google</span>
          </div>
          <span className='flex items-center justify-center w-full mt-5 text-[#525151]'>Already have an account? <span onClick={() => toggleUserAccount(false)} className=' hover:cursor-pointer ml-4 text-blue-400 font-semibold'>Log In</span></span>
        </form>

        {/* This form or user(patient) login page which allows to login an account as a patient. */}

        <form className={`${!hasAccount && 'translate-y-[100%] opacity-0 '} px-5 py-3 rounded-md bg-white h-[79%] w-[94%] absolute left-1/2 bottom-[2%] translate-x-[-50%] z-10} transition-all duration-500 ease-in-out`}>

          <p className={`text-red-500 text-sm font-[400] ${!error && 'hidden'}`} >* {error}</p>
          <p className='mt-3 p-1  font-semibold text-[#646464]'>Email</p>
          <input className='bg-[#f0f0f07b] font-[300px] text-[#363535e0] w-full rounded-md px-3 py-1.5' value={email} onChange={(e) => { setEmail(e.target.value) }} type="email" placeholder='xyz@gmail.com' required />
          <p className='mt-2 p-1  font-semibold text-[#646464]'>Password</p>
          <input className='bg-[#f0f0f07b] font-[300px] text-[#363535e0] w-full rounded-md px-3 py-1.5' type="password" value={password} onChange={(e) => { setPassword(e.target.value) }} placeholder='Enter password' required />
          <button className='cursor-pointer w-full font-semibold p-2 mt-8 bg-[#00BCD4] text-white rounded-sm' onClick={handleDriverLogin}>Log In</button>
          <div className='flex items-center justify-between mt-4'>
            <span className='w-[45%] h-[1px] bg-[#9a9696]'></span>
            <span className='font-semibold text-[#9a9696]'>Or</span>
            <span className='w-[45%] h-[1px] bg-[#9a9696]'></span>
          </div>
          <div className='flex items-center justify-center mt-4 p-2 border-1 border-[#F0F0F0] rounded-md cursor-pointer hover:bg-[#E0E0E0]'>
            <FcGoogle />
            <span className='ml-2 font-semibold'>Continue with Google</span>
          </div>
          <span className='flex items-center justify-center w-full mt-5 text-[#525151]'><span onClick={() => toggleUserAccount(true)} className='ml-4 text-blue-400 font-semibold hover:cursor-pointer'>Create new account</span></span>
        </form>

      </div>
    </>
  )
}

export default DriverLogin