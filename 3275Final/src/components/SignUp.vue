<template> <!-- define the layout -->
  <div class="edit-form">
    <div id="login-box">
  <div class="left">
    <h1>Sign up</h1>
    
    <input type="text" name="username" placeholder="Username" />
    <input type="text" name="email" placeholder="E-mail" />
    <input type="password" name="password" placeholder="Password" />
    <input type="password" name="password2" placeholder="Retype password" />
    
    <input type="submit" name="signup_submit" value="Sign me up" />
  </div>

</div>
  </div>

  
</template>

<script>

export default {
  methods: {
    
  },
  mounted() {		// called when component is loaded
    this.message = "";
  }
};
</script>

<style>
.edit-form {
  max-width: 400px;
  margin: auto;
}

@import url(https://fonts.googleapis.com/css?family=Roboto:400,300,500);
*:focus {
  outline: none;
}

body {
  margin: 0;
  padding: 0;
  background: #DDD;
  font-size: 16px;
  color: #222;
  font-weight: 300;
}

#login-box {
  position: relative;
  margin: auto;
  width: 400px;
  height: 400px;
  background: #FFF;
  border-radius: 2px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.4);
}

.left {
  position: absolute;
  top: 0;
  left: 0;
  box-sizing: border-box;
  padding: 40px;
  width: 400px;
  height: 400px;
}

h1 {
  margin: 10px 0 40px 0;
  font-weight: 300;
  font-size: 28px;
  text-align: center;
}

input[type="text"],
input[type="password"] {
  display: block;
  box-sizing: border-box;
  margin: 10px auto 10px auto;
  padding: 4px;
  height: 32px;
  border: none;
  border-bottom: 1px solid #AAA;
  font-weight: 400;
  font-size: 15px;
  transition: 0.2s ease;
  text-align: center;
}

input[type="text"]:focus,
input[type="password"]:focus {
  border-bottom: 2px solid #16a085;
  color: #16a085;
  transition: 0.2s ease;
  text-align: center;
}

input[type="submit"] {
  display: block;
  width: 60%;
  margin: 40px auto auto auto;
  background: #16a085;
  border: none;
  border-radius: 10px;
  color: #FFF;
  font-weight: 500;
  text-transform: uppercase;
  transition: 0.1s ease;
  cursor: pointer;
  text-align: center;
}

input[type="submit"]:hover,
input[type="submit"]:focus {
  opacity: 0.8;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.4);
  transition: 0.1s ease;
  text-align: center;
}

</style>
