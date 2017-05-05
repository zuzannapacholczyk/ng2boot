import { Injectable } from '@angular/core';
import {Http, Response} from "@angular/http";
import {Observable} from "rxjs/Observable";
import 'rxjs/Rx';
import {DayPilot} from "daypilot-pro-angular";

@Injectable()
export class DataService {

  constructor(private http: Http) {
  }

  getResources(): Observable<any[]> {
    return this.http.get("/api/resources").map((response: Response) => response.json());
  }

  getEvents(from: DayPilot.Date, to: DayPilot.Date): Observable<any[]> {
    return this.http.get("/api/events?from=" + from.toString() + "&to=" + to.toString()).map((response: Response) => response.json());
  }

  createEvent(data: CreateEventParams) : Observable<EventData> {
    return this.http.post("/api/events/create", data).map((response: Response) => response.json());
  }

}

export interface CreateEventParams{
  start: string,
  end: string,
  text: string,
  resource: string | number;
}

export interface EventData {
  id: string | number,
  start: string,
  end: string,
  text: string,
  resource: string | number;
}

