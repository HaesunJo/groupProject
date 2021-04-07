import Vue from "vue";
import Router from "vue-router";

Vue.use(Router);

export default new Router({
  mode: "history",
  routes: [
    {
      path: "/",
      alias: "/login",
      name: "login",
      component: () => import("./components/Login")
    }
   ,
    {
      path: "/registeredClassesList",
      name: "registered-classes-list",
      component: () => import("./components/RegisteredClassesList")
    }
    /*,
    {
      path: "/classes",
      name: "classes",
      component: () => import("./components/ClassesList")
    }*/
  ]
});
