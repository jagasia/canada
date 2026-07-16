<script setup>
import { onMounted, reactive, ref } from 'vue'
import { createProduct, deleteProduct, fetchProducts, updateProduct } from '../api'

const products = ref([])
const loading = ref(false)
const errorMessage = ref('')
const form = reactive({ id: null, name: '', category: '', price: '' })

function resetForm() {
  form.id = null
  form.name = ''
  form.category = ''
  form.price = ''
}

async function loadProducts() {
  loading.value = true
  errorMessage.value = ''
  try {
    const data = await fetchProducts()
    products.value = data
  } catch (error) {
    errorMessage.value = error.message || 'Unable to load products'
  } finally {
    loading.value = false
  }
}

async function saveProduct() {
  try {
    const payload = { name: form.name, category: form.category, price: Number(form.price) }
    if (form.id) {
      await updateProduct(form.id, payload)
    } else {
      await createProduct(payload)
    }
    resetForm()
    await loadProducts()
  } catch (error) {
    errorMessage.value = error.message || 'Failed to save product'
  }
}

async function editProduct(product) {
  form.id = product.id
  form.name = product.name
  form.category = product.category
  form.price = product.price
}

async function removeProduct(id) {
  try {
    await deleteProduct(id)
    await loadProducts()
  } catch (error) {
    errorMessage.value = error.message || 'Failed to delete product'
  }
}

onMounted(loadProducts)
</script>

<template>
  <div class="card">
    <h2>Admin Products</h2>
    <p class="subtle">Create, edit, and remove products.</p>

    <form @submit.prevent="saveProduct" class="product-form">
      <input v-model="form.name" placeholder="Product name" required />
      <input v-model="form.category" placeholder="Category" required />
      <input v-model="form.price" type="number" step="0.01" placeholder="Price" required />
      <button type="submit">{{ form.id ? 'Update product' : 'Create product' }}</button>
      <button type="button" class="secondary" @click="resetForm">Clear</button>
    </form>

    <p v-if="errorMessage" class="error">{{ errorMessage }}</p>

    <div v-if="loading">Loading products...</div>
    <table v-else>
      <thead>
        <tr>
          <th>Name</th>
          <th>Category</th>
          <th>Price</th>
          <th>Actions</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="product in products" :key="product.id">
          <td>{{ product.name }}</td>
          <td>{{ product.category }}</td>
          <td>{{ product.price }}</td>
          <td>
            <button class="secondary" @click="editProduct(product)">Edit</button>
            <button class="danger" @click="removeProduct(product.id)">Delete</button>
          </td>
        </tr>
      </tbody>
    </table>
  </div>
</template>
