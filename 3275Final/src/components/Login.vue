<template> <!-- define the layout -->
  <div class="edit-form">
    <h4>Login</h4>
    <form>
      <div class="form-group">
        <label for="customerId">Customer ID</label>
        <input
          type="text"
          class="form-control"
          id="customerId"
          v-model="customerLoginRequest.customerId"
        />
      </div>  
      <div class="form-group">
        <label for="password">Password</label>
        <input
          type="password"
          class="form-control"
          id="password"
          v-model="customerLoginRequest.password"
        />
      </div>
    </form>

    <button type="submit" class="button4" @click="login">Login</button>
    <button type="submit" class="button4" @click="signup">SignUp</button>
    <button type="submit" class="button4" @click="manager">Manager</button>
    
    <p style="text-align:center">{{ message }}</p>
  </div>
</template>

<script>
import LoginService from "../services/LoginService";

export default {
  name: "login",
  data() {						// data or variables used
    return {
      customerLoginRequest: { customerId: "", password: "" },  // json
      message: ""
    };
  },
  methods: {
    login() {
      LoginService.login(this.customerLoginRequest)  
        .then(response => {				// HttpStatus.OK
          var customer = response.data;
          console.log(customer);
          localStorage.setItem("cid",customer.id);
          this.$router.push({name: "registered-classes-list"});
        })
        .catch(e => {
          this.customerLoginRequest.customerId = "";
          this.customerLoginRequest.password = "";
          this.message = e.response.data.message;
          console.log(e.response.data);
        });
    },
    signup(){
        this.$router.push({name: "/signup"});
    },
    manager(){
      this.$router.push({name: "/managerLogin"});
    }
  },
  mounted() {		// called when component is loaded
    this.message = "";
  }
};
</script>

<style>
.edit-form {
  max-width: 300px;
  margin: auto;
}

.button4{
display:block;
width: 60%;
padding:5px;
margin: 20px auto 10px auto;
border:0.16em solid rgba(255,255,255,0);
border-radius:10px;
box-sizing: border-box;
text-decoration:none;
font-weight:300;
color:#FFFFFF;
text-shadow: 0 0.04em 0.04em rgba(0,0,0,0.35);
text-align:center;
transition: all 0.2s;
background-color:#16a085;
}
.button4:hover{
border-color: rgba(255,255,255,1);
} 


</style>
