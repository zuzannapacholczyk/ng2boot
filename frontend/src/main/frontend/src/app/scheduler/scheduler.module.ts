import {DayPilotModule} from "daypilot-pro-angular";
import {HttpModule} from "@angular/http";
import {BrowserModule} from "@angular/platform-browser";
import {NgModule} from "@angular/core";
import {SchedulerComponent} from "./scheduler.component";
import {DataService} from "./data.service";

@NgModule({
  imports: [
    BrowserModule,
    HttpModule,
    DayPilotModule
  ],
  declarations: [
    SchedulerComponent
  ],
  exports: [
    SchedulerComponent],
  providers: [DataService]
})

export class SchedulerModule {
}
