<template> <!-- define the layout -->
  <div class="edit-form">
    <h4>SignUp</h4>
    <form>
      <div class="form-group">
        <label for="customerId">User Id</label>
        <input
          type="text"
          class="form-control"
          id="customerId"
          v-model="signUpRequest.customerId"
        />
      </div>  

      <div class="form-group">
        <label for="customerName">User Name</label>
        <input
          type="text"
          class="form-control"
          id="customerName"
          v-model="signUpRequest.customerName"
        />
      </div>  

      <div class="form-group">
        <label for="customerEmail">User Email</label>
        <input
          type="text"
          class="form-control"
          id="customerEmail"
          v-model="signUpRequest.customerEmail"
        />
      </div>  

       <div class="form-group">
        <label for="customerPw">User Password</label>
        <input
          type="password"
          class="form-control"
          id="customerPw"
          v-model="signUpRequest.customerPw"
        />
      </div>  
    </form>

    <button type="submit" class="button4" @click="signup">SignUp</button>

    
    <p style="text-align:center">{{ message }}</p>
  </div>
</template>

<script>
import SignUpService from "../services/SignUpService";

export default {
  name: "signup",
  data() {						// data or variables used
    return {
      signUpRequest: { customerId: "", customerName: "", customerEmail: "", password: "" },  // json
      message: ""
    };
  },
  methods: {
    signup() {
           SignUpService.signup(this.signUpRequest)  
        .then(response => {				// HttpStatus.OK
          var customer = response.data;
          console.log(customer);    
          localStorage.setItem("cid",customer.id);
          this.$router.push({name: "login"});
        })
        .catch(e => {
          this.signUpRequest.customerId = "";
          this.signUpRequest.password = "";
          this.signUpRequest.customerName = "";
          this.signUpRequest.customerEmail = "";
          this.message = e.response.data.message;
          console.log(e.response.data);
        });
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