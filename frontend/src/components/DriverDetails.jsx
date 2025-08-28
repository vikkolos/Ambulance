import React from 'react'
import { IoIosClose } from "react-icons/io";

function DriverDetails() {
    return (
        // if bottom -100% then hide the div
        <div className='absolute bottom-[-00%] w-full bg-transparent rounded-t-3xl transition-all  duration-800 ease-in-out'>
            <div className='w-[90%] m-auto py-3 flex items-end justify-end '><IoIosClose className='text-white text-2xl h-[40px] w-[40px] rounded-full cursor-pointer bg-[#1b1a1afd]' /></div>
            <section className='bg-white w-[90%] m-auto rounded-[20px] flex items-center justify-center flex-col text-black '>
                <div className=' w-full
        '>
                    <div className='flex  justify-start gap-8 px-8  py-5 mt-4'>
                        <div className="h-[80px] aspect-square flex items-center justify-center rounded-2xl overflow-hidden shadow-lg ring-2 ring-white">
                            <img
                                className="w-full h-full object-cover object-center"
                                src="https://img.freepik.com/premium-photo/portrait-happy-young-casual-man-standing_171337-29744.jpg"
                                alt="driver-image"
                            />
                        </div>

                        <div>
                            <h3 className='font-semibold  text-2xl mb-2'>Driver Details</h3>
                            <p className='text-sm font-semibold'>Name : Suraj kumar</p>
                            <p className='text-sm font-semibold'>Age : 24</p>
                            <p className='text-sm font-semibold'>Ph No. : 9754865245</p>
                        </div>
                    </div>
                    <hr className='w-[90%] m-auto' />
                    <div className='flex items-start px-8 py-5 flex-col'>
                        <h3 className='text-xl font-semibold '>Ride Details</h3>
                        <p className='text-sm mt-1 font-semibold'>Total Distance : <span className='font-bold'>95.36 KM</span></p>
                        <h2 className='text-2xl font-bold w-full text-center mt-3'>BR45H3747</h2>
                    </div>
                </div>
            </section>

            <div className="flex justify-center mt-2 mb-5">
                <button className=" cursor-pointer border-nonetext-center w-[90%] text-xl px-2  py-3 rounded-[20px] bg-[#1b1a1afd] text-white">
                    cancel
                </button>
            </div>

        </ div>
    )
}

export default DriverDetails