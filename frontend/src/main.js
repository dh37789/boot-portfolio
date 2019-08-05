import Vue from 'vue';
import App from './App.vue';
import router from './router/router';
import Argon from "./plugins/argon-kit";
import VueScrollTo from 'vue-scrollto';
import { store } from './store/store';
import './registerServiceWorker'

Vue.config.productionTip = false
Vue.use(Argon)
Vue.use(VueScrollTo)

new Vue({
    store,
    router,
    render: h => h(App)
}).$mount('#app')