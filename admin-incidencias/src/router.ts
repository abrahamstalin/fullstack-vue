import Vue from 'vue';
import Router from 'vue-router';
import Login from './views/Login.vue';

Vue.use(Router);

export default new Router({
  routes: [
    {
      path: '/',
      name: 'login',
      component: Login,
    },
    {
      path: '/admin',
      name: 'admin',
      component: () => import('./views/admin/AdminApp.vue'),
      children:[
        { path: '', redirect:'/admin/dashboard'},
        { path: 'dashboard', name:"dashboard", component: () => import('./views/admin/DashboardView.vue')},
        { path: 'usuarios', name:"usuarios", component: () => import('./views/admin/UsuarioView.vue')},

      ],
      
      
    },
  ],
});
