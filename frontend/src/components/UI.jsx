import { useState, useCallback } from 'react';

// ── Toast Hook ──────────────────────────────────────────────
export function useToast() {
  const [toasts, setToasts] = useState([]);

  const show = useCallback((message, type = 'info') => {
    const id = Date.now();
    setToasts(t => [...t, { id, message, type }]);
    setTimeout(() => setToasts(t => t.filter(x => x.id !== id)), 3500);
  }, []);

  const success = useCallback((msg) => show(msg, 'success'), [show]);
  const error   = useCallback((msg) => show(msg, 'error'),   [show]);
  const info    = useCallback((msg) => show(msg, 'info'),    [show]);

  return { toasts, success, error, info };
}

// ── Toast Component ─────────────────────────────────────────
export function ToastContainer({ toasts }) {
  const icons = { success: '✓', error: '✕', info: 'ℹ' };
  return (
    <div className="toast-container">
      {toasts.map(t => (
        <div key={t.id} className={`toast toast-${t.type}`}>
          <span>{icons[t.type]}</span>
          <span>{t.message}</span>
        </div>
      ))}
    </div>
  );
}

// ── Modal Component ─────────────────────────────────────────
export function Modal({ title, onClose, children }) {
  return (
    <div className="modal-overlay" onClick={e => e.target === e.currentTarget && onClose()}>
      <div className="modal">
        <div className="modal-header">
          <span className="modal-title">{title}</span>
          <button className="modal-close" onClick={onClose}>✕</button>
        </div>
        <div className="modal-body">{children}</div>
      </div>
    </div>
  );
}

// ── Confirm Dialog ──────────────────────────────────────────
export function ConfirmModal({ title, message, onConfirm, onCancel }) {
  return (
    <Modal title={title} onClose={onCancel}>
      <p style={{ color: 'var(--text-300)', lineHeight: 1.6 }}>{message}</p>
      <div className="confirm-actions">
        <button className="btn btn-ghost" onClick={onCancel}>Cancel</button>
        <button className="btn btn-danger" onClick={onConfirm}>Delete</button>
      </div>
    </Modal>
  );
}

// ── Loading Spinner ─────────────────────────────────────────
export function Spinner() {
  return (
    <div className="loading-spinner">
      <div className="spinner" />
      <span style={{ fontSize: '0.875rem' }}>Loading…</span>
    </div>
  );
}

// ── Empty State ─────────────────────────────────────────────
export function EmptyState({ icon = '📭', title = 'No data found', sub = '' }) {
  return (
    <div className="empty-state">
      <div className="empty-icon">{icon}</div>
      <p className="empty-title">{title}</p>
      {sub && <p style={{ fontSize: '0.8rem' }}>{sub}</p>}
    </div>
  );
}

// ── Format Date ─────────────────────────────────────────────
export function fmtDate(dt) {
  if (!dt) return '—';
  return new Date(dt).toLocaleDateString('en-IN', {
    day: '2-digit', month: 'short', year: 'numeric',
    hour: '2-digit', minute: '2-digit',
  });
}
