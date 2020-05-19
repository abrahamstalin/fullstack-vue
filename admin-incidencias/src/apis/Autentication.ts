import axios, { AxiosStatic } from 'axios';
import { IUsuario} from '../domain/Usuario';

export class AutenticationAPI{

    private static usersAxios = axios.create();


    static async autentication(usuario:IUsuario):Promise<any>{
        let url = 'http://localhost:8080/authenticate';
        let response = await this.usersAxios.post<any>(url,usuario);
        return response.data;
    }



}