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

    <button type="submit" class="badge badge-success" @click="login">Login</button>
    <p>{{ message }}</p>
  </div>
</template>


<script>
// create LoginService
import LoginService from "../../services/LoginService";

export default {
  name: "login",
  data() {						
    return {
      customerLoginRequest: { customerId: "", password: "" },  
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
          this.$router.push({name: "registered-class-list"});
        })
        .catch(e => {
          this.customerLoginRequest.customerId = "";
          this.customerLoginRequest.password = "";
          this.message = e.response.data.message;
          console.log(e.response.data);
        });
    }
  },
  mounted() {	
    this.message = "";
  }
};
</script>

<style>
.edit-form {
  max-width: 300px;
  margin: auto;
}
</style>
