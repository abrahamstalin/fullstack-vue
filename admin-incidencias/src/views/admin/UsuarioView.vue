<template>
  <div>
    <h2>Usuario</h2>
    <!-- Tabla de Usuarios -->
    <div class="table-responsive">
      <table class="table table-bordered table-hover">
        <thead>
          <tr>
            <th>Id</th>
            <th>Nombre</th>
            <th>TipoUsuario</th>
            <th></th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="usuario in usuarios" :key="usuario.id">
            <td>{{usuario.id}}</td>
            <td>
              {{usuario.nombreUsuario}}</td>
            <td>
              {{usuario.tipoUsuario}}</td>
            <td>
              
                <button type="button" class="btn btn-info btn-block" @click="modificar(usuario)">Modificar</button>
                <button type="button" class="btn btn-danger btn-block" @click="eliminar(usuario.id)">Eliminar</button>
              
            </td>
          </tr>
        </tbody>
      </table>
    </div>


    <!-- Crear / Modificar -->

    <div class="form">
      <div class="form-group">
        <label for="" class="control-label">Nombre de usuario</label>
        <input type="text" class="form-control" placeholder="abrahamstalin" v-model="usuario.nombreUsuario">
      </div>
      <div class="form-group">
        <label for="" class="control-label">Contraseña</label>
        <input type="text" class="form-control" placeholder="****" v-model="usuario.contrasena">
      </div>
      <div class="form-group">
        <label for="" class="control-label">Tipo Usuario</label>
        <select class="form-control" v-model="usuario.tipoUsuario">
          <option>ADMINISTRADOR</option>
          <option>TESTER</option>
          <option>DESARROLLADOR</option>
        </select>
      </div>
      <button v-if="usuario.id" @click="actualizar()" type="button" class="btn btn-info btn-block mt-1">Actualizar</button>
      <button v-else @click="guardar()" type="button" class="btn btn-info btn-primary  btn-block mt-1">Guardar</button>
      <button @click="cancelar()" type="button" class="btn btn-warning btn-block mt-1">Cancelar</button>
    </div>

  </div>
</template>

<script lang="ts">
import { Component, Vue } from 'vue-property-decorator';
import { UsuarioAPI } from '../../apis/UsuarioAPI';
import { IUsuario } from '../../domain/Usuario';

@Component
export default class UsuarioView extends Vue {

  usuarios:IUsuario[]=[];
  usuario:IUsuario={};

    mounted(){
      UsuarioAPI.getUsuarios()
      .then((data:IUsuario[])=>{
        this.usuarios = data;
        this.sortUsuarios();
      })
      .catch((err:Error)=>{
        alert('Sucedio un error al obtener los usuarios.');
      });
    }

    guardar(){
      UsuarioAPI.saveUsuario(this.usuario)
      .then((data:IUsuario)=>{
        this.usuarios.push(data);
        this.sortUsuarios();
        this.usuario = {};
      })
      .catch((err:Error)=>{
        alert('Sucedio un error al obtener los usuarios.');
      });
    }

    sortUsuarios(){
      this.usuarios = this.usuarios.sort(
        (a,b)=>{
          if (a.id > b.id)
            return -1;
          else if (a.id < b.id)
            return 1;
          else return 0;
        }
      );
    }

    actualizar(){
      UsuarioAPI.updateUsuario(this.usuario.id, this.usuario).then((data:IUsuario)=>{
        this.usuarios  = this.usuarios.filter((e)=>{ return e.id != this.usuario.id;});
        this.usuarios.push(data);
        this.sortUsuarios();
        this.usuario = {};
      })
      .catch((err:any)=>{
        alert('Sucedio un error al actualizar');
      });
    }

    eliminar(id:Number){
      UsuarioAPI.deleteUsuario(id).then((data:IUsuario)=>{
        this.usuarios  = this.usuarios.filter((e)=>{ return e.id != data.id;});
        this.sortUsuarios();
        this.usuario = {};
      })
      .catch((err:any)=>{
        alert('Sucedio un error al actualizar');
      });
    }

    modificar(usuario:IUsuario){
      this.usuario = Object.assign({},usuario);
      this.usuario.contrasena = '';
    }

    cancelar(){
      this.usuario = {};

    }
}
</script>

<style scope>

</style>
