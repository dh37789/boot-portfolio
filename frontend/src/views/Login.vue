<template>
  <!-- shape Hero -->
  <section class="section-shaped section-lg my-0">
    <div class="shape shape-style-2 shape-default shape-skew">
      <span></span>
      <span></span>
      <span></span>
      <span></span>
      <span></span>
      <span></span>
      <span></span>
      <span></span>
      <span></span>
    </div>
    <div class="container pt-lg-md">
      <div class="row justify-content-center">
        <div class="col-lg-5">
          <card
            type="secondary"
            shadow
            header-classes="bg-white pb-5"
            body-classes="px-lg-5 py-lg-5"
            class="border-0"
          >
            <template>
              <div class="btn-wrapper text-center">
              </div>
            </template>
            <template>
              <form role="form">
                <base-input
                  alternative id="id"
                  class="mb-3"
                  placeholder="Email"
                  addon-left-icon="ni ni-email-83"
                ></base-input>
                <base-input
                  alternative id="pass"
                  type="password"
                  placeholder="Password"
                  addon-left-icon="ni ni-lock-circle-open"
                ></base-input>
                <base-checkbox>Remember me</base-checkbox>
                <div class="text-center mt-3">
                  <base-button block type="primary">Sign In</base-button>
                  <base-button block type="neutral">
                    <img slot="icon" src="../assets/img/icons/common/google.svg">Google Login
                  </base-button>
                </div>
              </form>
            </template>
          </card>
        </div>
      </div>
    </div>
  </section>
  <!-- 1st Hero Variation -->
</template>


<script>

import axios from 'axios'

export default {
  name: 'pass',
  data: () => {
    return{
     users:[] 
    }
  },
  created () {
    axios.get('http://127.0.0.1:5000/user/')
      .then(response => {
        this.users = response.data
    })
    .catch(e => {
      console.log('error : ', e)
    })
  }
}
</script>
