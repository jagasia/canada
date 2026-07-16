<script setup>
import { computed } from 'vue'
import { authState, clearAuth, loadAuth } from './auth'
import { useRoute, useRouter } from 'vue-router'

loadAuth()

const route = useRoute()
const router = useRouter()

const showNav = computed(() => route.name !== 'login' && route.name !== 'signup')

function logout() {
  clearAuth()
  router.push('/login')
}
</script>

<template>
  <div class="app-shell">
    <nav v-if="showNav" class="top-nav">
      <router-link to="/">Ecom App</router-link>
      <div class="nav-links">
        <router-link v-if="authState.roles.includes('ADMIN')" to="/admin/products">Admin Products</router-link>
        <router-link v-if="authState.roles.includes('USER')" to="/user">Products</router-link>
        <button class="link-button" @click="logout">Logout</button>
      </div>
    </nav>

    <main class="container">
      <router-view />
    </main>
  </div>
</template>
