import React, { useEffect, useState } from 'react'
import axios from 'axios'
import { Link, useParams } from 'react-router-dom';

export default function Home() {
    const [users,setUsers] = useState([])

    const {id} = useParams()
    
    useEffect(()=>{
        loadUsers();
    },[]);

    const loadUsers = async () =>{
        const result = await axios.get("http://localhost:8080/users/all");
        setUsers(result.data);
    };

    const deleteUser = async (id) =>{
        await axios.delete(`http://localhost:8080/users/delete/${id}`);
        loadUsers()
    }



  return (
    <div className='container'>
        <div className='py-4'>
        <table className="table table-striped table-hover border shadow">
  <thead>
    <tr>
      <th scope="col">User Id</th>
      <th scope="col">Name</th>
      <th scope="col">User Name</th>
      <th scope="col">Email</th>
      <th scope="col">Actions</th>
    </tr>
  </thead>
  <tbody>
    {
        users.map((user, index) => (
          <tr>
            <th scope="row" key={index}>{index+1}</th>
            <td>{user.name}</td>
            <td>{user.userName}</td>
            <td>{user.email}</td>
            <td>
                <button className="btn btn-primary mx-2">View</button>
                <Link className="btn btn-outline-primary mx-2" to={`/edituser/${user.id}`}>Edit</Link>
                <button className="btn btn-danger mx-2" onClick={()=>deleteUser(user.id)}>Delete</button> 
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
