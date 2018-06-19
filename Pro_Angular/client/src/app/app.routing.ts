import { ModuleWithProviders } from '@angular/core';

import { Routes, RouterModule } from '@angular/router';

import { UserEditComponent } from './components/user-edit.component';

import { SingerListComponent } from './components/singer-list.component';

import { HomeComponent } from './components/home.component';

import { SingerAddComponent } from './components/singer-add.component';

import { SingerEditComponent } from './components/singer-edit.component';

import { SingerDetailComponent } from './components/singer-detail.component';

const appRoutes: Routes = [
	{path: '', component: HomeComponent },
	{path: 'singers/:page', component: SingerListComponent },
	{path: 'crear-singer', component: SingerAddComponent },
	{path: 'editar-singer/:id', component: SingerEditComponent },
	{path: 'singer/:id', component: SingerDetailComponent },
	{path: 'mis-datos', component: UserEditComponent },
	{path: '**', component: HomeComponent }
];
export const appRoutingProviders: any[] = [];
export const routing: ModuleWithProviders = RouterModule.forRoot(appRoutes);