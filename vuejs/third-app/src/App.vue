<script setup>
  import Counter from "./components/Counter.vue";
import Login from "./components/Login.vue"
import Product1 from "./components/Product1.vue";
// import Product from "./components/Product.vue";

</script>

<template>
  <div id="app">
    <!-- Hero Section -->
    <section class="hero">
      <h1>Welcome to My Vue App</h1>
      <p>This is the hero section with a catchy tagline.</p>
    </section>

    <!-- Three Column Layout -->
    <section class="three-columns">
      <div class="column">
          <Login title="Admin Login" />
      </div>
      <div class="column">
          <!-- <Counter /> -->
           <Product1 />
      </div>
      <div class="column">
          <Login title="User Login" />
      </div>
    </section>
  </div>
</template>

<style scoped>
/* Reset parent so sections stack naturally */
#app {
  display: block; /* no flex here */
  margin: 0;
  padding: 0;
}

/* Hero Section */
.hero {
  text-align: center;
  padding: 4rem 2rem;
  background: linear-gradient(135deg, #4facfe, #00f2fe);
  color: white;
  width: 100%; /* ensure full width */
}

/* Three Column Layout */
.three-columns {
  display: flex;
  gap: 1.5rem;
  padding: 2rem;
}

.column {
  flex: 1;
  background: #f9f9f9;
  padding: 1.5rem;
  border-radius: 8px;
  box-shadow: 0 2px 6px rgba(0,0,0,0.1);
}

/* Responsive: stack columns on small screens */
@media (max-width: 768px) {
  .three-columns {
    flex-direction: column;
  }
}
</style>
