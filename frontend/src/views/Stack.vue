<template>
  <div id="stack">
    <section class="section">
      <div class="container">
        <div class="row justify-content-center">
          <div class="col-lg-12 text-center">
            <img src="img/brand/stack.png" class="logoImg" />
          </div>
        </div>
      </div>
    </section>
    <section class="section">
      <div class="container">
        <div class="col-12 text-left">
          <h1 class="display2">Language</h1>
          <div class="row my-4">
            <div class="col-12 text-left lang">
                <img class="skillIcon mx-3" src="img/skill/java.png">
                <img class="skillIcon mx-3" src="img/skill/html5.png">
                <img class="skillIcon mx-3" src="img/skill/css3.png">
                <img class="skillIcon mx-3" src="img/skill/javascript.png">
            </div>
          </div>
        </div>
        <div class="col-12 text-left lang">
          <h1 class="display2">Framework</h1>
          <div class="row my-4">
            <div class="col-12 text-left lang">
                <img class="skillIcon mx-3" src="img/skill/springframework2.png">
                <img class="skillIcon mx-3" src="img/skill/boot.png">
                <img class="skillIcon mx-3" src="img/skill/Vue.png">
                <img class="skillIcon mx-3" src="img/skill/nodejs.png">
            </div>
          </div>
        </div>
        <div class="col-12 text-left">
          <h1 class="display2">Database</h1>
          <div class="row my-4">
            <div class="col-12 text-left lang">
                <img class="skillIcon mx-3" src="img/skill/oracle.png">
                <img class="skillIcon mx-3" src="img/skill/maria.png">
            </div>
          </div>
        </div>
        <div class="col-12 text-left">
          <h1 class="display2">Etc..</h1>
          <div class="row my-4">
            <div class="col-12 text-left lang">
                <img class="skillIcon mx-3" src="img/skill/git.png">
                <img class="skillIcon mx-3" src="img/skill/svn.png">
            </div>
          </div>
        </div>
      </div>  
    </section>
  </div>
</template>
<script>
export default {};
</script>
<style>
.lang{
  justify-content: flex-start;
}
.skillIcon{
  border: 2px solid lightgray;
  border-radius: 30%;
  width: 130px;
  height: 130px;
}
</style>