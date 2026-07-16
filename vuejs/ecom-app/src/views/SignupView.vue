<script setup>
import { reactive, ref } from 'vue'
import { useRouter } from 'vue-router'
import { signupUser } from '../api'

const router = useRouter()
const form = reactive({ username: '', password: '', roles: [] })
const message = ref('')
const errorMessage = ref('')
const loading = ref(false)

const roleOptions = ['ADMIN', 'USER']

function toggleRole(role) {
  if (form.roles.includes(role)) {
    form.roles = form.roles.filter((item) => item !== role)
  } else {
    form.roles = [...form.roles, role]
  }
}

async function submitSignup() {
  loading.value = true
  errorMessage.value = ''
  message.value = ''

  try {
    await signupUser({
      username: form.username,
      password: form.password,
      roles: form.roles.join(',')
    })
    message.value = 'Account created successfully. Please log in.'
    setTimeout(() => router.push('/login'), 1000)
  } catch (error) {
    errorMessage.value = error.message || 'Signup failed'
  } finally {
    loading.value = false
  }
}
</script>

<template>
  <div class="card form-card">
    <h2>Create account</h2>
    <form @submit.prevent="submitSignup">
      <label>Username</label>
      <input v-model="form.username" required />

      <label>Password</label>
      <input v-model="form.password" type="password" required />

      <label>Roles</label>
      <div class="roles">
        <label v-for="role in roleOptions" :key="role" class="role-chip">
          <input type="checkbox" :checked="form.roles.includes(role)" @change="toggleRole(role)" />
          {{ role }}
        </label>
      </div>

      <p v-if="message" class="success">{{ message }}</p>
      <p v-if="errorMessage" class="error">{{ errorMessage }}</p>
      <button type="submit" :disabled="loading">{{ loading ? 'Creating account...' : 'Sign up' }}</button>
    </form>
  </div>
</template>
