import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {LoginuserService} from "./loginuser-service.service";
import {Restaurant} from "../model/restaurant";

@Injectable({
  providedIn: 'root'
})
export class RestaurantService {

  restaurants !: Restaurant[] ;
  private baseUrl = 'http://localhost:8888/restaurants';


  constructor(private http: HttpClient, private loginuserService: LoginuserService) { }

  searchRestaurants(pays: string): Observable<any> {
    const headers = new HttpHeaders({
      'Authorization': `Bearer ${localStorage.getItem("accessToken")}`
    });
    return this.http.get(`${this.baseUrl}/${pays}`, { headers: headers });
  }

  setRestaurants(restaurants: Restaurant[]) {
    this.restaurants = restaurants;
  }

  getRestaurants(): Restaurant[] {
    return this.restaurants;
  }

}
