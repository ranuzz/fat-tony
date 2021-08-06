import Vue from 'vue';
import Buefy from 'buefy';
import axios from 'axios';
import App from './App.vue';
import router from './router';
import store from './store';
import 'buefy/dist/buefy.css';

Vue.config.productionTip = false;
Vue.use(Buefy);
Vue.use(axios);
Vue.prototype.$http = axios;

new Vue({
  router,
  store,
  render: (h) => h(App),
}).$mount('#app');
