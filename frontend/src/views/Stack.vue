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
        <div v-for="(list, idx) in lists" v-bind:key="idx" class="col-12 text-left">
          <h1 class="display2"><Strong>Language</Strong></h1>
          <div class="row my-2">
            <div class="col-12 text-left lang">
                <img class="skillIcon mx-3 mb-2" v-bind:src="'img/skill/' + list.skill.skill_img">
            </div>
          </div>
        </div>
        <div class="col-12 text-left lang">
          <h1 class="display2"><Strong>Framework</Strong></h1>
          <div class="row my-2">
            <div class="col-12 text-left lang">
            </div>
          </div>
        </div>
        <div class="col-12 text-left">
          <h1 class="display2"><Strong>Database</Strong></h1>
          <div class="row my-2">
            <div class="col-12 text-left lang">
            </div>
          </div>
        </div>
        <div class="col-12 text-left">
          <h1 class="display2"><Strong>Version control</Strong></h1>
          <div class="row my-2">
            <div class="col-12 text-left lang">
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
            user_id: 'dhaudgkr',
            lists: []
        }
    },
    methods: {
        onInit: function() {
            axios.get('http://localhost:5000/skills/' + this.user_id)
            .then((res) => {
                console.log(res);
                this.lists = res.data.list;
            })
            .catch((err) => {
                console.log(err);
            })
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