import axios from "axios";

export class UserService{

    URL="http://localhost:8080/api/v1/user";

    login(authRequest){
        return axios.post(this.URL+"/login", authRequest);
    }

    signup(USER){
        return axios.post(this.URL+"/signup", user);
    }
}