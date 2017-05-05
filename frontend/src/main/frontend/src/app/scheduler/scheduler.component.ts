import {AfterViewInit, Component, ViewChild} from '@angular/core';
import {DayPilotSchedulerComponent} from "daypilot-pro-angular";
import {CreateEventParams, DataService} from "./data.service";

@Component({
  selector: 'scheduler-component',
  templateUrl: './scheduler.component.html',
  styleUrls: ['./scheduler.component.css']
})
export class SchedulerComponent implements  AfterViewInit {
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
    scale: "Day",
    onTimeRangeSelected: args => {
      let name = prompt("New event name:", "Event");
      this.scheduler.control.clearSelection();
      if (!name) {
        return;
      }
      let params: CreateEventParams = {
        start: args.start.toString(),
        end: args.end.toString(),
        text: name,
        resource: args.resource
      };
      this.ds.createEvent(params).subscribe(result => {
        this.events.push(result);
        this.scheduler.control.message("Event created");
      });
    }
  };

  constructor(private ds: DataService) {}

  ngAfterViewInit(): void {
    this.ds.getResources().subscribe(result => this.config.resources = result);

    var from = this.scheduler.control.visibleStart();
    var to = this.scheduler.control.visibleEnd();
    this.ds.getEvents(from, to).subscribe(result => this.events = result);
  }
}
