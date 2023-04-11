import {Component, OnInit} from '@angular/core';
import {Restaurant} from "../../model/restaurant";
import {RestaurantService} from "../../service/restaurant.service";
import {MyImage} from "../../model/images";

@Component({
  selector: 'app-restaurant',
  templateUrl: './restaurant.component.html',
  styleUrls: ['./restaurant.component.css']
})
export class RestaurantComponent implements OnInit {
  restaurants!: Restaurant[];
  responsiveOptions: any[] = [];

  carouselOptions = {
    value: this.restaurants,
    numVisible: 3,
    numScroll: 1,
    circular: true,
    autoplayInterval: 0,
    responsiveOptions: this.responsiveOptions
  };

  constructor(private restaurantService: RestaurantService) {
    this.responsiveOptions = [{
      breakpoint: '1024px',
      numVisible: 1,
      numScroll: 3
    }];
  }

  ngOnInit(): void {
    this.restaurants = this.restaurantService.getRestaurants();
  }
  images: MyImage[] = [
    { name: 'La Sqala', url: 'https://cdn.tasteatlas.com/images/restaurants/b215a55d0b174b2f8fec9acf0fd7172e.jpg?mw=560' },
    { name: 'Dar Yacout', url: 'https://cdn.tasteatlas.com/images/restaurants/958953f3c6674440b9eae766002f60dc.jpg?mw=560' },
    { name: 'Chez Hakim', url: 'https://lh3.googleusercontent.com/p/AF1QipMy5UjIkwFgAtFWlekfIHkk7rNmEPKtbgzk6zE6=s1360-w1360-h1020' },
    { name: 'Adwak', url: 'https://cdn.tasteatlas.com/images/restaurants/ba06057477fb4ed69f5d6a4c50b70b26.jpg?mw=1300' },
  ];

  getImageUrl(name: string): string {
    const image = this.images.find(img => img.name === name);
    return image ? image.url : '';
  }
}
