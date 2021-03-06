import Vue from 'vue';
import VueRouter from 'vue-router';
import Home from '../views/Home.vue';
import CreateRoom from '../views/CreateRoom.vue';
import GodRoom from '../views/GodRoom.vue';
import PlayerRoom from '../views/PlayerRoom.vue';

Vue.use(VueRouter);

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home,
  },
  {
    path: '/createroom',
    name: 'CreateRoom',
    component: CreateRoom,
  },
  {
    path: '/godroom',
    name: 'GodRoom',
    component: GodRoom,
  },
  {
    path: '/playerroom',
    name: 'PlayerRoom',
    component: PlayerRoom,
  },
  {
    path: '/about',
    name: 'About',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/About.vue'),
  },
];

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes,
});

export default router;
