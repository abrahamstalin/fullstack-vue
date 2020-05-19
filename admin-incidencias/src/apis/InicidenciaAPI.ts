import axios, { AxiosStatic } from 'axios';
import { IIncidencia} from '../domain/Inicidencia';

export class UsuarioAPI{

    private static usersAxios = axios.create();


    static async all():Promise<IIncidencia[]>{
        let url = 'http://localhost:8080/incidencias';
        let response = await this.usersAxios.get<IIncidencia[]>(url);
        return response.data;
    }


    static async sinAsignar():Promise<IIncidencia[]>{
        let url = 'http://localhost:8080/incidencias/ASIGNADA';
        let response = await this.usersAxios.get<IIncidencia[]>(url);
        return response.data;
    }

    static async desarrollo():Promise<IIncidencia[]>{
        let url = 'http://localhost:8080/incidencias/DESARROLLO';
        let response = await this.usersAxios.get<IIncidencia[]>(url);
        return response.data;
    }

    static async enValidacion():Promise<IIncidencia[]>{
        let url = 'http://localhost:8080/incidencias/EN_VALIDACION';
        let response = await this.usersAxios.get<IIncidencia[]>(url);
        return response.data;
    }

    static async rechazadas():Promise<IIncidencia[]>{
        let url = 'http://localhost:8080/incidencias/RECHAZADA';
        let response = await this.usersAxios.get<IIncidencia[]>(url);
        return response.data;
    }

    static async cerradas():Promise<IIncidencia[]>{
        let url = 'http://localhost:8080/incidencias/CERRADA';
        let response = await this.usersAxios.get<IIncidencia[]>(url);
        return response.data;
    }


    static async save(incidencia:IIncidencia):Promise<IIncidencia>{
        let url = 'http://localhost:8080/incidencias';
        let response = await this.usersAxios.post<IIncidencia>(url, incidencia);
        return response.data;
    }
    
    static async update(id:Number, incidencia:IIncidencia):Promise<IIncidencia>{
        let url =  `http://localhost:8080/incidencias/${id}`;
        let response = await this.usersAxios.put<IIncidencia>(url,incidencia);
        return response.data;
    }


}