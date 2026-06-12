import { useState } from 'react'
import Books from './pages/Books'
import Users from './pages/Users'
import IssuedBooks from './pages/IssuedBooks'
import './index.css'

function App() {
  const [page, setPage] = useState('books')

  return (
    <div>

      {/* Navbar */}
      <div className="navbar">
        <h2>📖 Library Management System</h2>
        <button className={page === 'books'  ? 'active' : ''} onClick={() => setPage('books')}>
          📚 Books
        </button>
        <button className={page === 'users'  ? 'active' : ''} onClick={() => setPage('users')}>
          👥 Users
        </button>
        <button className={page === 'issues' ? 'active' : ''} onClick={() => setPage('issues')}>
          📋 Issued Books
        </button>
      </div>

      {/* Pages */}
      {page === 'books'  && <Books />}
      {page === 'users'  && <Users />}
      {page === 'issues' && <IssuedBooks />}

    </div>
  )
}

export default App
