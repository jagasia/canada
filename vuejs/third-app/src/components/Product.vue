<script setup>
    import {ref} from "vue"
    let id=ref(0);
    let name=ref('')
    let category=ref('')
    let price=ref(0.0)
</script>

<template>
Id: <input type="number" v-model="id" /><br/>
Name: <input type="text" v-model="name" /><br/>
Category: <select v-model="category">
    <option value="">-- Select Category --</option>
      <option value="electronics">Electronics</option>
      <option value="fashion">Fashion</option>
      <option value="home">Home & Living</option>
      <option value="beauty">Beauty & Personal Care</option>
      <option value="sports">Sports & Outdoors</option>
      <option value="books">Books</option>
      <option value="toys">Toys & Games</option>
      <option value="groceries">Groceries</option>
</select>
Price:
<input type="number" v-model="price" />
<br/>
<input type="button" value="Submit" />
<br/>
{{ id }}<br/> {{ name }} <br/> {{ category }} <br/> {{ price }}

</template>