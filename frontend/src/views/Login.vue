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
                  <card type="secondary" shadow
                        header-classes="bg-white pb-5"
                        body-classes="px-lg-5 py-lg-5"
                        class="border-0">
                      <template>
                          <div class="btn-wrapper text-center">
                          </div>
                      </template>
                      <template>
                          <form role="form" @submit.prevent="onLogin">
                              <base-input alternative
                                          class="mb-3"
                                          placeholder="Email"
                                          addon-left-icon="ni ni-email-83"
                                          v-model="user_mail">
                              </base-input>
                              <base-input alternative
                                          type="password"
                                          placeholder="Password"
                                          addon-left-icon="ni ni-lock-circle-open"
                                          v-model="user_pass">
                              </base-input>
                              <base-checkbox>
                                  Remember me
                              </base-checkbox>
                              <div class="text-center mt-3">
                                 <base-button block type="primary" nativeType="submit">
                                   Sign In
                                 </base-button>
                              <base-button block type="neutral">
                                <img slot="icon" src="img/icons/common/google.svg">
                                  Google Login
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
  name: 'Login',
  data() {
    return{
      user_mail: '',
      user_pass: ''
    }
  },
  methods: {
    onLogin: function () {
      const frm = new FormData()
      frm.append('user_mail', this.user_mail)
      frm.append('user_pass', this.user_pass)

      axios.post('http://localhost:5000/restUser/login', frm)
      .then( response => {
        console.log('response', JSON.stringify(response, null, 2))
      }).catch(error => {
        console.log('failed', error)
      })
    }
  }
}
</script>
