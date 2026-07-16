<script setup>
import { computed } from 'vue'
import { useRouter } from 'vue-router'
import { authState, clearAuth } from '../auth'

const router = useRouter()

const isAdmin = computed(() => authState.roles.includes('ADMIN'))
const isUser = computed(() => authState.roles.includes('USER'))

function logout() {
  clearAuth()
  router.push('/login')
}
</script>

<template>
  <div class="card home-card">
    <h2>Welcome, {{ authState.username || 'guest' }}</h2>
    <p>Your roles: {{ authState.roles.join(', ') || 'None' }}</p>

    <div class="actions">
      <router-link v-if="isAdmin" to="/admin/products" class="btn">Manage Products</router-link>
      <router-link v-if="isUser" to="/user" class="btn">View Products</router-link>
      <button class="btn secondary" @click="logout">Logout</button>
    </div>
  </div>
</template>
