import {Component, ViewChild} from '@angular/core';
import {DayPilotSchedulerComponent} from "daypilot-pro-angular";

@Component({
  selector: 'scheduler-component',
  templateUrl: './scheduler.component.html',
  styleUrls: ['./scheduler.component.css']
})
export class SchedulerComponent {
  @ViewChild("scheduler1")
  scheduler: DayPilotSchedulerComponent;

  events: any;

  config: any = {
    timeHeaders : [
      {groupBy: "Month", format: "MMMM yyyy"},
      {groupBy: "Day", format: "d"}
    ],
    days: 30,
    startDate: "2016-11-01",
    scale: "Day"
  };
}
