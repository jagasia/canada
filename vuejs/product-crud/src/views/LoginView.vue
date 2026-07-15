<script setup>
    import { updateLoginStatus } from '@/services/AuthService';
import { UserService } from '@/services/UserService';
import {ref} from 'vue'
import { useRouter } from 'vue-router';
    let authRequest=ref({})
    let router=useRouter();

    function login(){
        const us=new UserService();
        us.login(authRequest.value)
        .then(res=>{
            console.log(res);
            var token=res.data.token;
            console.log("Token is: "+token);
            localStorage.setItem("token",token);
            console.log("LocalStorage token item is now created");
            
            updateLoginStatus();
            //redirect to home page. based on role.
            const roles=res.data.roles.split(",");
            if(roles.includes('ADMIN')){
                router.push("/admin/home");
            }else if(roles.includes('USER')){
                router.push("/user/home");
            }else{
                throw new Error("No valid roles found")
            }

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

