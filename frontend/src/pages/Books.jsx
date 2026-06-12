import { useState, useEffect } from 'react'
import axios from 'axios'

function Books() {
  // State to store list of books
  const [books, setBooks] = useState([])

  // State for the form inputs
  const [bookId,   setBookId]   = useState('')
  const [title,    setTitle]    = useState('')
  const [author,   setAuthor]   = useState('')
  const [quantity, setQuantity] = useState('')

  // State to show success or error message
  const [message, setMessage] = useState(null)

  // ── Fetch all books from Spring Boot ──────────────────
  const fetchBooks = () => {
    axios.get('http://localhost:8080/books')
      .then(response => {
        setBooks(response.data)
      })
      .catch(error => {
        setMessage({ text: 'Error: ' + error.message, type: 'error' })
      })
  }

  // Run fetchBooks when the page loads
  useEffect(() => {
    fetchBooks()
  }, [])

  // ── Add a new book ────────────────────────────────────
  const addBook = () => {
    axios.post('http://localhost:8080/books', {
      bookId:   parseInt(bookId),
      title:    title,
      author:   author,
      quantity: parseInt(quantity)
    })
    .then(response => {
      setMessage({ text: 'Book added successfully!', type: 'success' })
      setBookId('')
      setTitle('')
      setAuthor('')
      setQuantity('')
      fetchBooks()
    })
    .catch(error => {
      setMessage({ text: 'Error: ' + error.message, type: 'error' })
    })
  }

  // ── Delete a book ─────────────────────────────────────
  const deleteBook = (id) => {
    axios.delete(`http://localhost:8080/books/${id}`)
      .then(response => {
        setMessage({ text: 'Book deleted!', type: 'success' })
        fetchBooks()
      })
      .catch(error => {
        setMessage({ text: 'Error: ' + error.message, type: 'error' })
      })
  }

  return (
    <div className="page">
      <h2>📚 Books</h2>

      {/* Show message if any */}
      {message && <div className={`msg ${message.type}`}>{message.text}</div>}

      {/* Add Book Form */}
      <div className="form-card">
        <h3>Add New Book</h3>
        <input
          type="number"
          placeholder="Book ID"
          value={bookId}
          onChange={e => setBookId(e.target.value)}
        />
        <input
          type="text"
          placeholder="Title"
          value={title}
          onChange={e => setTitle(e.target.value)}
        />
        <input
          type="text"
          placeholder="Author"
          value={author}
          onChange={e => setAuthor(e.target.value)}
        />
        <input
          type="number"
          placeholder="Quantity"
          value={quantity}
          onChange={e => setQuantity(e.target.value)}
        />
        <button className="btn btn-primary" onClick={addBook}>
          Add Book
        </button>
      </div>

      {/* Books Table */}
      <div className="table-card">
        <table>
          <thead>
            <tr>
              <th>Book ID</th>
              <th>Title</th>
              <th>Author</th>
              <th>Quantity</th>
              <th>Action</th>
            </tr>
          </thead>
          <tbody>
            {books.map(book => (
              <tr key={book.bookId}>
                <td>{book.bookId}</td>
                <td>{book.title}</td>
                <td>{book.author}</td>
                <td>{book.quantity}</td>
                <td>
                  <button
                    className="btn btn-danger"
                    onClick={() => deleteBook(book.bookId)}
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

export default Books
