<script setup>
import {ref} from 'vue';
let counter=ref(0);
function increment(){
    counter.value++;
}

function decrement(){
    counter.value--;
}
</script>
<template>
    <button @click="decrement">-</button>
    {{counter}}
    <button @click="increment">+</button>
</template>