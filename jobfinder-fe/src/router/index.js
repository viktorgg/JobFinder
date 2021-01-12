import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import Ad from '../views/Ad.vue'
import Login from '../views/Login.vue'
import AdInfo from '../views/AdInfo.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/ad',
    name: 'Ad',
    component: Ad
  },
  {
    path: '/login',
    name: 'Login',
    component: Login
  },
  {
    path: '/adInfo',
    name: 'AdInfo',
    component: AdInfo
  },
  {
    path: '/about',
    name: 'About',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/About.vue')
  }
]

const router = new VueRouter({
  routes
})

export default router
