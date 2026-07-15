import axios from "axios"

export class ProductService{
    URL='http://localhost:8080/api/v2/products'


    getToken(){
         var token=localStorage.getItem("token");

        if(token==null || token=="" || token == undefined){
            console.log("You have not logged in")
            throw new Error("You have not logged in");
        }
        return token;
    }

    addProduct(product){
        var token=this.getToken();
        return axios.post(this.URL,product, {headers: {
            Authorization: `Bearer ${token}`
        }});
    }

    retrieveAllProducts(){
       var token=this.getToken();
        return axios.get(this.URL,{
        headers: {
            Authorization: `Bearer ${token}`
        }
    });
    }
}