<template>
<button @click="decrement">-</button>
<p>{{count}}</p>
<button @click="increment">+</button>
</template>

<script setup>
import {ref} from 'vue'
const count=ref(0);

function increment(){
    count.value++;
}

function decrement(){
    count.value--;
}
</script>