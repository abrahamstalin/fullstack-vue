<template>
  <div class="container">
    <div class="form">
      <div class="form-group">
        <label for="" class="control-label">Nombre de usuario</label>
        <input v-model="usuario.nombreUsuario" type="text" class="form-control" placeholder="abrahamstalin">
      </div>
      <div class="form-group">
        <label for="" class="control-label">Contrasena</label>
        <input v-model="usuario.contrasena" type="password" class="form-control" placeholder="***">
      </div>

      <button class="btn btn-primary btn-block" type="button" @click="autenticar()">Ingresar</button>

    </div>
  </div>
</template>

<script lang="ts">
import { Component, Vue } from 'vue-property-decorator';
import axios, { AxiosStatic } from 'axios';

import { IUsuario } from '../domain/Usuario';
import { AutenticationAPI } from '../apis/Autentication'


@Component
export default class Login extends Vue {
  usuario:IUsuario={};

  autenticar(){
    AutenticationAPI.autentication(this.usuario).then((res:any)=>{
      this.$store.dispatch('setToken',res.token).then(()=>{
        window.localStorage.setItem('token',res.token);
        this.$router.push({ path: `/admin` });
      }).catch((err:any)=>{
        console.log(err)
      });

      
      
    }).catch(
      (err:any)=>{
        console.log(err);
      }
    );
  }
}
</script>

<style scope>

</style>
