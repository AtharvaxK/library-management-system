import { useState, useEffect } from 'react'
import axios from 'axios'

function Users() {
  // State to store list of users
  const [users, setUsers] = useState([])

  // State for form inputs
  const [userId, setUserId] = useState('')
  const [name,   setName]   = useState('')
  const [type,   setType]   = useState('Student')

  // State to show success or error message
  const [message, setMessage] = useState(null)

  // ── Fetch all users from Spring Boot ─────────────────
  const fetchUsers = () => {
    axios.get('http://localhost:8080/users')
      .then(response => {
        setUsers(response.data)
      })
      .catch(error => {
        setMessage({ text: 'Error: ' + error.message, type: 'error' })
      })
  }

  // Run fetchUsers when the page loads
  useEffect(() => {
    fetchUsers()
  }, [])

  // ── Add a new user ────────────────────────────────────
  const addUser = () => {
    axios.post('http://localhost:8080/users', {
      userId: parseInt(userId),
      name:   name,
      type:   type
    })
    .then(response => {
      setMessage({ text: 'User added successfully!', type: 'success' })
      setUserId('')
      setName('')
      setType('Student')
      fetchUsers()
    })
    .catch(error => {
      setMessage({ text: 'Error: ' + error.message, type: 'error' })
    })
  }

  // ── Delete a user ─────────────────────────────────────
  const deleteUser = (id) => {
    axios.delete(`http://localhost:8080/users/${id}`)
      .then(response => {
        setMessage({ text: 'User deleted!', type: 'success' })
        fetchUsers()
      })
      .catch(error => {
        setMessage({ text: 'Error: ' + error.message, type: 'error' })
      })
  }

  return (
    <div className="page">
      <h2>👥 Users</h2>

      {/* Show message if any */}
      {message && <div className={`msg ${message.type}`}>{message.text}</div>}

      {/* Add User Form */}
      <div className="form-card">
        <h3>Add New User</h3>
        <input
          type="number"
          placeholder="User ID"
          value={userId}
          onChange={e => setUserId(e.target.value)}
        />
        <input
          type="text"
          placeholder="Name"
          value={name}
          onChange={e => setName(e.target.value)}
        />
        <select value={type} onChange={e => setType(e.target.value)}>
          <option value="Student">Student</option>
          <option value="Admin">Admin</option>
        </select>
        <button className="btn btn-primary" onClick={addUser}>
          Add User
        </button>
      </div>

      {/* Users Table */}
      <div className="table-card">
        <table>
          <thead>
            <tr>
              <th>User ID</th>
              <th>Name</th>
              <th>Type</th>
              <th>Action</th>
            </tr>
          </thead>
          <tbody>
            {users.map(user => (
              <tr key={user.userId}>
                <td>{user.userId}</td>
                <td>{user.name}</td>
                <td>{user.type}</td>
                <td>
                  <button
                    className="btn btn-danger"
                    onClick={() => deleteUser(user.userId)}
                  >
                    Delete
                  </button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  )
}

export default Users
