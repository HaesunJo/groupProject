<template>
  <div v-if="customer" class="list row">
    <div class="col-md-8">
      <div>Hi {{customer.name}}</div>
    </div>

    <div class="col-md-6">
      <h4>{{ this.subtitle }}</h4>
      <ul class="list-group">
        <li
          class="list-group-item"
          :class="{ active: index == currentIndex }"
          v-for="(classes, index) in classes"
          :key="index"
          @click="setActiveClass(classes, index)"
        >{{ classes.className }}</li>
      </ul>
    </div>

    <div class="col-md-6">
      <div v-if="currentClass">
        <h4>Class</h4>
        <div>
          <label>
            <strong>Class Section:</strong>
          </label>
          {{ currentClass.Section }}
        </div>
        <div>
          <label>
            <strong>Title:</strong>
          </label>
          {{ currentClass.className }}
        </div>
        <button
          v-if="regFlag"
          class="m-3 btn btn-sm btn-danger"
          @click="registerClass"
        >Register this class</button>
        <button
          v-else
          class="m-3 btn btn-sm btn-danger"
          @click="unregisterClass"
        >Unregister this class</button>
      </div>
      <div v-else>
        <br />
        <p v-if="classes">Please click on a Class...</p>
      </div>
      <div v-if="regFlag">
        <br />
        <a class="badge badge-warning" @click="refreshList">Show Registered Classes</a>
      </div>
      <div v-else>
        <br />
        <a class="badge badge-warning" @click="showUnregisterClass">Show Unregistered Classes</a>
      </div>
    </div>
  </div>
</template>

<script>
import CustomerDataService from "../services/CustomerDataService";
import RegistrationDataService from "../services/RegistrationDataService";

export default {
  name: "reg-classes-list",
  data() {
    return {
      customer: null,
      classes: [],
      currentClass: null,
      currentIndex: -1,
      subtitle: "Your Registered Classes List",
      regFlag: false,
      registrationRequest: { action: "", className: "" }
    };
  },

  methods: {
    showUnregisterClass() {
      // this.registrationRequest.studentId = this.student.id;
      RegistrationDataService.get(this.customer.id, false)
        .then(response => {
          this.currentClass = null;
          this.currentIndex = -1;
          this.classes = response.data;
          this.subtitle = "Unregistered Classes List";
          this.regFlag = true;
        })
        .catch(e => {
          console.log(e);
        });
    },
    unregisterClass() {
      this.registrationRequest.action = "remove";
      this.registrationRequest.className = this.currentClass.id;
      CustomerDataService.unregister(
        this.cistomer.id,
        this.registrationRequest
      ).then(response => {
        this.customer = response.data;
        this.refreshList();
      });
    },
    registerClass() {
      this.registrationRequest.action = "add";
      this.registrationRequest.className = this.currentClass.id;
      CustomerDataService.register(
        this.customer.id,
        this.registrationRequest
      ).then(response => {
        this.customer = response.data;
        this.refreshList();
      });
    },
    setActiveClass(classes, index) {
      this.currentClass = classes;
      this.currentIndex = index;
    },
    refreshList() {
      this.retrieveCustomer(this.customer.id);
      this.customer = this.customer.classes;
      this.currentClass = null;
      this.currentIndex = -1;
      this.regFlag = false;
      this.registrationRequest.customerId = "";
      this.registrationRequest.className = "";
    },
    retrieveCustomer() {
      var id = localStorage.getItem("cid");
      CustomerDataService.get(id)
        .then(response => {
          this.customer = response.data;
          this.classes = this.customer.classes;
          this.subtitle = "Your Registered Classes List";
          this.regFlag = false;
          console.log(this.customer);
        })
        .catch(e => {
          console.log(e);
        });
    }
  },

  mounted() {
    this.retrieveCustomer();
  }
};
</script>

<style>
.list {
  text-align: left;
  max-width: 750px;
  margin: auto;
}
</style>
