<template>
  <div id="profile">
    <section class="section">
      <div class="container">
        <div class="row justify-content-center">
          <div class="col-lg-12 text-center">
            <img src="img/brand/profile.png" class="logoImg" />
          </div>
        </div>
      </div>
    </section>
    <section class="section raws">
      <div class="container">
        <div class="profile-page pt-10">
          <card shadow class="card-profile" no-body>
            <div class="px-md-4 justify-content-center">
              <div class="col-lg-12 order-lg-2 mb-10">
                <div class="card-profile-image">
                  <img v-lazy="'img/brand/profile.jpg'" class="rounded-circle" />
                </div>
              </div>
              <div class="text-center box">
                <h2>
                  {{user.user_nm}}
                  <span class="font-weight-light">, 27</span>
                </h2>
                <div class="h6 font-weight-300">
                  <i class="ni location_pin mr-2"></i>Oh Myeong Hak
                </div>
                <div class="h6 mb-4">
                  <i class="ni business_briefcase-24 mr-2"></i>Backend Developer
                </div>
              </div>
              <div class="py-2 border-top text-center px-md-5">
                <div class="col-lg-11">
                  <table class="info my-2">
                    <tr>
                      <td class="icons">
                        <i class="fa fa-heartbeat"></i>
                      </td>
                      <td class="titles">
                        Birth
                      </td>
                      <td>
                        :
                      </td>
                      <td class="cont">{{ user.user_birth }}</td>
                    </tr>
                    <tr>
                      <td class="icons">
                        <i class="fa fa-phone fa-lg"></i>
                      </td>
                      <td class="titles">
                        Phone
                      </td>
                      <td>
                        :
                      </td>
                      <td class="cont">{{ user.user_tel }}</td>
                    </tr>
                    <tr>
                      <td class="icons">
                        <i class="fa fa-envelope-o fa-lg"></i>
                      </td>
                      <td class="titles">
                        Mail
                      </td>
                      <td>
                        :
                      </td>
                      <td class="cont">{{ user.user_mail }}</td>
                    </tr>
                    <tr>
                      <td class="icons">
                        <i class="fa fa-map-marker fa-lg"></i>
                      </td>
                      <td class="titles">
                        Addr
                      </td>
                      <td>
                        :
                      </td>
                      <td class="cont">{{ user.user_add }}</td>
                    </tr>
                    <tr>
                      <td class="icons">
                        <i class="fa fa-github-alt fa-lg"></i>
                      </td>
                      <td class="titles">
                        Git
                      </td>
                      <td>
                        :
                      </td>
                      <td class="cont">
                        <a :href="gitUrl">{{ user.user_gitUrl }}</a>
                      </td>
                    </tr>
                    <tr>
                      <td class="icons">
                        <i class="fa fa-pencil-square-o fa-lg"></i>
                      </td>
                      <td class="titles">
                        Blog
                      </td>
                      <td>
                        :
                      </td>
                      <td class="cont"><a :href="blogUrl">{{ urlSplit(blogUrl) }}
                        </a>
                      </td>
                    </tr>
                  </table>
                </div>
              </div>
              <div class="py-4 border-top text-center">
                <div class="row justify-content-center">
                  <div class="col-lg-9">
                    <p>{{ user.user_dtl }}</p>
                    <p><a class="hash" href="#">#성공적</a><a class="hash" href="#">#프로필</a><a class="hash" href="#">#만들었다</a><a class="hash" href="#">#힘들다</a></p>
                  </div>
                </div>
              </div>
            </div>
          </card>
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
            blogUrl: '',
            gitUrl: '',
            user: [],
            user_id: 'dhaudgkr'
        }
    },
    methods: {
        onInit: function() {
           axios.get('http://localhost:5000/users/' + this.user_id)
           .then((res) => {
               console.log(res);
               this.user = res.data.data;
               this.gitUrl = res.data.data.user_gitUrl;
               this.blogUrl = res.data.data.user_blogUrl;
           })
           .catch((err) => {
               console.log(err);
           });
        },
        urlSplit: function(str){
            var blogUrl = str.split('/');
            return blogUrl[0] + '//' + blogUrl[2] + '/' + blogUrl[3];
        }
    },
    created: function(){
        this.onInit();
    }
};
</script>
<style>
.box {
  padding-top: 150px;
}
.info {
  width: 100%;
  height: 100%;
}
.info tr{
  height: 35px;
}
.titles {
  width: 14%;
  padding-left: 10px;
  text-align: justify;
  font-weight: bold;
}
.cont {
  text-align: left;
  padding-left: 10px;
}
.cont a{
  color: #525F7F;
}
.icons{
  text-align: center;
  width: 0.8em;
}
.hash{
    margin-right: 10px;
}
.proImg{
    max-width: 100%;
    width: auto;
    max-height: 100%;
    height: auto;
}
</style>