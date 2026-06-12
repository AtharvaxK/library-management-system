import { useState, useEffect } from 'react'
import axios from 'axios'

function IssuedBooks() {
  // State to store all issued book records
  const [issues, setIssues] = useState([])

  // State for Issue form inputs
  const [bookId, setBookId] = useState('')
  const [userId, setUserId] = useState('')

  // State for Return form input
  const [returnId, setReturnId] = useState('')

  // State to show success or error message
  const [message, setMessage] = useState(null)

  // ── Fetch all issued books from Spring Boot ───────────
  const fetchIssues = () => {
    axios.get('http://localhost:8080/issues')
      .then(response => {
        setIssues(response.data)
      })
      .catch(error => {
        setMessage({ text: 'Error: ' + error.message, type: 'error' })
      })
  }

  // Run fetchIssues when the page loads
  useEffect(() => {
    fetchIssues()
  }, [])

  // ── Issue a book ──────────────────────────────────────
  const issueBook = () => {
    axios.post('http://localhost:8080/issues', {
      bookId: parseInt(bookId),
      userId: parseInt(userId)
    })
    .then(response => {
      setMessage({ text: 'Book issued successfully!', type: 'success' })
      setBookId('')
      setUserId('')
      fetchIssues()
    })
    .catch(error => {
      setMessage({ text: 'Error: ' + error.message, type: 'error' })
    })
  }

  // ── Return a book ─────────────────────────────────────
  const returnBook = () => {
    axios.put(`http://localhost:8080/issues/${returnId}/return`)
      .then(response => {
        setMessage({ text: 'Book returned successfully!', type: 'success' })
        setReturnId('')
        fetchIssues()
      })
      .catch(error => {
        setMessage({ text: 'Error: ' + error.message, type: 'error' })
      })
  }

  return (
    <div className="page">
      <h2>📋 Issued Books</h2>

      {/* Show message if any */}
      {message && <div className={`msg ${message.type}`}>{message.text}</div>}

      {/* Issue Book Form */}
      <div className="form-card">
        <h3>Issue a Book</h3>
        <input
          type="number"
          placeholder="Book ID"
          value={bookId}
          onChange={e => setBookId(e.target.value)}
        />
        <input
          type="number"
          placeholder="User ID"
          value={userId}
          onChange={e => setUserId(e.target.value)}
        />
        <button className="btn btn-success" onClick={issueBook}>
          Issue Book
        </button>
      </div>

      {/* Return Book Form */}
      <div className="form-card">
        <h3>Return a Book</h3>
        <input
          type="number"
          placeholder="Issue ID"
          value={returnId}
          onChange={e => setReturnId(e.target.value)}
        />
        <button className="btn btn-warning" onClick={returnBook}>
          Return Book
        </button>
      </div>

      {/* Issued Books Table */}
      <div className="table-card">
        <table>
          <thead>
            <tr>
              <th>Issue ID</th>
              <th>Book ID</th>
              <th>User ID</th>
              <th>Issue Date</th>
              <th>Return Date</th>
              <th>Status</th>
            </tr>
          </thead>
          <tbody>
            {issues.map(issue => (
              <tr key={issue.issueId}>
                <td>{issue.issueId}</td>
                <td>{issue.bookId}</td>
                <td>{issue.userId}</td>
                <td>
                  {issue.issueDate
                    ? new Date(issue.issueDate).toLocaleDateString()
                    : '-'}
                </td>
                <td>
                  {issue.returnDate
                    ? new Date(issue.returnDate).toLocaleDateString()
                    : '-'}
                </td>
                <td>
                  {issue.returnDate
                    ? <span className="badge badge-returned">✅ Returned</span>
                    : <span className="badge badge-active">⏳ Active</span>}
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  )
}

export default IssuedBooks
