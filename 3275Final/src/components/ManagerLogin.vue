<template> <!-- define the layout -->
  <div class="edit-form">
    <h4>Manager Login</h4>
    <form>
      <div class="form-group">
        <label for="managerId">Manager ID</label>
        <input
          type="text"
          class="form-control"
          id="managerId"
          v-model="managerLoginRequest.managerId"
        />
      </div>
      <div class="form-group">
        <label for="password">Password</label>
        <input
          type="password"
          class="form-control"
          id="password"
          v-model="managerLoginRequest.password"
        />
      </div>
    </form>

    <button type="submit" class="badge badge-success" @click="login">Login</button>

    
    <p>{{ message }}</p>
  </div>
</template>

<script>
import LoginService from "../services/LoginService";

export default {
  name: "login",
  data() {						// data or variables used
    return {
      managerLoginRequest: { managerId: "", password: "" },  // json
      message: ""
    };
  },
  methods: {
    login() {
      LoginService.loginManager(this.managerLoginRequest)  
        .then(response => {				// HttpStatus.OK
          var manager = response.data;
          console.log(manager);
          localStorage.setItem("cid",manager.id);
          this.$router.push({name: "registered-classes-list"});
        })
        .catch(e => {
          this.managerLoginRequest.managerId = "";
          this.managerLoginRequest.password = "";
          this.message = e.response.data.message;
          console.log(e.response.data);
        });
    },
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
</style>
