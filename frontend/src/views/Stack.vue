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
          <h1 class="display2"><Strong>Language</Strong></h1>
          <div class="row my-2">
            <div class="col-12 text-left lang">
                <img class="skillIcon mx-3 mb-2" src="img/skill/java.png">
                <img class="skillIcon mx-3 mb-2" src="img/skill/html5.png">
                <img class="skillIcon mx-3 mb-2" src="img/skill/css3.png">
                <img class="skillIcon mx-3 mb-2" src="img/skill/javascript.png">
            </div>
          </div>
        </div>
        <div class="col-12 text-left lang">
          <h1 class="display2"><Strong>Framework</Strong></h1>
          <div class="row my-2">
            <div class="col-12 text-left lang">
                <img class="skillIcon mx-3 mb-2" src="img/skill/springframework2.png">
                <img class="skillIcon mx-3 mb-2" src="img/skill/boot.png">
                <img class="skillIcon mx-3 mb-2" src="img/skill/Vue.png">
                <img class="skillIcon mx-3 mb-2" src="img/skill/nodejs.png">
            </div>
          </div>
        </div>
        <div class="col-12 text-left">
          <h1 class="display2"><Strong>Database</Strong></h1>
          <div class="row my-2">
            <div class="col-12 text-left lang">
                <img class="skillIcon mx-3 mb-2" src="img/skill/oracle.png">
                <img class="skillIcon mx-3 mb-2" src="img/skill/maria.png">
            </div>
          </div>
        </div>
        <div class="col-12 text-left">
          <h1 class="display2"><Strong>Version control</Strong></h1>
          <div class="row my-2">
            <div class="col-12 text-left lang">
                <img class="skillIcon mx-3 mb-2" src="img/skill/git.png">
                <img class="skillIcon mx-3 mb-2" src="img/skill/svn.png">
            </div>
          </div>
        </div>
      </div>  
    </section>
  </div>
</template>
<script>
import axios from 'axios';

export default {
    data() {
        return{
            language: [],
            framework: [],
            database: [],
            version: []
        }
    },
    methods: {
        onInit: function() {
            axios.get('http://localhost:5000/skills/')
        }
    },
    created: function(){
        this.onInit();
    }
};
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