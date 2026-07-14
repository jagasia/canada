<script setup>
    import {ref} from "vue"
    let prd=ref({})

    function validatePrice(){
        //price must be in the range of 20 and 1000
        if(prd.value.price<20 || prd.value.price>1000){
            // alert("Price must be in the range of 20 and 1000");      instead of alert, we can show the error message just below the price

            prd.value.price=0;
        }
    }
</script>

<template>
Id: <input type="number" v-model="prd.id" /><br/>
Name: <input type="text" v-model="prd.name" /><br/>
Category: <select v-model="prd.category">
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
<input type="number" v-model="prd.price" @change="validatePrice" />
<div v-if="prd.price < 20 || prd.price > 1000" style="color: red;">Price must be in the range of 20 and 1000</div>
<br/>
<input type="button" value="Submit" />
<br/>

{{  JSON.stringify(prd) }}
<br/>
Show result: <input type="checkbox" v-model="prd.showResult" />
<div v-if="prd.showResult">This is the result box</div>
<br/>

</template>