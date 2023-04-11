import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import {JWT_OPTIONS, JwtModule} from "@auth0/angular-jwt";

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './component/login/login.component';
import {FormsModule} from "@angular/forms";
import { HomeComponent } from './component/home/home.component';
import {RestaurantComponent} from "./component/restaurant/restaurant.component";
import {CarouselModule} from "primeng/carousel";
import {ButtonModule} from "primeng/button";

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomeComponent,
    RestaurantComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    CarouselModule,
    JwtModule.forRoot({
      jwtOptionsProvider: {
        provide: JWT_OPTIONS,
        useValue: {
          tokenGetter: () => {
            return localStorage.getItem('access_token');
          },
        }
      }
    }),
    FormsModule,
    ButtonModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
