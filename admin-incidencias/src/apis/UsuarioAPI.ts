import axios, { AxiosStatic } from 'axios';
import {IUsuario} from '../domain/Usuario';

export class UsuarioAPI{

    private static usersAxios = axios.create();


    static async getUsuarios():Promise<IUsuario[]>{
        let url = 'http://localhost:8080/usuarios';
        let response = await this.usersAxios.get<IUsuario[]>(url);
        return response.data;
    }

    static async me():Promise<IUsuario>{
        let url = 'http://localhost:8080/usuarios/me';
        let response = await this.usersAxios.get<IUsuario>(url);
        return response.data;
    }


    static async saveUsuario(usuario:IUsuario):Promise<IUsuario>{
        let url = 'http://localhost:8080/usuarios';
        let response = await this.usersAxios.post<IUsuario>(url, usuario);
        return response.data;
    }

    static async deleteUsuario(id:Number):Promise<IUsuario>{
        let url =  `http://localhost:8080/usuarios/${id}`;
        let response = await this.usersAxios.delete<IUsuario>(url);
        return response.data;
    }

    static async updateUsuario(id:Number, usuario:IUsuario):Promise<IUsuario>{
        let url =  `http://localhost:8080/usuarios/${id}`;
        let response = await this.usersAxios.put<IUsuario>(url,usuario);
        return response.data;
    }


}