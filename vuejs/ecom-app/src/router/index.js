import { createRouter, createWebHistory } from 'vue-router'
import { authState, loadAuth } from '../auth'

import LoginView from '../views/LoginView.vue'
import SignupView from '../views/SignupView.vue'
import HomeView from '../views/HomeView.vue'
import AdminProductsView from '../views/AdminProductsView.vue'
import UserProductsView from '../views/UserProductsView.vue'

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView,
    meta: { requiresAuth: true }
  },
  {
    path: '/login',
    name: 'login',
    component: LoginView
  },
  {
    path: '/signup',
    name: 'signup',
    component: SignupView
  },
  {
    path: '/admin',
    name: 'admin',
    component: HomeView,
    meta: { requiresAuth: true, roles: ['ADMIN'] }
  },
  {
    path: '/admin/products',
    name: 'admin-products',
    component: AdminProductsView,
    meta: { requiresAuth: true, roles: ['ADMIN'] }
  },
  {
    path: '/user',
    name: 'user',
    component: UserProductsView,
    meta: { requiresAuth: true, roles: ['USER'] }
  }
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

router.beforeEach((to, _from, next) => {
  loadAuth()

  if (to.path === '/login' && authState.token) {
    return next('/')
  }

  if (to.meta.requiresAuth && !authState.token) {
    return next('/login')
  }

  if (to.meta.roles && !to.meta.roles.some((role) => authState.roles.includes(role))) {
    return next('/')
  }

  next()
})

export default router
