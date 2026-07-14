<script setup>
defineProps({
  title: {
    type: String,
    required: true
  }
})
</script>

<template>
     <h3>
        {{ title }}
     </h3>
     Username: <input type="text" value="" /><br/>
     Password: <input type="password" value="" /><br/>
     <input type="Button" value="Login" />
</template>