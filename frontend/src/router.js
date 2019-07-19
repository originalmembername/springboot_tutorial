import Vue from 'vue'
import Router from 'vue-router'
import Cars from './components/Cars.vue'
import About from './components/About.vue'

Vue.use(Router)

export default new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/',
      name: 'cars',
      component: Cars
    },
    {
      path: '/about',
      name: 'about',
      component: About
    }
  ]
})
