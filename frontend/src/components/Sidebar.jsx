import { useState } from 'react';

const NAV_ITEMS = [
  { id: 'dashboard', icon: '⬡', label: 'Dashboard' },
  { id: 'books',     icon: '📚', label: 'Books',    section: 'Library' },
  { id: 'users',     icon: '👥', label: 'Users',    section: 'Library' },
  { id: 'issues',    icon: '📋', label: 'Issued Books', section: 'Library' },
];

export default function Sidebar({ activePage, onNavigate }) {
  return (
    <aside className="sidebar">
      {/* Brand */}
      <div className="sidebar-brand">
        <div className="sidebar-brand-logo">
          <div className="sidebar-brand-icon">📖</div>
          <div>
            <div className="sidebar-brand-name">LibraryHub</div>
            <div className="sidebar-brand-sub">Management System</div>
          </div>
        </div>
      </div>

      {/* Navigation */}
      <nav className="sidebar-nav">
        {NAV_ITEMS.map((item, idx) => {
          const prevSection = idx > 0 ? NAV_ITEMS[idx - 1].section : null;
          const showSection = item.section && item.section !== prevSection;

          return (
            <div key={item.id}>
              {showSection && (
                <div className="nav-section-label">{item.section}</div>
              )}
              <button
                id={`nav-${item.id}`}
                className={`nav-item${activePage === item.id ? ' active' : ''}`}
                onClick={() => onNavigate(item.id)}
              >
                <span className="nav-icon">{item.icon}</span>
                <span>{item.label}</span>
              </button>
            </div>
          );
        })}
      </nav>

      {/* Footer */}
      <div className="sidebar-footer">
        <div className="sidebar-footer-info">
          <div className="sidebar-footer-dot" />
          <div>
            <div style={{ fontSize: '0.75rem', color: 'var(--text-300)', fontWeight: 600 }}>
              Spring Boot API
            </div>
            <div className="sidebar-footer-text">localhost:8080</div>
          </div>
        </div>
      </div>
    </aside>
  );
}
