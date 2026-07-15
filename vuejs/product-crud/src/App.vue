<script setup>
import { onMounted, ref } from 'vue';
import { RouterLink, RouterView } from 'vue-router'
import { isLoggedIn, updateLoginStatus } from './services/AuthService';

// var isLoggedIn=false;
function logout() {
  localStorage.removeItem("token");
  localStorage.removeItem("username");
  localStorage.removeItem("roles");
}

onMounted(()=>{
  //check if user logged in or not
  updateLoginStatus();
})
</script>

<template>
  <div>

    <header class="header">
      <div class="title">
        Product Management System
      </div>

      <nav>

        <RouterLink to="/">Home</RouterLink>

        <RouterLink to="/product">
          Products
        </RouterLink>

        <RouterLink :to="isLoggedIn?'/logout':'/login'">
          <p v-if="!isLoggedIn">Login</p>
          <p v-if="isLoggedIn">Logout</p>
        </RouterLink>

        <RouterLink to="/signup">
          Signup
        </RouterLink>

        

      </nav>

    </header>
<main class="content">

    <div></div>

    <div class="center">
        <RouterView />
    </div>

    <div></div>

</main>
  </div>
</template>

<style scoped>

*{
  box-sizing:border-box;
}

body{
  margin:0;
}

.header{

  background:#2c3e50;
  color:white;

  display:flex;
  justify-content:space-between;
  align-items:center;

  padding:15px 30px;
}

.title{

  font-size:24px;
  font-weight:bold;
}

nav{

  display:flex;
  gap:15px;
}

nav a{

  color:white;
  text-decoration:none;

  padding:8px 14px;

  border-radius:5px;

  transition:0.3s;
}

nav a:hover{

  background:#42b883;
}

.router-link-exact-active{

  background:#42b883;
}

.content {

    display: grid;

    grid-template-columns: 2fr 6fr 2fr;

    gap: 20px;

    margin-top: 30px;

    width: 100%;
}

.center {

    background: white;

    padding: 20px;

    border-radius: 8px;

    box-shadow: 0 2px 8px rgba(0,0,0,.1);

    min-height: 600px;
}
</style>