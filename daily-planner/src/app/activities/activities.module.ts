import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ActivitiesRoutingModule } from './activities-routing.module';
import { ActivitiesComponent } from './activities.component';
import { ListActivitiesComponent } from './list-activities/list-activities.component';
import { ViewPlanComponent } from './view-plan/view-plan.component';
import { CustomiseFormComponent } from './customise-form/customise-form.component';


import { FormsModule, ReactiveFormsModule } from '@angular/forms';



@NgModule({
  declarations: [ActivitiesComponent, ListActivitiesComponent, ViewPlanComponent, CustomiseFormComponent],
  imports: [
    CommonModule,
    ActivitiesRoutingModule,
    FormsModule,
    ReactiveFormsModule
  ]
})
export class ActivitiesModule { }
