<template>
  <div class="card border p-1">
    <div class="card-img">
      <img class="projectImg" v-lazy="'img/brand/window10.png'"/>
    </div>
    <div class="card-body bg-white">
      <h5 class="card-title">
        <strong>JavaFX 메모장</strong>
        <a class="git" target="_blank" rel="noopener" href="https://github.com/dh37789">
          <i class="fa fa-github"></i>
        </a>
      </h5>
      <p class="card-text">JavaFx를 이용해 간단한 메모장을 만들어 보았습니다.</p>
      <h6 class="card-subTitle"><small>사용언어</small></h6>
      <div class="skill">
        <badge pill type="default" class="mr-1">Java</badge>
        <badge pill type="default" class="mr-1">JavaFx</badge>
      </div>
    </div>
    <div class="card-footer">
      <small class="text-muted">2019.01.08 ~ 2019.01.10</small>
      <a href="#">자세히</a>
    </div>
  </div>
</template>

<script>
  export default {
    name: "Card",
    props: {
      project: Object
    }
  }
</script>

<style scoped>

</style>
