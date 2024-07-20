import React, { useEffect, useState } from 'react'
import axios from 'axios'

export default function Home() {
    const [users,setUsers] = useState([])
    
    useEffect(()=>{
        loadUsers();
    },[]);

    const loadUsers = async () =>{
        const result = await axios.get("http://localhost:8080/users/all");
        setUsers(result.data);
    };


  return (
    <div className='container'>
        <div className='py-4'>
        <table className="table table-striped table-hover border shadow">
  <thead>
    <tr>
      <th scope="col">User Id</th>
      <th scope="col">User Name</th>
      <th scope="col">Name</th>
      <th scope="col">Email</th>
      <th scope="col">Actions</th>
    </tr>
  </thead>
  <tbody>
    {
        users.map((user, index) => (
          <tr>
            <th scope="row" key={index}>{index+1}</th>
            <td>{user.userName}</td>
            <td>{user.name}</td>
            <td>{user.email}</td>
            <td>
                <button className="btn btn-primary mx-2">View</button>
                <button className="btn btn-outline-primary mx-2">Edit</button>
                <button className="btn btn-danger mx-2">Delete</button> 
            </td>
          </tr>
        ))
  
    }
  </tbody>
</table>

        </div>
    </div>
  )
}