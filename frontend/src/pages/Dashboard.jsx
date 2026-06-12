import { useEffect, useState } from 'react';
import { BookAPI, UserAPI, IssueAPI } from '../api';
import { Spinner } from '../components/UI';

export default function Dashboard({ onNavigate }) {
  const [stats, setStats]     = useState(null);
  const [recent, setRecent]   = useState([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    async function load() {
      try {
        const booksRes  = await BookAPI.getAll();
        const usersRes  = await UserAPI.getAll();
        const issuesRes = await IssueAPI.getAll();

        const books  = booksRes.data;
        const users  = usersRes.data;
        const issues = issuesRes.data;

        const totalQty     = books.reduce((s, b) => s + (b.quantity || 0), 0);
        const activeIssues = issues.filter(i => !i.returnDate).length;

        setStats({
          totalBooks:  books.length,
          totalUsers:  users.length,
          totalIssued: issues.length,
          activeIssues,
          totalQty,
        });
        setRecent(issues.slice(-5).reverse());
      } catch (e) {
        // backend not running yet — show zeros
        setStats({ totalBooks: 0, totalUsers: 0, totalIssued: 0, activeIssues: 0, totalQty: 0 });
      } finally {
        setLoading(false);
      }
    }
    load();
  }, []);

  if (loading) return <Spinner />;

  const statCards = [
    { icon: '📚', label: 'Total Books',      value: stats.totalBooks,   sub: `${stats.totalQty} total copies`, cls: 'purple' },
    { icon: '👥', label: 'Registered Users', value: stats.totalUsers,   sub: 'Students & Admins',              cls: 'cyan'   },
    { icon: '📋', label: 'Total Issued',     value: stats.totalIssued,  sub: 'All time records',               cls: 'amber'  },
    { icon: '🔖', label: 'Active Issues',    value: stats.activeIssues, sub: 'Not yet returned',               cls: 'green'  },
  ];

  const days        = ['Mon','Tue','Wed','Thu','Fri','Sat','Sun'];
  const fakeActivity = [3, 7, 5, 9, 4, 6, 8];
  const maxAct       = Math.max(...fakeActivity);

  return (
    <div style={{ display: 'flex', flexDirection: 'column', gap: 28 }}>
      <div className="page-header">
        <div className="page-header-left">
          <h1>Welcome back 👋</h1>
          <p>Here's what's happening in your library today.</p>
        </div>
        <div style={{ display: 'flex', gap: 8 }}>
          <button id="dash-books"  className="btn btn-ghost btn-sm"  onClick={() => onNavigate('books')}>📚 Books</button>
          <button id="dash-issues" className="btn btn-primary btn-sm" onClick={() => onNavigate('issues')}>📋 Issue Book</button>
        </div>
      </div>

      <div className="stats-grid">
        {statCards.map(c => (
          <div key={c.label} className="stat-card">
            <div className={`stat-icon ${c.cls}`}>{c.icon}</div>
            <div className="stat-body">
              <div className="stat-label">{c.label}</div>
              <div className="stat-value">{c.value}</div>
              <div className="stat-sub">{c.sub}</div>
            </div>
          </div>
        ))}
      </div>

      <div style={{ display: 'grid', gridTemplateColumns: '1fr 1fr', gap: 20 }}>
        <div className="card">
          <div className="card-header">
            <span className="card-title">📋 Recent Issued Books</span>
            <button className="btn btn-ghost btn-sm" onClick={() => onNavigate('issues')}>View All →</button>
          </div>
          {recent.length === 0 ? (
            <div style={{ padding: '32px', textAlign: 'center', color: 'var(--text-500)', fontSize: '0.875rem' }}>
              No records yet
            </div>
          ) : (
            <div className="table-wrapper">
              <table>
                <thead><tr><th>Issue #</th><th>Book</th><th>User</th><th>Status</th></tr></thead>
                <tbody>
                  {recent.map(i => (
                    <tr key={i.issueId}>
                      <td className="td-main">#{i.issueId}</td>
                      <td>Book #{i.bookId}</td>
                      <td>User #{i.userId}</td>
                      <td>
                        <span className={`badge ${i.returnDate ? 'badge-green' : 'badge-amber'}`}>
                          {i.returnDate ? '✓ Returned' : '⏳ Active'}
                        </span>
                      </td>
                    </tr>
                  ))}
                </tbody>
              </table>
            </div>
          )}
        </div>

        <div className="card">
          <div className="card-header">
            <span className="card-title">📊 Weekly Activity</span>
            <span className="badge badge-purple">This Week</span>
          </div>
          <div className="card-body">
            <div className="activity-bar">
              {days.map((d, i) => (
                <div key={d} className="activity-row">
                  <span className="activity-label">{d}</span>
                  <div className="activity-track">
                    <div className="activity-fill" style={{ width: `${(fakeActivity[i] / maxAct) * 100}%` }} />
                  </div>
                  <span className="activity-count">{fakeActivity[i]}</span>
                </div>
              ))}
            </div>
          </div>
        </div>
      </div>

      <div className="card">
        <div className="card-header">
          <span className="card-title">⚡ Quick Actions</span>
        </div>
        <div className="card-body" style={{ display: 'flex', gap: 12, flexWrap: 'wrap' }}>
          <button id="qa-add-book"    className="btn btn-primary" onClick={() => onNavigate('books')}>➕ Add Book</button>
          <button id="qa-add-user"    className="btn btn-accent"  onClick={() => onNavigate('users')}>👤 Register User</button>
          <button id="qa-issue-book"  className="btn btn-ghost"   onClick={() => onNavigate('issues')}>📖 Issue a Book</button>
          <button id="qa-return-book" className="btn btn-ghost"   onClick={() => onNavigate('issues')}>↩️ Return a Book</button>
        </div>
      </div>
    </div>
  );
}
