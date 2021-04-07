

<template>
  <div id="app">
    <nav class="navbar navbar-expand navbar-dark bg-dark">
      <router-link to="/" class="navbar-brand">Home</router-link>
      <div class="navbar-nav mr-auto">
        <li class="nav-item">
          <router-link to="/classes" class="nav-link">Class</router-link>
        </li>
        <li class="nav-item">
          <router-link to="/mealPlan" class="nav-link">Meal Plan</router-link>
        </li>
        <li class="nav-item">
          <router-link to="/community" class="nav-link">Community</router-link>
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
