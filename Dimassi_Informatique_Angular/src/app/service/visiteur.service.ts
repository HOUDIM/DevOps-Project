import { HttpClient } from "@angular/common/http";
import { Visiteur } from "app/model/visiteur";
import { Injectable } from "@angular/core";
import { SousCategorie } from "app/model/sousCategorie";
import { Observable } from "rxjs";

@Injectable({
  providedIn: "root",
})
export class VisiteurService {
  host = "http://localhost:8081/api/visiteur";
  constructor(private client: HttpClient) {}

  public add(fd: FormData): Observable<Visiteur> {
    return this.client.post<Visiteur>(this.host + "/add", fd);
  }

  public login(fd: FormData): Observable<Visiteur> {
    return this.client.post<Visiteur>(this.host + "/login", fd);
  }
}
