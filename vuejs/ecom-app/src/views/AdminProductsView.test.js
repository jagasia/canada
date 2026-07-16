import { describe, it, expect, vi, beforeEach } from 'vitest'
import { render, screen, fireEvent, waitFor } from '@testing-library/vue'
import AdminProductsView from './AdminProductsView.vue'
import { createProduct, deleteProduct, fetchProducts, updateProduct } from '../api'

vi.mock('../api', () => ({
  fetchProducts: vi.fn(),
  createProduct: vi.fn(),
  updateProduct: vi.fn(),
  deleteProduct: vi.fn()
}))

describe('AdminProductsView', () => {
  beforeEach(() => {
    vi.clearAllMocks()
  })

  it('renders products from the backend', async () => {
    fetchProducts.mockResolvedValueOnce([
      { id: 1, name: 'Laptop', category: 'Electronics', price: 999.99 }
    ])

    render(AdminProductsView)

    expect(await screen.findByText('Laptop')).toBeInTheDocument()
    expect(screen.getByText('Electronics')).toBeInTheDocument()
    expect(screen.getByText('999.99')).toBeInTheDocument()
  })

  it('creates a product when the form is submitted', async () => {
    fetchProducts.mockResolvedValueOnce([]).mockResolvedValueOnce([])
    createProduct.mockResolvedValueOnce({ id: 2, name: 'Phone', category: 'Mobile', price: 599 })

    render(AdminProductsView)

    fireEvent.update(screen.getByPlaceholderText('Product name'), 'Phone')
    fireEvent.update(screen.getByPlaceholderText('Category'), 'Mobile')
    fireEvent.update(screen.getByPlaceholderText('Price'), '599')
    fireEvent.click(screen.getByRole('button', { name: /create product/i }))

    await waitFor(() => {
      expect(createProduct).toHaveBeenCalledWith({
        name: 'Phone',
        category: 'Mobile',
        price: 599
      })
    })
  })

  it('loads product values into the form when edit is clicked', async () => {
    fetchProducts.mockResolvedValueOnce([
      { id: 1, name: 'Laptop', category: 'Electronics', price: 999.99 }
    ])

    render(AdminProductsView)

    expect(await screen.findByText('Laptop')).toBeInTheDocument()

    fireEvent.click(screen.getByRole('button', { name: /edit/i }))

    await waitFor(() => {
      expect(screen.getByPlaceholderText('Product name')).toHaveValue('Laptop')
      expect(screen.getByPlaceholderText('Category')).toHaveValue('Electronics')
      expect(screen.getByPlaceholderText('Price')).toHaveValue(999.99)
    })
  })
})
