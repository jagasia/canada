<script setup>
import { ProductService } from '@/services/ProductService';
import { onMounted, ref } from 'vue';

let product = ref({})
let products = ref([]);

onMounted(() => {
    console.log("Product View component is mounted now");
    //call api and get all products then populate the products in the products array
   const ps = new ProductService();
   ps.retrieveAllProducts()
   .then(res=>{
    //populate the response in the products
    products.value=res.data;
    console.log(products.value);
    
   })
   .catch()

});

function addProduct() {
    console.log("Adding the following product");
    console.log(product);
    const ps = new ProductService();
    ps.addProduct(product.value)
        .then(res => {
            console.log("Response from web service:");
            console.log(res);

        })
        .catch(err => {
            console.log("Error while adding");
            console.log(err);

        })

}
</script>

<template>
    <div>
        <table>
            <tr>
                <td>Id</td>
                <td><input type="number" v-model="product.id"></td>
            </tr>

            <tr>
                <td>Name</td>
                <td><input type="text" v-model="product.name"></td>
            </tr>

            <tr>
                <td>Category</td>
                <td>
                    <select v-model="product.category">
                        <option value="">-- Select Category --</option>
                        <option>Electronics</option>
                        <option>Computers</option>
                        <option>Mobile Phones</option>
                        <option>Home Appliances</option>
                        <option>Furniture</option>
                        <option>Clothing</option>
                        <option>Footwear</option>
                        <option>Books</option>
                        <option>Sports</option>
                        <option>Toys</option>
                        <option>Beauty</option>
                        <option>Health</option>
                        <option>Groceries</option>
                        <option>Kitchen</option>
                        <option>Automotive</option>
                        <option>Stationery</option>
                        <option>Jewellery</option>
                        <option>Pet Supplies</option>
                        <option>Garden</option>
                        <option>Others</option>
                    </select>
                </td>
            </tr>

            <tr>
                <td>Price</td>
                <td><input type="number" v-model="product.price"></td>
            </tr>

            <tr>
                <td></td>
                <td><input type="button" value="Add" @click="addProduct"></td>
            </tr>
        </table>
        <br>
        {{ JSON.stringify(product) }}
    </div>

    <hr />

    <table border="1">
        <thead>
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Category</th>
                <th>Price</th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <tr v-for="product in products" >
                <td>{{ product.id }}</td>
                <td>{{ product.name }}</td>
                <td>{{ product.category }}</td>
                <td>{{ product.price }}</td>
                <td></td>
            </tr>
        </tbody>
    </table>
</template>



<style>
@media (min-width: 1024px) {
    .about {
        min-height: 100vh;
        display: flex;
        align-items: center;
    }
}
</style>
