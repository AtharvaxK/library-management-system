import axios from 'axios'

// ── BOOKS ──────────────────────────────────────────────────
export const BookAPI = {

  getAll: () =>
    axios.get('http://localhost:8080/books'),

  add: (book) =>
    axios.post('http://localhost:8080/books', book),

  updateQty: (id, qty) =>
    axios.put(`http://localhost:8080/books/${id}/quantity?quantity=${qty}`),

  delete: (id) =>
    axios.delete(`http://localhost:8080/books/${id}`),

}

// ── USERS ───────────────────────────────────────────────────
export const UserAPI = {

  getAll: () =>
    axios.get('http://localhost:8080/users'),

  add: (user) =>
    axios.post('http://localhost:8080/users', user),

  delete: (id) =>
    axios.delete(`http://localhost:8080/users/${id}`),

}

// ── ISSUED BOOKS ────────────────────────────────────────────
export const IssueAPI = {

  getAll: () =>
    axios.get('http://localhost:8080/issues'),

  issue: (data) =>
    axios.post('http://localhost:8080/issues', data),

  returnBook: (id) =>
    axios.put(`http://localhost:8080/issues/${id}/return`),

}
