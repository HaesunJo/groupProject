<template>
    <div>
        <b-navbar toggleable="lg" type="dark" variant="info">
            <b-navbar-brand to="/">Fitness at home</b-navbar-brand>

        <b-navbar-toggle target="nav_collapse" />

        <b-collapse is-nav id="nav_collapse">
            <b-navbar-nav>
                <b-nav-item to="/classes">Class</b-nav-item>
                <b-nav-item to="/mealplan">Meal Plan</b-nav-item>
                <b-nav-item to="/community">Community</b-nav-item>
                <b-nav-item to="/board">Review</b-nav-item>
            </b-navbar-nav>
        </b-collapse>
        </b-navbar>
    </div>
</template>

<script>
export default {
    name: "Header",
    data(){
        return{};
    }
}
</script>