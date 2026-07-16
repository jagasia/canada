import { describe, it, expect } from 'vitest'
import { render, screen } from '@testing-library/vue'
import { createRouter, createMemoryHistory } from 'vue-router'
import LoginView from './LoginView.vue'

const routes = [
  { path: '/login', component: LoginView },
  { path: '/signup', component: { template: '<div>Signup</div>' } }
]

describe('LoginView', () => {
  it('renders the login form', async () => {
    const router = createRouter({
      history: createMemoryHistory(),
      routes
    })

    render(LoginView, {
      global: {
        plugins: [router]
      }
    })

    expect(screen.getByRole('heading', { name: /login/i })).toBeInTheDocument()
    expect(screen.getByLabelText(/username/i)).toBeInTheDocument()
    expect(screen.getByLabelText(/password/i)).toBeInTheDocument()
  })
})
