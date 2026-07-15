<script setup>
import { updateLoginStatus } from '@/services/AuthService';

    localStorage.clear();
    updateLoginStatus();
</script>
<template>

    You have Logged out!
</template>