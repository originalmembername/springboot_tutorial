import Vue from 'vue'
import './plugins/vuetify'
import App from './App.vue'
import router from './router'
import VueResource from 'vue-resource'
import VueResourceMock from 'vue-resource-mock'
import MockData from './components/mock/carApi.js'

Vue.config.productionTip = false
Vue.use(VueResource)

if (process.env.NODE_ENV === 'development') {
  Vue.use(VueResourceMock, MockData)
}

new Vue({
  router,
  render: h => h(App)
}).$mount('#app')
