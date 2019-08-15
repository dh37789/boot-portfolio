<template>
  <div class="card border p-1 mb-2">
    <div class="card-img">
      <img class="projectImg" v-lazy="'img/brand/window10.png'"/>
    </div>
    <div class="card-body bg-white">
      <h5 class="card-title">
        <strong>{{project.proj_title}}</strong>
        <a class="git" target="_blank" rel="noopener" :href="project.proj_git">
          <i class="fa fa-github"></i>
        </a>
      </h5>
      <p class="card-text">{{project.proj_subcon}}</p>
      <h6 class="card-subTitle"><small>사용언어</small></h6>
      <div class="skill">
        <badge pill type="default" class="mr-1">Java</badge>
        <badge pill type="default" class="mr-1">JavaFx</badge>
      </div>
    </div>
    <div class="card-footer">
      <small class="text-muted">{{project.proj_start}} ~ {{project.proj_end}}</small>
      <a href="#">자세히</a>
    </div>
  </div>
</template>

<script>
  export default {
    name: "Card",
    props: [
      'project'
    ]
  }
</script>

<style>
  .git {
    float: right;
  }
  .projectImg {
    width: 100%;
    height: 100%;
  }

  .projTitle {
    font-size: 1.2em;
    font-weight: bold;
  }

  .card-img {
    border-color: white;
  }
</style>
