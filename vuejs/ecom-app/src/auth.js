import { reactive, computed } from 'vue'

const STORAGE_KEY = 'ecom-auth'

const authState = reactive({
  token: '',
  username: '',
  roles: [],
  initialized: false
})

function normalizeRoles(roles) {
  if (!roles) return []
  if (Array.isArray(roles)) return roles
  return String(roles)
    .split(',')
    .map((role) => role.trim())
    .filter(Boolean)
}

function loadAuth() {
  if (authState.initialized) return

  const stored = localStorage.getItem(STORAGE_KEY)
  if (stored) {
    try {
      const parsed = JSON.parse(stored)
      authState.token = parsed.token || ''
      authState.username = parsed.username || ''
      authState.roles = normalizeRoles(parsed.roles)
    } catch {
      authState.token = ''
      authState.username = ''
      authState.roles = []
    }
  }

  authState.initialized = true
}

function persistAuth() {
  localStorage.setItem(STORAGE_KEY, JSON.stringify({
    token: authState.token,
    username: authState.username,
    roles: authState.roles.join(',')
  }))
}

function setAuth(data) {
  authState.token = data.token || ''
  authState.username = data.username || ''
  authState.roles = normalizeRoles(data.roles)
  persistAuth()
}

function clearAuth() {
  authState.token = ''
  authState.username = ''
  authState.roles = []
  localStorage.removeItem(STORAGE_KEY)
}

const isAuthenticated = computed(() => !!authState.token)
const isAdmin = computed(() => authState.roles.includes('ADMIN'))
const isUser = computed(() => authState.roles.includes('USER'))

function hasRole(role) {
  return authState.roles.includes(role)
}

function getAuthHeaders() {
  return authState.token ? { Authorization: `Bearer ${authState.token}` } : {}
}

export {
  authState,
  loadAuth,
  setAuth,
  clearAuth,
  isAuthenticated,
  isAdmin,
  isUser,
  hasRole,
  getAuthHeaders
}
