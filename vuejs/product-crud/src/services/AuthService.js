import { ref } from "vue";

export const isLoggedIn = ref(false);

export function updateLoginStatus() {
    isLoggedIn.value = !!localStorage.getItem("token");
}