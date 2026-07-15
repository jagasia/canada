<script setup>
    import { UserService } from '@/services/UserService';
import {ref} from 'vue'
    let authRequest=ref({})

    function login(){
        const us=new UserService();
        us.login(authRequest.value)
        .then(res=>{
            console.log(res);
            var token=res.data.token;
            console.log("Token is: "+token);
            localStorage.setItem("token",token);
            console.log("LocalStorage token item is now created");
            
            
            //redirect to home page.
        })
        .catch(err=>console.log(err)
        )
    }

</script>


<template>
    <div>
       
        <br>
        <table>
            <tr>
                <td>
                    Username:
                </td>
                <td>
                    <input type="text" v-model="authRequest.username">
                </td>
            </tr>
            <tr>
                <td>Password:</td>
                <td>
                    <input type="password" v-model="authRequest.password">
                </td>
            </tr>
            <tr>
                <td>
                    <input type="button" value="Submit" @click="login">
                </td>
                <td>
                    
                </td>
            </tr>
        </table>
    </div>
</template>

