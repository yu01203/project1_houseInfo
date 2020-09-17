import Vue from "vue";
import App from "./App.vue";
import router from "./router";
import store from "./store";
import VModal from 'vue-js-modal'
import VueSession from 'vue-session'
import BootstrapVue from 'bootstrap-vue'
import 'bootstrap/dist/css/bootstrap.min.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'

import * as VueGoogleMaps from 'vue2-google-maps'

Vue.config.productionTip = false;
Vue.use(BootstrapVue)
Vue.use(VModal)
Vue.use(VueSession, sessionOptions)

Vue.use(VueGoogleMaps, {
  load: {
    key: 'AIzaSyCD1wK6VrNk0ef5FGUK9McpAEsG0GvAD7M',
    libraries: 'places', // This is required if you use the Autocomplete plugin
    // OR: libraries: 'places,drawing'
    // OR: libraries: 'places,drawing,visualization'
    // (as you require)

    //// If you want to set the version, you can do so:
    // v: '3.26',
  }
})

var sessionOptions = {
  persist: true
}

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount("#app");
