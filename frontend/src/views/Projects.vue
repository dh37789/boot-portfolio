<template>
  <div id="project">
    <section class="section">
      <div class="container">
        <div class="row justify-content-center">
          <div class="col-lg-12 text-center">
            <img src="img/brand/project.png" class="logoImg" />
          </div>
        </div>
      </div>
    </section>
    <section class="section">
      <div class="container">
        <div class="card-deck">
          <project :project="project"></project>
        </div>
      </div>
    </section>
  </div>
</template>
<script>
import axios from 'axios';
import Project from "./components/Project.vue";

export default {
  components: {
    Project
  }
};
</script>
<style>
.projectImg{
  width: 100%;
  height: 100%;
}
.projTitle{
  font-size: 1.2em;
  font-weight: bold;
}
.card-img{
  border-color: white;
}
.card-footer a{
  float: right;
}
.git{
  float:right;
}
</style>
