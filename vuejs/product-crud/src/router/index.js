import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import ProductView from '@/views/ProductView.vue'
import LoginView from '@/views/LoginView.vue'
import AdminHomeView from '@/views/AdminHomeView.vue'
import UserHomeView from '@/views/UserHomeView.vue'
import Logout from '@/views/Logout.vue'
import SignupView from '@/views/SignupView.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView,
    },
    {
      path: '/about',
      name: 'about',
      // route level code-splitting
      // this generates a separate chunk (About.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: () => import('../views/AboutView.vue'),
    },
    {
      path: '/product',
      component: ProductView
    },
    {
      path: '/login', component: LoginView
    },
    {
      path:"/admin/home",
      component: AdminHomeView
    },
    {
      path:"/user/home",
      component: UserHomeView
    },
    {
      path:"/logout",
      component: Logout
    },
    {
      path: "/signup",
      component: SignupView
    }
  ],
})

export default router
