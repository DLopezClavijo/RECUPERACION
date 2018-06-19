import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';

import { UserEditComponent } from './components/user-edit.component';

import { routing, appRoutingProviders } from './app.routing';

import { SingerListComponent } from './components/singer-list.component';

import { HomeComponent } from './components/home.component';

import { SingerAddComponent } from './components/singer-add.component';

import { SingerEditComponent } from './components/singer-edit.component';

import { SingerDetailComponent } from './components/singer-detail.component';


@NgModule({
  declarations: [
    AppComponent,
    UserEditComponent,
    SingerListComponent,
    HomeComponent,
    SingerAddComponent,
    SingerEditComponent,
    SingerDetailComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    routing
  ],
  providers: [appRoutingProviders],
  bootstrap: [AppComponent]
})
export class AppModule { }
