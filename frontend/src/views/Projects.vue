<template>
  <div id="project">
    <section class="section">
      <div class="container">
        <div class="row justify-content-center">
          <div class="col-lg-12 text-center">
            <img src="img/brand/project.png" class="logoImg"/>
          </div>
        </div>
      </div>
    </section>
    <section class="section">
      <div class="container">
        <div class="row">
          <div class="col-md-6 proj" v-for="(project,idx) in projects" :key="idx">
            <project :project="project" v-if="project !== null"></project>
          </div>
        </div>
      </div>
    </section>
  </div>
</template>
<script>
  import axios from 'axios';
  import Project from "./components/Project.vue";

  export default {
    data() {
      return {
        projects: []
      }
    },
    components: {
      Project
    },
    async created() {
      axios.get("http://localhost:5000/projects")
      .then((res) => {
        console.log(res.data.list);
        this.projects = res.data.list;
        console.log(this.projects);
      })
      .catch((err) => {
        console.log(err);
      });
    },
    methods: {
      arrNum: function (arr) {
        return arr.length;
      }
    }
  };
</script>
<style>
  .proj {
    display: flex;
  }

  .card {
    display: flex;
  }

  .card-footer a {
    float: right;
  }
</style>
