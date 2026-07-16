<script setup>
import { reactive, ref } from 'vue'
import { useRouter } from 'vue-router'
import { loginUser } from '../api'
import { setAuth } from '../auth'

const router = useRouter()
const form = reactive({ username: '', password: '' })
const errorMessage = ref('')
const loading = ref(false)

async function submitLogin() {
  loading.value = true
  errorMessage.value = ''

  try {
    const response = await loginUser({ username: form.username, password: form.password })
    setAuth(response)
    router.push('/')
  } catch (error) {
    errorMessage.value = error.message || 'Login failed'
  } finally {
    loading.value = false
  }
}
</script>

<template>
  <div class="card form-card">
    <h2>Login</h2>
    <form @submit.prevent="submitLogin">
      <label for="username">Username</label>
      <input id="username" v-model="form.username" required />

      <label for="password">Password</label>
      <input id="password" v-model="form.password" type="password" required />

      <p v-if="errorMessage" class="error">{{ errorMessage }}</p>
      <button type="submit" :disabled="loading">{{ loading ? 'Logging in...' : 'Login' }}</button>
    </form>

    <p class="subtle">Need an account? <router-link to="/signup">Sign up</router-link></p>
  </div>
</template>
