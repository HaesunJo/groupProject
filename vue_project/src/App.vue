<template>
  <div id="app">
    <nav class="navbar navbar-expand navbar-dark bg-dark">
      <router-link to="/" class="navbar-brand">CRS Demo</router-link>
      <div class="navbar-nav mr-auto">
        <li class="nav-item">
          <router-link to="/classes" class="nav-link">Classes</router-link>
        </li>
      </div>
    </nav>

    <div class="container mt-3">
      <router-view />  <!-- the vue component will display here -->
    </div>
  </div>
</template>


<script>
export default {
  name: "app"
};
</script>

<!--
<template>
  <div id="app">
    <img alt="Vue logo" src="./assets/logo.png">
    <HelloWorld msg="Welcome to Your Vue.js App"/>
  </div>
</template>

<script>
import HelloWorld from './components/HelloWorld.vue'

export default {
  name: 'App',
  components: {
    HelloWorld
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
-->
