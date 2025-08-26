import React, { useEffect } from 'react'
import { useNavigate } from 'react-router-dom';



export default function Wrapper({children}) {
    const navigate = useNavigate();
    const token = localStorage.getItem('token');

    useEffect(() => {
        if(!token){
            navigate('/user');
        }
    }, [ token]);

    return (
        <div>{children}</div>
    ) 
}
