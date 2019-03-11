import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { ActivityModel } from '../../data/activity.model';
import { ActivitiesService } from 'src/app/services/activities.service';


@Component({
  selector: 'app-list-activities',
  templateUrl: './list-activities.component.html',
  styleUrls: ['./list-activities.component.css']
})
export class ListActivitiesComponent implements OnInit {
  @Input() activitiesList: ActivityModel[];
  @Output() addItemPlan: EventEmitter<ActivityModel> = new EventEmitter<ActivityModel>();

  constructor(
   private activitiesService: ActivitiesService
   ) { }

  ngOnInit() {
 
  }
   addToDailyPlan(activity: ActivityModel) {
    this.addItemPlan.emit(activity);
}
}