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
          <div class="row my-2 ml-2">
            <div class="col-12 text-left lang">
              <template v-for="(list, idx) in lists"  >
                <div class="wapper" :key="idx" v-if="list.skill.skill_cls_no == '1'">
                  <img class="skillIcon" v-if="list.skill.skill_cls_no == '1'" v-bind:src="'img/skill/' + list.skill.skill_img">
                  <div class="links" v-if="list.skill.skill_cls_no == '1'">
                    <p class="title">{{ list.skill.skill_nm }}</p>
                    <p v-if="list.skill_lev == '1'">Beginner</p>
                    <p v-if="list.skill_lev == '2'">Normal</p>
                    <p v-if="list.skill_lev == '3'">Intermediate</p>
                    <p v-if="list.skill_lev == '4'">Advanced</p>
                  </div>
                </div>
              </template>
            </div>
          </div>
        </div>
        <div class="col-12 text-left lang">
          <h1 class="display2"><Strong>Framework</Strong></h1>
          <div class="row my-2 ml-2">
            <div class="col-12 text-left lang">
              <template v-for="(list, idx) in lists">
                <div class="wapper" :key="idx"  v-if="list.skill.skill_cls_no == '2'">
                  <img class="skillIcon" v-if="list.skill.skill_cls_no == '2'" v-bind:src="'img/skill/' + list.skill.skill_img">
                  <div class="links" v-if="list.skill.skill_cls_no == '2'">
                    <p class="title">{{ list.skill.skill_nm }}</p>
                    <p v-if="list.skill_lev == '1'">Beginner</p>
                    <p v-if="list.skill_lev == '2'">Normal</p>
                    <p v-if="list.skill_lev == '3'">Intermediate</p>
                    <p v-if="list.skill_lev == '4'">Advanced</p>
                  </div>
                </div>
              </template>
            </div>
          </div>
        </div>
        <div class="col-12 text-left">
          <h1 class="display2"><Strong>Database</Strong></h1>
          <div class="row my-2 ml-2">
            <div class="col-12 text-left lang">
              <template v-for="(list, idx) in lists">
                <div class="wapper" :key="idx"  v-if="list.skill.skill_cls_no == '3'">
                  <img class="skillIcon" v-if="list.skill.skill_cls_no == '3'" v-bind:src="'img/skill/' + list.skill.skill_img">
                  <div class="links" v-if="list.skill.skill_cls_no == '3'">
                    <p class="title">{{ list.skill.skill_nm }}</p>
                    <p v-if="list.skill_lev == '1'">Beginner</p>
                    <p v-if="list.skill_lev == '2'">Normal</p>
                    <p v-if="list.skill_lev == '3'">Intermediate</p>
                    <p v-if="list.skill_lev == '4'">Advanced</p>
                  </div>
                </div>
              </template>
            </div>
          </div>
        </div>
        <div class="col-12 text-left">
          <h1 class="display2"><Strong>Version control</Strong></h1>
          <div class="row my-2 ml-2">
            <div class="col-12 text-left lang">
              <template v-for="(list, idx) in lists"  >
                <div class="wapper" :key="idx"  v-if="list.skill.skill_cls_no == '4'">
                  <img class="skillIcon" v-if="list.skill.skill_cls_no == '4'" v-bind:src="'img/skill/' + list.skill.skill_img">
                  <div class="links" v-if="list.skill.skill_cls_no == '4'">
                    <p class="title">{{ list.skill.skill_nm }}</p>
                    <p v-if="list.skill_lev == '1'">Beginner</p>
                    <p v-if="list.skill_lev == '2'">Normal</p>
                    <p v-if="list.skill_lev == '3'">Intermediate</p>
                    <p v-if="list.skill_lev == '4'">Advanced</p>
                  </div>
                </div>
              </template>
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
            lists: [],
            language: true
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
        },
        langSw: function() {
            this.language = false;
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
  border-radius: 30%;
  width: 130px;
  height: 130px;
  transition: .5s ease;
}
</style>
