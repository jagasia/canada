import axios from "axios"

export class ProductService{
    URL='http://localhost:8080/api/v1/products'

    addProduct(product){
        return axios.post(this.URL,product);
    }

    retrieveAllProducts(){
        return axios.get(this.URL);
    }
}