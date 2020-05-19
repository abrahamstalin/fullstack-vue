<template>
  <div>

      <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="#">Admin Incidencias</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item" :class="$route.name=='dashboard'?'active':''">
                    <router-link class="nav-link" to="/admin">Dashboard</router-link>
                </li>
                <li class="nav-item" :class="$route.name=='usuarios'?'active':''">
                    <router-link class="nav-link" to="/admin/usuarios">Usuarios</router-link>
                </li>
            </ul>
        </div>
    </nav>
    <div class="container-fluid">
            
        <router-view/>
    </div>
    
  </div>
</template>

<script lang="ts">
import { Component, Vue } from 'vue-property-decorator';

@Component
export default class AdminApp extends Vue {

}
</script>

<style scope>

</style>
