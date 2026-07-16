import { getAuthHeaders } from './auth'

const API_BASE_URL = 'http://localhost:8080'

async function request(path, options = {}) {
  const headers = {
    'Content-Type': 'application/json',
    ...getAuthHeaders(),
    ...(options.headers || {})
  }

  const response = await fetch(`${API_BASE_URL}${path}`, {
    ...options,
    headers,
    body: options.body ? JSON.stringify(options.body) : undefined
  })

  if (!response.ok) {
    const message = await response.text()
    throw new Error(message || 'Request failed')
  }

  const contentType = response.headers.get('content-type') || ''
  if (contentType.includes('application/json')) {
    return response.json()
  }

  return response.text()
}

export async function loginUser(payload) {
  return request('/api/v1/user/login', { method: 'POST', body: payload })
}

export async function signupUser(payload) {
  return request('/api/v1/user/signup', { method: 'POST', body: payload })
}

export async function fetchProducts() {
  return request('/api/v2/products', { method: 'GET' })
}

export async function createProduct(product) {
  return request('/api/v2/products', { method: 'POST', body: product })
}

export async function updateProduct(id, product) {
  return request(`/api/v2/products/${id}`, { method: 'PUT', body: product })
}

export async function deleteProduct(id) {
  return request(`/api/v2/products/${id}`, { method: 'DELETE' })
}
