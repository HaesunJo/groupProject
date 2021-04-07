import Vue from "vue";
import Router from "vue-router";

// use router packacge = do mapping b/w url & componets in serverr(system)
// if input /
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
      path: "/registeredClassList",
      name: "registered-class-list",
      component: () => import("./components/RegisteredClassList")
    }
  ]
});



// go to router.js
// specify url components mapping
/// create component inside of component folder
// service folder = responsinle to interect with RESTfull application that was develpoedd in Springboot project
// backend = RESTful applicationn
// frontend = vue server 