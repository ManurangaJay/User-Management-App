import React from 'react'
import './Navbar.css'
import { Link } from 'react-router-dom'

export default function Navbar() {
  return (
    <div>
        <nav class="navbar bg-primary" data-bs-theme="dark">
            <div className="container-fluid">
                <a className="navbar-brand">User Management Application</a>
                <form className="d-flex" role="search">
                    <input className="form-control me-2" type="search" placeholder="Search" aria-label="Search"/>
                    <button className="btn btn-outline-light" type="submit">Search</button>
                </form>
                <Link className="btn btn-outline-light" to="/adduser">Add User</Link>
            </div>
        </nav>
    </div>
  )
}

