import { Component } from '@angular/core';
import {Router} from "@angular/router";
import {RestaurantService} from "../../service/restaurant.service";
import {Restaurant} from "../../model/restaurant";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {

  searchTerm: string = '';
  restaurants!: Restaurant[];

  constructor(private restaurantService: RestaurantService, private router: Router) { }

  onSubmit() {
    this.restaurantService.searchRestaurants(this.searchTerm).subscribe(
      data => {
        this.restaurants = data;
        this.restaurantService.setRestaurants(this.restaurants);
        this.router.navigate(['/restaurant']);
        console.log(this.restaurants)
      });
  }
}

