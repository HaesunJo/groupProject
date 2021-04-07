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
