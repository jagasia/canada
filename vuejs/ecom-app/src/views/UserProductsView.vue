<script setup>
import { onMounted, ref } from 'vue'
import { fetchProducts } from '../api'

const products = ref([])
const loading = ref(false)
const errorMessage = ref('')

async function loadProducts() {
  loading.value = true
  errorMessage.value = ''
  try {
    products.value = await fetchProducts()
  } catch (error) {
    errorMessage.value = error.message || 'Unable to load products'
  } finally {
    loading.value = false
  }
}

onMounted(loadProducts)
</script>

<template>
  <div class="card">
    <h2>All Products</h2>
    <p class="subtle">Users can browse the catalog.</p>

    <p v-if="errorMessage" class="error">{{ errorMessage }}</p>
    <div v-if="loading">Loading products...</div>
    <div v-else class="product-grid">
      <div v-for="product in products" :key="product.id" class="product-card">
        <h3>{{ product.name }}</h3>
        <p class="subtle">{{ product.category }}</p>
        <strong>${{ product.price }}</strong>
      </div>
    </div>
  </div>
</template>
